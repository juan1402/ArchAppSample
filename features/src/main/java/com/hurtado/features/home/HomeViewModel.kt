package com.hurtado.features.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.hurtado.common.base.BaseViewModel
import com.hurtado.common.util.Event
import com.hurtado.data.entities.Item
import com.hurtado.data.repository.AppDispatchers
import com.hurtado.data.repository.utils.Resource
import com.hurtado.features.R
import com.hurtado.features.home.domain.GetItemUseCase
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class HomeViewModel(
    private val getTopUsersUseCase: GetItemUseCase,
    private val dispatchers: AppDispatchers
) : BaseViewModel() {

    private val mutableUser = MediatorLiveData<Resource<List<Item>>>()
    val users: LiveData<Resource<List<Item>>> get() = mutableUser
    private var usersSource: LiveData<Resource<List<Item>>> = MutableLiveData()

    init {
        getUsers(false, "5d382bc1b7bf3")
    }

    // PUBLIC ACTIONS ---

    fun userRefreshesItems() = getUsers(true, "5d382bc1b7bf3")

    // ---

    private fun getUsers(forceRefresh: Boolean, page: String) =
        viewModelScope.launch(dispatchers.main) {
            mutableUser.removeSource(usersSource) // Make sure there is only one source of live data
            withContext(dispatchers.io) { usersSource = getTopUsersUseCase(forceRefresh, page) }
            mutableUser.addSource(usersSource) {
                mutableUser.value = it
                if (it.status == Resource.Status.ERROR)
                    mutableError.value = Event(R.string.user_error)
            }
        }
}
package com.hurtado.common.base

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections
import com.hurtado.common.util.Event
import com.hurtado.navigation.NavigationCommand

abstract class BaseViewModel: ViewModel() {

    // FOR ERROR HANDLER
    protected val mutableError = MutableLiveData<Event<Int>>()
    val snackBarError: LiveData<Event<Int>> get() = mutableError

    // FOR NAVIGATION
    private val mutableNavigation = MutableLiveData<Event<NavigationCommand>>()
    val navigation: LiveData<Event<NavigationCommand>> = mutableNavigation

    /**
     * Convenient method to handle navigation from a [ViewModel]
     */
    fun navigate(directions: NavDirections) {
        mutableNavigation.value = Event(NavigationCommand.To(directions))
    }
}
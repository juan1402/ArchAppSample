package com.hurtado.features.home

import com.hurtado.common.base.BaseFragment
import com.hurtado.common.base.BaseViewModel
import com.hurtado.features.R
import com.hurtado.features.databinding.FragmentHomeBinding
import com.hurtado.features.home.views.HomeAdapter
import org.koin.android.viewmodel.ext.android.viewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: HomeViewModel by viewModel()

    override fun onViewBound(binding: FragmentHomeBinding) {
        binding.itemList.adapter = HomeAdapter(viewModel)
        binding.viewModel = viewModel
    }

    override fun getLayoutId(): Int = R.layout.fragment_home

    override fun getViewModel(): BaseViewModel = viewModel

}
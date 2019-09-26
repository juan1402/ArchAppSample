package com.hurtado.common.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.fragment.app.Fragment
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.navigation.fragment.FragmentNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.google.android.material.snackbar.Snackbar
import com.hurtado.common.extensions.inflate
import com.hurtado.common.extensions.setupSnackBar
import com.hurtado.navigation.NavigationCommand

abstract class BaseFragment<Binding : ViewDataBinding> : Fragment() {

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        observeNavigation(getViewModel())
        setupSnackBar(this, getViewModel().snackBarError, Snackbar.LENGTH_LONG)
    }

    /**
     * Here we will inherit binding values based on the class
     * Parameters and store them in global variables so any class extending
     * From Base context has access to binding instance by default
     */
    @Throws(RuntimeException::class)
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        lateinit var binding: Binding

        container?.let {
            binding = DataBindingUtil.bind(it.inflate(getLayoutId()))
                ?: throw RuntimeException("Please provide a valid binding layout")
        }
            ?: run {
                binding = DataBindingUtil.bind(inflater.inflate(getLayoutId(), null))
                    ?: throw RuntimeException("Please provide a valid binding layout")
            }

        binding.lifecycleOwner = viewLifecycleOwner
        setHasOptionsMenu(true)

        onViewBound(binding)
        return binding.root
    }

    /**
     * This optional method is used to bind the required view model inside the
     * Xml file, this is optional to use tho is recommended
     * Bind them by calling the view model binding.customViewModel = viewModel
     */
    abstract fun onViewBound(binding: Binding)

    abstract fun getViewModel(): BaseViewModel

    @LayoutRes abstract fun getLayoutId(): Int

    // UTILS METHODS ---

    /**
     * Observe a [NavigationCommand] [Event] [LiveData].
     * When this [LiveData] is updated, [Fragment] will navigate to its destination
     */
    private fun observeNavigation(viewModel: BaseViewModel) {
        viewModel.navigation.observe(viewLifecycleOwner, Observer {
            it?.getContentIfNotHandled()?.let { command ->
                when (command) {
                    is NavigationCommand.To -> findNavController().navigate(
                        command.directions,
                        getExtras()
                    )
                    is NavigationCommand.Back -> findNavController().navigateUp()
                }
            }
        })
    }

    /**
     * [FragmentNavigatorExtras] mainly used to enable Shared Element transition
     */
    open fun getExtras(): FragmentNavigator.Extras = FragmentNavigatorExtras()

}
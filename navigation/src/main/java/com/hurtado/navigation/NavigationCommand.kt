package com.hurtado.navigation

import androidx.lifecycle.ViewModel
import androidx.navigation.NavDirections

/**
 * sealed class to handle navigation from a [ViewModel]
 */
sealed class NavigationCommand {
    data class To(val directions: NavDirections): NavigationCommand()
    object Back: NavigationCommand()
}
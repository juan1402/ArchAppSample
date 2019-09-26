package com.hurtado.common.extensions

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.google.android.material.snackbar.Snackbar
import com.hurtado.common.util.Event

fun ViewGroup.inflate(@LayoutRes layoutId: Int, addContainer: Boolean = false): View {
    return LayoutInflater.from(context).inflate(layoutId, this, addContainer)
}

fun Fragment.showSnackBar(snackBarText: String, timeLength: Int) {
    activity?.let { Snackbar.make(it.findViewById<View>(android.R.id.content), snackBarText, timeLength).show() }
}

fun Fragment.setupSnackBar(lifecycleOwner: LifecycleOwner, snackbarEvent: LiveData<Event<Int>>, timeLength: Int) {
    snackbarEvent.observe(lifecycleOwner, Observer { event ->
        event.getContentIfNotHandled()?.let { res ->
            context?.let { showSnackBar(it.getString(res), timeLength) }
        }
    })
}
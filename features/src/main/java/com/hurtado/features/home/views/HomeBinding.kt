package com.hurtado.features.home.views

import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.bumptech.glide.Glide
import com.hurtado.data.entities.Item
import com.hurtado.data.repository.utils.Resource
import java.util.*

object HomeBinding {

    @JvmStatic
    @BindingAdapter("app:showWhenLoading")
    fun <T> showWhenLoading(view: SwipeRefreshLayout, resource: Resource<T>?) {
        Log.d(HomeBinding::class.java.simpleName, "Resource: $resource")
        resource?.let { view.isRefreshing = it.status == Resource.Status.LOADING }
    }

    @JvmStatic
    @BindingAdapter("app:items")
    fun setItems(recyclerView: RecyclerView, resource: Resource<List<Item>>?) =
        with(recyclerView.adapter as HomeAdapter) {
            resource?.data?.let { updateData(it) }
        }

    @JvmStatic
    @BindingAdapter("app:imageUrl")
    fun loadImage(view: ImageView, base64: String) {
        Glide.with(view.context).load(Base64.getDecoder().decode(base64)).into(view)
    }

    @JvmStatic
    @BindingAdapter("app:showWhenEmptyList")
    fun showMessageErrorWhenEmptyList(view: View, resource: Resource<List<Item>>?) =
        resource?.let { res ->
            view.visibility = if (
                res.status == Resource.Status.ERROR
                && res.data != null
                && res.data!!.isEmpty()
            ) View.VISIBLE else View.GONE
        }
}
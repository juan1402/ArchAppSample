package com.hurtado.data.remote

class ItemDataSource(private val userService: ItemService) {

    fun fetchItemPageAsync(page: String?) = userService.fetchItemPageAsync(page)

}
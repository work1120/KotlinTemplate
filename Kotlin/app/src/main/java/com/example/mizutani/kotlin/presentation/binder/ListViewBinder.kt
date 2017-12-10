package com.example.mizutani.kotlin.presentation.binder

import android.databinding.BindingAdapter
import android.widget.ListView
import com.example.mizutani.kotlin.data.application.ApplicationContext
import com.example.mizutani.kotlin.domain.viewmodels.UserListItemModel
import com.example.mizutani.kotlin.presentation.adapter.UserListAdapter

@BindingAdapter("android:items")
fun ListView.setItem(items: List<UserListItemModel>) {
    var _adapter = UserListAdapter(context, items)
    adapter = _adapter
}
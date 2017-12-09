package com.example.mizutani.kotlin.presentation.view.activity

import android.content.Intent
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.mizutani.kotlin.R
import com.example.mizutani.kotlin.data.entities.db.UserEntity
import com.example.mizutani.kotlin.databinding.ActivityListviewBinding
import com.example.mizutani.kotlin.domain.viewmodels.UserListItemModel
import com.example.mizutani.kotlin.domain.viewmodels.UserListModel
import com.example.mizutani.kotlin.presentation.adapter.UserListAdapter
import com.raizlabs.android.dbflow.sql.language.Select

class UserListActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityListviewBinding>(this, R.layout.activity_listview)
        val listItem: List<UserEntity> = Select().from(UserEntity::class.java).queryList()
        var viewModel = UserListModel(listItem)
        var listView = findViewById<ListView>(R.id.userlist)
        setItem(listView, viewModel.liteItems)

        binding.model = viewModel
        binding!!.view = this
    }

    @BindingAdapter("items")
    fun setItem(listView: ListView, items: List<UserListItemModel>){
        var adapter = UserListAdapter(this, items)
        listView.adapter = adapter
    }

    fun RegistUser(view: View){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

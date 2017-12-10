package com.example.mizutani.kotlin.presentation.view.activity

import android.content.Context
import android.content.Intent
import android.databinding.BindingAdapter
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.View
import android.widget.ListView
import com.example.mizutani.kotlin.R
import com.example.mizutani.kotlin.data.application.ApplicationContext
import com.example.mizutani.kotlin.data.entities.db.UserEntity
import com.example.mizutani.kotlin.databinding.ActivityListviewBinding
import com.example.mizutani.kotlin.domain.viewmodels.UserListItemModel
import com.example.mizutani.kotlin.domain.viewmodels.UserListModel
import com.example.mizutani.kotlin.presentation.adapter.UserListAdapter
import com.raizlabs.android.dbflow.kotlinextensions.update
import com.raizlabs.android.dbflow.sql.language.Select

class UserListActivity : BaseActivity() {

    private var viewModel: UserListModel
    init{
        val listItem: List<UserEntity> = Select().from(UserEntity::class.java).queryList()
        viewModel = UserListModel(listItem)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityListviewBinding>(this, R.layout.activity_listview)
        binding.model = viewModel
        binding!!.view = this
        binding!!.items = viewModel.liteItems
    }

    override fun onResume() {
        super.onResume()
        val listItem: List<UserEntity> = Select().from(UserEntity::class.java).queryList()
        viewModel.Update(listItem)
    }

    fun RegistUser(view: View){
        var intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}

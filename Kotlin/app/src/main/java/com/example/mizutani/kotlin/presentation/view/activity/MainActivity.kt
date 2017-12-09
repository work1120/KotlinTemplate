package com.example.mizutani.kotlin.presentation.view.activity

import android.databinding.DataBindingUtil
import android.os.Bundle
import com.example.mizutani.kotlin.R
import com.example.mizutani.kotlin.data.entities.db.UserEntity
import com.example.mizutani.kotlin.domain.viewmodels.MainViewModel
import com.example.mizutani.kotlin.databinding.ActivityMainBinding

class MainActivity : BaseActivity() {

    val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.model = viewModel
        binding!!.view = this
    }

    fun RegistUser(_viewModel: MainViewModel){
        val userEntity: UserEntity = UserEntity()
        userEntity.UserId = _viewModel.userId
        userEntity.PassWord = _viewModel.passWord
        userEntity.save()
    }
}

package com.example.mizutani.kotlin.presentation.view.activity

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.mizutani.kotlin.R
import com.example.mizutani.kotlin.data.entities.db.UserEntity
import com.example.mizutani.kotlin.domain.viewmodels.MainViewModel
import com.example.mizutani.kotlin.databinding.ActivityMainBinding
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager
import com.raizlabs.android.dbflow.sql.language.Select
import com.raizlabs.android.dbflow.structure.ModelAdapter



class MainActivity : AppCompatActivity() {

    val viewModel: MainViewModel = MainViewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.model = viewModel
        binding!!.view = this
    }

    fun RegistUser(view: View){
        val adapter = FlowManager.getModelAdapter<UserEntity>(UserEntity::class.java)
        adapter.insert(UserEntity())
        adapter.save(UserEntity())

        val userEntity: UserEntity = UserEntity()
        userEntity.Name = viewModel.firstName + " " + viewModel.lastName
        userEntity.save()
    }

    fun Get(view: View)
    {
        val entities = Select().from(UserEntity::class.java).queryList()
        Toast.makeText(this, "", Toast.LENGTH_LONG).show()
    }
}

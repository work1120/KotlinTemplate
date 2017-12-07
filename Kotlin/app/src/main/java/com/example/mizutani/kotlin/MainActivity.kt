package com.example.mizutani.kotlin

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.mizutani.kotlin.domain.viewmodels.MainViewModel
import com.example.mizutani.kotlin.databinding.ActivityMainBinding
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
        binding.model = MainViewModel()
        FlowManager.init(FlowConfig.Builder(this).build())
    }
}

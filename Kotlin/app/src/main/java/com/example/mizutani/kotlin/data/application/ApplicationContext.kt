package com.example.mizutani.kotlin.data.application

import android.app.Application
import com.raizlabs.android.dbflow.config.FlowConfig
import com.raizlabs.android.dbflow.config.FlowManager

class ApplicationContext : Application()
{
    override fun onCreate(){
        super.onCreate()
        FlowManager.init(FlowConfig.Builder(this).build())
    }

    override fun onTerminate(){
        super.onTerminate()
        FlowManager.destroy()
    }
}
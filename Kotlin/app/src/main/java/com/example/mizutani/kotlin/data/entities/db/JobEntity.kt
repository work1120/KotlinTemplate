package com.example.mizutani.kotlin.data.entities.db

import com.example.mizutani.kotlin.AppDatabase
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.structure.BaseModel
import java.util.*

@Table(database = AppDatabase::class)
class JobEntity : BaseModel()
{
    @PrimaryKey
    @Column
    var Id : String = UUID.randomUUID().toString()

    @Column
    var Name: String = "無職"
}
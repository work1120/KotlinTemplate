package com.example.mizutani.kotlin.domain.viewmodels

import com.example.mizutani.kotlin.data.entities.db.UserEntity

class UserListModel(userentities: List<UserEntity>){
    var liteItems: ArrayList<UserListItemModel> = Create(userentities)

    fun Create(userentities: List<UserEntity>) : ArrayList<UserListItemModel>{
        var ret: ArrayList<UserListItemModel> = ArrayList()

        userentities.forEach{
            ret.add(UserListItemModel(it.UserId, it.PassWord, it.NickName))
        }

        return ret
    }

    fun Update(userEntities: List<UserEntity>){
        liteItems.clear()

        userEntities.forEach{
            liteItems.add(UserListItemModel(it.UserId, it.PassWord, it.NickName))
        }
    }
}
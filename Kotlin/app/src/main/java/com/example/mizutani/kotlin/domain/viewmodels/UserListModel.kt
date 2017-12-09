package com.example.mizutani.kotlin.domain.viewmodels

import com.example.mizutani.kotlin.data.entities.db.UserEntity

class UserListModel(var userentities: List<UserEntity>){
    public var liteItems: List<UserListItemModel> = Create(userentities)

    fun Create(userentities: List<UserEntity>) : ArrayList<UserListItemModel>{
        var ret: ArrayList<UserListItemModel> = ArrayList<UserListItemModel>()

        userentities.forEach{
            ret.add(UserListItemModel(it.UserId, it.PassWord, it.NickName))
        }

        return ret
    }
}
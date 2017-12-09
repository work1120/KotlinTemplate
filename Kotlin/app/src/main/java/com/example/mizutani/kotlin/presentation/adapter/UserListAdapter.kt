package com.example.mizutani.kotlin.presentation.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.mizutani.kotlin.databinding.UserlistItemBinding
import com.example.mizutani.kotlin.domain.viewmodels.UserListItemModel

class UserListAdapter(val context: Context, val _listItems: List<UserListItemModel>) : BaseAdapter(){

    var inflater: LayoutInflater?
    var listItems: List<UserListItemModel>? = _listItems

    init{
        inflater = LayoutInflater.from(context)
    }

    override fun getCount(): Int {
        return listItems!!.count()
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    override fun getItem(p0: Int): UserListItemModel {
        return listItems!![p0]
    }

    override fun getView(position: Int, contextView: View?, parent: ViewGroup?): View {
        var binding: UserlistItemBinding?
        if(contextView == null){
            binding = UserlistItemBinding.inflate(inflater!!, parent, false)
            binding.root.tag = binding
        }
        else{
            binding = contextView.tag as UserlistItemBinding
        }
        binding.userListItemModel = getItem(position)
        return binding.root
    }

}
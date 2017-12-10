package com.example.mizutani.kotlin.presentation.view.activity;

import android.content.Context;
import android.content.Intent;
import android.databinding.BindingAdapter;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import com.example.mizutani.kotlin.R;
import com.example.mizutani.kotlin.data.entities.db.UserEntity;
import com.example.mizutani.kotlin.databinding.ActivityListviewBinding;
import com.example.mizutani.kotlin.domain.viewmodels.UserListItemModel;
import com.example.mizutani.kotlin.domain.viewmodels.UserListModel;
import com.example.mizutani.kotlin.presentation.adapter.UserListAdapter;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.sql.language.Select;

import java.util.List;

public class UserListActivity extends BaseActivity {

    public static Context context;
    public UserListModel viewModel;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        ActivityListviewBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_listview);
        List<UserEntity> listItem = SQLite.select().from(UserEntity.class).queryList();
        viewModel = new UserListModel(listItem);
        ListView listView = findViewById(R.id.userlist);
        //setItem(listView, viewModel.getLiteItems());

        binding.setModel(viewModel);
        binding.setView(this);
        binding.setItems(viewModel.getLiteItems());
//        binding.model = viewModel;
//        binding.view = this;
    }

    @Override
    public void onResume(){
        super.onResume();
        List<UserEntity> listItem = SQLite.select().from(UserEntity.class).queryList();
        viewModel.Update(listItem);
    }

    @BindingAdapter("items")
    static public void setItem(ListView listView, List<UserListItemModel> items){
        UserListAdapter adapter = new UserListAdapter(context, items);
        listView.setAdapter(adapter);
    }

    public void RegistUser(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}

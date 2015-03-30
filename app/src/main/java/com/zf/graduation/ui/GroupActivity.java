package com.zf.graduation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import com.zf.graduation.R;
import com.zf.graduation.adapter.GroupListItemAdapter;
import com.zf.graduation.entity.Group;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i-fanzhang on 2015/3/20.
 */
public class GroupActivity extends ActionBarActivity {
    private ListView groupList;
    private GroupListItemAdapter groupAdapter;
    private List<Group> groups = new ArrayList<Group>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.group_activity);
        setGroupList();
        showGroup();
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        bar.setTitle("我拥有的组");
    }

    @Override
    public void onOptionsMenuClosed(Menu menu) {
        super.onOptionsMenuClosed(menu);
    }
    /*
    * 从数据库读取出来的数据
    * */
    public void setGroupList(){
        Group item = new Group();
        item.setName("家人");
        groups.add(item);
        groups.add(item);
        groups.add(item);
        groups.add(item);
        groups.add(item);
        groups.add(item);
        groups.add(item);
        groups.add(item);
    }

    /*
    * 显示组
    * */
    public void showGroup(){
        groupAdapter = new GroupListItemAdapter(GroupActivity.this,groups);
        groupList = (ListView)findViewById(R.id.group_list);
        groupList.setAdapter(groupAdapter);
        groupList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(GroupActivity.this,"你好",Toast.LENGTH_SHORT).show();
            }
        });
    }

}

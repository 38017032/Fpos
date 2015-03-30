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
import com.zf.graduation.adapter.ActivityListItemAdapter;
import com.zf.graduation.entity.Activities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i-fanzhang on 2015/3/20.
 */
public class ActivityActivity extends ActionBarActivity {
    private ListView activityList;
    private ActivityListItemAdapter activityAdapter;
    private List<Activities> activities = new ArrayList<Activities>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);
        setActivityList();
        showActivity();
        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);
        bar.setTitle("我参加的活动");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }

    /*
    * 显示活动
    * */
    public void showActivity(){
        activityAdapter = new ActivityListItemAdapter(ActivityActivity.this,activities);
        activityList = (ListView)findViewById(R.id.act_list);
        activityList.setAdapter(activityAdapter);
        activityList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(ActivityActivity.this, "你好", Toast.LENGTH_SHORT).show();
            }
        });
    }


    /*
    * 从数据库读取出来的数据
    * */
    public void setActivityList(){
        Activities item = new Activities();
        item.setName("活动");
        activities.add(item);
        activities.add(item);
        activities.add(item);
        activities.add(item);
        activities.add(item);
        activities.add(item);
        activities.add(item);
        activities.add(item);
    }
}

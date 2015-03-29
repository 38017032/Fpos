package com.zf.graduation.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zf.graduation.R;

import java.lang.reflect.Field;

/**
* Created by i-fanzhang on 2015/3/18.
*/
public class MainActivity extends ActionBarActivity {
    private TextView groupText;
    private TextView activityText;

    private RelativeLayout messageLayout;
    private RelativeLayout setupLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        groupText = (TextView)findViewById(R.id.group);
        activityText = (TextView)findViewById(R.id.activities);
        messageLayout = (RelativeLayout)findViewById(R.id.message);
        setupLayout = (RelativeLayout)findViewById(R.id.setting);

        showOverflowButton();

        ActionBar bar = getSupportActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);

        groupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, GroupActivity.class);
                startActivity(intent);
            }
        });

        activityText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActivityActivity.class);
                startActivity(intent);
            }
        });
        messageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
        setupLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,SetUpActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case 0:
                Intent createActivityIntent = new Intent(MainActivity.this,CreateActivityActivity.class);
                startActivity(createActivityIntent);
                break;
            case 1:
                Intent createGroupIntent = new Intent(MainActivity.this,CreateGroupActivity.class);
                startActivity(createGroupIntent);
                break;
            default:
                break;
        }
        return  true;
    }

    public void showOverflowButton(){
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if (menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception ex) {
            // ignore
        }
    }


}

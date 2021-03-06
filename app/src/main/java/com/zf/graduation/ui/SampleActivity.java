package com.zf.graduation.ui;

import android.app.Activity;
import android.app.ActionBar;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewConfiguration;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;
import com.zf.graduation.R;

import java.lang.reflect.Field;

/**
 * Created by fan on 2015/3/28.
 */
public class SampleActivity extends Activity {
    private TextView groupText;
    private TextView activityText;

    private RelativeLayout messageLayout;
    private RelativeLayout setupLayout;

    private DrawerLayout mainLayout;
    private LinearLayout layout;

    private ActionBarDrawerToggle mDrawerToggle;
    private DrawerArrowDrawable drawerArrow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sample_activity);

        groupText = (TextView)findViewById(R.id.group);
        activityText = (TextView)findViewById(R.id.activities);
        messageLayout = (RelativeLayout)findViewById(R.id.message);
        setupLayout = (RelativeLayout)findViewById(R.id.setting);

        mainLayout = (DrawerLayout)findViewById(R.id.main_layout);
        layout = (LinearLayout)findViewById(R.id.layout);
        ActionBar bar = getActionBar();
        bar.setDisplayHomeAsUpEnabled(true);
        bar.setHomeButtonEnabled(true);

        drawerArrow = new DrawerArrowDrawable(this) {
            @Override
            public boolean isLayoutRtl() {
                return false;
            }
        };
        mDrawerToggle = new ActionBarDrawerToggle(this, mainLayout,
                drawerArrow, 1,
                2) {

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
                invalidateOptionsMenu();
            }
        };
        mainLayout.setDrawerListener(mDrawerToggle);
        mDrawerToggle.syncState();

        groupText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SampleActivity.this, GroupActivity.class);
                startActivity(intent);
            }
        });

        activityText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SampleActivity.this, ActivityActivity.class);
                startActivity(intent);
            }
        });
        messageLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SampleActivity.this,MessageActivity.class);
                startActivity(intent);
            }
        });
        setupLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SampleActivity.this,SetUpActivity.class);
                startActivity(intent);
            }
        });
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.actionbar,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if(id == android.R.id.home){
            // 点击ActionBar左边的时候滑动效果
            if (mainLayout.isDrawerOpen(layout)) {
                mainLayout.closeDrawer(layout);
            } else {
                mainLayout.openDrawer(layout);
            }
        }
        else{
            if(id == R.id.create_activity){
                Intent createActivityIntent = new Intent(SampleActivity.this, CreateActivityActivity.class);
                startActivity(createActivityIntent);
            }
            else if(id == R.id.create_group){
                Intent createActivityIntent = new Intent(SampleActivity.this, CreateGroupActivity.class);
                startActivity(createActivityIntent);
            }
        }
        return super.onOptionsItemSelected(item);
    }

//    @Override
//    public boolean onMenuItemSelected(int featureId, MenuItem item) {
//        int id = item.getItemId();
//        if (id == android.R.id.home) {
//            // 点击ActionBar左边的时候滑动效果
//            if (mainLayout.isDrawerOpen(layout)) {
//                mainLayout.closeDrawer(layout);
//            } else {
//                mainLayout.openDrawer(layout);
//            }
//            return true;
//        }else {
//            switch (item.getItemId()) {
//                case 0:
//                    Intent createActivityIntent = new Intent(SampleActivity.this, CreateActivityActivity.class);
//                    startActivity(createActivityIntent);
//                    break;
//                case 1:
//                    Intent createGroupIntent = new Intent(SampleActivity.this, CreateGroupActivity.class);
//                    startActivity(createGroupIntent);
//                    break;
//                default:
//                    break;
//            }
//            return true;
//        }
//    }
}

package com.zf.graduation.ui;

import android.app.ActionBar;
import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.ikimuhendis.ldrawer.ActionBarDrawerToggle;
import com.ikimuhendis.ldrawer.DrawerArrowDrawable;
import com.zf.graduation.R;

/**
 * Created by fan on 2015/3/28.
 */
public class SampleActivity extends Activity {
    private TextView groupText;
    private TextView activityText;

    private RelativeLayout messageLayout;
    private RelativeLayout setupLayout;

    private DrawerLayout mainLayout;

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


    }
}

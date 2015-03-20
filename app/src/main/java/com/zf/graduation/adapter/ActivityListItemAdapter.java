package com.zf.graduation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zf.graduation.R;
import com.zf.graduation.entity.Activities;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by i-fanzhang on 2015/3/19.
 */
public class ActivityListItemAdapter extends BaseAdapter {
    private Context context;
    private List<Activities> activityList = new ArrayList<Activities>();
    private LayoutInflater inflater;

    public ActivityListItemAdapter(Context context,List<Activities> list){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.activityList = list;
    }
    @Override
    public int getCount() {
        return activityList.size();
    }

    @Override
    public Object getItem(int position) {
        return activityList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Activities item = activityList.get(position);
        ViewHolder holder = null;
        if(convertView == null){
            convertView = inflater.inflate(R.layout.group_list_item,null);
            holder = new ViewHolder();
            holder.name = (TextView) convertView.findViewById(R.id.group_name);
            convertView.setTag(holder);
        }
        else{
            holder = (ViewHolder)convertView.getTag();
        }
        holder.name.setText("活动");
        return convertView;
    }

    public class ViewHolder{
        public TextView name;
    }
}

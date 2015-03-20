package com.zf.graduation.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zf.graduation.R;
import com.zf.graduation.entity.Group;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by i-fanzhang on 2015/3/19.
 */
public class GroupListItemAdapter extends BaseAdapter {
    private Context context;
    private List<Group> groupList = new ArrayList<Group>();
    private LayoutInflater inflater;

    public GroupListItemAdapter(Context context,List<Group> list){
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.groupList = list;
    }
    @Override
    public int getCount() {
        return groupList.size();
    }

    @Override
    public Object getItem(int position) {
        return groupList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Group item = groupList.get(position);
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
        holder.name.setText("家人");
        return convertView;
    }

    public class ViewHolder{
        public TextView name;
    }
}

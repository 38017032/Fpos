package com.zf.graduation.test;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.zf.graduation.R;

import se.emilsjolander.stickylistheaders.StickyListHeadersAdapter;

/**
 * Created by i-fanzhang on 2015/3/19.
 */
public class TestAdapter extends BaseAdapter implements StickyListHeadersAdapter{
    private String []headerText = {"组","活动"};
    private String []itemList1 = {"家庭","班级","儿时玩伴"};
    private String []itemList2 = {"班聚","聚餐","约会"};
    private LayoutInflater inflater;

    @Override
    public int getCount() {
        return 0;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }

    @Override
    public View getHeaderView(int i, View view, ViewGroup viewGroup) {
        HeaderViewHolder holder = null;
        if(view == null){
            holder = new HeaderViewHolder();
            view = inflater.inflate(R.layout.test_item_header,null);
            holder.header = (TextView)view.findViewById(R.id.activities);
            view.setTag(holder);
        }
        else{
            holder = (HeaderViewHolder)view.getTag();
        }
        holder.header.setText(headerText[i]);
        return view;
    }

    @Override
    public long getHeaderId(int i) {
        return 0;
    }

    public class HeaderViewHolder{
        public TextView header;
    }

    public class ContentViewHolder{
        public TextView content;
    }

}

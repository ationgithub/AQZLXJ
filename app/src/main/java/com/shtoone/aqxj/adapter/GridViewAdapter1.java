package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shtoone.aqxj.R;

import java.util.List;
import java.util.Map;

/**
 * Created by liangfeng on 2017/10/9.
 */

public class GridViewAdapter1 extends BaseAdapter {

    private List<Map<String, String>> list;
    private Context context;
    private String TAG = "GridViewAdapter1";

    public GridViewAdapter1(Context context, List<Map<String, String>> list) {
        this.list = list;
        this.context = context;
    }

    @Override
    public int getCount() {
        return list.size();
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
        View itemView = LayoutInflater.from(context).inflate(R.layout.gridview_item1, null);
        TextView itemNum = (TextView) itemView.findViewById(R.id.tv_gridview_item_num);
        TextView itemTitle = (TextView) itemView.findViewById(R.id.tv_gridview_item_title);
        ImageView itemIcon = (ImageView) itemView.findViewById(R.id.iv_gridview_item);

        itemTitle.setText(list.get(position).get("itemTitle"));
        if (position < list.size()) {
            itemNum.setText(list.get(position).get("itemNum"));
        }
        if (position == 0) {
            itemNum.setVisibility(View.GONE);
            itemIcon.setVisibility(View.VISIBLE);
                itemIcon.setImageResource(R.drawable.gride_view_add);
        }
        return itemView;
    }
}

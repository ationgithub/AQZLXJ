package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;

import java.util.List;
import java.util.Map;

/**
 * Created by liangfeng on 2017/10/9.
 */

public class GridViewAdapter2 extends BaseAdapter {

    private int [] icons= {R.drawable.gride_view_analyse,R.drawable.gride_view_find,
            R.drawable.gride_view_analyse,
            R.drawable.gride_view_in,
            R.drawable.gride_view_out,
            R.drawable.gride_view_find2
            };

    private List<Map<String, String>> list;
    private Context context;
    private String TAG = "GridViewAdapter1";
    private String noshenhe;

    public GridViewAdapter2(Context context, List<Map<String, String>> list, String noshenhe) {
        this.list = list;
        this.context = context;
        this.noshenhe = noshenhe;
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
        View itemView = LayoutInflater.from(context).inflate(R.layout.gridview_item2, null);
        TextView itemNum = (TextView) itemView.findViewById(R.id.tv_gridview_item_num);
        TextView itemTitle = (TextView) itemView.findViewById(R.id.tv_gridview_item_title);
        ImageView itemIcon = (ImageView) itemView.findViewById(R.id.iv_gridview_item);

        if (position==0){
            itemNum.setVisibility(View.VISIBLE);
            itemNum.setText(noshenhe);
            itemTitle.setText(list.get(position).get("itemTitle"));
            if(BaseApplication.renwuRed){
            Drawable drawable = context.getResources().getDrawable(R.drawable.layer_list_red_dot,null);
            drawable.setBounds(10,1,40,60);//40 60
            itemNum.setCompoundDrawables(null,null,drawable,null);
            }else {
                itemNum.setCompoundDrawables(null,null,null,null);
            }
            itemIcon.setVisibility(View.GONE);
        }
//        if (position==6){
//            itemNum.setVisibility(View.VISIBLE);
//            itemNum.setText(noshenhe);
//            itemTitle.setText(list.get(position).get("itemTitle"));
//            itemIcon.setVisibility(View.GONE);
//        }

        itemTitle.setText(list.get(position).get("itemTitle"));
        itemIcon.setImageResource(icons[position]);
        return itemView;
    }
}

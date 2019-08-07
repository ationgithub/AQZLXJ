package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.StorageQueryDetailActivityData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */
public class StorageDetailActivityRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = StorageDetailActivityRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private List<StorageQueryDetailActivityData.XiuzhengBean> itemsData;
    private Resources mResources;

    public StorageDetailActivityRecyclerViewAdapter(Context context, List<StorageQueryDetailActivityData.XiuzhengBean> itemsData) {
        super();
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
    }

    @Override
    public int getItemCount() {
        if (itemsData != null && itemsData.size() > 0) {
            return itemsData.size();
        }
        return 0;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StorageDetailActivityRecyclerViewAdapter.ItemViewHolder) {
            StorageDetailActivityRecyclerViewAdapter.ItemViewHolder mItemViewHolder = (StorageDetailActivityRecyclerViewAdapter.ItemViewHolder) holder;
            StorageQueryDetailActivityData.XiuzhengBean item= itemsData.get(position);
            ViewGroup mViewGroup = (ViewGroup) mItemViewHolder.tv_remark.getParent();
            mViewGroup.setBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));
            mItemViewHolder.tv_remark.setText(item.getRemark());
            mItemViewHolder.tv_xiuzhengzhi.setText(String.valueOf(item.getXiuzhengzhi()));
            mItemViewHolder.tv_xiuzhnegren.setText(item.getCreateperson());
            mItemViewHolder.tv_time.setText(item.getCreatedatetime());
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new StorageDetailActivityRecyclerViewAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_storage_detail_activity, parent, false));
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_remark;
        TextView tv_xiuzhengzhi;
        TextView tv_xiuzhnegren;
        TextView tv_time;


        public ItemViewHolder(View view) {
            super(view);
            tv_remark = (TextView) view.findViewById(R.id.tv_remark_item_recyclerview_storage_detal_activity);
            tv_xiuzhengzhi = (TextView) view.findViewById(R.id.tv_xiuzhengzhi_item_recyclerview_storage_detal_activity);
            tv_xiuzhnegren = (TextView) view.findViewById(R.id.tv_xiuzhnegren_item_recyclerview_storage_detal_activity);
            tv_time = (TextView) view.findViewById(R.id.tv_time_item_recyclerview_storage_detal_activity);
        }
    }
}

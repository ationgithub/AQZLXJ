package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.StorageFragmentListData;
import com.socks.library.KLog;

import java.util.List;

/**
 * Created by Administrator on 2017/8/7.
 */
public class StorageFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = StorageFragmentRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<StorageFragmentListData.DataBean> itemsData;
    private Resources mResources;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public StorageFragmentRecyclerViewAdapter(Context context, List<StorageFragmentListData.DataBean> itemsData) {
        super();
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
        KLog.e(TAG,"--------StorageFragmentRecyclerViewAdapter----------");
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
        KLog.e(TAG,"--------setOnItemClickListener----------");
    }

    @Override
    public int getItemCount() {
        if (itemsData != null && itemsData.size() > 0) {
            //这里的10是根据分页查询，一页该显示的条数
            if (itemsData.size() > 4) {
                return itemsData.size() + 1;
            } else {
                return itemsData.size();
            }
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItemCount() > 4 && position + 1 == getItemCount()) {
            return StorageFragmentRecyclerViewAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return StorageFragmentRecyclerViewAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof StorageFragmentRecyclerViewAdapter.ItemViewHolder) {
            StorageFragmentRecyclerViewAdapter.ItemViewHolder mItemViewHolder = (StorageFragmentRecyclerViewAdapter.ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            StorageFragmentListData.DataBean item = itemsData.get(position);
            mItemViewHolder.tv_depart.setText(item.getDepartname());
            mItemViewHolder.tv_material.setText(item.getCailiaoname());
            mItemViewHolder.tv_liaocang.setText(item.getLiaoCangname());
            mItemViewHolder.tv_kucun.setText(item.getResult());
            mItemViewHolder.tv_xiuzhengzhi.setText(item.getXiuzheng());
            mItemViewHolder.tv_chushiliang.setText(item.getChushi());
            mItemViewHolder.tv_jingjiezhi.setText(item.getJingjiezhi());

            if (mOnItemClickListener != null) {
                mItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getLayoutPosition();
                        mOnItemClickListener.onItemClick(holder.itemView, position);
                    }
                });
            }
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == StorageFragmentRecyclerViewAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new StorageFragmentRecyclerViewAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_storage_fragment, parent, false));
        } else if (viewType == ProduceQueryFragmentRecyclerViewAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new StorageFragmentRecyclerViewAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_depart;
        TextView tv_material;
        TextView tv_liaocang;
        TextView tv_chuliang;
        TextView tv_kucun;
        TextView tv_xiuzhengzhi;
        TextView tv_chushiliang;
        TextView tv_jingjiezhi;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_produce_query_fragment);
            tv_depart = (TextView) view.findViewById(R.id.tv0_item_recyclerview_storage_fragment);
            tv_material = (TextView) view.findViewById(R.id.tv1_item_recyclerview_storage_fragment);
            tv_liaocang = (TextView) view.findViewById(R.id.tv2_item_recyclerview_produce_query_fragment);
//            tv_chuliang = (TextView) view.findViewById(R.id.tv3_item_recyclerview_produce_query_fragment);
            tv_kucun = (TextView) view.findViewById(R.id.tv4_item_recyclerview_storage_fragment);
            tv_xiuzhengzhi = (TextView) view.findViewById(R.id.tv5_item_recyclerview_storage_fragment);
            tv_chushiliang = (TextView) view.findViewById(R.id.tv6_item_recyclerview_storage_fragment);
            tv_jingjiezhi= (TextView) view.findViewById(R.id.tv7_item_recyclerview_storage_fragment);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

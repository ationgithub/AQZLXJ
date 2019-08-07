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
import com.shtoone.aqxj.bean.YCLChuChangWeightFragmentListData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */

public class YCLChuChangWeightFragmentRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private  Context                                            context;
    private  OnItemClickListener                                mOnItemClickListener;
    private  List<YCLChuChangWeightFragmentListData.DataEntity> itemsData;
    private Resources                                           mResources;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public YCLChuChangWeightFragmentRecycleViewAdapter(Context context, List<YCLChuChangWeightFragmentListData.DataEntity> itemsData) {
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
    }


    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == YCLChuChangWeightFragmentRecycleViewAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new YCLChuChangWeightFragmentRecycleViewAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_chuchang_query_fragment, parent, false));
        } else if (viewType == YCLChuChangWeightFragmentRecycleViewAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new YCLChuChangWeightFragmentRecycleViewAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            YCLChuChangWeightFragmentListData.DataEntity item = itemsData.get(position);
            mItemViewHolder.tv_datetype.setText(item.getDatetype());
            mItemViewHolder.tv_shebei.setText(item.getBanhezhanminchen());
            mItemViewHolder.tv_cailiao_name.setText(item.getCailiaoName());
            mItemViewHolder.tv_provider.setText(item.getGongyingshangName());
            mItemViewHolder.tv_pizhong.setText(item.getPizhong()+"");
            mItemViewHolder.tv_maozhong.setText(item.getMaozhong()+"");
            if (String.valueOf(item.getPici()).equals("null")){
                mItemViewHolder.tv_pici.setText("");
            }
            else{
                mItemViewHolder.tv_pizhong.setText(item.getPici()+"");
            }

            mItemViewHolder.tv_jingzhong.setText(item.getJingzhong()+"");

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
            return YCLChuChangWeightFragmentRecycleViewAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return YCLChuChangWeightFragmentRecycleViewAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_datetype;
        TextView tv_shebei;
        TextView tv_cailiao_name;
        TextView tv_provider;
        TextView tv_pici;
        TextView tv_maozhong;
        TextView tv_pizhong;
        TextView tv_jingzhong;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_chuchang_query_fragment);
            tv_datetype = (TextView)view.findViewById(R.id.tv_time_item_recyclerview_chuchang_query_fragment);
            tv_shebei = (TextView) view.findViewById(R.id.tv1_item_recyclerview_chuchang_query_fragment);
            tv_cailiao_name = (TextView) view.findViewById(R.id.tv2_item_recyclerview_chuchang_query_fragment);
            tv_provider = (TextView) view.findViewById(R.id.tv3_item_recyclerview_chuchang_query_fragment);
            tv_pici = (TextView) view.findViewById(R.id.tv4_item_recyclerview_chuchang_query_fragment);
            tv_maozhong = (TextView) view.findViewById(R.id.tv5_item_recyclerview_chuchang_query_fragment);
            tv_pizhong = (TextView) view.findViewById(R.id.tv6_item_recyclerview_chuchang_query_fragment);
            tv_jingzhong = (TextView) view.findViewById(R.id.tv7_item_recyclerview_chuchang_query_fragment);

        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

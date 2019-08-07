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
import com.shtoone.aqxj.bean.YCLChuChangWeightFragmentDetailData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */

public class YCLChuChangWeightFragmentDetailRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context                                              context;
    private OnItemClickListener                                  mOnItemClickListener;
    private Resources                                            mResources;
    private List<YCLChuChangWeightFragmentDetailData.DataEntity> itemsData;

    public YCLChuChangWeightFragmentDetailRecycleViewAdapter(Context context, List<YCLChuChangWeightFragmentDetailData.DataEntity> itemsData) {
        this.context = context;
        mResources = context.getResources();
        this.itemsData = itemsData;
    }

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }



    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == YCLChuChangWeightFragmentDetailRecycleViewAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new YCLChuChangWeightFragmentDetailRecycleViewAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_chuchang_detail_query_fragment, parent, false));
        } else if (viewType == YCLChuChangWeightFragmentDetailRecycleViewAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new YCLChuChangWeightFragmentDetailRecycleViewAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof YCLChuChangWeightFragmentDetailRecycleViewAdapter.ItemViewHolder) {
            YCLChuChangWeightFragmentDetailRecycleViewAdapter.ItemViewHolder mItemViewHolder = (YCLChuChangWeightFragmentDetailRecycleViewAdapter.ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            YCLChuChangWeightFragmentDetailData.DataEntity item = itemsData.get(position);
            mItemViewHolder.tv1.setText(item.getCailiaoName());
            mItemViewHolder.tv2.setText(item.getGongyingshangName());
            mItemViewHolder.tv3.setText(item.getJinchangshijian());
            mItemViewHolder.tv4.setText(item.getChuchangshijian());
            mItemViewHolder.tv5.setText(item.getQianchepai());
            mItemViewHolder.tv6.setText(item.getMaozhong()+"");
            mItemViewHolder.tv7.setText(item.getPizhong()+"");
            mItemViewHolder.tv8.setText(item.getJingzhong()+"");
            mItemViewHolder.tv9.setText(item.getKouzhong()+"");
            mItemViewHolder.tv10.setText(item.getKoulv());
            mItemViewHolder.tv11.setText(String.valueOf(item.getChengzhongpiancha()));
            mItemViewHolder.tv12.setText(item.getSibangyuan());
            mItemViewHolder.tv13.setText(String.valueOf(item.getRemark()));
            if (String.valueOf(item.getPici()).equals("null")){
                mItemViewHolder.tv_pici.setText("");
            }
            else{
                mItemViewHolder.tv_pici.setText(item.getPici()+"");
            }


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
            return YCLChuChangWeightFragmentDetailRecycleViewAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return YCLChuChangWeightFragmentDetailRecycleViewAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        private TextView                            tv1;
        private TextView                            tv2;
        private TextView                            tv3;
        private TextView                            tv4;
        private TextView                                     tv5;
        private TextView                                     tv6;
        private TextView                                     tv7;
        private TextView                                     tv8;
        private TextView                                     tv9;
        private TextView                                     tv10;
        private TextView                                     tv11;
        private TextView                                     tv12;
        private TextView                                     tv13;
        private TextView                                     tv_pici;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_chuchang_query_fragment);
            tv1 = (TextView)view.findViewById(R.id.tv1_chuchang_query_detail_activity);
            tv2 = (TextView)view.findViewById(R.id.tv2_chuchang_query_detail_activity);
            tv3 = (TextView)view.findViewById(R.id.tv3_chuchang_query_detail_activity);
            tv4 = (TextView)view.findViewById(R.id.tv4_chuchang_query_detail_activity);
            tv5 = (TextView)view.findViewById(R.id.tv5_chuchang_query_detail_activity);
            tv6 = (TextView)view.findViewById(R.id.tv6_chuchang_query_detail_activity);
            tv7 = (TextView)view.findViewById(R.id.tv7_chuchang_query_detail_activity);
            tv8 = (TextView)view.findViewById(R.id.tv8_chuchang_query_detail_activity);
            tv9 = (TextView)view.findViewById(R.id.tv9_chuchang_query_detail_activity);
            tv10 = (TextView)view.findViewById(R.id.tv10_chuchang_query_detail_activity);
            tv11 = (TextView)view.findViewById(R.id.tv11_chuchang_query_detail_activity);
            tv12 = (TextView)view.findViewById(R.id.tv12_chuchang_query_detail_activity);
            tv13 = (TextView)view.findViewById(R.id.tv13_chuchang_query_detail_activity);
            tv_pici = (TextView) view.findViewById(R.id.tv_pici_chuchang_query_detail_activity);

        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

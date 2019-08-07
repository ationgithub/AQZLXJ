package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.PeiliaoTongzhidanVerifyFragmentListData;
import com.shtoone.aqxj.fragment.engineeringactivity.TaskListDetailActivity;
import com.shtoone.aqxj.fragment.laboratoryactivity.LilunPeihebiDetailActivity;
import com.shtoone.aqxj.fragment.laboratoryactivity.PeiliaoTongzhidanDetailActivity;
import com.shtoone.aqxj.ui.SlantedTextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class PeiliaoTongzhidanVerifyFragmentRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = PeiliaoTongzhidanVerifyFragmentRVAdapter.class.getSimpleName();
    private Context                                                  context;
    private OnItemClickListener                                      mOnItemClickListener;
    private List<PeiliaoTongzhidanVerifyFragmentListData.DataEntity> itemsData;
    private Resources                                                mResources;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public PeiliaoTongzhidanVerifyFragmentRVAdapter(Context context, List<PeiliaoTongzhidanVerifyFragmentListData.DataEntity> itemsData) {
        super();
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
        Log.e(TAG, "itemsData=: "+ itemsData.toString() );
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
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
            return PeiliaoTongzhidanVerifyFragmentRVAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return PeiliaoTongzhidanVerifyFragmentRVAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    private void jump1DetailActivity(int position) {
        Intent intent = new Intent(context, PeiliaoTongzhidanDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("PeiliaoTongzhidanDetail", itemsData.get(position));
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void jump2DetailActivity(int position) {
        Intent intent = new Intent(context, LilunPeihebiDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("PeiliaoTongzhidanDetail", itemsData.get(position));
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    private void jump3DetailActivity(int position) {
        Intent intent = new Intent(context, TaskListDetailActivity.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("idNumber", itemsData.get(position).getRenwuNo());
        itemsData.get(position);
        bundle.putSerializable("biaoshi", "1");
        intent.putExtras(bundle);
        context.startActivity(intent);
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof PeiliaoTongzhidanVerifyFragmentRVAdapter.ItemViewHolder) {
            PeiliaoTongzhidanVerifyFragmentRVAdapter.ItemViewHolder mItemViewHolder = (PeiliaoTongzhidanVerifyFragmentRVAdapter.ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            PeiliaoTongzhidanVerifyFragmentListData.DataEntity item = itemsData.get(position);
            Log.e(TAG, "item=:"+ item.toString() );
            mItemViewHolder.tv_depart.setText(item.getDepartname());
            mItemViewHolder.tv_noticeNo.setText(item.getSgphbNo());
            mItemViewHolder.tv_phbNo.setText(item.getLlphbNo());
            mItemViewHolder.tv_sjqd.setText(item.getSjqd());
            mItemViewHolder.tv_renwudanNo.setText(item.getRenwuNo());
            mItemViewHolder.tv_jzbw.setText(item.getJzbw());
            mItemViewHolder.tv8_item_recyclerview_peiliaotongzhidan_creatime.setText(item.getCreateDateTime());

            if (item.getState()==null||item.getState().equals("null")){
                mItemViewHolder.stv_peihebi.setText("未审核");
            }else if (item.getState().equals("0")){
                mItemViewHolder.stv_peihebi.setText("未审核");
            }else if (item.getState().equals("2")){
                mItemViewHolder.stv_peihebi.setText("审核不合格");
            }

//            mItemViewHolder.tv_noticeNo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    jump1DetailActivity(holder.getLayoutPosition());
//                }
//            });
//
//            mItemViewHolder.tv_phbNo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    jump2DetailActivity(holder.getLayoutPosition());
//                }
//            });
//
//            mItemViewHolder.tv_renwudanNo.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    jump3DetailActivity(holder.getLayoutPosition());
//                }
//            });

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
        if (viewType == PeiliaoTongzhidanVerifyFragmentRVAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new PeiliaoTongzhidanVerifyFragmentRVAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_peibitongzhidan_verify_fragment, parent, false));
        } else if (viewType == PeiliaoTongzhidanVerifyFragmentRVAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new PeiliaoTongzhidanVerifyFragmentRVAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_depart;
        TextView tv_noticeNo;
        TextView tv_phbNo;
        TextView tv_sjqd;
        TextView tv_renwudanNo;
        TextView tv_jzbw;
        TextView tv8_item_recyclerview_peiliaotongzhidan_creatime;
        SlantedTextView stv_peihebi;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_peiliaotongzhidan);
            tv_depart = (TextView) view.findViewById(R.id.tv0_item_recyclerview_peiliaotongzhidan);
            tv_noticeNo = (TextView) view.findViewById(R.id.tv1_item_recyclerview_peiliaotongzhidan);
            tv_phbNo = (TextView) view.findViewById(R.id.tv4_item_recyclerview_peiliaotongzhidan);
            tv_sjqd = (TextView) view.findViewById(R.id.tv5_item_recyclerview_peiliaotongzhidan);
            tv_renwudanNo = (TextView) view.findViewById(R.id.tv6_item_recyclerview_peiliaotongzhidan);
            tv_jzbw = (TextView) view.findViewById(R.id.tv7_item_recyclerview_peiliaotongzhidan);
            tv8_item_recyclerview_peiliaotongzhidan_creatime = (TextView) view.findViewById(R.id.tv8_item_recyclerview_peiliaotongzhidan_creatime);
            stv_peihebi = (SlantedTextView) view.findViewById(R.id.stv_peihebi);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

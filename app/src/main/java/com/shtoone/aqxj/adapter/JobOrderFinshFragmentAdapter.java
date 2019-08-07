package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.JobOrderFinshData;
import com.shtoone.aqxj.bean.UserInfoData;
import com.shtoone.aqxj.ui.MyProgressBar;
import com.shtoone.aqxj.ui.SlantedTextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */

public class JobOrderFinshFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private OnItemDelClickListener mOnItemClickListener;
    private List<JobOrderFinshData.DataEntity> itemsData;
    private Resources mResources;
    private static UserInfoData mUserInfoData;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public JobOrderFinshFragmentAdapter(Context context, List<JobOrderFinshData.DataEntity> itemsData) {
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
        mUserInfoData = BaseApplication.mUserInfoData;
    }

    public void setOnItemClickListener(OnItemDelClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == JobOrderFinshFragmentAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new JobOrderFinshFragmentAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_produced_job_order, parent, false));
        } else if (viewType == JobOrderFinshFragmentAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new JobOrderFinshFragmentAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));
            JobOrderFinshData.DataEntity item = itemsData.get(position);
            if (item.getZhuangtai().equals("0")) {
                mItemViewHolder.tvState.setText("未生成");
            } else if (item.getZhuangtai().equals("1")) {
                mItemViewHolder.tvState.setText("已生成");
            } else if (item.getZhuangtai().equals("2")) {
                mItemViewHolder.tvState.setText("生产中");
            } else if (item.getZhuangtai().equals("3")) {
                mItemViewHolder.tvState.setText("已完工");
            } else if (item.getZhuangtai().equals("-1")) {
                mItemViewHolder.tvState.setText("未提交");
            }
            mItemViewHolder.tvOpenDate.setText(item.getKaipanriqi());
            mItemViewHolder.tvCastingParts.setText(item.getJzbw());
            mItemViewHolder.tvRealVolume.setText(item.getShijifangliang());
            mItemViewHolder.tvjiecao.setText(item.getJiechao());
            mItemViewHolder.tvTaskId.setText(item.getRenwuno());
            mItemViewHolder.tvPeiBiNo.setText(item.getSgphbno());
            mItemViewHolder.tvDesignStrength.setText(item.getShuinibiaohao());
            mItemViewHolder.tvPlanVolume.setText(item.getJihuafangliang());
            mItemViewHolder.tvDesignVolume.setText(item.getShejifangliang());
            if (item.getZhuangtai().equals("2")){
                mItemViewHolder.stv_ischeck.setText("生产中");
            }else if (item.getZhuangtai().equals("3")){
                mItemViewHolder.stv_ischeck.setText("已完工");
            }

            if (!TextUtils.isEmpty(item.getBaifenbi())){
                double v = Double.parseDouble(item.getBaifenbi()) * 100;
                int jindu = (int) v;
                mItemViewHolder.pb_jindu.setProgress(jindu);
            }else {
                mItemViewHolder.pb_jindu.setProgress(0);
            }


            if (mOnItemClickListener != null) {
                mItemViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        int position = holder.getLayoutPosition();
                        mOnItemClickListener.onItemClick(holder.itemView, position);
                    }
                });

                mItemViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View v) {
                        int position = holder.getLayoutPosition();
                        mOnItemClickListener.onLongItemClick(holder.itemView, position);
                        return true;
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
            return JobOrderFinshFragmentAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return JobOrderFinshFragmentAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView        cv;
        TextView        tvState;
        TextView        tvOpenDate;
        TextView        tvCastingParts;
        TextView        tvRealVolume;
        TextView        tvjiecao;
        TextView        tvTaskId;
        TextView        tvPeiBiNo;
        TextView        tvDesignStrength;
        TextView        tvPlanVolume;
        TextView        tvDesignVolume;
        MyProgressBar   pb_jindu;
        SlantedTextView stv_ischeck;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_finsh_query_fragment);
            tvState = (TextView) view.findViewById(R.id.tvState);
            tvOpenDate = (TextView) view.findViewById(R.id.tvOpenDate);
            tvCastingParts = (TextView) view.findViewById(R.id.tvCastingParts);
            tvRealVolume = (TextView) view.findViewById(R.id.tvRealVolume);
            tvjiecao = (TextView) view.findViewById(R.id.tvjiecao);
            tvTaskId = (TextView) view.findViewById(R.id.tvTaskId);
            tvPeiBiNo = (TextView) view.findViewById(R.id.tvPeiBiNo);
            tvDesignStrength = (TextView) view.findViewById(R.id.tvDesignStrength);
            tvPlanVolume = (TextView) view.findViewById(R.id.tvPlanVolume);
            pb_jindu = (MyProgressBar) view.findViewById(R.id.executeProgress);
            tvDesignVolume = (TextView) view.findViewById(R.id.tvDesignVolume);
            stv_ischeck = (SlantedTextView) view.findViewById(R.id.stv_ischeck);

        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.JobOrderUnfinshData;
import com.shtoone.aqxj.bean.UserInfoData;
import com.shtoone.aqxj.ui.SlantedTextView;

import java.util.List;

public class JobOrderUnfinshFragmentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private OnItemDelClickListener mOnItemClickListener;
    private List<JobOrderUnfinshData.DataEntity> itemsData;
    private Resources mResources;
    private static UserInfoData mUserInfoData;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }


    public JobOrderUnfinshFragmentAdapter(Context context, List<JobOrderUnfinshData.DataEntity> itemsData) {
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
        if (viewType == JobOrderUnfinshFragmentAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new JobOrderUnfinshFragmentAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_unproduced_job_order, parent, false));
        } else if (viewType == JobOrderUnfinshFragmentAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new JobOrderUnfinshFragmentAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));
            JobOrderUnfinshData.DataEntity item = itemsData.get(position);
            if (item.getZhuangtai().equals("0")) {
                mItemViewHolder.tvState.setText("未配料");
            } else if (item.getZhuangtai().equals("1")) {
                mItemViewHolder.tvState.setText("已配料");
            } else if (item.getZhuangtai().equals("2")) {
                mItemViewHolder.tvState.setText("生产中");
            } else if (item.getZhuangtai().equals("3")) {
                mItemViewHolder.tvState.setText("已完成");
            } else if (item.getZhuangtai().equals("-1")) {
                mItemViewHolder.tvState.setText("未提交");
            }else if (item.getZhuangtai().equals("-2")&&item.getState().equals("0")) {
                mItemViewHolder.tvState.setText("未审核");
            }else if (item.getZhuangtai().equals("-2")&&item.getState().equals("2")) {
                mItemViewHolder.tvState.setText("审核不合格");
            }

            /********************************************/
            if(item.isSelected()){
                 mItemViewHolder.item_root.setBackgroundColor(Color.parseColor("#00EEEE"));
            }else {
                 mItemViewHolder.item_root.setBackgroundColor(Color.parseColor("#e7e9fd"));
            }
            /********************************************/
            mItemViewHolder.tvOpenDate.setText(item.getKaipanriqi());
            mItemViewHolder.tvProjectName.setText(item.getGcmc());
            mItemViewHolder.tvCastingParts.setText(item.getJzbw());
            mItemViewHolder.tvCreateDate.setText(item.getCreatetime());
            mItemViewHolder.tvCreatePerson.setText(item.getCreateperson());
            mItemViewHolder.tvTaskId.setText(item.getRenwuno());
            mItemViewHolder.tvPeiBiNo.setText(item.getSgphbno());
            mItemViewHolder.tvDesignStrength.setText(item.getShuinibiaohao());
            mItemViewHolder.tvPlanVolume.setText(item.getJihuafangliang());
            if (item.getZhuangtai().equals("0")) {
                mItemViewHolder.stv_ischeck.setText("未配料");
            } else if (item.getZhuangtai().equals("1")) {
                mItemViewHolder.stv_ischeck.setText("已配料");
            } else if (item.getZhuangtai().equals("2")) {
                mItemViewHolder.stv_ischeck.setText("生产中");
            } else if (item.getZhuangtai().equals("3")) {
                mItemViewHolder.stv_ischeck.setText("已完成");
            } else if (item.getZhuangtai().equals("-1")) {
                mItemViewHolder.stv_ischeck.setText("未提交");
            }else if (item.getZhuangtai().equals("-2")) {
                mItemViewHolder.stv_ischeck.setText("未审核");
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
//            if (itemsData.size() > 4) {
//                return itemsData.size() + 1;
//            } else {
                return itemsData.size();
            //}
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItemCount() > 4 && position + 1 == getItemCount()) {
            return JobOrderUnfinshFragmentAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return JobOrderUnfinshFragmentAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView        cv;
        TextView        tvState;
        TextView        tvOpenDate;
        TextView        tvProjectName;
        TextView        tvCastingParts;
        TextView        tvCreateDate;
        TextView        tvCreatePerson;
        TextView        tvTaskId;
        TextView        tvPeiBiNo;
        TextView        tvDesignStrength;
        TextView        tvPlanVolume;
        SlantedTextView stv_ischeck;
        LinearLayout item_root;
        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_unfinsh_query_fragment);
            tvState = (TextView) view.findViewById(R.id.tvState);
            tvOpenDate = (TextView) view.findViewById(R.id.tvOpenDate);
            tvProjectName = (TextView) view.findViewById(R.id.tvProjectName);
            tvCastingParts = (TextView) view.findViewById(R.id.tvCastingParts);
            tvCreateDate = (TextView) view.findViewById(R.id.tvCreateDate);
            tvCreatePerson = (TextView) view.findViewById(R.id.tvCreatePerson);
            tvTaskId = (TextView) view.findViewById(R.id.tvTaskId);
            tvPeiBiNo = (TextView) view.findViewById(R.id.tvPeiBiNo);
            tvDesignStrength = (TextView) view.findViewById(R.id.tvDesignStrength);
            tvPlanVolume = (TextView) view.findViewById(R.id.tvPlanVolume);
            stv_ischeck = (SlantedTextView) view.findViewById(R.id.stv_ischeck);
            item_root = (LinearLayout) view.findViewById(R.id.item_root);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }

}

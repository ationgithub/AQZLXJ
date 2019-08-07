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
import com.shtoone.aqxj.bean.WZProjectProgressQueryData;
import com.shtoone.aqxj.ui.MyProgressBar;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */

public class WZProjectProgressQueryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<WZProjectProgressQueryData.DataEntity> itemsData;
    private Resources mResources;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public WZProjectProgressQueryAdapter(Context context, List<WZProjectProgressQueryData.DataEntity> itemsData) {
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == WZProjectProgressQueryAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new WZProjectProgressQueryAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_wzprogress_query_fragment, parent, false));
        } else if (viewType == WZProjectProgressQueryAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new WZProjectProgressQueryAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {

        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            WZProjectProgressQueryData.DataEntity item = itemsData.get(position);
            mItemViewHolder.tv_no.setText(item.getId() + "");
            mItemViewHolder.tv_name.setText(item.getProjectName());
            mItemViewHolder.tv_sheji.setText(String.valueOf(item.getShejifangliang()));
            mItemViewHolder.tv_shiji.setText(String.valueOf(item.getShijifangliang()));
            double v = item.getJindu() * 100;
            int jindu = (int) v;
            mItemViewHolder.pb_progress.setProgress(jindu);
            if (item.getProjectType() == 0) {
                mItemViewHolder.tv_projecttype.setText("单位工程");
            } else if (item.getProjectType() == 1) {
                mItemViewHolder.tv_projecttype.setText("分部工程");
            } else if (item.getProjectType() == 2) {
                mItemViewHolder.tv_projecttype.setText("分项工程");
            } else if (item.getProjectType() == 3) {
                mItemViewHolder.tv_projecttype.setText("浇筑部位");
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
            return WZProjectProgressQueryAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return WZProjectProgressQueryAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_no;
        TextView tv_name;
        TextView tv_sheji;
        TextView tv_shiji;
        MyProgressBar pb_progress;
        TextView tv_projecttype;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_wzprogress_query_fragment);
            tv_no = (TextView) view.findViewById(R.id.tv_no_item_recyclerview_wzprogress_query_fragment);
            tv_name = (TextView) view.findViewById(R.id.tv_name_item_recyclerview_wzprogress_query_fragment);
            tv_sheji = (TextView) view.findViewById(R.id.tv_sheji_item_recyclerview_wzprogress_query_fragment);
            tv_shiji = (TextView) view.findViewById(R.id.tv_shiji_item_recyclerview_wzprogress_query_fragment);
            pb_progress = (MyProgressBar) view.findViewById(R.id.pb_wzprogress);
            tv_projecttype = (TextView) view.findViewById(R.id.tv_projecttype_item_recyclerview_wzprojress_query_fragment);

        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

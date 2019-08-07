package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.TaskListImpQueryFragmenData;
import com.shtoone.aqxj.ui.SlantedTextView;

import java.util.List;

/**
 * Created by Administrator on 2017/8/14.
 */
public class TaskListImpQueryFragmentRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = TaskListImpQueryFragmentRecyclerViewAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<TaskListImpQueryFragmenData.DataBean> itemsData;
    private Resources mResources;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public TaskListImpQueryFragmentRecyclerViewAdapter(Context context, List<TaskListImpQueryFragmenData.DataBean> itemsData) {
        super();
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
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
            return TaskListImpQueryFragmentRecyclerViewAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return TaskListImpQueryFragmentRecyclerViewAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof TaskListImpQueryFragmentRecyclerViewAdapter.ItemViewHolder) {
            TaskListImpQueryFragmentRecyclerViewAdapter.ItemViewHolder mItemViewHolder = (TaskListImpQueryFragmentRecyclerViewAdapter.ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            TaskListImpQueryFragmenData.DataBean item = itemsData.get(position);
            mItemViewHolder.tv_state.setText(getState(item.getZhuangtai()));
            mItemViewHolder.tv_time.setText(item.getCreateTime());
            mItemViewHolder.tv_renwuno.setText(item.getRenwuNo());
            mItemViewHolder.tv_pbno.setText(item.getSgphbNo());
            mItemViewHolder.tv_gcmc.setText(item.getGcmc());
            mItemViewHolder.tv5_item_recyclerview_jihua.setText(item.getJihuafangliang());
            mItemViewHolder.tv6_item_recyclerview_sheji.setText(item.getShejifangliang());
            double baifenbi = item.getBaifenbi()* 100;
            int jindu = (int)baifenbi;
            mItemViewHolder.tv_progress.setProgress(jindu);
            if (String.valueOf(item.getZhuangtai()).equals("null")){
                mItemViewHolder.stv_ischeck.setText("");
            }else if (item.getZhuangtai().equals("1")){
                mItemViewHolder.stv_ischeck.setText("已配料");
            }else if (item.getZhuangtai().equals("0")){
                mItemViewHolder.stv_ischeck.setText("未配料");
            }else if (item.getZhuangtai().equals("2")){
                mItemViewHolder.stv_ischeck.setText("生产中");
            }else if (item.getZhuangtai().equals("3")){
                mItemViewHolder.stv_ischeck.setText("已完成");
            }else if (item.getZhuangtai().equals("-1")){
                mItemViewHolder.stv_ischeck.setText("未提交");
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

    public String getState(String zhuangtai){
        if(null != zhuangtai){
            String state = "";
            if("0".equals(zhuangtai)){
                state = context.getResources().getString(R.string.weipeiliao);
            }else if ("1".equals(zhuangtai)){
                state = context.getResources().getString(R.string.yipeiliao);
            }else if ("2".equals(zhuangtai)){
                state = context.getResources().getString(R.string.shengchangzhong);
            }else if ("3".equals(zhuangtai)){
                state = context.getResources().getString(R.string.yiwancheng);
            }
            return state;
        }else {
            return "";
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TaskListImpQueryFragmentRecyclerViewAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new TaskListImpQueryFragmentRecyclerViewAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_tsklist_query_fragment, parent, false));
        } else if (viewType == TaskListImpQueryFragmentRecyclerViewAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new TaskListImpQueryFragmentRecyclerViewAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView         cv;
        TextView         tv_state;
        TextView         tv_time;
        TextView         tv_renwuno;
        TextView         tv_pbno;
        TextView         tv_gcmc;
        TextView         tv5_item_recyclerview_jihua;
        TextView         tv6_item_recyclerview_sheji;
        ProgressBar      tv_progress;
        SlantedTextView stv_ischeck;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_tasklist_query_fragment);
            tv_state = (TextView) view.findViewById(R.id.tv0_item_recyclerview_tasklist_query_fragment);
            tv_time = (TextView) view.findViewById(R.id.tv1_item_recyclerview_tasklist_query_fragment);
            tv_renwuno = (TextView) view.findViewById(R.id.tv2_item_recyclerview_tasklist_query_fragment);
            tv_pbno = (TextView) view.findViewById(R.id.tv3_item_recyclerview_tasklist_query_fragment);
            tv_gcmc = (TextView) view.findViewById(R.id.tv4_item_recyclerview_tasklist_query_fragment);
            tv_progress = (ProgressBar) view.findViewById(R.id.tv5_item_recyclerview_tasklist_query_fragment);
            tv5_item_recyclerview_jihua = (TextView) view.findViewById(R.id.tv5_item_recyclerview_jihua);
            tv6_item_recyclerview_sheji = (TextView) view.findViewById(R.id.tv6_item_recyclerview_sheji);
            stv_ischeck = (SlantedTextView) view.findViewById(R.id.stv_ischeck);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

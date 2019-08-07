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
import com.shtoone.aqxj.bean.TaskListDetailActivityData;
import com.socks.library.KLog;

import java.util.List;

/**
 * Created by Administrator on 2017/8/21.
 */
public class TaskListDetailReportRecylerView extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private static final String TAG = TaskListDetailReportRecylerView.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<TaskListDetailActivityData.ZYJLDataBean> itemsData;
    private Resources mResources;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public TaskListDetailReportRecylerView(Context context, List<TaskListDetailActivityData.ZYJLDataBean> itemsData) {
        super();
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
        KLog.e(TAG, "--------TaskListDetailReportRecylerView----------");
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
        if (holder instanceof TaskListDetailReportRecylerView.ItemViewHolder) {
            TaskListDetailReportRecylerView.ItemViewHolder mItemViewHolder = (TaskListDetailReportRecylerView.ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            TaskListDetailActivityData.ZYJLDataBean item = itemsData.get(position);

            mItemViewHolder.tv_renwudan_origin.setText(item.getRenwuno1());
            mItemViewHolder.tv_renwudan.setText(item.getRenwuno2());
            mItemViewHolder.tv_fangliang.setText(item.getFangliang());
            mItemViewHolder.tv_time.setText(item.getShijian());
            mItemViewHolder.tv_person.setText(item.getCaozuozhe());
            mItemViewHolder.tv_type.setText(getType(item.getType()));
            mItemViewHolder.tv_tranger_type.setText(getTranferType(item.getRenwuno1(), item.getRenwuno2()));
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewHolder holder = new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_report_tasklist_detail, parent, false));
        return holder;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_renwudan_origin;
        TextView tv_renwudan;
        TextView tv_fangliang;
        TextView tv_time;
        TextView tv_person;
        TextView tv_type;
        TextView tv_tranger_type;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_report_tasklist_detail);
            tv_renwudan_origin = (TextView) view.findViewById(R.id.tv0_item_recyclerview_report_tasklist_detail);
            tv_renwudan = (TextView) view.findViewById(R.id.tv1_item_recyclerview_report_tasklist_detail);
            tv_fangliang = (TextView) view.findViewById(R.id.tv2_item_recyclerview_report_tasklist_detail);
            tv_time = (TextView) view.findViewById(R.id.tv3_item_recyclerview_report_tasklist_detail);
            tv_person = (TextView) view.findViewById(R.id.tv4_item_recyclerview_report_tasklist_detail);
            tv_type = (TextView) view.findViewById(R.id.tv5_item_recyclerview_report_tasklist_detail);
            tv_tranger_type = (TextView) view.findViewById(R.id.tv6_item_recyclerview_report_tasklist_detail);
        }
    }

    public String getType(String type) {
        String finalType = "";
        if ("0".equals(type)) {
            finalType = context.getResources().getString(R.string.bufang);
        } else if ("1".equals(type)) {
            finalType = context.getResources().getString(R.string.fangliang_zy);
        }
        return finalType;
    }

    public String getTranferType(String rewuno1, String rewuno2) {
        String tranferType = "";
        if (rewuno1.equals(rewuno2)) {
            tranferType = context.getResources().getString(R.string.zhuanru);
        } else {
            tranferType = context.getResources().getString(R.string.zhuanchu);
        }
        return tranferType;
    }
}

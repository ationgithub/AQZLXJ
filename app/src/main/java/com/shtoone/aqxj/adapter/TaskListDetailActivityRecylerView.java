package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.TaskListDetailActivityData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/15.
 */
public class TaskListDetailActivityRecylerView extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = TaskListDetailActivityRecylerView.class.getSimpleName();
    private Context context;
    private List<TaskListDetailActivityData.XGJLDataBean> xgjlDataBeen;
    private Resources mResources;

    public TaskListDetailActivityRecylerView(Context context, List<TaskListDetailActivityData.XGJLDataBean> xgjlDataBeen) {
        super();
        this.context = context;
        this.xgjlDataBeen = xgjlDataBeen;
        mResources = context.getResources();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ItemViewHolder holder = new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recylerview_task_list_activity, parent, false));
        return holder;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_renwuno;
        TextView tv_person;
        TextView tv_time;
        TextView tv_way;


        public ItemViewHolder(View view) {
            super(view);
            tv_renwuno = (TextView) view.findViewById(R.id.tv_renwuno_item_recyclerview_task_list_acticity);
            tv_person = (TextView) view.findViewById(R.id.tv_person_item_recyclerview_task_list_acticity);
            tv_time = (TextView) view.findViewById(R.id.tv_time_item_recyclerview_task_list_acticity);
            tv_way = (TextView) view.findViewById(R.id.tv_way_item_recyclerview_task_list_acticity);

        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            TaskListDetailActivityData.XGJLDataBean item = xgjlDataBeen.get(position);
            ViewGroup mViewGroup = (ViewGroup) mItemViewHolder.tv_time.getParent();
            mViewGroup.setBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));
            mItemViewHolder.tv_renwuno.setText(item.getRenwuno());
            mItemViewHolder.tv_person.setText(item.getXiugairen());
            mItemViewHolder.tv_time.setText(item.getXiugaishijian());
            mItemViewHolder.tv_way.setText(getModifyType(item.getType()));
        }
    }

    @Override
    public int getItemCount() {
        if (xgjlDataBeen != null && xgjlDataBeen.size() > 0) {
            return xgjlDataBeen.size();
        }
        return 0;
    }

    public String getModifyType(String type){
        String modifyType = "";
        if("0".equals(type)){
            modifyType = context.getResources().getString(R.string.add);
        }else if("1".equals(type)){
            modifyType = context.getResources().getString(R.string.modify);
        }else if("2".equals(type)){
            modifyType = context.getResources().getString(R.string.tijiao);
        }else if("3".equals(type)){
            modifyType = context.getResources().getString(R.string.delete);
        }else if("4".equals(type)){
            modifyType = context.getResources().getString(R.string.end);
        }

        return modifyType;
    }

}

package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.SlumpData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */
public class SlumpActivityRecylerView extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = SlumpActivityRecylerView.class.getSimpleName();
    private Context context;
    private List<SlumpData.DataBean> listData;
    private Resources mResources;
    private OnItemClickListener mOnItemClickListener;

    public SlumpActivityRecylerView(Context context, List<SlumpData.DataBean> listData) {

        super();
        this.context = context;
        this.listData = listData;
        mResources = context.getResources();
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof SlumpActivityRecylerView.ItemViewHolder) {
            SlumpActivityRecylerView.ItemViewHolder mItemViewHolder = (SlumpActivityRecylerView.ItemViewHolder) holder;
            SlumpData.DataBean item = listData.get(position);
            mItemViewHolder.tv_slump.setText(item.getTypename());

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
        if (listData != null && listData.size() > 0) {
            return listData.size();
        }
        return 0;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        SlumpActivityRecylerView.ItemViewHolder holder = new SlumpActivityRecylerView.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recylerview_slump_activity, parent, false));
        return holder;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_slump;

        public ItemViewHolder(View view) {
            super(view);
            tv_slump = (TextView) view.findViewById(R.id.tv_slump_item);

        }
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

}

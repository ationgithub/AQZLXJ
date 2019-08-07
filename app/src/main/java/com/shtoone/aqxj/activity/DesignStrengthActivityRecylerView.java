package com.shtoone.aqxj.activity;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.adapter.OnItemClickListener;
import com.shtoone.aqxj.bean.DesignStrengthData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */
public class DesignStrengthActivityRecylerView extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = DesignStrengthActivityRecylerView.class.getSimpleName();
    private Context context;
    private List<DesignStrengthData.DataBean> listData;
    private Resources mResources;
    private OnItemClickListener mOnItemClickListener;

    public DesignStrengthActivityRecylerView(Context context, List<DesignStrengthData.DataBean> listData) {
        super();
        this.context = context;
        this.listData = listData;
        mResources = context.getResources();
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof DesignStrengthActivityRecylerView.ItemViewHolder) {
            DesignStrengthActivityRecylerView.ItemViewHolder mItemViewHolder = (DesignStrengthActivityRecylerView.ItemViewHolder) holder;
            DesignStrengthData.DataBean item = listData.get(position);
            mItemViewHolder.tv_design_strength.setText(item.getTypename());

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
        DesignStrengthActivityRecylerView.ItemViewHolder holder = new DesignStrengthActivityRecylerView.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recylerview_design_strength_activity, parent, false));
        return holder;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_design_strength;

        public ItemViewHolder(View view) {
            super(view);
            tv_design_strength = (TextView) view.findViewById(R.id.tv_design_strength_item);

        }
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }
}

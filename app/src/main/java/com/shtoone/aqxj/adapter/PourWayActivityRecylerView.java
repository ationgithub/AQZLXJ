package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.PourWayData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */
public class PourWayActivityRecylerView extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = PourWayActivityRecylerView.class.getSimpleName();
    private Context context;
    private List<PourWayData.DataBean> listData;
    private Resources mResources;
    private OnItemClickListener mOnItemClickListener;

    public PourWayActivityRecylerView(Context context, List<PourWayData.DataBean> listData) {
        super();
        this.context = context;
        this.listData = listData;
        Log.e(TAG, "listData=:"+listData.toString() );
        mResources = context.getResources();
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PourWayActivityRecylerView.ItemViewHolder) {
            PourWayActivityRecylerView.ItemViewHolder mItemViewHolder = (PourWayActivityRecylerView.ItemViewHolder) holder;
            PourWayData.DataBean item = listData.get(position);
            Log.e(TAG, "item=:"+item.toString());
            mItemViewHolder.tv_pour_way.setText(item.getTypename());

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
        PourWayActivityRecylerView.ItemViewHolder holder = new PourWayActivityRecylerView.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recylerview_pour_way_activity, parent, false));
        return holder;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView tv_pour_way;

        public ItemViewHolder(View view) {
            super(view);
            tv_pour_way = (TextView) view.findViewById(R.id.tv_pour_way_item);

        }
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

}

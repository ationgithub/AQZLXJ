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
import com.shtoone.aqxj.bean.PourPositionData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/22.
 */
public class PourPositionActivityRecylerView  extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private static final String TAG = PourPositionActivityRecylerView.class.getSimpleName();
    private Context context;
    private List<PourPositionData.DataBean> listData;
    private Resources mResources;
    private OnItemClickListener mOnItemClickListener;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public PourPositionActivityRecylerView(Context context, List<PourPositionData.DataBean> listData) {
        super();
        this.context = context;
        this.listData = listData;
        mResources = context.getResources();
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof PourPositionActivityRecylerView.ItemViewHolder) {
            PourPositionActivityRecylerView.ItemViewHolder mItemViewHolder = (PourPositionActivityRecylerView.ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));
            PourPositionData.DataBean item = listData.get(position);
            mItemViewHolder.tv_projectname.setText(item.getZjiedian());
            mItemViewHolder.tv_fenxiang.setText(item.getBjiedian());
            mItemViewHolder.tv_fenbu.setText(item.getYjiedian());
            mItemViewHolder.tv_jzbw.setText(item.getProjectname());
            mItemViewHolder.tv_sjqd.setText(item.getShejiqiangdu());
            mItemViewHolder.tv_sjfl.setText(item.getShejifangliang());

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
            //这里的10是根据分页查询，一页该显示的条数
            if (listData.size() > 4) {
                return listData.size() + 1;
            } else {
                return listData.size();
            }
        }
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        if (getItemCount() > 4 && position + 1 == getItemCount()) {
            return PourPositionActivityRecylerView.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return PourPositionActivityRecylerView.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == PourPositionActivityRecylerView.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new PourPositionActivityRecylerView.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recylerview_pour_position_activity, parent, false));
        } else if (viewType == PourPositionActivityRecylerView.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new PourPositionActivityRecylerView.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_projectname;
        TextView tv_fenxiang;
        TextView tv_fenbu;
        TextView tv_jzbw;
        TextView tv_sjqd;
        TextView tv_sjfl;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_pourposition);
            tv_projectname = (TextView) view.findViewById(R.id.tv0_item_recyclerview_projectname);
            tv_fenxiang = (TextView) view.findViewById(R.id.tv1_item_recyclerview_fenxiangproject);
            tv_fenbu = (TextView) view.findViewById(R.id.tv3_item_recyclerview_fenbuproject);
            tv_jzbw = (TextView) view.findViewById(R.id.tv4_item_recyclerview_jzposition);
            tv_sjqd = (TextView) view.findViewById(R.id.tv5_item_recyclerview_sjqd);
            tv_sjfl = (TextView) view.findViewById(R.id.tv7_item_recyclerview_sjfangliang);
        }
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

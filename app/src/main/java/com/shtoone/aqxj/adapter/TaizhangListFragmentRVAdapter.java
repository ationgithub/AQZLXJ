package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.QuyangFragmentListData;
import com.shtoone.aqxj.bean.TaizhangData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class TaizhangListFragmentRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = TaizhangListFragmentRVAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<TaizhangData.DataBean> itemsData;
    private Resources mResources;
    private QuyangFragmentListData.DataBean db;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public TaizhangListFragmentRVAdapter(Context context, List<TaizhangData.DataBean> itemsData,QuyangFragmentListData.DataBean db) {
        super();
        this.context = context;
        this.itemsData = itemsData;
        this.db = db;
        mResources = context.getResources();
        Log.e(TAG, "itemsData=: "+ itemsData.toString() );
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
            return TaizhangListFragmentRVAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return TaizhangListFragmentRVAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }



    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof TaizhangListFragmentRVAdapter.ItemViewHolder) {
            TaizhangListFragmentRVAdapter.ItemViewHolder mItemViewHolder = (TaizhangListFragmentRVAdapter.ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            TaizhangData.DataBean item = itemsData.get(position);
            Log.e(TAG, "item=:"+ item.toString() );
            mItemViewHolder.tv_cailiaomingchen1.setText(db.getCailiaoName());
            mItemViewHolder.tv_quhangshijian.setText(item.getQuyangshijian());
            mItemViewHolder.tv_number.setText(String.valueOf(item.getTaizhangid()));
            mItemViewHolder.tv_jinchangshijian1.setText(db.getJinchangshijian());
            mItemViewHolder.tv_picihao1.setText(db.getPici());

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
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == TaizhangListFragmentRVAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new TaizhangListFragmentRVAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_taizhanglist_fragment, parent, false));
        } else if (viewType == TaizhangListFragmentRVAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new TaizhangListFragmentRVAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_cailiaomingchen1;
        TextView tv_quhangshijian;
        TextView tv_number;
        TextView tv_jinchangshijian1;
        TextView tv_picihao1;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_taizhang);
            tv_cailiaomingchen1 = (TextView) view.findViewById(R.id.tv1_item_recyclerview_quyang1);
            tv_quhangshijian = (TextView) view.findViewById(R.id.tv6_item_recyclerview_taizhang);
            tv_number = (TextView) view.findViewById(R.id.tv7_item_recyclerview_taizhang);
            tv_jinchangshijian1 = (TextView) view.findViewById(R.id.tv4_item_recyclerview_quyang1);
            tv_picihao1 = (TextView) view.findViewById(R.id.tv5_item_recyclerview_quyang1);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

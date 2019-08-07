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

import java.util.List;

/**
 * Created by Administrator on 2017/8/10.
 */
public class QuyangFragmentRVAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private static final String TAG = QuyangFragmentRVAdapter.class.getSimpleName();
    private Context context;
    private OnItemClickListener mOnItemClickListener;
    private List<QuyangFragmentListData.DataBean> itemsData;
    private Resources mResources;

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public QuyangFragmentRVAdapter(Context context, List<QuyangFragmentListData.DataBean> itemsData) {
        super();
        this.context = context;
        this.itemsData = itemsData;
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
            return QuyangFragmentRVAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return QuyangFragmentRVAdapter.ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }



    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, final int position) {
        if (holder instanceof QuyangFragmentRVAdapter.ItemViewHolder) {
            QuyangFragmentRVAdapter.ItemViewHolder mItemViewHolder = (QuyangFragmentRVAdapter.ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            QuyangFragmentListData.DataBean item = itemsData.get(position);
            Log.e(TAG, "item=:"+ item.toString() );
            mItemViewHolder.tv_depart.setText(item.getDepartname());
            mItemViewHolder.tv_matName.setText(item.getCailiaoName());
            mItemViewHolder.tv_jinzhong.setText(item.getJingzhongT());
            mItemViewHolder.tv_maozhong.setText(item.getMaozhongT());
            mItemViewHolder.tv_matNo.setText(item.getCailiaoNo());
            mItemViewHolder.tv_liangcang.setText(item.getLCname());
            mItemViewHolder.tv_bfName.setText(item.getBfName());
            mItemViewHolder.tv_jingchangTime.setText(item.getJinchangshijian());
            mItemViewHolder.tv_pici.setText(item.getPici());

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
        if (viewType == QuyangFragmentRVAdapter.ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new QuyangFragmentRVAdapter.ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recyclerview_quyang_fragment, parent, false));
        } else if (viewType == QuyangFragmentRVAdapter.ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new QuyangFragmentRVAdapter.FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tv_depart;
        TextView tv_matName;
        TextView tv_jinzhong;
        TextView tv_maozhong;
        TextView tv_matNo;
        TextView tv_liangcang;
        TextView tv_bfName;
        TextView tv_jingchangTime;
        TextView tv_pici;
        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_quyang);
            tv_depart = (TextView) view.findViewById(R.id.tv0_item_recyclerview_quyang);
            tv_matName = (TextView) view.findViewById(R.id.tv1_item_recyclerview_quyang);
            tv_jinzhong = (TextView) view.findViewById(R.id.tv2_item_recyclerview_produce_quyang);
            tv_maozhong = (TextView) view.findViewById(R.id.tv3_item_recyclerview_produce_query_quyang);
            tv_matNo = (TextView) view.findViewById(R.id.tv4_item_recyclerview_quyang);
            tv_liangcang = (TextView) view.findViewById(R.id.tv5_item_recyclerview_quyang);
            tv_bfName = (TextView) view.findViewById(R.id.tv6_item_recyclerview_quyang);
            tv_jingchangTime = (TextView) view.findViewById(R.id.tv7_item_recyclerview_quyang);
            tv_pici = (TextView) view.findViewById(R.id.tv8_item_pici);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

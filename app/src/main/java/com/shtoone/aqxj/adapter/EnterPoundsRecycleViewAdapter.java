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
import com.shtoone.aqxj.bean.EnterPoundsListData;

import java.util.List;

public class EnterPoundsRecycleViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<EnterPoundsListData.DataEntity> itemData;
    private Resources mResources;
    private OnItemClickListener mOnItemClickListener;

    public EnterPoundsRecycleViewAdapter(Context context, List<EnterPoundsListData.DataEntity> itemData){
        super();
        this.context = context;
        this.itemData = itemData;
        mResources = context.getResources();
    }

    public enum ITEM_TYPE {
        TYPE_ITEM, TYPE_FOOTER
    }

    public void setOnItemClickListener(OnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE.TYPE_ITEM.ordinal()) {
            return new ItemViewHolder(LayoutInflater.from(context).inflate(R.layout.item_recycleview_enterpoundsquery, parent, false));
        } else if (viewType == ITEM_TYPE.TYPE_FOOTER.ordinal()) {
            return new FootViewHolder(LayoutInflater.from(context).inflate(R.layout.recyclerview_item_foot, parent, false));
        }
        return null;
    }

    @Override
    public void onBindViewHolder(final RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof ItemViewHolder) {
            ItemViewHolder mItemViewHolder = (ItemViewHolder) holder;
            mItemViewHolder.cv.setCardBackgroundColor(position % 2 == 0 ? mResources.getColor(R.color.material_teal_50) : mResources.getColor(R.color.material_blue_50));

            EnterPoundsListData.DataEntity item = itemData.get(position);
            mItemViewHolder.tvWaagName.setText(item.getBanhezhanminchen());
            mItemViewHolder.tvMaterialName.setText(item.getCailiaoname());
            mItemViewHolder.tvJingzhong.setText(item.getJingzhong());
            mItemViewHolder.tvEnterpoundTimes.setText(item.getJinchangshijian());
            mItemViewHolder.tvProviderName.setText(item.getGongyingshangname());
            mItemViewHolder.tvIshege.setText(item.getPici());
            mItemViewHolder.tvliaocang.setText(item.getLCname());
            mItemViewHolder.tvbangdanhao.setText(item.getSerialNo());

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
    public int getItemViewType(int position) {
        if (getItemCount() > 4 && position + 1 == getItemCount()) {
            return ITEM_TYPE.TYPE_FOOTER.ordinal();
        } else {
            return ITEM_TYPE.TYPE_ITEM.ordinal();
        }
    }

    @Override
    public int getItemCount() {
        if (itemData != null && itemData.size() > 0) {
            //这里的10是根据分页查询，一页该显示的条数
            if (itemData.size() > 4) {
                return itemData.size() + 1;
            } else {
                return itemData.size();
            }
        }
        return 0;
    }

    static class ItemViewHolder extends RecyclerView.ViewHolder {
        CardView cv;
        TextView tvWaagName;
        TextView tvMaterialName;
        TextView tvEnterpoundTimes;
        TextView tvProviderName;
        TextView tvJingzhong;
        TextView tvIshege;
        TextView tvliaocang;
        TextView tvbangdanhao;

        public ItemViewHolder(View view) {
            super(view);
            cv = (CardView) view.findViewById(R.id.cv_item_recyclerview_pitch_produce_query_fragment);
            tvWaagName= (TextView) view.findViewById(R.id.tvWaagName);
            tvMaterialName= (TextView) view.findViewById(R.id.tvMaterialName);
            tvEnterpoundTimes= (TextView) view.findViewById(R.id.tvEnterpoundTimes);
            tvProviderName= (TextView) view.findViewById(R.id.tvProviderName);
            tvJingzhong= (TextView) view.findViewById(R.id.tv_jingzhongV);
            tvIshege= (TextView) view.findViewById(R.id.isHege);
            tvliaocang= (TextView) view.findViewById(R.id.liaocang);
            tvbangdanhao= (TextView) view.findViewById(R.id.bangdanhao);
        }
    }

    static class FootViewHolder extends RecyclerView.ViewHolder {

        public FootViewHolder(View view) {
            super(view);
        }
    }
}

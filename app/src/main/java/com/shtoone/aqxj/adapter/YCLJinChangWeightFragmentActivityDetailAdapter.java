package com.shtoone.aqxj.adapter;

import android.content.Context;
import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.shtoone.aqxj.bean.YCLJinChangWeightFragmentDetailData;

import java.util.List;

/**
 * Created by Administrator on 2017/8/8.
 */

public class YCLJinChangWeightFragmentActivityDetailAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{

    private Context   context;
    private Resources mResources;
    private List<YCLJinChangWeightFragmentDetailData.DataEntity> itemsData;

    public YCLJinChangWeightFragmentActivityDetailAdapter(Context context, List<YCLJinChangWeightFragmentDetailData.DataEntity> itemsData) {
        super();
        this.context = context;
        this.itemsData = itemsData;
        mResources = context.getResources();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        if (itemsData != null && itemsData.size() > 0) {
            return itemsData.size();
        }
        return 0;
    }
}

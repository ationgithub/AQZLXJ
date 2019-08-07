package com.shtoone.aqxj.adapter.factory;

import android.support.v7.widget.RecyclerView;
import android.view.animation.OvershootInterpolator;

import jp.wasabeef.recyclerview.adapters.ScaleInAnimationAdapter;
import jp.wasabeef.recyclerview.adapters.SlideInLeftAnimationAdapter;

/**
 * Created by liangfeng on 2017/11/6.
 */

public class ScaleInAnimationAdapterFactory {

    public ScaleInAnimationAdapter getAdapter(RecyclerView.Adapter adapter){
        SlideInLeftAnimationAdapter mSlideInLeftAnimationAdapter = new SlideInLeftAnimationAdapter(adapter);
        mSlideInLeftAnimationAdapter.setDuration(500);
        mSlideInLeftAnimationAdapter.setInterpolator(new OvershootInterpolator(.5f));
        ScaleInAnimationAdapter scaleInAnimationAdapter = new ScaleInAnimationAdapter(mSlideInLeftAnimationAdapter);
        return scaleInAnimationAdapter;
    }
}

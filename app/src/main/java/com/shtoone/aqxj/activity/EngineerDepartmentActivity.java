package com.shtoone.aqxj.activity;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.event.EventData;
import com.shtoone.aqxj.fragment.engineeringactivity.JobOrderFragment;
import com.shtoone.aqxj.fragment.engineeringactivity.MaterialConsumeFragment;
import com.shtoone.aqxj.fragment.engineeringactivity.TaskListImpQueryFragment;
import com.shtoone.aqxj.fragment.mainactivity.YCLWeightHouseQuertFragment;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;

public class EngineerDepartmentActivity extends BaseActivity {
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private AHBottomNavigation bottomNavigation;
    private int bottomNavigationPreposition = 0;
    private SupportFragment[] mFragments = new SupportFragment[4];
    private FrameLayout fl_container;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enginer);

        if (savedInstanceState == null) {
            mFragments[0] = YCLWeightHouseQuertFragment.newInstance();
            mFragments[1] = MaterialConsumeFragment.newInstance();
            mFragments[2] = TaskListImpQueryFragment.newInstance();
            mFragments[3] = JobOrderFragment.newInstance();
            int showPosition = 0;
            loadMultipleRootFragment(R.id.fl_container_concrete_activity, showPosition, mFragments[0], mFragments[1], mFragments[2],mFragments[3]);
        } else {
            mFragments[0] = findFragment(YCLWeightHouseQuertFragment.class);
            mFragments[1] = findFragment(MaterialConsumeFragment.class);
            mFragments[2] = findFragment(TaskListImpQueryFragment.class);
            mFragments[3] = findFragment(JobOrderFragment.class);
        }

        initView();
        initData();
    }

    private void initData() {

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.jinchang_data, R.drawable.ic_search_white_18dp, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.material_consume, R.drawable.ic_overproof, R.color.material_green_100);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.renwudan_zxlist, R.drawable.ic_overproof, R.color.material_green_100);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.job_order, R.drawable.ic_search_white_18dp, R.color.white);
        bottomNavigationItems.add(item1);
        bottomNavigationItems.add(item2);
        bottomNavigationItems.add(item3);
        bottomNavigationItems.add(item4);
        bottomNavigation.addItems(bottomNavigationItems);
        bottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.white));
        bottomNavigation.setBehaviorTranslationEnabled(false);
        bottomNavigation.setColored(true);
        bottomNavigation.setForceTint(false);
        bottomNavigation.setAccentColor(getResources().getColor(R.color.base_color));
        bottomNavigation.setInactiveColor(getResources().getColor(R.color.gray));
        bottomNavigation.setForceTitlesDisplay(true);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, final boolean wasSelected) {
                showHideFragment(mFragments[position], mFragments[bottomNavigationPreposition]);
                bottomNavigationPreposition = position;
                if (wasSelected) {
                    BaseApplication.bus.post(new EventData(position));
                }

                fl_container.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!wasSelected && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            int cx = (fl_container.getLeft() + fl_container.getRight()) / 2;
                            int cy = fl_container.getBottom();
                            int radius = Math.max(fl_container.getWidth(), fl_container.getHeight());
                            Animator mAnimator = ViewAnimationUtils.createCircularReveal(fl_container, cx, cy, 0, radius);
                            mAnimator.setDuration(300);
                            mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                            mAnimator.start();
                        }
                    }
                });

            }
        });

        int currentItem = 0;
        bottomNavigation.setCurrentItem(currentItem);

    }

    private void initView() {
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation_concrete_activity);
        fl_container = (FrameLayout) findViewById(R.id.fl_container_concrete_activity);

    }

}

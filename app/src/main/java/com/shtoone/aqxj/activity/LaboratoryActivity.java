package com.shtoone.aqxj.activity;

import android.animation.Animator;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;

import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.fragment.mainactivity.ConcreteFragment;
import com.socks.library.KLog;

import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;

public class LaboratoryActivity extends BaseActivity {
    private static final String TAG = LaboratoryActivity.class.getSimpleName();
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private AHBottomNavigation bottomNavigation;
    private int bottomNavigationPreposition = 0;
    private SupportFragment[] mFragments = new SupportFragment[4];
    private String itemFromSG;
    private FrameLayout fl_container;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_laboratory);
        itemFromSG = getIntent().getStringExtra("SG");

        if (savedInstanceState == null) {
            mFragments[0] = ConcreteFragment.newInstance();
            mFragments[1] = ConcreteFragment.newInstance();
            mFragments[2] = ConcreteFragment.newInstance();
            mFragments[3] = ConcreteFragment.newInstance();
            int showPosition = 0;
            loadMultipleRootFragment(R.id.fl_container_laboratory_activity, showPosition, mFragments[0], mFragments[1], mFragments[2],mFragments[3]);
        } else {
            mFragments[0] = findFragment(ConcreteFragment.class);
            mFragments[1] =findFragment(ConcreteFragment.class);
            mFragments[2] = findFragment(ConcreteFragment.class);
            mFragments[3] = findFragment(ConcreteFragment.class);
        }

        initView();
        initData();
    }

    private void initView() {
        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation_laboratory_activity);
        fl_container = (FrameLayout) findViewById(R.id.fl_container_laboratory_activity);
    }

    public void initData() {

        AHBottomNavigationItem item1 = new AHBottomNavigationItem(R.string.yaliji, R.drawable.ic_yaliji, R.color.white);
        AHBottomNavigationItem item2 = new AHBottomNavigationItem(R.string.wannengji, R.drawable.ic_wannengji, R.color.material_yellow_100);
        AHBottomNavigationItem item3 = new AHBottomNavigationItem(R.string.statistic, R.drawable.ic_statistic, R.color.material_green_100);
        AHBottomNavigationItem item4 = new AHBottomNavigationItem(R.string.peiliao, R.drawable.ic_yaliji, R.color.white);
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

//                    BaseApplication.bus.post(new EventData(position));
                    KLog.e("position:" + position);
                }

                fl_container.post(new Runnable() {
                    @Override
                    public void run() {
                        if (!wasSelected && Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                            int cx = (fl_container.getLeft() + fl_container.getRight()) / 2;
                            int cy = fl_container.getBottom();
                            int radius = Math.max(fl_container.getWidth(), fl_container.getHeight());
                            Animator mAnimator = ViewAnimationUtils.createCircularReveal(fl_container, cx, cy, 0, radius);
                            mAnimator.setDuration(500);
                            mAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
                            mAnimator.start();
                        }
                    }
                });
            }
        });

        int currentItem = 0;
        Log.e(TAG,"BaseApplication.mUserInfoData:"+BaseApplication.mUserInfoData);
        if ("SG".equals(BaseApplication.mUserInfoData.getType())) {
            switch (itemFromSG) {
                case "yaliji":
                    currentItem = 0;
                    break;

                case "wannengji":
                    currentItem = 1;
                    break;

                case "statistic":
                    currentItem = 2;
                    break;
            }
        }

        bottomNavigation.setCurrentItem(currentItem);
    }

//    @Subscribe
//    public void updateSearch(EventData mEventData) {
//        if (mEventData.position == ConstantsUtils.NOTIFY_REFRESH) {
//            ViewGroup viewGroup = (ViewGroup) findViewById(android.R.id.content).getRootView();
//            Dialoghelper.successSnackbar(viewGroup, "恭喜，保存成功", Dialoghelper.APPEAR_FROM_TOP_TO_DOWN);
//        }
//    }
}

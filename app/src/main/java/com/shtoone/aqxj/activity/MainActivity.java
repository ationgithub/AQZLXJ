package com.shtoone.aqxj.activity;

import android.animation.Animator;
import android.content.Intent;
import android.graphics.RectF;
import android.os.Build;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewAnimationUtils;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigation;
import com.aurelhubert.ahbottomnavigation.AHBottomNavigationItem;
import com.pgyersdk.update.PgyUpdateManager;
import com.shtoone.aqxj.BaseApplication;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.activity.base.BaseActivity;
import com.shtoone.aqxj.fragment.mainactivity.ConcreteFragment;
import com.shtoone.aqxj.fragment.mainactivity.EngineeringDepartmentFragment;
import com.shtoone.aqxj.utils.ConstantsUtils;
import com.shtoone.aqxj.utils.SharedPreferencesUtils;
import java.util.ArrayList;

import me.yokeyword.fragmentation.SupportFragment;
import zhy.com.highlight.HighLight;

public class MainActivity extends BaseActivity implements NavigationView.OnNavigationItemSelectedListener {
    private static final String TAG = MainActivity.class.getSimpleName();
    // 再点一次退出程序时间设置
    private static final long WAIT_TIME = 2000L;
    private long TOUCH_TIME = 0;
    private NavigationView mNavigationView;
    private DrawerLayout mDrawer;
    private ActionBarDrawerToggle toggle;
    private SupportFragment[] mFragments = new SupportFragment[5];
    private ArrayList<AHBottomNavigationItem> bottomNavigationItems = new ArrayList<>();
    private AHBottomNavigation bottomNavigation;
    private int bottomNavigationPreposition = 0;
    private HighLight mHightLight;
    private TextView tv_username;
    private FrameLayout fl_container;
    private TextView tv_phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new PgyUpdateManager.Builder()
                .setForced(true)                //设置是否强制更新
                .setUserCanRetry(false)         //失败后是否提示重新下载
                .setDeleteHistroyApk(true)     // 检查更新前是否删除本地历史 Apk
                .register();

        if (savedInstanceState == null) {
//            mFragments[0] = ConcreteFragment.newInstance();
            mFragments[0] = ConcreteFragment.newInstance();
            mFragments[1] = ConcreteFragment.newInstance();
//            mFragments[1] = LaboratoryFragment.newInstance();
            mFragments[2] = ConcreteFragment.newInstance();
            mFragments[3] = EngineeringDepartmentFragment.newInstance();

            loadMultipleRootFragment(R.id.fl_container_main_activity, 0, mFragments[0], mFragments[1],mFragments[2],mFragments[3]);
        } else {
            // 这里库已经做了Fragment恢复,所有不需要额外的处理了, 不会出现重叠问题
            // 这里我们需要拿到mFragments的引用,也可以通过getSupportFragmentManager.getFragments()自行进行判断查找(效率更高些),用下面的方法查找更方便些
//            mFragments[0] = findFragment(ConcreteFragment.class);
            mFragments[0] = findFragment(ConcreteFragment.class);
            mFragments[1] = findFragment(ConcreteFragment.class);

//            mFragments[1] = findFragment(LaboratoryFragment.class);
            mFragments[2] = findFragment(ConcreteFragment.class);
            mFragments[3] = findFragment(EngineeringDepartmentFragment.class);

        }
        initView();
        initData();
    }


    private void initView() {
        mDrawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        mNavigationView = (NavigationView) findViewById(R.id.navigationView_main_activity);
        mNavigationView.setNavigationItemSelectedListener(this);
        fl_container = (FrameLayout) findViewById(R.id.fl_container_main_activity);
        LinearLayout llNavHeader = (LinearLayout) mNavigationView.getHeaderView(0);
        tv_username = (TextView) llNavHeader.findViewById(R.id.tv_username_nav_header_main);
        tv_phone_number = (TextView) llNavHeader.findViewById(R.id.tv_phone_number_nav_header_main);
        llNavHeader.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mDrawer.closeDrawer(GravityCompat.START);
                mDrawer.postDelayed(new Runnable() {
                    @Override
                    public void run() {

                    }
                }, 250);
            }
        });

        bottomNavigation = (AHBottomNavigation) findViewById(R.id.bottom_navigation_main_activity);
    }

    public void initToolBar(Toolbar toolbar) {
        toggle = new ActionBarDrawerToggle(this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.setDrawerListener(toggle);
        toggle.syncState();
    }

    public void initData() {
        if (null != BaseApplication.mUserInfoData) {
            if (!TextUtils.isEmpty(BaseApplication.mUserInfoData.getUserFullName())) {
                tv_username.setText("用户：" + BaseApplication.mUserInfoData.getUserFullName());
            }
            if (!TextUtils.isEmpty(BaseApplication.mUserInfoData.getUserPhoneNum())) {
                tv_phone_number.setText("电话：" + BaseApplication.mUserInfoData.getUserPhoneNum());
            }
        }
        /***********************************************/
        int [] bottomTitles = {R.string.message,R.string.workbench,R.string.orgniser,R.string.personal_message,};
        int [] bottomIcons = {R.drawable.ic_lab,R.drawable.ic_bhz,R.drawable.gbc, R.drawable.gcb,R.color.white};
        int [] bottomBackgroundColors = { R.color.white,R.color.material_yellow_100,R.color.white, R.color.material_yellow_100, R.color.white};
        for (int i = 0; bottomTitles.length>i;i++){
            bottomNavigationItems.add(new AHBottomNavigationItem(bottomTitles[i],bottomIcons[i],bottomBackgroundColors[i]));
        }
        /***********************************************/
        bottomNavigation.addItems(bottomNavigationItems);
        bottomNavigation.setDefaultBackgroundColor(getResources().getColor(R.color.white));
        bottomNavigation.setBehaviorTranslationEnabled(true);
        bottomNavigation.setColored(true);
        bottomNavigation.setForceTint(false);
        bottomNavigation.setAccentColor(getResources().getColor(R.color.base_color));
        bottomNavigation.setInactiveColor(getResources().getColor(R.color.gray));
        bottomNavigation.setForceTitlesDisplay(true);

        bottomNavigation.setOnTabSelectedListener(new AHBottomNavigation.OnTabSelectedListener() {
            @Override
            public void onTabSelected(int position, boolean wasSelected) {
                BaseApplication.parametersData.cailiaono = "";
                BaseApplication.parametersData.materialID = "";
                showHideFragment(mFragments[position], mFragments[bottomNavigationPreposition]);
                bottomNavigationPreposition = position;

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
        bottomNavigation.setCurrentItem(0);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            if (System.currentTimeMillis() - TOUCH_TIME < WAIT_TIME) {
                finish();
            } else {
                TOUCH_TIME = System.currentTimeMillis();
                Toast.makeText(this, R.string.press_again_exit, Toast.LENGTH_SHORT).show();
            }
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(final MenuItem item) {
        mDrawer.closeDrawer(GravityCompat.START);
        mDrawer.postDelayed(new Runnable() {
            @Override
            public void run() {
                int id = item.getItemId();

                if (id == R.id.message_drawer_main_activity) {
//            JumpToMessageActivity();
                } else if (id == R.id.logout_drawer_main_activity) {
                    JumpToLoginActivity();
                } else if (id == R.id.about_drawer_main_activity) {
                    //JumpToAboutActivity();
                } else if (id == R.id.version_drawer_main_activity) {
                    //JumpToVersionActivity();
                }
            }
        }, 250);
        return true;
    }

    private void JumpToLoginActivity() {
        //清除已存的用户信息
        SharedPreferencesUtils.put(this, ConstantsUtils.USERNAME, "");
        SharedPreferencesUtils.put(this, ConstantsUtils.PASSWORD, "");
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    private void JumpToMessageActivity() {
        Intent intent = new Intent(this, MessageActivity.class);
        startActivity(intent);
    }

    private void JumpToAboutActivity() {
        Intent intent = new Intent(this, AboutActivity.class);
        startActivity(intent);
    }

    private void JumpToVersionActivity() {
        Intent intent = new Intent(this, VersionActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onResume() {
        if ((Boolean) SharedPreferencesUtils.get(MainActivity.this, ConstantsUtils.ISFIRSTGUIDE, true)) {
//            showTipMask();
        }
        super.onResume();
    }

    private void showTipMask() {
        mHightLight = new HighLight(MainActivity.this)//
                .addHighLight(R.id.action_hierarchy, R.layout.info_gravity_right_up, new HighLight.OnPosCallback() {
                    @Override
                    public void getPos(float rightMargin, float bottomMargin, RectF rectF, HighLight.MarginInfo marginInfo) {
                        marginInfo.rightMargin = 1;
                        marginInfo.topMargin = rectF.bottom;
                    }
                }).setClickCallback(new HighLight.OnClickCallback() {
                    @Override
                    public void onClick() {
                        mHightLight = new HighLight(MainActivity.this);
                        mHightLight.addHighLight(R.id.fab, R.layout.info_down, new HighLight.OnPosCallback() {
                            @Override
                            public void getPos(float rightMargin, float bottomMargin, RectF rectF, HighLight.MarginInfo marginInfo) {
                                marginInfo.rightMargin = rectF.width() / 2 + 1;
                                marginInfo.bottomMargin = bottomMargin + rectF.height();
                            }
                        }).setClickCallback(new HighLight.OnClickCallback() {
                            @Override
                            public void onClick() {
                                SharedPreferencesUtils.put(MainActivity.this, ConstantsUtils.ISFIRSTGUIDE, false);
                            }
                        }).show();
                    }
                });
        mHightLight.show();
    }

    @Override
    public boolean swipeBackPriority() {
        return false;
    }
}

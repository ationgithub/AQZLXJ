package com.shtoone.aqxj.utils;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.ImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.target.Target;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.shtoone.aqxj.R;
import com.shtoone.aqxj.bean.TaizhangData;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//        downLoadPicture("https://www.mukedaba.com/data/attachment/forum/201703/16/011906yaj0k3jbbrgrifaz.jpg");
public class ImageActivity extends ActionBarActivity {
    ViewPager viewPager;
    ViewPagerAdapter adapter;
    List<Map<String, Object>> data;
//    protected ImageLoader imageLoader = ImageLoader.getInstance();
    DisplayImageOptions options;
    //不能加，与ationBar 冲突
//    Toolbar mtool;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.image_layout);
//        mtool = (Toolbar) findViewById(R.id.toolbar_toolbar);
//        initToolbarBackNavigation(mtool);
        init();
    }

    public void init() {
        viewPager = (ViewPager) findViewById(R.id.viewpager);
        data = getData();



//        imageLoader=ImageLoader.getInstance();
//        imageLoader.init(ImageLoaderConfiguration.createDefault(this));
//        options = new DisplayImageOptions.Builder()
//                .showStubImage(R.drawable.ic_launcher) // 在ImageView加载过程中显示图片
//                .showImageForEmptyUri(R.drawable.ic_launcher) // image连接地址为空时
//                .showImageOnFail(R.drawable.ic_launcher) // image加载失败
//                .cacheInMemory(true) // 加载图片时会在内存中加载缓存
//                .cacheOnDisc(true) // 加载图片时会在磁盘中加载
//                .build();
        adapter = new ViewPagerAdapter(data);
        viewPager.setAdapter(adapter);
    }

    //这个方法长度是动态的，可以改成你从服务器获取的图片，这样数量就不确定啦
    public List<Map<String, Object>> getData() {
        TaizhangData.DataBean pics = (TaizhangData.DataBean)getIntent().getSerializableExtra("scannerImgDetail");
        List<String> picList = new ArrayList<>();
        if(!pics.getGzpic().equals("")){
            picList.add(pics.getGzpic());
        }
        if(!pics.getJlpic().equals("")){
            picList.add(pics.getJlpic());
        }
        if(!pics.getPzpic().equals("")){
            picList.add(pics.getPzpic());
        }
        if(!pics.getQypic().equals("")){
            picList.add(pics.getQypic());
        }
        List<Map<String, Object>> mdata = new ArrayList<Map<String, Object>>();
        if(picList.size()>0){
            for(int i=0;i<picList.size();i++){
            Map<String, Object> map = new HashMap<String, Object>();
//            map.put("url", "http://img2.duitang.com/uploads/item/201207/19/20120719132725_UkzCN.jpeg");
            map.put("url", com.shtoone.aqxj.utils.URL.BaseURL+"QYSYFILE/"+picList.get(i));
            map.put("view", new ImageView(this));
            mdata.add(map);
            }
        }
        return  mdata;
    }

    public class ViewPagerAdapter extends PagerAdapter {

        List<Map<String,Object>> viewLists;

        public ViewPagerAdapter(List<Map<String,Object>> lists)
        {
            viewLists = lists;
        }

        @Override
        public int getCount() {                                                                 //获得size
            // TODO Auto-generated method stub
            return viewLists.size();
        }

        @Override
        public boolean isViewFromObject(View arg0, Object arg1) {
            // TODO Auto-generated method stub
            return arg0 == arg1;
        }

        @Override
        public void destroyItem(View view, int position, Object object)                       //销毁Item
        {
            ImageView x=(ImageView)viewLists.get(position).get("view");
            x.setScaleType(ImageView.ScaleType.FIT_CENTER);
            ((ViewPager) view).removeView(x);
        }

        @Override
        public Object instantiateItem(View view, int position)                                //实例化Item
        {
            ImageView x=(ImageView)viewLists.get(position).get("view");
            x.setScaleType(ImageView.ScaleType.FIT_CENTER);
//            imageLoader.displayImage(viewLists.get(position).get("url").toString(), x,options);
            Glide.with(getApplicationContext()).load(viewLists.get(position).get("url").toString()).placeholder(R.drawable.error)
                    .listener(new RequestListener<String, GlideDrawable>() {
                        @Override
                        public boolean onException(Exception e, String model, Target<GlideDrawable> target, boolean isFirstResource) {
                            return false;
                        }

                        @Override
                        public boolean onResourceReady(GlideDrawable resource, String model, Target<GlideDrawable> target, boolean isFromMemoryCache, boolean isFirstResource) {
                            return false;
                        }
                    })
                    .into(x);
            ((ViewPager) view).addView(x, 0);

            return viewLists.get(position).get("view");
        }
    }

}
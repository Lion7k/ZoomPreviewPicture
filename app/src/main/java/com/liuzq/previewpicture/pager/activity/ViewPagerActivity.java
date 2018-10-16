package com.liuzq.previewpicture.pager.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

import com.liuzq.previewpicture.ImageUrlConfig;
import com.liuzq.previewpicture.R;
import com.liuzq.previewpicture.bean.UserViewInfo;
import com.liuzq.previewpicture.pager.adapter.MyPagerAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzq on 2018/10/16.
 */

public class ViewPagerActivity extends AppCompatActivity {
    private ArrayList<UserViewInfo> mThumbViewInfoList = new ArrayList<>();
    ViewPager mViewPager;
    private MyPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewpager);
        mViewPager = (ViewPager) findViewById(R.id.mViewPager);
        //准备数据
        List<String> urls = ImageUrlConfig.getUrls();
        for (int i = 0; i < 1; i++) {
            mThumbViewInfoList.add(new UserViewInfo(urls.get(i)));
        }
        adapter = new MyPagerAdapter(mThumbViewInfoList, this);
        mViewPager.setAdapter(adapter);
    }
}

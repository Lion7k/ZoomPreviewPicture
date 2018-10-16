package com.liuzq.previewpicture.pager.adapter;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liuzq.imagepreview.GPreviewBuilder;
import com.liuzq.previewpicture.R;
import com.liuzq.previewpicture.bean.UserViewInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzq on 2018/10/16.
 */

public class MyPagerAdapter extends PagerAdapter {
    private Context mContext;
    private List<UserViewInfo> mThumbViewInfoList = new ArrayList<>();

    public MyPagerAdapter(List<UserViewInfo> list, Context mContext) {
        this.mThumbViewInfoList = list;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return mThumbViewInfoList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        ImageView view = (ImageView) LayoutInflater.from(mContext).inflate(R.layout.item_image2, container, false);
        Glide.with(mContext)
                .load(mThumbViewInfoList.get(position).getUrl())
                .error(R.mipmap.ic_iamge_zhanwei)
                .into(view);
        view.setTag(R.id.iv, position);
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setRect(v);
                GPreviewBuilder.from((Activity) mContext)
                        .setData(mThumbViewInfoList)
                        .setSingleShowType(false)
                        .setCurrentIndex((Integer) v.getTag(R.id.iv))
                        .setType(GPreviewBuilder.IndicatorType.Dot)
                        .start();
            }
        });
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    private void setRect(View view) {
        for (UserViewInfo s : mThumbViewInfoList) {
            Rect bounds = new Rect();
            view.getGlobalVisibleRect(bounds);
            s.setBounds(bounds);
        }
    }
}

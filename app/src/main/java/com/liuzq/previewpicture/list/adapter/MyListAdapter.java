package com.liuzq.previewpicture.list.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.liuzq.previewpicture.R;
import com.liuzq.previewpicture.bean.UserViewInfo;

import java.util.ArrayList;

/**
 * Created by liuzq on 2018/10/16.
 */

public class MyListAdapter extends BaseAdapter {
    private Context context;
    private LayoutInflater inflate;
    private ArrayList<UserViewInfo> mThumbViewInfoList;

    public MyListAdapter(Context context, ArrayList<UserViewInfo> mThumbViewInfoList) {
        this.context = context;
        this.mThumbViewInfoList = mThumbViewInfoList;
        this.inflate = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return mThumbViewInfoList == null ? 0 : mThumbViewInfoList.size();
    }

    @Override
    public Object getItem(int position) {
        return mThumbViewInfoList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = inflate.inflate(R.layout.item_image, null);
        ImageView iv = (ImageView) view.findViewById(R.id.iv);
        Glide.with(context)
                .load(mThumbViewInfoList.get(position).getUrl())
                .error(R.mipmap.ic_iamge_zhanwei)
                .into(iv);
        iv.setTag(R.id.iv, mThumbViewInfoList.get(position));
        return view;
    }
}

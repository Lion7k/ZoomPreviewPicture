package com.liuzq.previewpicture.recycle.adapter;

import android.content.Context;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.liuzq.previewpicture.R;
import com.liuzq.previewpicture.bean.UserViewInfo;

/**
 * Created by liuzq on 2018/10/16.
 */

public class MyBaseQuickAdapter extends BaseQuickAdapter<UserViewInfo, BaseViewHolder> {
    private Context context;

    public MyBaseQuickAdapter(Context context) {
        super(R.layout.item_image);
        this.context = context;
    }

    @Override
    protected void convert(BaseViewHolder helper, UserViewInfo item) {
        final ImageView thumbView = helper.getView(R.id.iv);
        Glide.with(context)
                .load(item.getUrl())
                .error(R.mipmap.ic_iamge_zhanwei)
                .into(thumbView);
        helper.getView(R.id.iv).setTag(R.id.iv, item.getUrl());
    }
}

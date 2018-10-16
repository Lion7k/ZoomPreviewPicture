package com.liuzq.previewpicture.video.adapter;

import android.content.Context;
import android.view.View;
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
        if (item.getVideoUrl() == null) {
            helper.getView(R.id.btnVideo).setVisibility(View.GONE);
        } else {
            helper.getView(R.id.btnVideo).setVisibility(View.VISIBLE);
        }

        Glide.with(context)
                .load(item.getUrl())
                .placeholder(R.mipmap.ic_launcher)
                .error(R.mipmap.ic_iamge_zhanwei)
                .into(thumbView);
        thumbView.setTag(R.id.iv, item.getUrl());
    }
}

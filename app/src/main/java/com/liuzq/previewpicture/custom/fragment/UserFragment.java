package com.liuzq.previewpicture.custom.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.liuzq.imagepreview.view.BasePhotoFragment;
import com.liuzq.previewpicture.R;
import com.liuzq.previewpicture.bean.UserViewInfo;

/**
 * Created by liuzq on 2018/10/16.
 */

public class UserFragment extends BasePhotoFragment {
    /****
     * 用户具体数据模型
     ***/
    private UserViewInfo b;

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        b = (UserViewInfo) getBeanViewInfo();
        imageView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                Log.d("SmoothImageView", "onLongClick");
                Toast.makeText(getContext(), "长按事件:" + b.getUser(), Toast.LENGTH_LONG).show();
                return false;
            }
        });
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_image_photo_layout, container, false);
    }
}

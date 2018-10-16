package com.liuzq.previewpicture.custom.activity;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.liuzq.imagepreview.GPreviewActivity;
import com.liuzq.previewpicture.R;

/**
 * Created by liuzq on 2018/10/16.
 */

public class CustomActivity extends GPreviewActivity {
    /***
     * 重复该方法 *使用你的自定义布局
     ***/
    @Override
    public int setContentLayout() {
        return R.layout.activity_custom_preview;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //退出时调用，d封装方法的 不然没有动画效果
                transformOut();
            }
        });
    }
}

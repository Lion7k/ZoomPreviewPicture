package com.liuzq.imagepreview.entity;

import android.graphics.Rect;
import android.os.Parcelable;
import android.support.annotation.Nullable;

/**
 * Created by liuzq on 2018/10/16.
 * Deprecated: 图片预览接口
 */

public interface IThumbViewInfo extends Parcelable {
    /****
     * 图片地址
     *
     * @return String
     ****/
    String getUrl();

    /**
     * 记录坐标
     *
     * @return Rect
     ***/
    Rect getBounds();


    /**
     * 获取视频链接
     ***/
    @Nullable
    String getVideoUrl();
}

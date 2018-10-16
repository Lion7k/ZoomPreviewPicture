package com.liuzq.imagepreview.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.widget.ImageView;

/**
 * Created by liuzq on 2018/10/16.
 * Deprecated: 加载器接口
 */

public interface IZoomMediaLoader {
    /***
     * @param  context 容器
     * @param   path  图片你的路径
     * @param   simpleTarget   图片加载状态回调
     * ***/
    void displayImage(@NonNull Fragment context, @NonNull String path, @NonNull SimpleTarget<Bitmap> simpleTarget);

    /***
     * 加载gif 图
     * @param  context 容器
     * @param   path  图片你的路径
     * @param   simpleTarget   图片加载状态回调
     * ***/
    void displayGifImage(@NonNull Fragment context, @NonNull String path, ImageView imageView, @NonNull SimpleTarget simpleTarget);
    /**
     * 停止
     *
     * @param context 容器
     **/
    void onStop(@NonNull Fragment context);

    /**
     * 停止
     *
     * @param c 容器
     **/
    void clearMemory(@NonNull Context c);
}

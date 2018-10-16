package com.liuzq.previewpicture.app;

import android.app.Application;

import com.liuzq.imagepreview.ZoomMediaLoader;

/**
 * Created by liuzq on 2018/10/16.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        ZoomMediaLoader.getInstance().init(new TestImageLoader());
    }
}

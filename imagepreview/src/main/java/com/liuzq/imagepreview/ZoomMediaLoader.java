package com.liuzq.imagepreview;

import com.liuzq.imagepreview.loader.IZoomMediaLoader;

/**
 * Created by liuzq on 2018/10/16.
 * Deprecated: 图片加载管理器
 */

public class ZoomMediaLoader {
    private volatile IZoomMediaLoader loader;
    public  static ZoomMediaLoader getInstance(){
        return  Holder.holder;
    }
    private ZoomMediaLoader(){

    }

    private  static  class  Holder{
        static ZoomMediaLoader holder=new ZoomMediaLoader();
    }

    /****
     * 初始化加载图片类
     * @param  loader 自定义
     * **/
    public  void init(IZoomMediaLoader loader){
        this.loader=loader;
    }

    public IZoomMediaLoader getLoader() {
        if (loader==null){
            throw  new  NullPointerException("ZoomMediaLoader loader  no init");
        }
        return loader;
    }
}

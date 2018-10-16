# ZoomPreviewPicture
本项目受Google官方demo Zooming a View 启发，实现了点击小图放大至全屏预览，退出全屏恢复至原来位置这两个过程的动画过渡。 常见应用场景如微信朋友圈照片九宫格和微信聊天图片,视频,gif预览，某些手机系统相册等viewpager图片查看 缩放 拖拽下拉缩小退出（效果同微信图片浏览）

特点

    1.支持自定义图片加载框架。
    2.支持重写activity,完成切换切换效果。
    3.图片查看 缩放 拖拽下拉缩小退出。
    4.支持自定义activity,Fragment。
    5.支持视频和自定义视频播放控件。
    6.支持类似微信朋友圈照片九宫格和微信聊天图片预览。
    7.指示器类型选择 圆点模式(贝塞尔圆点指示器)和数字模式。
    8.增加接口实体类。不在使用数据转化。
    8.支持GIF显示。 ####效果如下：

通过Gradle抓取:

  compile 'com.liuzq:ImagePreview:1.0'

1.本项目类库依赖第三库

            注意: 由于的photoview有些事件冲突，将1.3.1版本源代码修改采用依赖本地。

      compile 'com.android.support:support-fragment:25.3.1'
      compile 'com.android.support:support-core-utils:25.3.1'

2.示例代码

            注意:: 你实现自定义类，在你 app onCreate() 中

    @Override
      public void onCreate() {
          super.onCreate();
          ZoomMediaLoader.getInstance().init(new TestImageLoader());
      }

package com.liuzq.previewpicture.nine.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.jaeger.ninegridimageview.NineGridImageView;
import com.liuzq.previewpicture.ImageUrlConfig;
import com.liuzq.previewpicture.R;
import com.liuzq.previewpicture.bean.UserViewInfo;
import com.liuzq.previewpicture.nine.adapter.PostAdapter;
import com.liuzq.previewpicture.nine.entity.Post;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by liuzq on 2018/10/16.
 */

public class GridStyleActivity extends BaseActivity {
    private RecyclerView mRvPostLister;
    private PostAdapter mNineImageAdapter;
    private List<Post> mPostList;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        setContentView(R.layout.activity_recycler);
        setSupportActionBar((Toolbar) findViewById(R.id.toolbar));
        mRvPostLister = (RecyclerView) findViewById(R.id.rv_post_list);
        final LinearLayoutManager manager = new LinearLayoutManager(this);
        mRvPostLister.setLayoutManager(manager);
        mPostList = new ArrayList<>();
        for (int i = 0; i < 29; i++) {
            List<UserViewInfo> imgUrls = new ArrayList<>();
            UserViewInfo userViewInfo;
            Random ss = new Random();

            for (int j = 0; j < ss.nextInt(9); j++) {
                userViewInfo = new UserViewInfo(ImageUrlConfig.getUrls().get(j));
                imgUrls.add(userViewInfo);
            }
            Post post = new Post("Am I handsome? Am I handsome? Am I handsome?", imgUrls);
            mPostList.add(post);
        }

        mNineImageAdapter = new PostAdapter(this, mPostList, NineGridImageView.STYLE_GRID);
        mRvPostLister.setAdapter(mNineImageAdapter);
        manager.scrollToPositionWithOffset(5, 0);
        mRvPostLister.post(new Runnable() {
            @Override
            public void run() {
                View view = manager.findViewByPosition(1);
                if (view != null) System.out.println(view.getMeasuredHeight());
            }
        });
    }
}

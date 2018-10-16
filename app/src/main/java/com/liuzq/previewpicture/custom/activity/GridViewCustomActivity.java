package com.liuzq.previewpicture.custom.activity;

import android.graphics.Rect;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ImageView;

import com.liuzq.imagepreview.GPreviewBuilder;
import com.liuzq.previewpicture.ImageUrlConfig;
import com.liuzq.previewpicture.R;
import com.liuzq.previewpicture.bean.UserViewInfo;
import com.liuzq.previewpicture.custom.adapter.MyListAdapter;
import com.liuzq.previewpicture.custom.fragment.UserFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzq on 2018/10/16.
 */

public class GridViewCustomActivity extends AppCompatActivity {
    private ArrayList<UserViewInfo> mThumbViewInfoList = new ArrayList<>();
    GridView listView;
    private int type;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        type = getIntent().getIntExtra("type", 0);
        listView = (GridView) findViewById(R.id.listView);
        //准备数据
        List<String> urls = ImageUrlConfig.getUrls();
        for (int i = 0; i < urls.size(); i++) {
            mThumbViewInfoList.add(new UserViewInfo(urls.get(i)));
        }
        MyListAdapter adapter = new MyListAdapter(this, mThumbViewInfoList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                computeBoundsBackward(listView.getFirstVisiblePosition());
                if (type == 0) {//自定义activity
                    GPreviewBuilder.from(GridViewCustomActivity.this)
                            .to(CustomActivity.class)
                            .setData(mThumbViewInfoList)
                            .setCurrentIndex(position)
                            .setType(GPreviewBuilder.IndicatorType.Dot)
                            .start();
                } else if (type == 1) {//自定义Fragment
                    GPreviewBuilder.from(GridViewCustomActivity.this)
                            .setData(mThumbViewInfoList)
                            .setCurrentIndex(position)
                            .setUserFragment(UserFragment.class)
                            .setType(GPreviewBuilder.IndicatorType.Dot)
                            .start();
                } else {
                    //自定义activity和Fragment
                    GPreviewBuilder.from(GridViewCustomActivity.this)
                            .to(CustomActivity.class)
                            .setData(mThumbViewInfoList)
                            .setUserFragment(UserFragment.class)
                            .setCurrentIndex(position)
                            .setSingleFling(false)
                            .setDrag(false)
                            .setType(GPreviewBuilder.IndicatorType.Dot)
                            .start();
                }
            }
        });
    }

    /**
     * 查找信息
     * 从第一个完整可见item逆序遍历，如果初始位置为0，则不执行方法内循环
     */
    private void computeBoundsBackward(int firstCompletelyVisiblePos) {
        for (int i = firstCompletelyVisiblePos; i < mThumbViewInfoList.size(); i++) {
            View itemView = listView.getChildAt(i - firstCompletelyVisiblePos);
            Rect bounds = new Rect();
            if (itemView != null) {
                //需要显示过度控件
                ImageView thumbView = (ImageView) itemView.findViewById(R.id.iv);
                //拿到在控件屏幕可见中控件显示为矩形Rect信息
                thumbView.getGlobalVisibleRect(bounds);
            }
            mThumbViewInfoList.get(i).setBounds(bounds);
        }
    }
}

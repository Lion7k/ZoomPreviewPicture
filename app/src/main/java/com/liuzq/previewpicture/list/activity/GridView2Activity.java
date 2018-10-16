package com.liuzq.previewpicture.list.activity;

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
import com.liuzq.previewpicture.list.adapter.MyListAdapter;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by liuzq on 2018/10/16.
 */

public class GridView2Activity extends AppCompatActivity {
    private ArrayList<UserViewInfo> mThumbViewInfoList = new ArrayList<>();
    GridView listView;
    private MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid);
        listView = (GridView) findViewById(R.id.listView);
        //准备数据
        List<String> urls = ImageUrlConfig.getUrls();
        for (int i = 0; i < urls.size(); i++) {
            mThumbViewInfoList.add(new UserViewInfo(urls.get(i)));
        }
        adapter = new MyListAdapter(this, mThumbViewInfoList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                computeBoundsBackward(listView.getFirstVisiblePosition());
                GPreviewBuilder.from(GridView2Activity.this)
                        .setData(mThumbViewInfoList)
                        .setCurrentIndex(position)
                        .setType(GPreviewBuilder.IndicatorType.Dot)
                        .start();

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
                ImageView thumbView = (ImageView) itemView.findViewById(R.id.iv);
                thumbView.getGlobalVisibleRect(bounds);
            }
            mThumbViewInfoList.get(i).setBounds(bounds);
        }
    }
}

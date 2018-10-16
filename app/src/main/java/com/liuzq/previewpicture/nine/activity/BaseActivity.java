package com.liuzq.previewpicture.nine.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.liuzq.previewpicture.nine.ViewServer;

/**
 * Created by liuzq on 2018/10/16.
 */

public class BaseActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ViewServer.get(this).addWindow(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        ViewServer.get(this).removeWindow(this);
    }

    @Override
    public void onResume() {
        super.onResume();
        ViewServer.get(this).setFocusedWindow(this);
    }
}

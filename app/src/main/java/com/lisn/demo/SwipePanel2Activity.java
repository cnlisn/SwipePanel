package com.lisn.demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.lisn.swipepanel.SwipePanel;


/**
 * 侧滑返回 静态使用
 */
public class SwipePanel2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_swipe_panel2);
        SwipePanel swipePanel = findViewById(R.id.swipePanel);
        swipePanel.setOnFullSwipeListener(new SwipePanel.OnFullSwipeListener() {
            @Override
            public void onFullSwipe(int direction) {
                swipePanel.close();
                finish();
            }
        });
    }
}

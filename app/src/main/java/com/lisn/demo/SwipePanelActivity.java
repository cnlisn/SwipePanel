package com.lisn.demo;

import android.graphics.drawable.RotateDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.lisn.swipepanel.SwipePanel;


public class SwipePanelActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        initSwipeBack();
    }

    private void initSwipeBack() {
        final SwipePanel swipeLayout = new SwipePanel(this);
        swipeLayout.setLeftEdgeSize(dp2px(100));// 设置左侧触发阈值 100dp
        swipeLayout.setLeftDrawable(com.lisn.demo.R.drawable.base_back);// 设置左侧 icon
        swipeLayout.setLeftSwipeColor(getResources().getColor(R.color.colorPrimary));
        swipeLayout.wrapView(findViewById(R.id.rootLayout));// 设置嵌套在 rootLayout 外层
        // 设置完全划开松手后的监听
        swipeLayout.setOnFullSwipeListener(new SwipePanel.OnFullSwipeListener() {
            @Override
            public void onFullSwipe(int direction) {
                swipeLayout.close(direction);// 关闭
                finish();
            }
        });


        swipeLayout.setRightEdgeSize(dp2px(100));
        swipeLayout.setRightDrawable(R.drawable.ic_rotate);
        swipeLayout.setRightSwipeColor(getResources().getColor(R.color.colorPrimary));
        swipeLayout.setRightCenter(true);
        swipeLayout.setOnFullSwipeListener(new SwipePanel.OnFullSwipeListener() {
            @Override
            public void onFullSwipe(int direction) {
                swipeLayout.close(direction);
                finish();
            }
        });

        swipeLayout.setOnProgressChangedListener(new SwipePanel.OnProgressChangedListener() {
            @Override
            public void onProgressChanged(int direction, float progress, boolean isTouch) {
                Log.e("SwipePanelActivity", "onProgressChanged: direction=" + direction);
                Log.e("SwipePanelActivity", "onProgressChanged: progress=" + progress);
                Log.e("SwipePanelActivity", "onProgressChanged: isTouch=" + isTouch);

                if (direction == SwipePanel.RIGHT) {

                    RotateDrawable drawable = (RotateDrawable) swipeLayout.getRightDrawable();
                    drawable.setLevel((int) (progress * 20000));
                }
            }
        });

    }

    public int dp2px(float dpValue) {
        final float scale = SwipePanelActivity.this.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}

# SwipePanel
侧滑返回

## 效果图


![](https://github.com/cnlisn/SwipePanel/blob/master/Picture/screenshot-1572856578012.jpg)


## 代码中动态使用


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
        
## 布局中静态使用

    <?xml version="1.0" encoding="utf-8"?>
    <com.lisn.swipepanel.SwipePanel xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:app="http://schemas.android.com/apk/res-auto"
        android:id="@+id/swipePanel"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:background="#CCD1D9"
        app:isLeftCenter="false"
        app:leftDrawable="@drawable/base_back"
        app:leftEdgeSize="100dp"
        app:leftSwipeColor="@color/colorPrimary">

        <TextView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:layout_gravity="center"
            android:text="静态使用" />
    </com.lisn.swipepanel.SwipePanel>

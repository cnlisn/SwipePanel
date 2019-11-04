package com.lisn.demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;



public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        Intent intent = null;
        if (view.getId() == R.id.btn_swipepanel) {
            intent = new Intent(this, SwipePanelActivity.class);
        } else if (view.getId() == R.id.btn_swipepanel2) {
            intent = new Intent(this, SwipePanel2Activity.class);
        }
        if (intent != null)
            startActivity(intent);
    }
}

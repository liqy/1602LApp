package com.liqy.l602lapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import view.BitmapAndTextView;

/**
 * 主页面
 */
public class MainActivity extends AppCompatActivity {

    BitmapAndTextView myview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        myview = (BitmapAndTextView) findViewById(R.id.myview);

        //第五步
        myview.setMyListener(new BitmapAndTextView.MyClickListener() {
            @Override
            public void innerToast(View view) {
                Toast.makeText(getBaseContext(), "你点击了院内", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void outerToast(View view) {
                Toast.makeText(getBaseContext(), "你点击了院外", Toast.LENGTH_SHORT).show();
            }
        });

    }


}

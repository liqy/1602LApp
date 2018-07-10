package com.liqy.meituan;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.liqy.meituan.home.MainActivity;
import com.liqy.meituan.search.SearchActivity;

public class SplashActivity extends AppCompatActivity {

    public static final int TYPE = 0;
    public static final int DELAY_TIME = 1000;
    public int totalTime = 3;


    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (totalTime < 1) {
                Intent intent=new Intent(SplashActivity.this, SearchActivity.class);
                startActivity(intent);
                finish();
            } else {
                totalTime--;
                handler.sendEmptyMessageDelayed(TYPE, DELAY_TIME);
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        handler.sendEmptyMessageDelayed(TYPE, DELAY_TIME);
    }
}

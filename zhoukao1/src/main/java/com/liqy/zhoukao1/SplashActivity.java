package com.liqy.zhoukao1;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.liqy.zhoukao1.view.CountDownView;

public class SplashActivity extends AppCompatActivity {

    CountDownView downText;

    //倒计时长
    int time = 3;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        downText = (CountDownView) findViewById(R.id.downText);
        downText.start(this,MainActivity.class);

        downText.setListener(new CountDownView.MyListener() {
            @Override
            public void onClick(View view) {
                //TODO 跳转
            }
        });

    }
}

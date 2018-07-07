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
                downText.stop();//停止倒计时
                Intent intent=new Intent(SplashActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }
}

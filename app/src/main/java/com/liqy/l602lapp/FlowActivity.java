package com.liqy.l602lapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import view.FlowLayout;


public class FlowActivity extends AppCompatActivity {
    LayoutInflater mInflater;
    FlowLayout flowLayout;
    private String[] mVals = new String[]
            {"很好，了不得，很好，了不得，很好，了不得，很好，了不得，很好，了不得，很好，了不得，很好，了不得",
                    "不错不错", "就是他了", "完美的，没毛病", "下次还来买"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_flow);

        flowLayout = (FlowLayout) findViewById(R.id.flowLayout);
        mInflater = LayoutInflater.from(this);
        initFlowLayout();

    }

    private void initFlowLayout() {
        for (int i = 0; i < mVals.length; i++) {
            final RelativeLayout rl2 = (RelativeLayout) mInflater.inflate(R.layout.flow_layout, flowLayout, false);
            TextView tv2 = (TextView) rl2.findViewById(R.id.tv);
            tv2.setText(mVals[i]);
            rl2.setTag(i);
            flowLayout.addView(rl2);
            rl2.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    //TODO 点击事件
                }
            });

        }
    }
}

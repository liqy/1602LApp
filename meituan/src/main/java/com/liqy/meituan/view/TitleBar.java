package com.liqy.meituan.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.liqy.meituan.R;

/**
 * 自定义标题栏
 * Copyright 星期二 YourCompany.
 */
public class TitleBar extends RelativeLayout implements View.OnClickListener {

    ImageView back;//点击就销毁
    TextView title;//

    BarListener barListener;

    public TitleBar(Context context) {
        super(context);
        initBar(context, null);
    }

    public TitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initBar(context, attrs);
    }

    private void initBar(Context context, AttributeSet attrs) {
        View view = LayoutInflater.from(context).inflate(R.layout.title_bar, this);
        back = (ImageView) view.findViewById(R.id.bar_back);
        title = (TextView) view.findViewById(R.id.bar_title);

        back.setOnClickListener(this);

        if (attrs != null) {
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.TitleBar);
            String string = typedArray.getString(R.styleable.TitleBar_title);
            typedArray.recycle();

            title.setText(string);
        }

    }

    public void setBarListener(BarListener barListener) {
        this.barListener = barListener;
    }

    /**
     * 设置是否
     * @param isHide
     */
    public void setHideBack(boolean isHide){
        if (isHide){
            back.setVisibility(GONE);
        }else {
            back.setVisibility(VISIBLE);
        }
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == back.getId()) {
            if (barListener != null) {//处理返回事件
                barListener.back();
            }
        }
    }

    /**
     * 设置返回监听接口
     */
    public interface BarListener {
        public void back(); //处理返回
    }

}

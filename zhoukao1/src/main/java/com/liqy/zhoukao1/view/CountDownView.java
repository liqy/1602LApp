package com.liqy.zhoukao1.view;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.liqy.zhoukao1.R;

/**
 * 自定义倒计时控件
 * Copyright 星期六 YourCompany.
 */
public class CountDownView extends View {

    Paint paint;//画笔
    int time;
    float radius;
    int textColor;
    int bgColor;

    int cx;
    int cy;


    MyListener listener;
    Handler handler;

    public CountDownView(Context context) {
        super(context);
        init(context, null);
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    public CountDownView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        //初始化属性
        if (attrs != null) {
            //获取属性列表
            TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.CountDownView);
            //TODO 初始化自定义属性
            time = typedArray.getInteger(R.styleable.CountDownView_CountDownTime, 3);
            radius = typedArray.getDimension(R.styleable.CountDownView_CountDownRadius, 25);
            textColor = typedArray.getColor(R.styleable.CountDownView_CountDownTextColor, Color.BLACK);
            bgColor = typedArray.getColor(R.styleable.CountDownView_CountDownBgColor, Color.WHITE);
            //释放
            typedArray.recycle();
        } else {
            time = 3;
            radius = 30;
            textColor = Color.BLACK;
            bgColor = Color.WHITE;
        }

        //初始化画笔
        paint = new Paint();
        paint.setStyle(Paint.Style.STROKE);
        paint.setColor(bgColor);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(2);

    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        cx = w / 2;
        cy = h / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //画圆形
        Path path = new Path();
        path.addCircle(cx, cy, radius, Path.Direction.CW);
        canvas.drawPath(path, paint);

        //绘制文字
        paint.setColor(textColor);
        paint.setTextSize(18);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText("" + time, cx, cy, paint);

    }

    /**
     * 设置倒计时时间
     *
     * @param time
     */
    public void setTime(int time) {
        this.time = time;
        //TODO 刷新页面
        invalidate();
    }

    /**
     * 启动倒计时
     *
     * @param cur
     * @param next
     */
    public void start(final Activity cur, final Class<?> next) {
        //定义Handler
        handler = new Handler() {
            @Override
            public void handleMessage(Message msg) {
                super.handleMessage(msg);
                //TODO 结束条件
                if (time == 0) {
                    //跳转到MainActivity
                    Intent intent = new Intent(cur, next);
                    cur.startActivity(intent);
                    cur.finish();
                } else {
                    time--;//倒计时
                    setTime(time); //刷新页面
                    sendEmptyMessageDelayed(1, 1000);//下一秒
                }
            }
        };


        //开始倒计时
        handler.sendEmptyMessageDelayed(1, 1000);

    }

    /**
     * 停止倒计时
     */
    public void stop() {
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getAction() == MotionEvent.ACTION_DOWN) {
            if (listener != null) {
                listener.onClick(this);
            }
        }
        return super.onTouchEvent(event);
    }

    public void setListener(MyListener listener) {
        this.listener = listener;
    }

    //    设置点击事件
    public interface MyListener {
        void onClick(View view);
    }


}

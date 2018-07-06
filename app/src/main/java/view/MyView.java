package view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.Region;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Toast;

import com.liqy.l602lapp.R;


/**
 * Android Studio updating indices 一直闪烁
 * https://blog.csdn.net/BigBoySunshine/article/details/80423055
 *
 * @file FileName
 * 1602LApp
 *  * liqy 字体颜色 大小圆心 半径 文字
 * Copyright 星期五 YourCompany.
 */
public class MyView extends View {

    Paint paint;
    private String text = "Android";
    private int textColor=Color.WHITE;

    /**
     * 构造函数（直接 new 调用此构造函数）
     *
     * @param context
     */
    public MyView(Context context) {
        super(context);
        init(context);
    }

    /**
     * 构造函数 （加载布局文件的时候调用 XML）
     *
     * @param context
     * @param attrs
     */
    public MyView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /**
     * 构造函数 （定义主题文件时需要）
     *
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public MyView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
    }

    private void init(Context context, @Nullable AttributeSet attrs) {
        init(context);

//        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.MyView);
//        text = typedArray.getString(R.styleable.MyView_MyText);
//        typedArray.recycle();

        TypedArray typedArray=context.obtainStyledAttributes(attrs,R.styleable.MyView);

        text =typedArray.getString(R.styleable.MyView_MyText);

        textColor=typedArray.getColor(R.styleable.MyView_MyTextColor,Color.WHITE);

        typedArray.recycle();
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL);
        paint.setAntiAlias(true);
        paint.setStrokeWidth(10);
        paint.setTextSize(18);
    }

    /**
     * 加载XML 监听
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
    }

    /**
     * 测量
     *
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 获取视图的最终大小
     *
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
    }

    /**
     * 布局
     *
     * @param changed
     * @param left
     * @param top
     * @param right
     * @param bottom
     */
    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
    }

    /**
     * 绘制
     *
     * @param canvas
     */
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制矩形
        Rect rect = new Rect(100, 100, 300, 300);
        canvas.drawRect(rect, paint);

        //绘制圆形
        Path path = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CW);
        paint.setColor(Color.BLACK);
        canvas.drawPath(path, paint);

        //绘制文字
        paint.setColor(textColor);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, 200, 200, paint);
    }


    /**
     * TODO　点击事件
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                int x = (int) event.getX();
                int y = (int) event.getY();

                break;
            default:
                break;

        }

        return super.onTouchEvent(event);

    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
    }

    @Override
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
    }
}

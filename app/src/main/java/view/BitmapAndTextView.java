package view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
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

import com.liqy.l602lapp.R;

/**
 * @file FileName
 * 1602LApp
 * Copyright 星期五 YourCompany.
 */
public class BitmapAndTextView extends View {

    Paint paint;//定义画笔

    //第二步
    MyClickListener listener; //定义监听事件

    Region region; //定义全局区域
    Region circleRegion;//切割圆形区域

    /**
     * 构造函数
     * @param context
     */
    public BitmapAndTextView(Context context) {
        super(context);
        init(context);
    }

    /**
     * 构造函数
     * @param context
     * @param attrs
     */
    public BitmapAndTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    /**
     * 构造函数
     * @param context
     * @param attrs
     * @param defStyleAttr
     */
    public BitmapAndTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 初始化变量
     * @param context
     */
    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);

        region = new Region();
        circleRegion = new Region();

    }

    /**
     * 初始化变量，初始化自定义属性
     * @param context
     * @param attrs
     */
    private void init(Context context, AttributeSet attrs) {
        init(context);
    }

    /**
     * 测量控件大小
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    /**
     * 获取最终控件大小
     * @param w
     * @param h
     * @param oldw
     * @param oldh
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        //设置全局区域范围（整个控件大小）
        Rect react = new Rect(0, 0, w, h);
        region.set(react);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //绘制图片
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, 200, 200, paint);

        //定义圆形区域路径
        Path path = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CW);

        //切割圆形区域
        circleRegion.setPath(path, region);

        //画圆形
        canvas.drawPath(path, paint);
    }

    /**
     * 事件处理
     * @param event
     * @return
     */
    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //第四步 （获取点击坐标）
                int x = (int) event.getX();
                int y = (int) event.getY();


                if (circleRegion.contains(x, y)) {//院内
                    if (listener != null) {
                        listener.innerToast(this);
                    }
                } else {
                    if (listener != null) {//院外
                        listener.outerToast(this);
                    }
                }

                break;
            default:
                break;
        }


        return super.onTouchEvent(event);

    }


    /**
     * 第三步 设置监听事件
     *
     * @param listener
     */
    public void setMyListener(MyClickListener listener) {
        this.listener = listener;
    }

    /**
     * 第一步定义点击事件接口
     */
    public interface MyClickListener {
        void innerToast(View view);//圆内
        void outerToast(View view);//园外
    }


}

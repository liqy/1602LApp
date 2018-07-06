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
 *  * liqy
 * Copyright 星期五 YourCompany.
 */
public class BitmapAndTextView extends View {

    Paint paint;

    //第二步
    MyClickListener listener;

    Region region;
    Region circleRegion;

    public BitmapAndTextView(Context context) {
        super(context);
        init(context);
    }

    public BitmapAndTextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init(context, attrs);
    }

    private void init(Context context) {
        paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        paint.setAntiAlias(true);

        region =new Region();
        circleRegion=new Region();

    }

    private void init(Context context, AttributeSet attrs) {
        init(context);
    }

    public BitmapAndTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Rect react=new Rect(0,0,w,h);
        region.set(react);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.ic_launcher);
        canvas.drawBitmap(bitmap, 200, 200, paint);

        Path path = new Path();
        path.addCircle(200, 200, 100, Path.Direction.CW);

        circleRegion.setPath(path,region);

        canvas.drawPath(path, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //第四步
                int x=(int)event.getX();
                int y=(int)event.getY();

                if (circleRegion.contains(x,y)){
                    if (listener!=null){
                        listener.innerToast(this);
                    }
                }else {
                    if (listener!=null){
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
     * 第三步
     *
     * @param listener
     */
    public void setMyListener(MyClickListener listener) {
        this.listener = listener;
    }

    /**
     * 第一步定义接口
     */
    public interface MyClickListener {
        void innerToast(View view);

        void outerToast(View view);
    }


}

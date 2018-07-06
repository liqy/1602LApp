package view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @file FileName
 * 1602LApp
 *  * liqy
 * Copyright 星期五 YourCompany.
 */
public class PathView extends View {

    public PathView(Context context) {
        super(context);
    }

    public PathView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public PathView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        RectF rect = new RectF(0, 0, 200, 200);
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStyle(Paint.Style.FILL);
        canvas.drawArc(rect, 0, 90, true, paint);

        paint.setColor(Color.GREEN);
        canvas.drawArc(rect, 90, 120, true, paint);

        paint.setColor(Color.YELLOW);
        canvas.drawArc(rect, 210, 150, true, paint);


    }
}

package com.gouhao.eventdispatchdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;

import com.gouhao.eventdispatchdemo.util.MotionEventUtils;

/**
 * Created by GouHao on 2017/12/9.
 */

public class CustomView extends View {
    private static final String TAG = CustomView.class.getSimpleName();
    private Paint paint;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xff000000);
        paint.setTextSize(40);

        setClickable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("CustomView", 0, 30, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: " + MotionEventUtils.getActionName(event));
        return super.onTouchEvent(event);
    }
}

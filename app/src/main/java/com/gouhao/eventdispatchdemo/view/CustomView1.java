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

public class CustomView1 extends View {
    private static final String TAG = CustomView1.class.getSimpleName();
    private Paint paint;
    private float lastX, lastY;
    public CustomView1(Context context) {
        this(context, null);
    }

    public CustomView1(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xff000000);
        paint.setTextSize(40);

        setClickable(true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText(TAG, 0, 30, paint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: " + MotionEventUtils.getActionName(event));
        int action = event.getAction() & MotionEvent.ACTION_MASK;
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = event.getX();
//                lastY = event.getY();
//                getParent().requestDisallowInterceptTouchEvent(true);
//                break;
//            case MotionEvent.ACTION_MOVE:
//                if(canIntercept(event)) {
//                    getParent().requestDisallowInterceptTouchEvent(true);
//                } else {
//                    getParent().requestDisallowInterceptTouchEvent(false);
//                }
//                break;
//        }
        return super.onTouchEvent(event);
    }

    private boolean canIntercept(MotionEvent ev) {
        float newX = ev.getX();
        float newY = ev.getY();
        return Math.abs(newX - lastX) < Math.abs(newY - lastY);
    }
}

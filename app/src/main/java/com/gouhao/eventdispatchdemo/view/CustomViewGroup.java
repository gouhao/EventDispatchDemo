package com.gouhao.eventdispatchdemo.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;

import com.gouhao.eventdispatchdemo.util.MotionEventUtils;

/**
 * Created by GouHao on 2017/12/9.
 */

public class CustomViewGroup extends ViewGroup {
    private static final String TAG = CustomViewGroup.class.getSimpleName();
    private Paint paint;

    public CustomViewGroup(Context context) {
        this(context, null);
    }

    public CustomViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xff000000);
        paint.setTextSize(40);
        setClickable(true);
    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int childCount = getChildCount();
        int left = l + getPaddingLeft();
        int top = t + getPaddingTop();

        for(int i = 0; i < childCount; i++) {
            View child = getChildAt(i);
            MarginLayoutParams layoutParams = (MarginLayoutParams) child.getLayoutParams();
            child.layout(left, top, left + child.getMeasuredWidth(), top + child.getMeasuredHeight());
            top += child.getHeight() + layoutParams.bottomMargin;
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawText("CustomViewGroup", 0, 30, paint);
    }
    private float lastX, lastY;
//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.d(TAG, "onInterceptTouchEvent: " + MotionEventUtils.getActionName(ev));
//        int action = ev.getAction() & MotionEvent.ACTION_MASK;
//        switch (action) {
//            case MotionEvent.ACTION_DOWN:
//                lastX = ev.getX();
//                lastY = ev.getY();
//                return false;
//            case MotionEvent.ACTION_MOVE:
//                return canIntercept(ev);
//            case MotionEvent.ACTION_UP:
//                return false;
//            default:
//                return super.onInterceptTouchEvent(ev);
//        }
//    }

//    @Override
//    public boolean onInterceptTouchEvent(MotionEvent ev) {
//        Log.d(TAG, "onInterceptTouchEvent: " + MotionEventUtils.getActionName(ev));
//        int action = ev.getAction() & MotionEvent.ACTION_MASK;
//        if(action == MotionEvent.ACTION_DOWN) {
//            return false;
//        }
//        return true;
//    }
    private boolean canIntercept(MotionEvent ev) {
        float newX = ev.getX();
        float newY = ev.getY();
        return Math.abs(newX - lastX) > Math.abs(newY - lastY);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        Log.d(TAG, "onTouchEvent: " + MotionEventUtils.getActionName(event));
        return super.onTouchEvent(event);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        measureChildren(widthMeasureSpec, heightMeasureSpec);
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }
}

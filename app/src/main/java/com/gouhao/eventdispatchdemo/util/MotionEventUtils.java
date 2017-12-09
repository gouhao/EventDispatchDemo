package com.gouhao.eventdispatchdemo.util;

import android.view.MotionEvent;

/**
 * Created by GouHao on 2017/12/9.
 */

public class MotionEventUtils {
    public static String getActionName(MotionEvent motionEvent) {
        int action = motionEvent.getAction() & MotionEvent.ACTION_MASK;
        switch (action) {
            case MotionEvent.ACTION_DOWN:
                return "ACTION_DOWN";
            case MotionEvent.ACTION_MOVE:
                return "ACTION_MOVE";
            case MotionEvent.ACTION_UP:
                return "ACTION_UP";
            case MotionEvent.ACTION_CANCEL:
                return "ACTION_CANCEL";
            default:
                return "ACTION: " + action;
        }
    }
}

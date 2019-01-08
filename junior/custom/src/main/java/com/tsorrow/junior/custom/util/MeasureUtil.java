package com.tsorrow.junior.custom.util;

import android.app.Activity;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class MeasureUtil {
    private final static String TAG = "MeasureUtil";

    public static float getTextWidth(String text, float textSize) {
        if (text==null || text.length()<=0) {
            return 0;
        }
        Paint paint = new Paint();
        paint.setTextSize(textSize);
        return paint.measureText(text);
    }

    public static float getTextHeight(String text, float textSize) {
        Paint paint = new Paint();
        paint.setTextSize(textSize);
        Paint.FontMetrics fm = paint.getFontMetrics();
        return fm.descent - fm.ascent;
    }

    public static float getRealHeight(Activity act, int resid) {
        LinearLayout llayout = (LinearLayout) act.findViewById(resid);
        return getRealHeight(llayout);
    }

    public static float getRealHeight(View parent, int resid) {
        LinearLayout llayout = (LinearLayout) parent.findViewById(resid);
        return getRealHeight(llayout);
    }

    public static float getRealHeight(View child) {
        LinearLayout llayout = (LinearLayout) child;
        ViewGroup.LayoutParams params = llayout.getLayoutParams();
        if (params == null) {
            params = new ViewGroup.LayoutParams(
                    ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        }
        int widthSpec = ViewGroup.getChildMeasureSpec(0, 0, params.width);
        int heightSpec;
        if (params.height > 0) {
            heightSpec = View.MeasureSpec.makeMeasureSpec(params.height, View.MeasureSpec.EXACTLY);
        } else {
            heightSpec = View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED);
        }
        llayout.measure(widthSpec, heightSpec);
        return llayout.getMeasuredHeight();
    }

}

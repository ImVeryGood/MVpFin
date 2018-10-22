package com.newdicooker.tempetek.mvpfin.mvp_network.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by SPC
 * on 2018/10/19
 * 邮箱：13027699936@163.com.
 * version 2.0.4
 */

public class AnimateCircleView extends View {
    protected final String TAG = "SSSSSSSSSSSSSS";
    private Paint paint1;
    private Paint paint2;
    private Paint paint3;
    RectF mDrawRectf = new RectF();

    public AnimateCircleView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public void initView(Context mContext, AttributeSet attributeSet) {
        paint1 = new Paint(Paint.ANTI_ALIAS_FLAG | Paint.DITHER_FLAG);
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(80);
        paint1.setColor(Color.RED);

        paint2 = new Paint(paint1);
        paint2.setColor(Color.GREEN);

        paint3 = new Paint(paint1);
        paint3.setColor(Color.BLUE);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    }
}

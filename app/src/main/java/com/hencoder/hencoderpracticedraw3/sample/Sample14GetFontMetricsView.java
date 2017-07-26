package com.hencoder.hencoderpracticedraw3.sample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

public class Sample14GetFontMetricsView extends View {
    Paint paint1 = new Paint(Paint.ANTI_ALIAS_FLAG);
    Paint paint2 = new Paint(Paint.ANTI_ALIAS_FLAG);
    String[] texts = {"A", "a", "J", "j", "Â", "â"};
    float yOffset;
    int top = 200;
    int bottom = 400;

    public Sample14GetFontMetricsView(Context context) {
        super(context);
    }

    public Sample14GetFontMetricsView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public Sample14GetFontMetricsView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    {
        paint1.setStyle(Paint.Style.STROKE);
        paint1.setStrokeWidth(20);
        paint1.setColor(Color.parseColor("#E91E63"));
        paint2.setTextSize(160);

        Paint.FontMetrics fontMetrics = paint2.getFontMetrics();
        //fontMetrics.ascent: -148 , fontMetrics.descent: 39
        //取中间坐标， -(ascent+descent)/2
        //获取范围， 是一个左下角坐标 为（0，0）字体的矩阵，所以取出来的ascent 是负值。
        //因为是负的值， 所以最后算出来的值要加-号。取得一个正数。
        yOffset = - (fontMetrics.ascent + fontMetrics.descent) / 2;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawRect(50, top, getWidth() - 50, bottom, paint1);

        int middle = (top + bottom) / 2;
        canvas.drawText(texts[0], 100, middle + yOffset, paint2);
        canvas.drawText(texts[1], 200, middle + yOffset, paint2);
        canvas.drawText(texts[2], 300, middle + yOffset, paint2);
        canvas.drawText(texts[3], 400, middle + yOffset, paint2);
        canvas.drawText(texts[4], 500, middle + yOffset, paint2);
        canvas.drawText(texts[5], 600, middle + yOffset, paint2);
    }
}

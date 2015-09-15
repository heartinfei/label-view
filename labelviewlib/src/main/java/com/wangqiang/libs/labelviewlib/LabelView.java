package com.wangqiang.libs.labelviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.Gravity;
import android.widget.TextView;

/**
 * Created by heartinfei on 2015/9/11.
 */
public class LabelView extends TextView {
    protected float distance = 0;
    protected int position = 0;
    protected int style = 1;

    public LabelView(Context context) {
        super(context);
    }

    public LabelView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setGravity(Gravity.CENTER);
        init(context, attrs, 0);
    }

    public LabelView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setGravity(Gravity.CENTER);
        init(context, attrs, defStyle);
    }


    protected void setUpLabel() {
        setRotation(position == 0 ? -45 : 45);
        float tranX = getWidth() / 2 - distance - getHeight() / 2;
        float offset = getHeight() / 8.0f;
        if (position == 0) {
            tranX = style == 0 ? -tranX : -tranX - offset;
        } else {
            tranX = style == 0 ? tranX : tranX + offset;
        }
        setTranslationY(style == 0 ? distance : -offset);
        setTranslationX(tranX);
    }

    protected void init(Context context, AttributeSet attrs, int defStyle) {
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.LabelView, defStyle, 0);
        distance = a.getDimension(R.styleable.LabelView_label_distance, 0);
        position = a.getInt(R.styleable.LabelView_label_position, 0);
        style = a.getInt(R.styleable.LabelView_label_type, 0);
        a.recycle();
    }//end init

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        setUpLabel();
    }
}

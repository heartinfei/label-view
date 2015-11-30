package com.wangqiang.libs.labelviewlib;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by heartinfei on 2015/11/30.
 */
public class CustomerFontTextView extends TextView {
    public CustomerFontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomerFontTextView);
        if (a == null) {
            return;
        }
        String typeFacePath = a.getString(R.styleable.CustomerFontTextView_customTypeface);
        if (TextUtils.isEmpty(typeFacePath)) {
            return;
        }
        Typeface typeFace = Typeface.createFromAsset(context.getAssets(), typeFacePath);
        setTypeface(typeFace);
        a.recycle();
    }//end CustomerFontTextView

}

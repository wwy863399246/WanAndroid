package com.wwy.android.view.roundview;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.RippleDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

import com.wwy.android.R;


public class RoundViewDelegate {
    private View view;
    private Context context;
    private GradientDrawable gd_background = new GradientDrawable();
    private GradientDrawable gd_background_press = new GradientDrawable();
    private int backgroundColor;
    private int backgroundStartColor;
    private int backgroundEndColor;
    private int backgroundPressColor;
    private int backgroundPressStartColor;
    private int backgroundPressEndColor;
    private int cornerRadius;
    private int cornerRadius_TL;
    private int cornerRadius_TR;
    private int cornerRadius_BL;
    private int cornerRadius_BR;
    private int strokeWidth;
    private int strokeColor;
    private int strokePressColor;
    private int textPressColor;
    private boolean isRadiusHalfHeight;
    private boolean isWidthHeightEqual;
    private boolean isRippleEnable;
    private float[] radiusArr = new float[8];
    private int strokeDashGap;
    private int strokeDashWidth;

    public RoundViewDelegate(View view, Context context, AttributeSet attrs) {
        this.view = view;
        this.context = context;
        obtainAttributes(context, attrs);
    }

    private void obtainAttributes(Context context, AttributeSet attrs) {
        TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.RoundTextView);
        backgroundColor = ta.getColor(R.styleable.RoundTextView_rv_backgroundColor, Color.TRANSPARENT);
        backgroundStartColor = ta.getColor(R.styleable.RoundTextView_rv_backgroundStartColor, Color.TRANSPARENT);
        backgroundEndColor = ta.getColor(R.styleable.RoundTextView_rv_backgroundEndColor, Color.TRANSPARENT);
        backgroundPressColor = ta.getColor(R.styleable.RoundTextView_rv_backgroundPressColor, Integer.MAX_VALUE);
        backgroundPressStartColor = ta.getColor(R.styleable.RoundTextView_rv_backgroundPressStartColor, Integer.MAX_VALUE);
        backgroundPressEndColor = ta.getColor(R.styleable.RoundTextView_rv_backgroundPressEndColor, Integer.MAX_VALUE);
        cornerRadius = ta.getDimensionPixelSize(R.styleable.RoundTextView_rv_cornerRadius, 0);
        strokeWidth = ta.getDimensionPixelSize(R.styleable.RoundTextView_rv_strokeWidth, 0);
        strokeColor = ta.getColor(R.styleable.RoundTextView_rv_strokeColor, Color.TRANSPARENT);
        strokePressColor = ta.getColor(R.styleable.RoundTextView_rv_strokePressColor, Integer.MAX_VALUE);
        strokeDashGap = ta.getDimensionPixelSize(R.styleable.RoundTextView_rv_strokeDashGap, 0);
        strokeDashWidth = ta.getDimensionPixelSize(R.styleable.RoundTextView_rv_strokeDashWidth, 0);
        textPressColor = ta.getColor(R.styleable.RoundTextView_rv_textPressColor, Integer.MAX_VALUE);
        isRadiusHalfHeight = ta.getBoolean(R.styleable.RoundTextView_rv_isRadiusHalfHeight, false);
        isWidthHeightEqual = ta.getBoolean(R.styleable.RoundTextView_rv_isWidthHeightEqual, false);
        cornerRadius_TL = ta.getDimensionPixelSize(R.styleable.RoundTextView_rv_cornerRadius_TL, 0);
        cornerRadius_TR = ta.getDimensionPixelSize(R.styleable.RoundTextView_rv_cornerRadius_TR, 0);
        cornerRadius_BL = ta.getDimensionPixelSize(R.styleable.RoundTextView_rv_cornerRadius_BL, 0);
        cornerRadius_BR = ta.getDimensionPixelSize(R.styleable.RoundTextView_rv_cornerRadius_BR, 0);
        isRippleEnable = ta.getBoolean(R.styleable.RoundTextView_rv_isRippleEnable, true);

        ta.recycle();
    }

    public void setBackgroundColor(int backgroundColor) {
        this.backgroundColor = backgroundColor;
        setBgSelector();
    }

    public void setBackgroundStartColor(int backgroundStartColor) {
        this.backgroundStartColor = backgroundStartColor;
        setBgSelector();
    }

    public void setBackgroundEndColor(int backgroundEndColor) {
        this.backgroundEndColor = backgroundEndColor;
        setBgSelector();
    }

    public void setBackgroundPressColor(int backgroundPressColor) {
        this.backgroundPressColor = backgroundPressColor;
        setBgSelector();
    }

    public void setBackgroundPressStartColor(int backgroundPressStartColor) {
        this.backgroundPressStartColor = backgroundPressStartColor;
        setBgSelector();
    }

    public void setBackgroundPressEndColor(int backgroundPressEndColor) {
        this.backgroundPressEndColor = backgroundPressEndColor;
        setBgSelector();
    }

    public void setCornerRadius(int cornerRadius) {
        this.cornerRadius = dp2px(cornerRadius);
        setBgSelector();
    }

    public void setStrokeWidth(float strokeWidth) {
        this.strokeWidth = dp2px(strokeWidth);
        setBgSelector();
    }

    public void setStrokeColor(int strokeColor) {
        this.strokeColor = strokeColor;
        setBgSelector();
    }

    public void setStrokePressColor(int strokePressColor) {
        this.strokePressColor = strokePressColor;
        setBgSelector();
    }

    public void setTextPressColor(int textPressColor) {
        this.textPressColor = textPressColor;
        setBgSelector();
    }

    public void setIsRadiusHalfHeight(boolean isRadiusHalfHeight) {
        this.isRadiusHalfHeight = isRadiusHalfHeight;
        setBgSelector();
    }

    public void setIsWidthHeightEqual(boolean isWidthHeightEqual) {
        this.isWidthHeightEqual = isWidthHeightEqual;
        setBgSelector();
    }

    public void setCornerRadius_TL(int cornerRadius_TL) {
        this.cornerRadius_TL = cornerRadius_TL;
        setBgSelector();
    }

    public void setCornerRadius_TR(int cornerRadius_TR) {
        this.cornerRadius_TR = cornerRadius_TR;
        setBgSelector();
    }

    public void setCornerRadius_BL(int cornerRadius_BL) {
        this.cornerRadius_BL = cornerRadius_BL;
        setBgSelector();
    }

    public void setCornerRadius_BR(int cornerRadius_BR) {
        this.cornerRadius_BR = cornerRadius_BR;
        setBgSelector();
    }

    public int getBackgroundColor() {
        return backgroundColor;
    }

    public int getBackgroundPressColor() {
        return backgroundPressColor;
    }

    public int getCornerRadius() {
        return cornerRadius;
    }

    public int getStrokeWidth() {
        return strokeWidth;
    }

    public int getStrokeColor() {
        return strokeColor;
    }

    public int getStrokePressColor() {
        return strokePressColor;
    }

    public int getTextPressColor() {
        return textPressColor;
    }

    public boolean isRadiusHalfHeight() {
        return isRadiusHalfHeight;
    }

    public boolean isWidthHeightEqual() {
        return isWidthHeightEqual;
    }

    public int getCornerRadius_TL() {
        return cornerRadius_TL;
    }

    public int getCornerRadius_TR() {
        return cornerRadius_TR;
    }

    public int getCornerRadius_BL() {
        return cornerRadius_BL;
    }

    public int getCornerRadius_BR() {
        return cornerRadius_BR;
    }

    protected int dp2px(float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }

    protected int sp2px(float sp) {
        final float scale = this.context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (sp * scale + 0.5f);
    }

    private void setDrawable(GradientDrawable gd, int backgroundStartColor, int backgroundEndColor, int strokeColor) {
        gd.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gd.setColors(new int[]{backgroundStartColor, backgroundEndColor});
        if (cornerRadius_TL > 0 || cornerRadius_TR > 0 || cornerRadius_BR > 0 || cornerRadius_BL > 0) {
            radiusArr[0] = cornerRadius_TL;
            radiusArr[1] = cornerRadius_TL;
            radiusArr[2] = cornerRadius_TR;
            radiusArr[3] = cornerRadius_TR;
            radiusArr[4] = cornerRadius_BR;
            radiusArr[5] = cornerRadius_BR;
            radiusArr[6] = cornerRadius_BL;
            radiusArr[7] = cornerRadius_BL;
            gd.setCornerRadii(radiusArr);
        } else {
            gd.setCornerRadius(cornerRadius);
        }

        gd.setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap);
    }

    private void setDrawable(GradientDrawable gd, int color, int strokeColor) {
        gd.setColor(color);

        if (cornerRadius_TL > 0 || cornerRadius_TR > 0 || cornerRadius_BR > 0 || cornerRadius_BL > 0) {
            radiusArr[0] = cornerRadius_TL;
            radiusArr[1] = cornerRadius_TL;
            radiusArr[2] = cornerRadius_TR;
            radiusArr[3] = cornerRadius_TR;
            radiusArr[4] = cornerRadius_BR;
            radiusArr[5] = cornerRadius_BR;
            radiusArr[6] = cornerRadius_BL;
            radiusArr[7] = cornerRadius_BL;
            gd.setCornerRadii(radiusArr);
        } else {
            gd.setCornerRadius(cornerRadius);
        }

        gd.setStroke(strokeWidth, strokeColor, strokeDashWidth, strokeDashGap);
    }

    @SuppressLint("ObsoleteSdkInt")
    public void setBgSelector() {
        StateListDrawable bg = new StateListDrawable();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP && isRippleEnable) {
            if (backgroundStartColor != 0 && backgroundEndColor != 0) {
                setDrawable(gd_background, backgroundStartColor, backgroundEndColor, strokeColor);
                bg.addState(new int[]{-android.R.attr.state_pressed}, gd_background);
                if (backgroundPressStartColor != Integer.MAX_VALUE && backgroundPressEndColor != Integer.MAX_VALUE || strokePressColor != Integer.MAX_VALUE) {
                    setDrawable(gd_background_press, backgroundPressStartColor, backgroundPressEndColor, strokePressColor);
                    bg.addState(new int[]{android.R.attr.state_pressed}, gd_background_press);
                }
                view.setBackground(bg);
                //setDrawable(gd_background, backgroundStartColor, backgroundEndColor, strokeColor);
                //RippleDrawable rippleDrawable = new RippleDrawable(getPressedColorSelector(backgroundPressStartColor, backgroundStartColor), gd_background, null);
//                bg.addState(new int[]{-android.R.attr.state_pressed}, gd_background);
//                if (backgroundPressStartColor != Integer.MAX_VALUE && backgroundPressEndColor != Integer.MAX_VALUE || strokePressColor != Integer.MAX_VALUE) {
//                    setDrawable(gd_background_press, backgroundPressStartColor, backgroundPressEndColor, strokePressColor);
//                    RippleDrawable rippleDrawable = new RippleDrawable(getPressedColorSelector(backgroundStartColor, backgroundPressEndColor), gd_background_press, null);
//                    bg.addState(new int[]{android.R.attr.state_pressed}, rippleDrawable);
//                }
//                view.setBackground(bg);
            } else {
                setDrawable(gd_background, backgroundColor, strokeColor);
                RippleDrawable rippleDrawable = new RippleDrawable(getPressedColorSelector(backgroundColor, backgroundPressColor), gd_background, null);
                view.setBackground(rippleDrawable);
            }

        } else {
            if (backgroundStartColor != 0 && backgroundEndColor != 0) {
                setDrawable(gd_background, backgroundStartColor, backgroundEndColor, strokeColor);
                bg.addState(new int[]{-android.R.attr.state_pressed}, gd_background);
                if (backgroundPressStartColor != Integer.MAX_VALUE && backgroundPressEndColor != Integer.MAX_VALUE || strokePressColor != Integer.MAX_VALUE) {
                    setDrawable(gd_background_press, backgroundPressStartColor, backgroundPressEndColor, strokePressColor);
                    bg.addState(new int[]{android.R.attr.state_pressed}, gd_background_press);
                }
            } else {
                setDrawable(gd_background, backgroundColor, strokeColor);
                bg.addState(new int[]{-android.R.attr.state_pressed}, gd_background);
                if (backgroundPressColor != Integer.MAX_VALUE || strokePressColor != Integer.MAX_VALUE) {
                    setDrawable(gd_background_press, backgroundPressColor == Integer.MAX_VALUE ? backgroundColor : backgroundPressColor, strokePressColor ==
                            Integer.MAX_VALUE ? strokeColor : strokePressColor);
                    bg.addState(new int[]{android.R.attr.state_pressed}, gd_background_press);
                }
            }
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {//16
                view.setBackground(bg);
            } else {
                view.setBackgroundDrawable(bg);
            }
        }

        if (view instanceof TextView) {
            if (textPressColor != Integer.MAX_VALUE) {
                ColorStateList textColors = ((TextView) view).getTextColors();
                ColorStateList colorStateList = new ColorStateList(new int[][]{new int[]{-android.R.attr.state_pressed}, new int[]{android.R.attr
                        .state_pressed}}, new int[]{textColors.getDefaultColor(), textPressColor});
                ((TextView) view).setTextColor(colorStateList);
            }
        }
    }

    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    private ColorStateList getPressedColorSelector(int normalColor, int pressedColor) {
        return new ColorStateList(new int[][]{new int[]{android.R.attr.state_pressed}, new int[]{android.R.attr.state_focused}, new int[]{android.R.attr
                .state_activated}, new int[]{}}, new int[]{pressedColor, pressedColor, pressedColor, normalColor});
    }
}
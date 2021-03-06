/*
 * Copyright (C) 2016, TP-LINK TECHNOLOGIES CO., LTD.
 *
 * asd.java
 *
 * 
 *
 * Author huanghaiqi, Created at 2016-12-26
 *
 * Ver 1.0, 2016-12-26, huanghaiqi, Create file.
 */

package com.halohoop.recyclerviewdragsortswipedemo.ui;

import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.ColorInt;
import android.support.annotation.MenuRes;
import android.support.v4.view.ViewCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

/**
 * Created by yuan on 29/11/2016.
 */

public abstract class BaseItemDecoration extends RecyclerView.ItemDecoration {

    private GradientDrawable mGradientDrawableDivider;

    private Drawable mDrawable;

    BaseItemDecoration(int color, Drawable drawable) {
        mDrawable = drawable;
        generateDividerDrawable(color);
    }

    private void generateDividerDrawable(int color) {
        mGradientDrawableDivider = new GradientDrawable();
        mGradientDrawableDivider.setColor(color);
    }

    Drawable getDividerDrawable() {
        return mDrawable == null ? mGradientDrawableDivider : mDrawable;
    }

}
package com.halohoop.widgets;

import android.content.Context;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

/**
 * Created by Pooholah on 2016/9/15.
 */

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {

    //SurfaceHolder
    private SurfaceHolder mHolder;
    //用于绘图的Canvas
    private Canvas mCanvas;
    //子线程标志位
    private boolean mIsDrawing;

    public MySurfaceView(Context context) {
        this(context, null);
    }

    public MySurfaceView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public MySurfaceView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context, attrs);
        initAttrs(attrs);
    }

    private void init(Context context, AttributeSet attrs) {
        mHolder = getHolder();
        mHolder.addCallback(this);
        setFocusable(true);
        setFocusableInTouchMode(true);
        this.setKeepScreenOn(true);
        mHolder.setFormat(PixelFormat.OPAQUE);
    }

    private void initAttrs(AttributeSet attrs) {
        //TODO deal with attrs
    }

    //表示SurfaceView的创建，改变和销毁
    @Override
    public void surfaceCreated(SurfaceHolder surfaceHolder) {
        mIsDrawing = true;
        //子线程重复绘制
        new Thread(this).start();//见run方法
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        mIsDrawing = false;
    }

    @Override
    public void run(){
        while(mIsDrawing){
            draw();
        }
    }

    private void draw(){
        try {
            mCanvas = mHolder.lockCanvas();
            //draw something
        }catch (Exception e){

        }finally {
            if(mCanvas!=null){
                mHolder.unlockCanvasAndPost(mCanvas);//保证每次都能将内容提交
            }
        }
    }

}

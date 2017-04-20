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
        //--让背景透明--
        this.setZOrderOnTop(true);
        mHolder.setFormat(PixelFormat.TRANSLUCENT);
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
    public void surfaceDestroyed(SurfaceHolder holder) {//当view不可见的时候调用
        mIsDrawing = false;
    }

    @Override
    public void run(){
        while(mIsDrawing){
            cyclingDraw();
        }
    }

    private void cyclingDraw(){
        Canvas canvas = null;
        try {
            canvas = mHolder.lockCanvas();
            drawStuff(canvas);
        }catch (Exception e){

        }finally {
            if(canvas!=null){
                mHolder.unlockCanvasAndPost(canvas);//保证每次都能将内容提交
            }
        }
    }

    private void drawStuff(Canvas canvas){
        //清屏
        canvas.drawColor(Color.WHITE);

    }

}

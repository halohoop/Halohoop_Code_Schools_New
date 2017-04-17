package com.halohoop.androidallanims;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.halohoop.androidallanims.frameanimation.FrameAnimationActivity;
import com.halohoop.androidallanims.tweenanimation.TweenAnimationActivity;
import com.halohoop.androidallanims.utils.ToastUtils;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViewById(R.id.tv_frame).setOnClickListener(this);
        findViewById(R.id.tv_tween).setOnClickListener(this);
        findViewById(R.id.tv_pro).setOnClickListener(this);
        findViewById(R.id.tv_tran).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_frame:
                ToastUtils.t(this, "Go to Frame Animation Activity.");
                startAct(FrameAnimationActivity.class);
                break;
            case R.id.tv_tween:
                ToastUtils.t(this, "Go to Tween Animation Activity.");
                startAct(TweenAnimationActivity.class);
                break;
            case R.id.tv_pro:
                ToastUtils.t(this, "Go to Property Animation Activity.");
                startAct(PropertyAnimationActivity.class);
                break;
            case R.id.tv_tran:
                ToastUtils.t(this, "Go to Transition Animation Activity.");
                startAct(TransitionAnimationActivity.class);
                break;
        }
    }

    private void startAct(Class clz) {
        Intent intent = new Intent(this, clz);
        startActivity(intent);
    }


}

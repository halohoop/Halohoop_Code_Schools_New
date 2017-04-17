package com.halohoop.androidallanims.tweenanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.halohoop.androidallanims.R;

/**
 * Created by Pooholah on 2017/4/17.
 */

public class TweenAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween);
        findViewById(R.id.tv_tween_alpha_xml).setOnClickListener(this);
        findViewById(R.id.tv_tween_scale_xml).setOnClickListener(this);
        findViewById(R.id.tv_tween_trans).setOnClickListener(this);
        findViewById(R.id.tv_tween_rota).setOnClickListener(this);
        findViewById(R.id.tv_tween_custom).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_tween_alpha_xml:
                break;
            case R.id.tv_tween_alpha_code:
                break;
            case R.id.tv_tween_scale_xml:
                break;
            case R.id.tv_tween_scale_code:
                break;
            case R.id.tv_tween_trans_xml:
                break;
            case R.id.tv_tween_trans_code:
                break;
            case R.id.tv_tween_rota_xml:
                break;
            case R.id.tv_tween_rota_code:
                break;
            case R.id.tv_tween_custom:
                break;
        }
    }
}

package com.halohoop.androidallanims.frameanimation;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.halohoop.androidallanims.R;

/**
 * Created by Pooholah on 2017/4/17.
 */

public class FrameAnimationActivity extends AppCompatActivity implements View.OnClickListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame);
        findViewById(R.id.tv_frame_code).setOnClickListener(this);
        findViewById(R.id.tv_frame_xml).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_frame_xml:
                break;
            case R.id.tv_frame_code:
                break;
        }
    }
}

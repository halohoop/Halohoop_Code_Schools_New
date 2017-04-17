package com.halohoop.androidallanims.utils;

import android.content.Context;
import android.widget.Toast;

/**
 * Created by Pooholah on 2017/4/17.
 */

public class ToastUtils {
    public static void t(Context context, String str) {
        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
    }
}

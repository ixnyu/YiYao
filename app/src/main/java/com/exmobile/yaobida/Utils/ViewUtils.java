package com.exmobile.yaobida.Utils;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

/**
 * Created by Administrator on 2015/10/23 0023.
 */
public class ViewUtils {
    public static void removeParent(View view){
        //先找到父控件 再移除
        ViewParent parent= view.getParent();
        if (parent instanceof ViewGroup){
            ViewGroup group = (ViewGroup) parent;
            System.out.println("移除父");
            group.removeView(view);
        }
    }
}

package com.exmobile.yaobida.Utils;

import android.content.Context;

import com.exmobile.yaobida.Base.BaseApplication;

import java.util.logging.Handler;

/**
 * Created by Administrator on 2015/10/29 0029.
 */
public class UiUtils {

    private static Handler mHandler;

    public static Context getContext(){
        return BaseApplication.getApplication();
    }

    public static void runOnUiThread(Runnable runnable){
        //是否在主线程运行
        if (android.os.Process.myTid()==BaseApplication.getMainTid()){
            runnable.run();
        }else {
            //获取handler
            BaseApplication.getHandler().post(runnable);
        }

    }
}

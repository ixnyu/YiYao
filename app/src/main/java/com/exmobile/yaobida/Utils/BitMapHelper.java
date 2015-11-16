package com.exmobile.yaobida.Utils;

import com.lidroid.xutils.BitmapUtils;

/**
 * Created by Administrator on 2015/11/13 0013.
 */
public class BitMapHelper {
    private BitMapHelper() {
    }
    private static BitmapUtils sBitmapUtils;

    /**
     * BitmapUtils 不是单例的根据需要重载多个获取实例的方法
     */
    public static BitmapUtils getBitMapUtils(){
        if (sBitmapUtils==null){
            //第二个参数缓存路径 第三个参数加载图片最多消耗多少比例的内存 0.03f-0.8f
            sBitmapUtils = new BitmapUtils(UiUtils.getContext(),FileUtils.getDir("icon").getAbsolutePath(),0.3f);
        }

        return sBitmapUtils;
    }
}

package com.exmobile.yaobida.Utils;

import android.os.Environment;

import com.lidroid.xutils.util.IOUtils;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by Administrator on 2015/11/13 0013.
 */
public class FileUtils {
    public static final String CACHE = "cache";
    public static final String ROOT = "yaobida";




    public static File getDir(String string) {
        StringBuilder path = new StringBuilder();
        path.append(Environment.getExternalStorageDirectory().getAbsolutePath()); //获得SD路径
        path.append(File.separator); // '/'
        path.append(ROOT); //  /mnt/sdcard/yaobida/cache
        path.append(File.separator); // '/'
        path.append(string); //  /mnt/sdcard/yaobida/cache/
        File file = new File(path.toString());
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs(); //创建文件夹
        }
        return file;
    }

    public static File getCacheDir() {
        return getDir(CACHE);
    }

    public static void saveLocal(String string) {
        BufferedWriter bufferedWriter = null;
        try {
            File dir = getCacheDir();
            File file = new File(dir, "home");
            FileWriter fileWriter = new FileWriter(file);
            bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write(string);
            bufferedWriter.flush();
            bufferedWriter.close();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            IOUtils.closeQuietly(bufferedWriter);
        }


    }

}

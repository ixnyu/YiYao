package com.exmobile.yaobida.Base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by xnyu on 2015-10-15.
 */
public abstract class BaseActivity extends AppCompatActivity {
    // 管理运行的所有的activity
    public final static List<BaseActivity> mActivities = new LinkedList<BaseActivity>();

    public static BaseActivity activity;

    @Override
    protected void onResume() {
        super.onResume();
        activity=this;
    }
    @Override
    protected void onPause() {
        super.onPause();
        activity=null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        synchronized (mActivities) {
            mActivities.add(this);
        }
        init();
        initView();

    }

    abstract public  void initView();

    abstract public void init();

    @Override
    protected void onDestroy() {
        super.onDestroy();
        synchronized (mActivities) {
            mActivities.remove(this);
        }
    }

    public void killAll() {
        // 复制了一份mActivities 集合
        List<BaseActivity> copy;
        synchronized (mActivities) {
            copy = new LinkedList<BaseActivity>(mActivities);
        }
        for (BaseActivity activity : copy) {
            activity.finish();
        }
        // 杀死当前的进程
       // android.os.Process.killProcess(android.os.Process.myPid());
    }

}

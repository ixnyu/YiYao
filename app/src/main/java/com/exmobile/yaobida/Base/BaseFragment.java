package com.exmobile.yaobida.Base;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.exmobile.yaobida.Utils.ViewUtils;
import com.exmobile.yaobida.View.LoadingPage;

/**
 * Created by xnyu on 2015-10-15.
 */
public abstract class BaseFragment extends Fragment {

    private LoadingPage mLoadingPage;

        @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        if (mLoadingPage == null) {
            mLoadingPage = new LoadingPage(getActivity()) {
                @Override
                public View createSuccessView() {
                    return BaseFragment.this.createSuccessView();
                }

                @Override
                public BaseFragment.LoadResult load() {
                    return BaseFragment.this.load();
                }
            };
            //在FrameLayout中添加4种不同的界面
        }
        else {
            ViewUtils.removeParent(mLoadingPage);
        }
        //根据服务器的数据显示具体内容
//        show();
        //        View view = init(inflater);
        //        initView(savedInstanceState);


        return mLoadingPage;
    }
    public enum LoadResult {
        error(2), empty(3), success(4);
        int value;

        LoadResult(int value) {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    public void show(){
        if (mLoadingPage != null) {
            mLoadingPage.show();
        }
    }

    public abstract View createSuccessView();
    public abstract LoadResult load();

}
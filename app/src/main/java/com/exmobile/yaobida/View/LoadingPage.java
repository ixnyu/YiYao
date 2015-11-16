package com.exmobile.yaobida.View;

import android.content.Context;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;

import com.exmobile.yaobida.Base.BaseFragment;
import com.exmobile.yaobida.R;
import com.exmobile.yaobida.Utils.ThreadManager;
import com.exmobile.yaobida.Utils.UiUtils;

/**
 * Created by Administrator on 2015/10/29 0029.
 */
public abstract class LoadingPage extends FrameLayout {

    public static final int STATE_UNKNOWN = 0;
    public static final int STATE_LOADING = 1;
    public static final int STATE_ERROR = 2;
    public static final int STATE_EMPTY = 3;
    public static final int STATE_SUCCESS = 4;
    public int state = STATE_UNKNOWN;
    //加载中界面
    private View loadingView;
    //错误界面
    private View errorView;
    //空界面
    private View emptyView;
    //加载成功的界面;
    private View successView;

    public LoadingPage(Context context) {
        super(context);
        init();
    }

    private void init() {
        loadingView = createLoadingView();
        if (loadingView != null) {
            this.addView(loadingView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        errorView = createErrorView();
        if (errorView != null) {
            this.addView(errorView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        emptyView = createEmptyView();
        if (emptyView != null) {
            this.addView(emptyView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        }
        //根据不同的状态显示不同的界面
        showPage();


    }

    public LoadingPage(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public LoadingPage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }


    private View createEmptyView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.loadpage_loading, null);
        return view;
    }

    private View createErrorView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.loadpage_error, null);
        Button errBtn = (Button) view.findViewById(R.id.fragment_error_retry_btn);
        errBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                show();
            }
        });
        return view;
    }

    /**
     * 返回加载中界面
     *
     * @return
     */
    private View createLoadingView() {
        View view = View.inflate(UiUtils.getContext(), R.layout.loadpage_loading, null);
        return view;
    }

    //根据不同状态显示不同页面
    private void showPage() {
        if (loadingView != null) {
            loadingView.setVisibility(state == STATE_UNKNOWN || state == STATE_LOADING ? View.VISIBLE : View.INVISIBLE);
        }
        if (errorView != null) {
            errorView.setVisibility(state == STATE_ERROR ? View.VISIBLE : View.INVISIBLE);
        }
        if (emptyView != null) {
            emptyView.setVisibility(state == STATE_EMPTY ? View.VISIBLE : View.INVISIBLE);
        }
        if (state == STATE_SUCCESS) {
            if (successView == null) {
                successView = createSuccessView();
                this.addView(successView, new FrameLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
                successView.setVisibility(View.VISIBLE);
            }
        } else {
            if (successView != null) {
                successView.setVisibility(View.INVISIBLE);
            }
        }
    }

    /**
     * 根据服务器的数据切换状态
     */
    public void show() {
        if (state == STATE_ERROR || state == STATE_EMPTY) {
            state = STATE_LOADING;
        }

        ThreadManager.getInstance().createLongPool().execute(new Runnable() {
            @Override
            public void run() {
                final BaseFragment.LoadResult result = load();
                SystemClock.sleep(1000);
                UiUtils.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        if (result != null) {
                            state = result.getValue();
                            //状态改变 重新判断显示页面
                            showPage();
                        }
                    }
                });
            }
        });
        showPage();
    }

    public abstract View createSuccessView();

    public abstract BaseFragment.LoadResult load();

}

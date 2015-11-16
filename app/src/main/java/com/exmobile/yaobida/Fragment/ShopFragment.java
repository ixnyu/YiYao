package com.exmobile.yaobida.Fragment;

import android.view.View;
import android.widget.TextView;

import com.exmobile.yaobida.Base.BaseFragment;

/**
 * Created by xnyu on 2015-10-15.
 */
public class ShopFragment extends BaseFragment {
//    @Override
//    public View init(LayoutInflater inflater) {
//        return null;
//    }

    @Override
    public LoadResult load() {
        return LoadResult.success;
    }

    @Override
    public View createSuccessView() {
        TextView textView = new TextView(getActivity());
        textView.setText(getClass().getSimpleName());
        textView.setTextSize(30);
        return textView;
    }

}

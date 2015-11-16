package com.exmobile.yaobida.Fragment;

import android.view.View;

import com.exmobile.yaobida.Base.BaseFragment;
import com.exmobile.yaobida.R;

/**
 * Created by xnyu on 2015-10-15.
 */
public class ConsultFragment extends BaseFragment {
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
        View view = View.inflate(getActivity(), R.layout.fragment_consult, null);
        return view;
    }
}

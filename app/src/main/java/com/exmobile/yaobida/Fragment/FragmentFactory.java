package com.exmobile.yaobida.Fragment;

import com.exmobile.yaobida.Activity.HomeActivity;
import com.exmobile.yaobida.Base.BaseFragment;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by xnyu on 2015-10-16.
 */
public class FragmentFactory {

    /**
     * 缓存Fragment
     */
    public static Map<Integer, BaseFragment> mFragment = new HashMap<>();

    /**
     * 创建Fragment
     */
    public static BaseFragment createrFragment(int position) {
        BaseFragment fragments;
        fragments = mFragment.get(position);
        if (fragments == null) {
            if (position == HomeActivity.HOME_FRAGMENT) {
                fragments = new HomeFragment();
            } else if (position == HomeActivity.CONSULT_FRAGMENT) {
                fragments = new ConsultFragment();
            } else if (position == HomeActivity.SHOP_FRAGMENT) {
                fragments = new ShopFragment();
            } else if (position == HomeActivity.MY_FRAGMENT) {
                fragments = new MyFragment();
            }
            if (fragments != null) {
                mFragment.put(position, fragments);
            }
        }
        return fragments;

    }
}

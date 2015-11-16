package com.exmobile.yaobida.Activity;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.RadioButton;

import com.exmobile.yaobida.Base.BaseActivity;
import com.exmobile.yaobida.Fragment.FragmentFactory;
import com.exmobile.yaobida.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * Created by xnyu on 2015-10-15.
 */
public class HomeActivity extends BaseActivity implements View.OnClickListener {


    public static final int HOME_FRAGMENT = 0;
    public static final int CONSULT_FRAGMENT = 1;
    public static final int SHOP_FRAGMENT = 2;
    public static final int MY_FRAGMENT = 3;


    @Bind(R.id.fl_main)
    FrameLayout mFrameLayout;
    @Bind(R.id.vp_main)
    ViewPager mVpMain;
    @Bind(R.id.rb_home)
    RadioButton mRbHome;
    @Bind(R.id.rb_consult)
    RadioButton mRbConsult;
    @Bind(R.id.rb_shop)
    RadioButton mRbShop;
    @Bind(R.id.rb_my)
    RadioButton mRbMy;

    @Override
    public void initView() {

        mRbHome.setChecked(true);
        mRbHome.setOnClickListener(this);
        mRbConsult.setOnClickListener(this);
        mRbShop.setOnClickListener(this);
        mRbMy.setOnClickListener(this);
        mVpMain.setCurrentItem(HOME_FRAGMENT);
        mVpMain.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public int getCount() {
                //4个导航页
                return 4;
            }

            @Override
            public Fragment getItem(int position) {
                //通过FragmentFactory生产Fragment
                return FragmentFactory.createrFragment(position);
            }
        });
        mVpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                FragmentFactory.createrFragment(position).show();//切换是重新加载
                switch (position) {
                    case HOME_FRAGMENT:
                        mRbHome.setChecked(true);
                        break;
                    case CONSULT_FRAGMENT:
                        mRbConsult.setChecked(true);
                        break;
                    case SHOP_FRAGMENT:
                        mRbShop.setChecked(true);
                        break;
                    case MY_FRAGMENT:
                        mRbMy.setChecked(true);
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    @Override
    public void init() {
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.rb_home:
                mVpMain.setCurrentItem(HOME_FRAGMENT);
                break;
            case R.id.rb_consult:
                mVpMain.setCurrentItem(CONSULT_FRAGMENT);
                break;
            case R.id.rb_shop:
                mVpMain.setCurrentItem(SHOP_FRAGMENT);
                break;
            case R.id.rb_my:
                mVpMain.setCurrentItem(MY_FRAGMENT);
                break;
        }
    }
}

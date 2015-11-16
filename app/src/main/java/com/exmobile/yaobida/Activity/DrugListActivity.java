package com.exmobile.yaobida.Activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.exmobile.yaobida.Base.BaseActivity;
import com.exmobile.yaobida.R;
import com.exmobile.yaobida.Utils.ScreenUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by xnyu on 2015-10-20.
 */
public class DrugListActivity extends BaseActivity {

    private List<String> mParentList = new ArrayList<>();
    private List<String> mChildList = new ArrayList<>();
    private List<String> mDrugList = new ArrayList<>();
    private String[] mDrugPrice = {"¥ 15.00","¥ 4.00"};

    @Override
    public void initView() {

    }

    @Override
    public void init() {
        mParentList.add("感冒发烧");
        mParentList.add("五官口腔");
        mParentList.add("五官口腔");
        mParentList.add("五官口腔");
        mParentList.add("五官口腔");
        mChildList.add("推荐排序");
        mChildList.add("进口药至国产药");
        mChildList.add("国产药至进口药");
        mChildList.add("价格低到高");
        mChildList.add("价格高到低");
        mChildList.add("热销排序");
        mDrugList.add("999感冒灵颗粒");
        mDrugList.add("999感冒灵颗粒10");
        setContentView(R.layout.fragment_druglist);
        //        spinner.setAdapter(new MySpinnerAdapter(getApplicationContext()));
        RelativeLayout parentLayout = (RelativeLayout) findViewById(R.id.fragment_druglist_parent);
        RelativeLayout childLayout = (RelativeLayout) findViewById(R.id.fragment_druglist_child);
        LinearLayout topLinearLayout = (LinearLayout) findViewById(R.id.fragment_druglist_top_linear);
        ImageView searchIv = (ImageView) findViewById(R.id.fragment_druglist_search);
        ListView drugList = (ListView) findViewById(R.id.fragment_druglist_lv);
        drugList.setAdapter(new MyDrugList(this));
        searchIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(DrugListActivity.this,SearchActivity.class));
            }
        });
//        LinearLayout sortLinearLayout = (LinearLayout) findViewById(R.id.fragment_druglist_sort_linear);

        parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showParentPopWindow(v);
            }
        });
        childLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showChildPopWindow(v);
            }
        });
    }

    private void showChildPopWindow(View view) {
        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(DrugListActivity.this).inflate(
                R.layout.popupwindow_parent, null);
        // 设置按钮的点击事件
        PopupWindow popupWindow = new PopupWindow(contentView,
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setWidth(ScreenUtils.getScreenWidth(DrugListActivity.this) / 2);
        popupWindow.setHeight(ScreenUtils.getScreenHeight(DrugListActivity.this) / 2);
        ListView listView = (ListView)contentView.findViewById(R.id.popupwindow_parent_lv);
        listView.setAdapter(new ArrayAdapter<String>(this,R.layout.fragment_druglist_child_item,mChildList));
        listView.setDividerHeight(0);
        popupWindow.setTouchable(true);
        //            DrugListActivity.this.getWindow().getAttributes().alpha = 0.7f;
        //                DrugListActivity.this.getWindow().setAttributes(params);
        backgroundAlpha(0.7f);
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);


    }

    private void showParentPopWindow(View view) {

        // 一个自定义的布局，作为显示的内容
        View contentView = LayoutInflater.from(DrugListActivity.this).inflate(
                R.layout.popupwindow_parent, null);
        // 设置按钮的点击事件
        PopupWindow popupWindow = new PopupWindow(contentView,
                WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, true);
        popupWindow.setWidth(ScreenUtils.getScreenWidth(DrugListActivity.this) / 2);
        popupWindow.setHeight(ScreenUtils.getScreenHeight(DrugListActivity.this) / 2);
        ListView listView = (ListView)contentView.findViewById(R.id.popupwindow_parent_lv);
        listView.setAdapter(new MyAdapter(this));
        listView.setDividerHeight(0);
        popupWindow.setTouchable(true);
//            DrugListActivity.this.getWindow().getAttributes().alpha = 0.7f;
//                DrugListActivity.this.getWindow().setAttributes(params);
        backgroundAlpha(0.7f);
        // 如果不设置PopupWindow的背景，无论是点击外部区域还是Back键都无法dismiss弹框
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                backgroundAlpha(1f);
            }
        });


        // 设置好参数之后再show
        popupWindow.showAsDropDown(view);


    }

    public void backgroundAlpha(float bgAlpha) {
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = bgAlpha; //0.0-1.0
        getWindow().setAttributes(lp);
    }

    class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局

        /*构造函数*/
        public MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mParentList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fragment_druglist_parent_item_lv,null);
                holder = new ViewHolder();
                    /*得到各个控件的对象*/
                holder.text = (TextView) convertView.findViewById(R.id.fragment_druglist_parent_item_tv);
                holder.iv = (ImageView) convertView.findViewById(R.id.fragment_druglist_parent_item_iv);
                convertView.setTag(holder);//绑定ViewHolder对象
            } else {
                holder = (ViewHolder) convertView.getTag();//取出ViewHolder对象
            }
            /*设置TextView显示的内容，即我们存放在动态数组中的数据*/
            holder.iv.setImageResource(R.mipmap.fragment_druglist_cold);
            holder.text.setText(mParentList.get(position));
            return convertView;
        }

    }


    /*存放控件*/
    public final class ViewHolder {
        public ImageView iv;
        public TextView text;
    }

    private class MyDrugList extends BaseAdapter {
        private LayoutInflater mInflater;
        public MyDrugList(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mDrugList.size();
        }

        @Override
        public Object getItem(int position) {
            return null;
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            convertView = mInflater.inflate(R.layout.fragment_druglist_item,null);
            TextView textView1 = (TextView) convertView.findViewById(R.id.fragment_druglist_item_drugname);
            TextView textView2 = (TextView) convertView.findViewById(R.id.fragment_druglist_item_drugprice);
            textView1.setText(mDrugList.get(position));
            textView2.setText(mDrugPrice[position]);
            return convertView;
        }
    }
}

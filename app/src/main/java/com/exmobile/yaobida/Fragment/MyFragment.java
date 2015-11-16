package com.exmobile.yaobida.Fragment;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.exmobile.yaobida.Base.BaseFragment;
import com.exmobile.yaobida.R;

/**
 * Created by xnyu on 2015-10-15.
 */
public class MyFragment extends BaseFragment {
    public static final int TYPE1 = 0;
    public static final int TYPE2 = 1;
    public static final int TYPE3 = 2;
    public static final int TYPE4 = 3;
    //    @Override
    //    public View init(LayoutInflater inflater) {
    //        return null;
    //    }
//    private String[] data = {"当前订单", "已完成订单", "我的收藏", "地址管理", "药师咨询", "查看城市开通范围", "推荐APP", "查看所有评价"};
//    private String[] typeStr = {"当前订单", "已完成订单"};
//    private int[] image = {R.mipmap.my_1, R.mipmap.my_2, R.mipmap.my_3, R.mipmap.my_4, R.mipmap.my_5, R.mipmap.my_6, R.mipmap.my_7, R.mipmap.my_8};

    @Override
    public LoadResult load() {
        return LoadResult.success;
    }

    @Override
    public View createSuccessView() {
        View view = View.inflate(getActivity(), R.layout.fragment_my, null);
        ListView listView = (ListView) view.findViewById(R.id.fragment_my_lv);
        Button button = (Button) view.findViewById(R.id.fragment_my_btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(),LoginActivity.class));
            }
        });
        listView.setAdapter(new MyAdapter(getActivity()));

        return view;
    }

    class MyAdapter extends BaseAdapter {
        private LayoutInflater mInflater;

        public MyAdapter(Context context) {
            mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return 10;
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
        public int getViewTypeCount() {
            return 4;
        }

        @Override
        public int getItemViewType(int position) {
            if (position == 0||position==1) {
                return TYPE1;
            } else if (position == 2 || position == 4) {
                return TYPE2;
            } else if (position == 6) {
                return TYPE3;
            } else {
                return TYPE4;
            }
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            switch (getItemViewType(position)) {
                case TYPE1:
                    convertView = mInflater.inflate(R.layout.fragment_my_itme1, null);
                    ImageView imageView = (ImageView) convertView.findViewById(R.id.fragment_my_item1_iv);
                    TextView textView = (TextView) convertView.findViewById(R.id.fragment_my_item1_tv);
                    TextView textView4 = (TextView) convertView.findViewById(R.id.fragment_my_item1_tv2);
                    if (position == 0){
                        imageView.setImageResource(R.mipmap.my_1);
                        textView.setText("当前订单");
                        textView4.setText("1");
                        textView4.setTextColor(Color.RED);
                    } else if (position ==1){
                        imageView.setImageResource(R.mipmap.my_2);
                        textView.setText("已完成订单");
                        textView4.setText("12");
                        textView4.setTextColor(Color.BLACK);
                    }
                    break;
                case TYPE2:
                    convertView = mInflater.inflate(R.layout.fragment_my_item2, null);
                    break;
                case TYPE4:
                    convertView = mInflater.inflate(R.layout.fragment_my_item3, null);
                    ImageView imageView1 = (ImageView) convertView.findViewById(R.id.fragment_my_item3_iv);
                    TextView textView1 = (TextView) convertView.findViewById(R.id.fragment_my_item3_tv);
                    if (position == 3) {
                        imageView1.setImageResource(R.mipmap.my_3);
                        textView1.setText("我的收藏");
                    } else if (position == 5){
                        imageView1.setImageResource(R.mipmap.my_4);
                        textView1.setText("地址管理");
                    } else if (position == 7){
                        imageView1.setImageResource(R.mipmap.my_6);
                        textView1.setText("查看城市开通范围");
                    } else if (position==8){
                        imageView1.setImageResource(R.mipmap.my_7);
                        textView1.setText("推荐APP");
                    } else if (position==9){
                        imageView1.setImageResource(R.mipmap.my_8);
                        textView1.setText("查看所有评价");
                    }
                    break;
                case TYPE3:
                    convertView = mInflater.inflate(R.layout.fragment_my_item4,null);
                    ImageView imageView2 = (ImageView) convertView.findViewById(R.id.fragment_my_item4_iv);
                    TextView textView2 = (TextView) convertView.findViewById(R.id.fragment_my_item4_tv);
                    imageView2.setImageResource(R.mipmap.my_5);
                    textView2.setText("药师咨询");
                    break;
            }
            return convertView;
        }
    }
}

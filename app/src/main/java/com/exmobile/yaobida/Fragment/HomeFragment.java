package com.exmobile.yaobida.Fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.exmobile.yaobida.Activity.DrugListActivity;
import com.exmobile.yaobida.Activity.SearchActivity;
import com.exmobile.yaobida.Base.BaseFragment;
import com.exmobile.yaobida.Bean.CategoriesBean;
import com.exmobile.yaobida.R;
import com.exmobile.yaobida.Utils.BitMapHelper;
import com.exmobile.yaobida.Utils.L;
import com.exmobile.yaobida.Utils.NetUtils;
import com.exmobile.yaobida.Utils.UiUtils;
import com.exmobile.yaobida.http.HttpRequest;
import com.exmobile.yaobida.http.HttpUtils;
import com.google.gson.Gson;
import com.lidroid.xutils.BitmapUtils;
import com.lidroid.xutils.bitmap.PauseOnScrollListener;

import java.util.List;

/**
 * Created by xnyu on 2015-10-15.
 */
public class HomeFragment extends BaseFragment {
    private ListView mListView;
    private List<CategoriesBean.ResultEntity> mCategories;
    //bitmap加载网络图片
    private BitmapUtils mBitmapUtils;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
                show();
    }

    @Override
    public LoadResult load() {
        L.i("网络是否连接", String.valueOf(NetUtils.isConnected(UiUtils.getContext())));
       if (NetUtils.isConnected(UiUtils.getContext())){
           String resultStr = HttpUtils.doPost( HttpRequest.APIURL + HttpRequest.DRUGCATEORIES, "");
           Gson gson = new Gson();
           CategoriesBean categoriesBean = gson.fromJson(resultStr, CategoriesBean.class);
           mCategories = categoriesBean.getResult();
           return LoadResult.success;
       } else {
           return LoadResult.error;
       }
    }



    @Override
    public View createSuccessView() {
        View view = View.inflate(getActivity(), R.layout.fragment_home, null);
        Button searchBtn = (Button) view.findViewById(R.id.fragment_home_search);
        searchBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), SearchActivity.class));
            }
        });
        mListView = (ListView) view.findViewById(R.id.fragment_home_details_lv);
        mListView.addHeaderView(View.inflate(getActivity(), R.layout.fragment_home_headerview, null), null, true);
        mListView.setAdapter(new MyAdapter(getActivity()));
        mBitmapUtils = BitMapHelper.getBitMapUtils();
        //第二参数 慢速滑动false加载图片 第三个参数快速滑动true不加载图片
        mListView.setOnScrollListener(new PauseOnScrollListener(mBitmapUtils,false,true));
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                startActivity(new Intent(getActivity(), DrugListActivity.class));
            }
        });
        return view;
    }


    class MyAdapter extends BaseAdapter {

        private LayoutInflater mInflater;//得到一个LayoutInfalter对象用来导入布局

        /*构造函数*/
        public MyAdapter(Context context) {
            this.mInflater = LayoutInflater.from(context);
        }

        @Override
        public int getCount() {
            return mCategories.size();
        }

        @Override
        public Object getItem(int position) {
            return position;
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(final int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                convertView = mInflater.inflate(R.layout.fragment_home_details_item, null);
                holder = new ViewHolder();
                    /*得到各个控件的对象*/
                holder.title = (TextView) convertView.findViewById(R.id.fragment_home_titletv_lv_item);
                holder.text = (TextView) convertView.findViewById(R.id.fragment_home_contenttv_lv_item);
                holder.iv = (ImageView) convertView.findViewById(R.id.fragment_home_iv_lv_item);
                convertView.setTag(holder);//绑定ViewHolder对象
            } else {
                holder = (ViewHolder) convertView.getTag();//取出ViewHolder对象
            }
            //            holder.iv.setImageResource(mCategories.get(position).getImageView());
            mBitmapUtils.display(holder.iv, HttpRequest.IMAGEURL + "Category/" + mCategories.get(position).getCategoryPic());
            /*设置TextView显示的内容，即我们存放在动态数组中的数据*/
            holder.title.setText(mCategories.get(position).getCategoryName());
            holder.text.setText(mCategories.get(position).getCategoryWords());
            return convertView;
        }

    }


    /*存放控件*/
    public class ViewHolder {
        public ImageView iv;
        public TextView title;
        public TextView text;
    }

}


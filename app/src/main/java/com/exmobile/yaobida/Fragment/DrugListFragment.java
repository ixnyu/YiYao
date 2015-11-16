//package com.exmobile.yaobida.Fragment;
//
//import android.os.Bundle;
//import android.view.LayoutInflater;
//import android.view.View;
//import android.view.ViewGroup;
//import android.widget.BaseAdapter;
//
//import com.exmobile.yaobida.Base.BaseFragment;
//import com.exmobile.yaobida.R;
//
///**
// * Created by xnyu on 2015-10-19.
// */
//public class DrugListFragment extends BaseFragment {
//
//    private String[] mDrugs = {"感冒发烧","口腔咽喉","清热解毒","皮肤用药"};
//
//    @Override
//    public View init(LayoutInflater inflater) {
//        View view = inflater.inflate(R.layout.fragment_druglist, null);
////        Spinner spinner = (Spinner) view.findViewById(R.id.fragment_druglist_spinner);
////        spinner.setAdapter(new MySpinnerAdapter(inflater));
//        return view;
//    }
//
//    @Override
//    public void initView(Bundle savedInstanceState) {
//
//    }
//
//    @Override
//    public LoadResult load() {
//        return null;
//    }
//
//    @Override
//    public View createSuccessView() {
//        return null;
//    }
//
//    class MySpinnerAdapter extends BaseAdapter {
//        private LayoutInflater mInflater;
//
//        public MySpinnerAdapter(LayoutInflater inflater) {
//            mInflater = inflater;
//        }
//
//        @Override
//        public int getCount() {
//            return 4;
//        }
//
//        @Override
//        public Object getItem(int position) {
//            return position;
//        }
//
//        @Override
//        public long getItemId(int position) {
//            return position;
//        }
//
//        @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//            View view = mInflater.inflate(R.layout.fragment_druglist_spinner_item, null);
////            TextView textView = (TextView) view.findViewById(R.id.fragment_drug_sort_iv);
////            textView.setText(mDrugs[position]);
//            return view;
//        }
//    }
//}

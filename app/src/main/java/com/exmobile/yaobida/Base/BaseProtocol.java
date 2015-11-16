//package com.exmobile.yaobida.Base;
//
//import com.exmobile.yaobida.http.HttpUtils;
//
///**
// * Created by Administrator on 2015/10/30 0030.
// */
//public class BaseProtocol {
//    public static final String SERVER_NAME = "http://139.196.17.222:8012/API/";
//    public static final String GETCATEGORIES = "GetCategories.ashx";
//
//    private static String loadServer(){
//        try {
//            HttpUtils.doPostAsyn(SERVER_NAME + GETCATEGORIES, "", new HttpUtils.CallBack() {
//                @Override
//                public void onRequestComplete(String result) {
//
//                }
//            });
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }
//
//
//}

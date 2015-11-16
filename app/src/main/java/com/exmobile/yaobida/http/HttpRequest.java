package com.exmobile.yaobida.http;

import com.exmobile.yaobida.Base.BaseFragment;
import com.exmobile.yaobida.Bean.CategoriesBean;

import java.util.List;

/**
 * Created by Administrator on 2015/10/30 0030.
 */
public class HttpRequest {
    public static final String APIURL = "http://139.196.17.222:8012/API/";
    public static final String IMAGEURL = "http://139.196.17.222:8012/images/";
    public static final String SERVER_URL = "http://139.196.17.222:8012/API/";
    public static final String DRUGCATEORIES = "GetCategories.ashx";


    /**
     * 检查服务器返回的数据
     *
     * @param categories
     * @return 返回数据状态
     */
    private BaseFragment.LoadResult checkData(List<CategoriesBean.ResultEntity> categories) {
        if (categories.size() == 0) {
            return BaseFragment.LoadResult.error;
        } else {
            return BaseFragment.LoadResult.success;
        }
    }

}

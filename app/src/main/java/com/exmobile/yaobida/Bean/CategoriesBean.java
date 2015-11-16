package com.exmobile.yaobida.Bean;

import java.util.List;

/**
 * Created by Administrator on 2015/10/30 0030.
 */
public class CategoriesBean {


    /**
     * CategoryID : 1
     * CategoryNo : C01
     * CategoryName : 感冒发烧1
     * CategoryWords : 感康  快克  泰诺  白加黑  感冒灵  板蓝根
     * CategoryPic : c1.png
     * CategorySmallPic : c1_s.png
     */

    private List<ResultEntity> Result;

    public void setResult(List<ResultEntity> Result) {
        this.Result = Result;
    }

    public List<ResultEntity> getResult() {
        return Result;
    }

    public static class ResultEntity {
        private String CategoryID;
        private String CategoryNo;
        private String CategoryName;
        private String CategoryWords;
        private String CategoryPic;
        private String CategorySmallPic;

        public void setCategoryID(String CategoryID) {
            this.CategoryID = CategoryID;
        }

        public void setCategoryNo(String CategoryNo) {
            this.CategoryNo = CategoryNo;
        }

        public void setCategoryName(String CategoryName) {
            this.CategoryName = CategoryName;
        }

        public void setCategoryWords(String CategoryWords) {
            this.CategoryWords = CategoryWords;
        }

        public void setCategoryPic(String CategoryPic) {
            this.CategoryPic = CategoryPic;
        }

        public void setCategorySmallPic(String CategorySmallPic) {
            this.CategorySmallPic = CategorySmallPic;
        }

        public String getCategoryID() {
            return CategoryID;
        }

        public String getCategoryNo() {
            return CategoryNo;
        }

        public String getCategoryName() {
            return CategoryName;
        }

        public String getCategoryWords() {
            return CategoryWords;
        }

        public String getCategoryPic() {
            return CategoryPic;
        }

        public String getCategorySmallPic() {
            return CategorySmallPic;
        }
    }
}

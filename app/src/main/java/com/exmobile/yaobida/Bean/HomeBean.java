package com.exmobile.yaobida.Bean;

import java.util.List;

/**
 * Created by Administrator on 2015/10/30 0030.
 */
public class HomeBean {

    /**
     * Code : 1
     * Message : 获取分类成功
     * Result : [{"CategoryID":"1","CategoryNo":"C01","CategoryName":"感冒发烧1","CategoryWords":"感康  快克  泰诺  白加黑  感冒灵  板蓝根","CategoryPic":"c1.png","CategorySmallPic":"c1_s.png"},{"CategoryID":"2","CategoryNo":"C02","CategoryName":"感冒发烧2","CategoryWords":"感康  快克  泰诺  白加黑  感冒灵  板蓝根","CategoryPic":"c2.png","CategorySmallPic":"c1_s.png"},{"CategoryID":"3","CategoryNo":"C03","CategoryName":"感冒发烧3","CategoryWords":"感康  快克  泰诺  白加黑  感冒灵  板蓝根","CategoryPic":"c3.png","CategorySmallPic":"c1_s.png"},{"CategoryID":"4","CategoryNo":"C04","CategoryName":"感冒发烧4","CategoryWords":"感康  快克  泰诺  白加黑  感冒灵  板蓝根","CategoryPic":"c4.png","CategorySmallPic":"c1_s.png"}]
     */

    private String Code;
    private String Message;
    /**
     * CategoryID : 1
     * CategoryNo : C01
     * CategoryName : 感冒发烧1
     * CategoryWords : 感康  快克  泰诺  白加黑  感冒灵  板蓝根
     * CategoryPic : c1.png
     * CategorySmallPic : c1_s.png
     */

    private List<ResultEntity> Result;

    public void setCode(String Code) {
        this.Code = Code;
    }

    public void setMessage(String Message) {
        this.Message = Message;
    }

    public void setResult(List<ResultEntity> Result) {
        this.Result = Result;
    }

    public String getCode() {
        return Code;
    }

    public String getMessage() {
        return Message;
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

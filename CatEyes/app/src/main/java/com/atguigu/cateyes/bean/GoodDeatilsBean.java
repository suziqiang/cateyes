package com.atguigu.cateyes.bean;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * Created by Administrator on 2016/7/4 0004.
 */
public class GoodDeatilsBean implements Serializable {


    /**
     * buyPic : http://p0.meituan.net/180.180/movie/fa9c6639db2761ea8f2eeeaece3cf2f9284099.jpg
     * curNumber : 596
     * dealid : 29251108
     * endTime : 1483199999
     * notes : 签收商品前请检查商品数量，如有损坏及少件情况请拒收商品。
     * price : 379
     * servicePromise : ["正版授权","假一赔十","真实评价"]
     * term : [{"desc":["（周末、法定节假日通用）"],"title":"有效期"},{"desc":["3181393422"],"title":"商家QQ"},{"desc":["商家电话：10105335；联系时间：周一至周五09:00-18:00"],"title":"产品咨询"},{"desc":["每个用户最多可购买10件"],"title":"购买说明"},{"desc":["全国（除港澳台外）均可配送"],"title":"配送范围"},{"desc":["本单使用汇通快运（400-956-5656）"],"title":"快递公司"},{"desc":["本单包邮，配送范围内无需再额外支付邮费"],"title":"配送费用"},{"desc":["下单后48小时内发货。不能发顺丰，留言发顺丰的订单默认发包邮快递。"],"title":"配送时间"},{"desc":["如需退换货，请进入我的订单"],"title":"售后保障"}]
     * title : 美国队长盾牌移动电源
     * topPics : ["http://p0.meituan.net/movie/fa9c6639db2761ea8f2eeeaece3cf2f9284099.jpg","http://p1.meituan.net/movie/5b125ebb3e7fb7d4a2363aa6f68a58c7145432.jpg","http://p0.meituan.net/movie/9a4b7307b345b0ceec14bf478d085e1148590.jpg"]
     * value : 399
     */

    private DataBean data;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean implements Serializable {
        private String buyPic;
        private int curNumber;
        private int dealid;
        private int endTime;
        private String notes;
        private float price;
        private String title;
        private float value;
        private ArrayList<String> servicePromise;
        /**
         * desc : ["（周末、法定节假日通用）"]
         * title : 有效期
         */

        private ArrayList<TermBean> term;
        private ArrayList<String> topPics;

        public String getBuyPic() {
            return buyPic;
        }

        public void setBuyPic(String buyPic) {
            this.buyPic = buyPic;
        }

        public int getCurNumber() {
            return curNumber;
        }

        public void setCurNumber(int curNumber) {
            this.curNumber = curNumber;
        }

        public int getDealid() {
            return dealid;
        }

        public void setDealid(int dealid) {
            this.dealid = dealid;
        }

        public int getEndTime() {
            return endTime;
        }

        public void setEndTime(int endTime) {
            this.endTime = endTime;
        }

        public String getNotes() {
            return notes;
        }

        public void setNotes(String notes) {
            this.notes = notes;
        }

        public float getPrice() {
            return price;
        }

        public void setPrice(float price) {
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public float getValue() {
            return value;
        }

        public void setValue(float value) {
            this.value = value;
        }

        public ArrayList<String> getServicePromise() {
            return servicePromise;
        }

        public void setServicePromise(ArrayList<String> servicePromise) {
            this.servicePromise = servicePromise;
        }

        public ArrayList<TermBean> getTerm() {
            return term;
        }

        public void setTerm(ArrayList<TermBean> term) {
            this.term = term;
        }

        public ArrayList<String> getTopPics() {
            return topPics;
        }

        public void setTopPics(ArrayList<String> topPics) {
            this.topPics = topPics;
        }

        public static class TermBean implements Serializable{
            private String title;
            private ArrayList<String> desc;

            public String getTitle() {
                return title;
            }

            public void setTitle(String title) {
                this.title = title;
            }

            public ArrayList<String> getDesc() {
                return desc;
            }

            public void setDesc(ArrayList<String> desc) {
                this.desc = desc;
            }
        }
    }
}

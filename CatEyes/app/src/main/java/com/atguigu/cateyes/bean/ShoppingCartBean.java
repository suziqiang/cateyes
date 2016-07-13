package com.atguigu.cateyes.bean;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class ShoppingCartBean extends GoodDeatilsBean.DataBean {
    private  boolean ischecked=true;
    private int count=1;

    public boolean ischecked() {
        return ischecked;
    }

    public void setIschecked(boolean ischecked) {
        this.ischecked = ischecked;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    @Override
    public String toString() {
        return "ShoppingCartBean{" +
                "ischecked=" + ischecked +
                ", count=" + count +
                '}';
    }
}

package com.atguigu.cateyes.bean;

import com.atguigu.cateyes.Untils.PinYinUtils;

/**
 * Created by Administrator on 2016/6/30 0030.
 */
public class City {
    private String name;
    private String pinYin;
    public City(String name){
        this.name=name;
         pinYin = PinYinUtils.getPinYin(name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinYin() {
        return pinYin;
    }

    public void setPinYin(String pinYin) {
        this.pinYin = pinYin;
    }

    @Override
    public String toString() {
        return "City{" +
                "name='" + name + '\'' +
                ", pinYin='" + pinYin + '\'' +
                '}';
    }
}

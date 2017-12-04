package com.example.myapplication;

import android.graphics.drawable.Drawable;

/**
 * Created by 강미 on 2017-11-28.
 */

//(Brand) custom list에 들어가는 데이터 셋팅

public class DataItem {
 /*  int resIdThumbnail;
    String brandName;

    public DataItem(int resIdThumbnail, String brandName) {
        this.resIdThumbnail = resIdThumbnail;
        this.brandName = brandName;
    }
    */
    private Drawable iconDrawable;
    private  String titleStr;
    private  String descStr;

    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }

    public Drawable getIcon() {
        return this.iconDrawable ;
    }
    public String getTitle() {
        return this.titleStr ;
    }
    public String getDesc() {
        return this.descStr ;
    }
}

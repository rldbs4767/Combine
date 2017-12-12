package com.example.myapplication;

import android.graphics.drawable.Drawable;


//(Brand) custom list에 들어가는 데이터 셋팅

public class DataItem {

    //list에 들어갈 그림,타이틀,상세텍스트 선언
    private Drawable iconDrawable;
    private  String titleStr;
    private  String descStr;

    //셋팅
    public void setIcon(Drawable icon) {
        iconDrawable = icon ;
    }
    public void setTitle(String title) {
        titleStr = title ;
    }
    public void setDesc(String desc) {
        descStr = desc ;
    }

    //아이콘을 넣음
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

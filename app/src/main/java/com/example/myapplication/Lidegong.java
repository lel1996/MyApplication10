package com.example.myapplication;

import cn.bmob.v3.BmobObject;

/**
 * Created by 李二林 on 2018/1/13.
 */

public class Lidegong extends BmobObject {
    private String name;
    private String content;
    public String getName(){return name;}
    public void setName(String name){this.name=name;}
    public  String getContent(){return content;}
    public  void  setContent(String content){this.content=content;}
}

package com.example.myapplication;

import cn.bmob.v3.BmobObject;

/**
 * Created by 李二林 on 2018/1/15.
 */

public class Feedback extends BmobObject {
    private String password;
    private String name;


    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }



    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }


}

package com.example.myapplication;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobUser;

/**
 * Created by 李二林 on 2018/1/12.
 */

public class User extends BmobUser {
    private String name;
    private  String password;
    public String getUsername(){return this.name;}
    public void  setUsername(String name){this.name=name;}
    public  String getPassword(){return this.password;}
    public  void setPassword(String password){this.password=password;}

}

package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
private Button denglu,zhuce;
    private EditText euser,epassword;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bmob.initialize(MainActivity.this,"cd4973fd84d5c9c2b5b9c32ba60b0da3");
        denglu= (Button) findViewById(R.id.denglu);
        zhuce= (Button) findViewById(R.id.zhuce);
        euser= (EditText) findViewById(R.id.edituser);
        epassword= (EditText) findViewById(R.id.editpassword);

        zhuce.setOnClickListener(this);
        denglu.setOnClickListener(this);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.zhuce:
                zhuce();
                break;
            case R.id.denglu:
                denglu();
                break;
        }

    }

    private void denglu() {
        final String usename=euser.getText().toString();
        String usepassword=epassword.getText().toString();
         BmobUser user=new BmobUser();
       user.setUsername(usename);
       user.setPassword(usepassword);
        user.login(new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if(e==null){
                    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_SHORT).show();
                    Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                    intent.putExtra("name0",usename);
                    //传送的是登陆时的名字；
                    startActivity(intent);
                }
                else{  Toast.makeText(MainActivity.this,"登陆失败",Toast.LENGTH_SHORT).show();}
            }
        });
    }

    private void zhuce() {
        BmobUser user=new BmobUser();
        String usename=euser.getText().toString();
        String usepassword=epassword.getText().toString();
        if(usename.isEmpty()||usepassword.isEmpty()){
            Toast.makeText(MainActivity.this,"用户名或密码为空",Toast.LENGTH_SHORT).show();
            return;
        }
        user.setUsername(usename);
        user.setPassword(usepassword);
        user.signUp(new SaveListener<User>() {
            @Override
            public void done(User s, BmobException e) {
                if(s==null){
                    Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
                }
               else{
                    Toast.makeText(MainActivity.this,"该用户已经注册过",Toast.LENGTH_SHORT).show();
                }
            }
        });
//        user.signUp(new SaveListener<User>() {
//            @Override
//            public void done(User s, BmobException e) {
//
//                if(e==null){
//                    Toast.makeText(MainActivity.this,"注册成功",Toast.LENGTH_SHORT).show();
//                }
//                else{
//                    Toast.makeText(MainActivity.this,"注册失败",Toast.LENGTH_SHORT).show();
//                }
//            }
//        });
    }
}

package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class Main4Activity extends AppCompatActivity implements View.OnClickListener {
private ImageView imageView1,imageView2,imageView3,imageView4;
    private Button button1,button2;
    private TextView editText;
    private EditText e;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        imageView1= (ImageView) findViewById(R.id.lidegong);
        imageView2= (ImageView) findViewById(R.id.lichunxia);
        imageView3= (ImageView) findViewById(R.id.lidalin);
        imageView4= (ImageView) findViewById(R.id.lielrin);

        button1= (Button) findViewById(R.id.qunliaofasong);
        button2= (Button) findViewById(R.id.qunliaochakan);

        e= (EditText) findViewById(R.id.qunliaoed);

       editText= (TextView) findViewById(R.id.qunliaochakaned);

        button1.setOnClickListener(this);
        button2.setOnClickListener(this);

        imageView1.setImageResource(R.drawable.b3);
        imageView2.setImageResource(R.drawable.b1);
        imageView3.setImageResource(R.drawable.b2);
        imageView4.setImageResource(R.drawable.b4);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.qunliaofasong:
                qunliaofasong();
                break;
            case R.id.qunliaochakan:
                quliaochakan();
                break;

        }

    }

    private void quliaochakan() {
        Feedback feedback=new Feedback();
        BmobQuery<Feedback> query=new BmobQuery<>();
        query.findObjects(new FindListener<Feedback>() {
            @Override
            public void done(List<Feedback> list, BmobException e) {
                if(e==null){
                    Toast.makeText(Main4Activity.this, "查询成功", Toast.LENGTH_SHORT).show();
                    String str="";
                    for(Feedback feedback:list){
                        str+="发送人："+feedback.getName()+ " " +"发送信息："+feedback.getPassword()+"\n";
                    }
                     editText.setText(str);
                }
                    else Toast.makeText(Main4Activity.this, "查询失败", Toast.LENGTH_SHORT).show();
            }

        });

    }

    private void qunliaofasong() {
        Feedback feedback=new Feedback();
        Intent intent=getIntent();
        String user= intent.getStringExtra("yonghuming");
        feedback.setName(user);
        feedback.setPassword(e.getText().toString());
        feedback.save(new SaveListener<String>() {
            @Override
            public void done(String s, BmobException e) {
                if(e==null){
                    Toast.makeText(Main4Activity.this,"发送成功",Toast.LENGTH_SHORT).show();
                }
                else Toast.makeText(Main4Activity.this, "发送失败", Toast.LENGTH_SHORT).show();
            }
        });
    }
}

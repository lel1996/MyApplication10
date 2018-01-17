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

import cn.bmob.v3.Bmob;
import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.SaveListener;

public class Main3Activity extends AppCompatActivity implements View.OnClickListener {
private TextView textView,text1;
    private EditText editText;
    private ImageView image;
    private Button fasong,chakan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        Bmob.initialize(Main3Activity.this,"cd4973fd84d5c9c2b5b9c32ba60b0da3");
        textView= (TextView) findViewById(R.id.textview);
        editText= (EditText) findViewById(R.id.editext);
        fasong= (Button) findViewById(R.id.fasong);
        chakan= (Button) findViewById(R.id.chakan);
        text1= (TextView) findViewById(R.id.text1);
        image= (ImageView) findViewById(R.id.image1);

        Intent intent=getIntent();
        int image1=intent.getIntExtra("img",0);
        String name=intent.getStringExtra("name");
        String name1=intent.getStringExtra("name1");

        image.setImageResource(image1);
        text1.setText(name);
        fasong.setOnClickListener(this);
        chakan.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.fasong:
                fasong();
                break;
            case R.id.chakan:
                chakan();
                break;
        }
    }

    private void chakan() {
        //用点到的谁的名字所对应的Bmob表；
        Intent intent=getIntent();
        final String name=intent.getStringExtra("name");
        final String namez=intent.getStringExtra("name1");
        if(name.equals("李德功")){
            final Lidegong lidegong=new Lidegong();
            BmobQuery<Lidegong> query=new BmobQuery<>();
            query.findObjects(new FindListener<Lidegong>() {
                @Override
                public void done(List<Lidegong> list, BmobException e) {
                    if(e==null){
                        String str="";


                        for (Lidegong lidegong:list) {
                            str+="发送人"+lidegong.getName()+" " +"消息内容"+lidegong.getContent()+"\n";
                        }

                        textView.setText(str);
                    }
                }
            });
        }
        //李春霞的内容查询
        if(name.equals("李春霞")){
            Intent intent1=getIntent();
            final String name1=intent1.getStringExtra("name");
            final String namex=intent1.getStringExtra("name1");
            final Lichunxia lichuxia=new Lichunxia();
            BmobQuery<Lichunxia> query=new BmobQuery<>();
            query.findObjects(new FindListener<Lichunxia>() {
                @Override
                public void done(List<Lichunxia> list, BmobException e) {
                    if(e==null){
                        String str="";

                        for (Lichunxia lichunxia :list) {
                            str+="发送人"+lichunxia.getName()+" " +"消息内容"+lichunxia.getContent()+"\n";
                        }

                        textView.setText(str);
                    }
                }
            });
        }
        //李大林的查询；
        if(name.equals("李大林")){
            Intent intent2=getIntent();
            final String name2=intent2.getStringExtra("name");
            final String namec=intent2.getStringExtra("name1");
            final Lidalin lidalin=new Lidalin();
            BmobQuery<Lidalin> query=new BmobQuery<>();
            query.findObjects(new FindListener<Lidalin>() {
                @Override
                public void done(List<Lidalin> list, BmobException e) {
                    if(e==null){
                        String str="";

                        for (Lidalin lidalin:list) {
                            str+="发送人"+lidalin.getName()+" " +"消息内容"+lidalin.getContent()+"\n";
                        }

                        textView.setText(str);
                    }
                }
            });
        }
        //李二林的查询；
        if(name.equals("李二林")){
            Intent intent3=getIntent();
            final String name3=intent3.getStringExtra("name");
            final String namev=intent3.getStringExtra("name1");

            final Lierlin lierlin=new Lierlin();
            BmobQuery<Lierlin> query=new BmobQuery<>();
            query.findObjects(new FindListener<Lierlin>() {
                @Override
                public void done(List<Lierlin> list, BmobException e) {
                    if(e==null){
                        String str="";

                        for (Lierlin lierlin:list) {
                            str+="发送人"+lierlin.getName()+" " +"消息内容"+lierlin.getContent()+"\n";
                        }

                        textView.setText(str);
                    }
                }
            });
        }
    }

    private void fasong() {
        Intent intent=getIntent();
        String name=intent.getStringExtra("name");
        String name1=intent.getStringExtra("name1");
        if(name.equals("李德功")){
            //向李德功表中插入数据；
            String c=editText.getText().toString();
            Lidegong lidegong=new Lidegong();
            lidegong.setName(name1);
            lidegong.setContent(c);
            lidegong.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if(e==null){
                        Toast.makeText(Main3Activity.this,"消息发送成功",Toast.LENGTH_SHORT).show();
                    }
                    else {Toast.makeText(Main3Activity.this,"消息发送失败",Toast.LENGTH_SHORT).show();}
                }
            });

        }
        //李春霞的插入数据
        if(name.equals("李春霞")){
            //向李德功表中插入数据；
            String c=editText.getText().toString();
            Lichunxia lichuxia=new Lichunxia();
            lichuxia.setName(name1);
            lichuxia.setContent(c);
            lichuxia.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if(e==null){
                        Toast.makeText(Main3Activity.this,"消息发送成功",Toast.LENGTH_SHORT).show();
                    }
                    else {Toast.makeText(Main3Activity.this,"消息发送失败",Toast.LENGTH_SHORT).show();}
                }
            });

        }


        if(name.equals("李大林")){
            //向李大林表中插入数据；
                String c=editText.getText().toString();
                Lidalin lidalin=new Lidalin();
                lidalin.setName(name1);
                lidalin.setContent(c);
                lidalin.save(new SaveListener<String>() {
                    @Override
                    public void done(String s, BmobException e) {
                        if(e==null){
                            Toast.makeText(Main3Activity.this,"消息发送成功",Toast.LENGTH_SHORT).show();
                        }
                        else {Toast.makeText(Main3Activity.this,"消息发送失败",Toast.LENGTH_SHORT).show();}
                    }
                });

            }

        if(name.equals("李二林")){
            //向李二林表中插入数据；
            String c=editText.getText().toString();
            Lierlin lierlin=new Lierlin();
            lierlin.setName(name1);
            lierlin.setContent(c);
            lierlin.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if(e==null){
                        Toast.makeText(Main3Activity.this,"消息发送成功",Toast.LENGTH_SHORT).show();
                    }
                    else {Toast.makeText(Main3Activity.this,"消息发送失败",Toast.LENGTH_SHORT).show();}
                }
            });


        }
    }
}

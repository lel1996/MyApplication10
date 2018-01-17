package com.example.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import cn.bmob.v3.Bmob;

import static android.R.attr.name;

public class Main2Activity extends AppCompatActivity implements AdapterView.OnItemClickListener {
private TextView textView;
    private ImageView imageView;
    private ListView listview;
    private List<Map<String,Object>> list;
    private Button qunliao;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Bmob.initialize(Main2Activity.this,"cd4973fd84d5c9c2b5b9c32ba60b0da3");
        imageView= (ImageView) findViewById(R.id.image);
        textView= (TextView) findViewById(R.id.textview);
        listview= (ListView) findViewById(R.id.listview);
        qunliao= (Button) findViewById(R.id.qunliao);
        Intent in=getIntent();
        final String name=in.getStringExtra("name");
        iii();
        SimpleAdapter a=new SimpleAdapter(this,list,R.layout.list_item,
                new String[]{"img","name"},new int[]{R.id.image,R.id.textview});
        listview.setAdapter(a);


        listview.setOnItemClickListener(this);

        qunliao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent2=new Intent();
                intent2.setClass(Main2Activity.this,Main4Activity.class);
                intent2.putExtra("yonghuming",name);
                startActivity(intent2);
            }
        });

    }

    private void iii() {
        String []name={"李德功","李春霞","李大林","李二林"};
        int []img={R.drawable.b3,R.drawable.b1,R.drawable.b2,R.drawable.b4};
        list=new ArrayList<>();
        for(int i=0;i<4;i++){
            Map map=new HashMap();
            map.put("name",name[i]);
            map.put("img",img[i]);
            list.add(map);
        }
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
Intent intent1=getIntent();
      String str=intent1.getStringExtra("name0");
       Intent intent=new Intent(Main2Activity.this,Main3Activity.class);
        intent.putExtra("name1",str);
        intent.putExtra("img",(int) list.get(position).get("img"));
        intent.putExtra("name", (String) list.get(position).get("name"));
        startActivity(intent);
    }
}

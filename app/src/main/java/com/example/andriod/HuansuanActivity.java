package com.example.andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HuansuanActivity extends AppCompatActivity {
Button cd,tj1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huansuan);
        cd=(Button)findViewById(R.id.cd);
        tj1=(Button)findViewById(R.id.tj1);
        cd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4=new Intent(HuansuanActivity.this,DanweiActivity.class);
                startActivity(intent4);
            }
        });
        tj1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent5=new Intent(HuansuanActivity.this,TijiActivity.class);
                startActivity(intent5);
            }
        });
    }
    }


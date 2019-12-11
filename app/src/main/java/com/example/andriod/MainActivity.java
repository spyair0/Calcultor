package com.example.andriod;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;

import static com.example.andriod.Expression.toPostfix;
import static com.example.andriod.Expression.toValue;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button shu1, shu2, shu3, shu4, shu5, shu6, shu7, shu8, shu9, shu0;
    Button jia, jian, cheng, chu,jie,san;
    Button m1, m2, m3, m4,m5,m6;
    Button sin, cos, tan, fang, percent, dian, c, back, dengyu;
    Button jinzhi,danwei,huilv;
    TextView et,c1;
    EditText t1,t2,t3,t4,e1,e2,e3;
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.add_item:
                Toast.makeText(this, "这是帮助！", Toast.LENGTH_SHORT).show();
                break;
                default:

        }
        return true;
    }
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shu1 = (Button) findViewById(R.id.shu1);
        shu2 = (Button) findViewById(R.id.shu2);
        shu3 = (Button) findViewById(R.id.shu3);
        shu4 = (Button) findViewById(R.id.shu4);
        shu5 = (Button) findViewById(R.id.shu5);
        shu6 = (Button) findViewById(R.id.shu6);
        shu7 = (Button) findViewById(R.id.shu7);
        shu8 = (Button) findViewById(R.id.shu8);
        shu9 = (Button) findViewById(R.id.shu9);
        shu0 = (Button) findViewById(R.id.shu0);
        jia = (Button) findViewById(R.id.jia);
        jian = (Button) findViewById(R.id.jian);
        cheng = (Button) findViewById(R.id.cheng);
        chu = (Button) findViewById(R.id.chu);
        m1 = (Button) findViewById(R.id.m1);
        m2 = (Button) findViewById(R.id.m2);
        m3 = (Button) findViewById(R.id.m3);
        m4 = (Button) findViewById(R.id.m4);
        m5 = (Button) findViewById(R.id.m5);
        m6 = (Button) findViewById(R.id.m6);
        sin = (Button) findViewById(R.id.sin);
        cos = (Button) findViewById(R.id.cos);
        tan = (Button) findViewById(R.id.tan);
        fang = (Button) findViewById(R.id.fang);
        percent = (Button) findViewById(R.id.percent);
        dian = (Button) findViewById(R.id.dian);
        c = (Button) findViewById(R.id.c);
        back = (Button) findViewById(R.id.back);
        dengyu = (Button) findViewById(R.id.dengyu);
        jie = (Button) findViewById(R.id.jie);
        san = (Button) findViewById(R.id.san);
        jinzhi=(Button)findViewById(R.id.jinzhi) ;
        danwei = (Button) findViewById(R.id.danwei);
        huilv=(Button)findViewById(R.id.huilv);
        et = (TextView) findViewById(R.id.et);
        shu1.setOnClickListener(this);
        shu2.setOnClickListener(this);
        shu3.setOnClickListener(this);
        shu4.setOnClickListener(this);
        shu5.setOnClickListener(this);
        shu6.setOnClickListener(this);
        shu7.setOnClickListener(this);
        shu8.setOnClickListener(this);
        shu9.setOnClickListener(this);
        shu0.setOnClickListener(this);
        jia.setOnClickListener(this);
        jian.setOnClickListener(this);
        cheng.setOnClickListener(this);
        chu.setOnClickListener(this);
        sin.setOnClickListener(this);
        cos.setOnClickListener(this);
        tan.setOnClickListener(this);
        fang.setOnClickListener(this);
        percent.setOnClickListener(this);
        c.setOnClickListener(this);
        dian.setOnClickListener(this);
        back.setOnClickListener(this);
        m1.setOnClickListener(this);
        m2.setOnClickListener(this);
        m3.setOnClickListener(this);
        m4.setOnClickListener(this);
        m5.setOnClickListener(this);
        m6.setOnClickListener(this);
        jie.setOnClickListener(this);
        san.setOnClickListener(this);
        danwei.setOnClickListener(this);
        jinzhi.setOnClickListener(this);
        dengyu.setOnClickListener(this);
        huilv.setOnClickListener(this);
        et.setText("");

    }

    @Override
    public void onClick(View v) {
        int a=et.getText().toString().length();
        switch (v.getId()) {
            case R.id.back:
                if(et.getText().toString().length()==0)
                    et.setText("");
                else
              et.setText(et.getText().toString().substring(0, et.getText().toString().length()-1));
              break;
            case R.id.c:
            et.setText("");
            break;
            case R.id.cheng:
                if(a==0)
                    et.setText(et.getText().toString()+"");
                else {
                    if (et.getText().toString().substring(a - 1).equals("+") || et.getText().toString().substring(a - 1).equals("÷"))
                        et.setText(et.getText().toString().substring(0, a-1) + "×");
                    else if (et.getText().toString().substring(a - 1).equals("-")) {
                        if ( et.getText().toString().substring(a - 2,a-1).equals("÷"))
                            et.setText(et.getText().toString().substring(0, a - 2) + "×");
                        else
                            et.setText(et.getText().toString().substring(0, a - 1) + "×");
                    } else {
                        if (et.getText().toString().substring(a-1).equals("×")||et.getText().toString().substring(a-1).equals("."))
                            et.setText(et.getText().toString() + "");
                        else
                            et.setText(et.getText().toString() + "×");
                    }
                }
              
                break;
            case R.id.chu:
                if(a==0)
                    et.setText(et.getText().toString()+"");
                else {
                    if (et.getText().toString().substring(a - 1).equals("+") || et.getText().toString().substring(a - 1).equals("×"))
                        et.setText(et.getText().toString().substring(0, a-1) + "÷");
                    else if (et.getText().toString().substring(a - 1).equals("-")) {
                        if ( et.getText().toString().substring(a - 2,a-1).equals("×"))
                            et.setText(et.getText().toString().substring(0, a - 2) + "÷");
                        else
                            et.setText(et.getText().toString().substring(0, a - 1) + "÷");
                    } else {
                        if (et.getText().toString().substring(a-1).equals("÷")||et.getText().toString().substring(a-1).equals("."))
                            et.setText(et.getText().toString() + "");
                        else
                            et.setText(et.getText().toString() + "÷");
                    }
                }

                break;
            case R.id.jia:
                if(a==0)
                    et.setText(et.getText().toString()+"");
                else {
                    if (et.getText().toString().substring(a - 1).equals("÷") || et.getText().toString().substring(a - 1).equals("×"))
                        et.setText(et.getText().toString().substring(0, a-1) + "+");
                    else if (et.getText().toString().substring(a - 1).equals("-")) {
                        if (et.getText().toString().substring(a - 2,a-1).equals("÷") || et.getText().toString().substring(a - 2,a-1).equals("×"))
                            et.setText(et.getText().toString().substring(0, a - 2) + "+");
                         else
                            et.setText(et.getText().toString().substring(0, a - 1) + "+");
                    } else {
                        if (et.getText().toString().substring(a-1).equals("+")||et.getText().toString().substring(a-1).equals("."))
                            et.setText(et.getText().toString() + "");
                        else
                        et.setText(et.getText().toString() + "+");
                    }
                }
                break;
            case R.id.jian:
                if (et.getText().toString().substring(a -1).compareTo("+") == 0)
                    et.setText(et.getText().toString().substring(0, a-1 ) + "-");
                else if (et.getText().toString().substring(a-1).compareTo("-") != 0 && et.getText().toString().substring(a-1).compareTo(".") != 0)
                    et.setText(et.getText().toString() + "-");

                break;

            case R.id.dengyu:
                String infix2 = et.getText().toString();
                if(infix2.indexOf('i')>0){
                    int x=infix2.indexOf("sin(");
                    StringBuffer s = new StringBuffer(infix2);
                    String temp ="";
                    for(int i=x+4;s.charAt(i)!=')';i++)
                    {
                        temp+=s.charAt(i);
                    }
                    double a1 = Math.toRadians(toValue(toPostfix(temp)));
                    String res = String.valueOf(Math.sin(a1));
                    et.setText(res);
                }else if(infix2.indexOf('o')>0){
                    int x=infix2.indexOf("cos(");
                    StringBuffer s = new StringBuffer(infix2);
                    String temp ="";
                    for(int i=x+4;s.charAt(i)!=')';i++)
                    {
                        temp+=s.charAt(i);
                    }
                    double a1 = Math.toRadians(toValue(toPostfix(temp)));
                    String res = String.valueOf(Math.cos(a1));
                    et.setText(res);
                }else if(infix2.indexOf('a')>0){
                    int x=infix2.indexOf("tan(");
                    StringBuffer s = new StringBuffer(infix2);
                    String temp ="";
                    for(int i=x+4;s.charAt(i)!=')';i++)
                    {
                        temp+=s.charAt(i);
                    }
                    double a1 = Math.toRadians(toValue(toPostfix(temp)));
                    String res = String.valueOf(Math.tan(a1));
                   et.setText(res);
                }
                else{
                    StringBuffer e= toPostfix(et.getText().toString());
                    Log.i("hou",new String(e));
                    BigDecimal bg = new BigDecimal(toValue(e) + "");
                    et.setText(String.valueOf(bg));
                }
                break;
            case R.id.dian:
                et.setText(et.getText().toString()+".");
                break;
            case R.id.fang:
                et.setText(et.getText().toString()+"^2");
                break;
            case R.id.san:
                et.setText(et.getText().toString()+"^3");
                break;
            case R.id.jie:
                et.setText(et.getText().toString()+"!");
                break;
            case R.id.percent:
                et.setText(et.getText().toString()+"%");
                break;
            case R.id.sin:
                et.setText(et.getText().toString()+"sin(");
                break;
            case R.id.cos:
                et.setText(et.getText().toString()+"cos(");
                break;
            case R.id.tan:
                et.setText(et.getText().toString()+"tan(");
                break;
            case R.id.m1:
            case R.id.m2:
            case R.id.m3:
                et.setText(et.getText().toString()+"(");
                break;
            case R.id.m4:
                et.setText(et.getText().toString()+")");
                break;
            case R.id.m5:
            case R.id.m6:
            case R.id.shu0:
                et.setText(et.getText().toString()+'0');
                break;
            case R.id.shu1:
                et.setText(et.getText().toString()+'1');
                break;
            case R.id.shu2:
                et.setText(et.getText().toString()+'2');
                break;
            case R.id.shu3:
                et.setText(et.getText().toString()+'3');
                break;
            case R.id.shu4:
                et.setText(et.getText().toString()+'4');
                break;
            case R.id.shu5:
                et.setText(et.getText().toString()+'5');
                break;
            case R.id.shu6:
                et.setText(et.getText().toString()+'6');
                break;
            case R.id.shu7:
                et.setText(et.getText().toString()+'7');
                break;
            case R.id.shu8:
                et.setText(et.getText().toString()+'8');
                break;
            case R.id.shu9:
                et.setText(et.getText().toString()+'9');
                break;
            case R.id.danwei:
                Intent intent2=new Intent(MainActivity.this,HuansuanActivity.class);
                startActivity(intent2);
                break;

            case R.id.jinzhi:
                Intent intent1=new Intent(MainActivity.this,JinzhiActivity.class);
                startActivity(intent1);
                break;
            case R.id.huilv:
                Intent intent3=new Intent(MainActivity.this,HuilvActivity.class);
                startActivity(intent3);
                break;

            default:
                break;
        }
        }

    }

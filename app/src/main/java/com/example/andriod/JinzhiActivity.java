package com.example.andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.math.BigDecimal;


public class JinzhiActivity extends AppCompatActivity {
    Button jz;
    EditText el;
    TextView tl;
    private Spinner s1 = null;
    private Spinner s2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jinzhi);
        Resources res3 = getResources();
        String[] jinzhi = res3.getStringArray(R.array.jinzhi);
        s1 = (Spinner) findViewById(R.id.s1);
        s2 = (Spinner) findViewById(R.id.s2);
        jz = (Button) findViewById(R.id.jz);
        el = (EditText) findViewById(R.id.e1);
        tl = (TextView) findViewById(R.id.e2);
        el.setText("1");
        ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, jinzhi);
        s1.setAdapter(adapter3);
        s2.setAdapter(adapter3);
        s1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int c, long l) {
                String Text = s1.getItemAtPosition(c).toString();
                if (Text.equals("二进制")) {
                    Toast.makeText(JinzhiActivity.this, "只能输入0或1", Toast.LENGTH_SHORT).show();
                } else if (Text.equals("八进制")) {
                    Toast.makeText(JinzhiActivity.this, "只能输入小于等于8的数字", Toast.LENGTH_SHORT).show();
                }
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        s2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int c, long l) {
                String Text = s2.getItemAtPosition(c).toString();
                Toast.makeText(JinzhiActivity.this, Text, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        jz.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                {
                    if (s1.getSelectedItem().toString().equals("十进制")
                    ) {
                        if(s2.getSelectedItem().toString().equals("十六进制")) {

                           int i = Integer.valueOf(el.getText().toString()).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(Integer.toHexString(i)));
                        }else  if(s2.getSelectedItem().toString().equals("二进制")) {

                            int i = Integer.valueOf(el.getText().toString()).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(Integer.toBinaryString(i)));
                        }else  if(s2.getSelectedItem().toString().equals("八进制")) {

                            int i = Integer.valueOf(el.getText().toString()).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(Integer.toOctalString(i)));
                        }else {
                            int i = Integer.valueOf(el.getText().toString()).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(i));
                        }
                    }else if (s1.getSelectedItem().toString().equals("十六进制")
                    ) {
                        if(s2.getSelectedItem().toString().equals("十进制")) {
                            tl.setText(String.valueOf(Integer.valueOf(el.getText().toString(),16).toString()));
                        }else  if(s2.getSelectedItem().toString().equals("二进制")) {

                            int i = Integer.valueOf(String.valueOf(Integer.valueOf(el.getText().toString(),16).toString())).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(Integer.toBinaryString(i)));
                        }else  if(s2.getSelectedItem().toString().equals("八进制")) {

                            int i = Integer.valueOf(String.valueOf(Integer.valueOf(el.getText().toString(),16).toString())).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(Integer.toOctalString(i)));
                        }else {
                            int i = Integer.valueOf(el.getText().toString()).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(i));
                        }
                    }else if (s1.getSelectedItem().toString().equals("八进制")
                    ) {
                        if(s2.getSelectedItem().toString().equals("十进制")) {
                            tl.setText(String.valueOf(Integer.valueOf(el.getText().toString(),8).toString()));
                        }else  if(s2.getSelectedItem().toString().equals("二进制")) {

                            int i = Integer.valueOf(String.valueOf(Integer.valueOf(el.getText().toString(),8).toString())).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(Integer.toBinaryString(i)));
                        }else  if(s2.getSelectedItem().toString().equals("十六进制")) {

                            int i = Integer.valueOf(String.valueOf(Integer.valueOf(el.getText().toString(),8).toString())).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(Integer.toHexString(i)));
                        }
                        else {
                            int i = Integer.valueOf(el.getText().toString()).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(i));
                        }
                    }else if (s1.getSelectedItem().toString().equals("二进制")
                    ) {
                        if(s2.getSelectedItem().toString().equals("十进制")) {
                            tl.setText(String.valueOf(Integer.valueOf(el.getText().toString(),2).toString()));
                        }else  if(s2.getSelectedItem().toString().equals("十六进制")) {

                            int i = Integer.valueOf(String.valueOf(Integer.valueOf(el.getText().toString(),2).toString())).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(Integer.toHexString(i)));
                        }else  if(s2.getSelectedItem().toString().equals("八进制")) {

                            int i = Integer.valueOf(String.valueOf(Integer.valueOf(el.getText().toString(),2).toString())).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(Integer.toOctalString(i)));
                        }else {
                            int i = Integer.valueOf(el.getText().toString()).intValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            tl.setText(String.valueOf(i));
                        }
                    }

                }

                ;
            };
        });
    };
}
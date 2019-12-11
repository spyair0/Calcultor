package com.example.andriod;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.lang.reflect.Array;
import java.math.BigDecimal;

public class DanweiActivity extends AppCompatActivity {
    Button dw;
    EditText e2;
    TextView t2;
    private Spinner sd1 = null;
    private Spinner sd2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_danwei);
        Resources res1 = getResources();
        String[] danweisp = res1.getStringArray(R.array.danweisp);
        sd1 = (Spinner) findViewById(R.id.sd1);
        sd2 = (Spinner) findViewById(R.id.sd2);
        dw = (Button) findViewById(R.id.dw);
        e2 = (EditText) findViewById(R.id.ed1);
        t2 = (TextView) findViewById(R.id.ed2);
        e2.setText("1");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, danweisp);
        sd1.setAdapter(adapter1);
        sd2.setAdapter(adapter1);
        sd1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int c, long l) {
                String Text = sd1.getItemAtPosition(c).toString();
                Toast.makeText(DanweiActivity.this, Text, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sd2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int c, long l) {
                String Text = sd2.getItemAtPosition(c).toString();
                Toast.makeText(DanweiActivity.this, Text, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        dw.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                {
                    if (sd1.getSelectedItem().toString().equals("厘米") && sd2.getSelectedItem().toString().equals("毫米")
                            || sd1.getSelectedItem().toString().equals("分米") && sd2.getSelectedItem().toString().equals("厘米")
                            || sd1.getSelectedItem().toString().equals("米") && sd2.getSelectedItem().toString().equals("分米")) {
                        double i = Double.valueOf(e2.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i*10+"");
                        t2.setText(String.valueOf(bg));
                    } else if (sd1.getSelectedItem().toString().equals("米") && sd2.getSelectedItem().toString().equals("厘米") ||
                            sd1.getSelectedItem().toString().equals("分米") && sd2.getSelectedItem().toString().equals("毫米")) {
                        double i = Double.valueOf(e2.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i*100+"");
                        t2.setText(String.valueOf(bg));
                    } else if (sd1.getSelectedItem().toString().equals("厘米") && sd2.getSelectedItem().toString().equals("米") ||
                            sd1.getSelectedItem().toString().equals("毫米") && sd2.getSelectedItem().toString().equals("分米")) {
                        double i = Double.valueOf(e2.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i/100+"");
                        t2.setText(String.valueOf(bg));
                    } else if (sd1.getSelectedItem().toString().equals("毫米") && sd2.getSelectedItem().toString().equals("厘米")
                            || sd1.getSelectedItem().toString().equals("厘米") && sd2.getSelectedItem().toString().equals("分米")
                            || sd1.getSelectedItem().toString().equals("分米") && sd2.getSelectedItem().toString().equals("米")) {
                        double i = Double.valueOf(e2.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i/10+"");
                        t2.setText(String.valueOf(bg));
                    } else if (sd1.getSelectedItem().toString().equals("米") && sd2.getSelectedItem().toString().equals("毫米")
                    ) {
                        double i = Double.valueOf(e2.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i*1000+"");
                        t2.setText(String.valueOf(bg));
                    } else if (sd1.getSelectedItem().toString().equals("毫米") && sd2.getSelectedItem().toString().equals("米")
                    ) {
                        double i = Double.valueOf(e2.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i/1000+"");
                        t2.setText(String.valueOf(bg));
                    } else {
                        double i = Double.valueOf(e2.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i+"");
                        t2.setText(String.valueOf(bg));
                    }
                }
                ;


            }

            ;
        });
    }
}

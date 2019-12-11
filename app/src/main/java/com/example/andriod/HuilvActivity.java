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


public class HuilvActivity extends AppCompatActivity {
    Button hl;
    EditText ehl;
    TextView thl;
    private Spinner sh1 = null;
    private Spinner sh2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_huilv);
        Resources res2 = getResources();
        String[] huilvsp = res2.getStringArray(R.array.huilvsp);
        sh1 = (Spinner) findViewById(R.id.sh1);
        sh2 = (Spinner) findViewById(R.id.sh2);
        hl = (Button) findViewById(R.id.hl);
        ehl = (EditText) findViewById(R.id.eh1);
        thl = (TextView) findViewById(R.id.eh2);
        ehl.setText("1");
        ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, huilvsp);
        sh1.setAdapter(adapter2);
        sh2.setAdapter(adapter2);
        sh1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int c, long l) {
                String Text = sh1.getItemAtPosition(c).toString();
                Toast.makeText(HuilvActivity.this, Text, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        sh2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int c, long l) {
                String Text = sh2.getItemAtPosition(c).toString();
                Toast.makeText(HuilvActivity.this, Text, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        hl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                {
                    if (sh1.getSelectedItem().toString().equals("美元")
                    ) {
                        if(sh2.getSelectedItem().toString().equals("人民币")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 7.09 + "");
                            thl.setText(String.valueOf(bg));
                        }else  if(sh2.getSelectedItem().toString().equals("日元")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 107.55 + "");
                            thl.setText(String.valueOf(bg));
                    }else  if(sh2.getSelectedItem().toString().equals("欧元")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i* 0.907 + "");
                            thl.setText(String.valueOf(bg));
                        }
                        else{
                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            thl.setText(String.valueOf(bg));
                        }
                }else  if (sh1.getSelectedItem().toString().equals("人民币")
                    ) {
                        if(sh2.getSelectedItem().toString().equals("美元")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 0.141 + "");
                            thl.setText(String.valueOf(bg));
                        }else  if(sh2.getSelectedItem().toString().equals("日元")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 15.16+ "");
                            thl.setText(String.valueOf(bg));
                        }else  if(sh2.getSelectedItem().toString().equals("欧元")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 0.128 + "");
                            thl.setText(String.valueOf(bg));
                        }
                        else{
                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            thl.setText(String.valueOf(bg));
                        }
                    }else  if (sh1.getSelectedItem().toString().equals("欧元")
                    ) {
                        if(sh2.getSelectedItem().toString().equals("美元")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 1.1017 + "");
                            thl.setText(String.valueOf(bg));
                        }else  if(sh2.getSelectedItem().toString().equals("日元")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 118.4878 + "");
                            thl.setText(String.valueOf(bg));
                        }else  if(sh2.getSelectedItem().toString().equals("人民币")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i *7.812 + "");
                            thl.setText(String.valueOf(bg));
                        }
                        else{
                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            thl.setText(String.valueOf(bg));
                        }
                    }else  if (sh1.getSelectedItem().toString().equals("日元")
                    ) {
                        if(sh2.getSelectedItem().toString().equals("美元")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 0.009298 + "");
                            thl.setText(String.valueOf(bg));
                        }else  if(sh2.getSelectedItem().toString().equals("人民币")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 0.06593 + "");
                            thl.setText(String.valueOf(bg));
                        }else  if(sh2.getSelectedItem().toString().equals("欧元")) {

                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i * 0.00844 + "");
                            thl.setText(String.valueOf(bg));
                        }
                        else{
                            double i = Double.valueOf(ehl.getText().toString()).doubleValue();
                            BigDecimal bg = new BigDecimal(i + "");
                            thl.setText(String.valueOf(bg));
                        }
                    }

            }

            ;
        };
    });
};
}
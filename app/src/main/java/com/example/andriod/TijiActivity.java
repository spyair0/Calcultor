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


public class TijiActivity extends AppCompatActivity {
    Button tj;
    EditText etj;
    TextView ttj;
    private Spinner st1 = null;
    private Spinner st2 = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiji);
        Resources res1 = getResources();
        String[] tijisp = res1.getStringArray(R.array.tijisp);
        st1 = (Spinner) findViewById(R.id.st1);
        st2 = (Spinner) findViewById(R.id.st2);
        tj = (Button) findViewById(R.id.tj);
        etj = (EditText) findViewById(R.id.et1);
        ttj = (TextView) findViewById(R.id.et2);
        etj.setText("1");
        ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, tijisp);
        st1.setAdapter(adapter1);
        st2.setAdapter(adapter1);
        st1.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int c, long l) {
                String Text = st1.getItemAtPosition(c).toString();
                Toast.makeText(TijiActivity.this, Text, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        st2.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int c, long l) {
                String Text = st2.getItemAtPosition(c).toString();
                Toast.makeText(TijiActivity.this, Text, Toast.LENGTH_SHORT).show();
            }

            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        tj.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                {
                    if (st1.getSelectedItem().toString().equals("立方米") && st2.getSelectedItem().toString().equals("立方分米")
                            || st1.getSelectedItem().toString().equals("立方分米") && st2.getSelectedItem().toString().equals("立方厘米")
                            ) {
                        double i = Double.valueOf(etj.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i*1000+"");
                        ttj.setText(String.valueOf(bg));
                    } else if (st1.getSelectedItem().toString().equals("立方米") && st2.getSelectedItem().toString().equals("立方厘米")
                           ) {
                        double i = Double.valueOf(etj.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i*1000000+"");
                        ttj.setText(String.valueOf(bg));
                    } else if (st1.getSelectedItem().toString().equals("立方厘米") && st2.getSelectedItem().toString().equals("立方米") ) {
                        double i = Double.valueOf(etj.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i/100000+"");
                        ttj.setText(String.valueOf(bg));
                    } else if ( st1.getSelectedItem().toString().equals("立方厘米") && st2.getSelectedItem().toString().equals("立方分米")
                            || st1.getSelectedItem().toString().equals("立方分米") && st2.getSelectedItem().toString().equals("立方米")) {
                        double i = Double.valueOf(etj.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i/1000+"");
                        ttj.setText(String.valueOf(bg));
                    } else {
                        double i = Double.valueOf(etj.getText().toString()).doubleValue();
                        BigDecimal bg=new BigDecimal(i+"");
                        ttj.setText(String.valueOf(bg ));
                    }
                }
                ;


            }

            ;
        });
    }
}


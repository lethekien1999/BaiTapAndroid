package com.example.covertmoney;

import  androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    Spinner spinner1;
    Spinner spinner2;
    TextView result;
    EditText edtText;
    String a ="";
    String b ="";
    double i;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }
    public void init() {
        result = findViewById(R.id.result);
        edtText = findViewById(R.id.edittext);

        spinner1 = findViewById(R.id.spinner1);
        spinner2 = findViewById(R.id.spinner2);
        String[] items= { "Chọn 1 mệnh giá bất kì","VND", "USD", "EU", "ISK", "ARS","SEK", "GBP", "KRW"};

        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, items);
        spinner1.setAdapter(arrayAdapter);
        spinner1.setOnItemSelectedListener(this);
        spinner2.setAdapter(arrayAdapter);
        spinner2.setOnItemSelectedListener(this);
        edtText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if(a.equals("")||b.equals("")||a.equals("Chọn 1 mệnh giá bất kì")||b.equals("Chọn 1 mệnh giá bất kì")||edtText.getText().toString().equals("")) {
                    result.setText("");
                }
                else {
                    try {
                        i = Double.parseDouble(edtText.getText().toString());
                        result.setText(String.format("%.2f",Convert(i,a,b)));
                    }catch (Exception ex){
                        ex.printStackTrace();
                    }
                }
            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Spinner spinner1=(Spinner) parent;
        Spinner spinner2=(Spinner) parent;

        if(spinner1.getId()==R.id.spinner1){
            a = (String) spinner1.getItemAtPosition(position);
        }
        if(spinner2.getId()==R.id.spinner2){
            b = (String) spinner2.getItemAtPosition(position);
        }
        if(a.equals("")||b.equals("")||a.equals("Chọn 1 mệnh giá bất kì")||b.equals("Chọn 1 mệnh giá bất kì")) {
            result.setText("");
        }
        else {
            try {
                i = Double.parseDouble(edtText.getText().toString());
                result.setText(String.format("%.2f",Convert(i,a,b)));
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }
    }
    public double format(String a){
        double i = 0;
        switch (a){
            case "USD":
                i= 1.0;
                break;
            case "EU":
                i= 0.84292;
                break;
            case "ISK":
                i = 138.43013;
                break;
            case "VND":
                i= 23.0;
                break;
            case "ARS":
                i= 77.73;
                break;
            case "SEK":
                i= 8.7;
                break;
            case "GBP":
                i= 0.759;
                break;
            case "KRW":
                i= 1132.13963;
                break;
            default:
                break;
        };
        return i;
    }
    public double Convert(double number,String a,String b){
        double c = format(a);
        double d = format(b);

        double convert = number*d/c;
        
        return convert;
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}

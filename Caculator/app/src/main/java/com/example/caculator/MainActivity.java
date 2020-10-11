package com.example.caculator;

import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {


    private TextView tvResult;

    private Button btnNumber0;
    private Button btnNumber1;
    private Button btnNumber2;
    private Button btnNumber3;
    private Button btnNumber4;
    private Button btnNumber5;
    private Button btnNumber6;
    private Button btnNumber7;
    private Button btnNumber8;
    private Button btnNumber9;

    private Button btnCong;
    private Button btnTru;
    private Button btnNhan;
    private Button btnChia;
    private Button btnDel;
    private Button btnClear;
    private Button btnPoint;
    private Button btnResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initWidget();
        setEventClickViews();
        Typeface typeface =Typeface.createFromAsset(getAssets(), "fonts/digital7.ttf");
        tvResult.setTypeface(typeface);
    }
    public void initWidget(){
        tvResult =findViewById(R.id.tv_result);

        btnNumber0 = findViewById(R.id.btnNumber0);
        btnNumber1 = findViewById(R.id.btnNumber1);
        btnNumber2 = findViewById(R.id.btnNumber2);
        btnNumber3 = findViewById(R.id.btnNumber3);
        btnNumber4 = findViewById(R.id.btnNumber4);
        btnNumber5 = findViewById(R.id.btnNumber5);
        btnNumber6 = findViewById(R.id.btnNumber6);
        btnNumber7 = findViewById(R.id.btnNumber7);
        btnNumber8 = findViewById(R.id.btnNumber8);
        btnNumber9 = findViewById(R.id.btnNumber9);

        btnCong = findViewById(R.id.btnCong);
        btnTru = findViewById(R.id.btnTru);
        btnNhan = findViewById(R.id.btnNhan);
        btnChia = findViewById(R.id.btnChia);
        btnResult = findViewById(R.id.btnResult);
        btnPoint = findViewById(R.id.btnPoint);
        btnDel = findViewById(R.id.btnDel);
        btnClear = findViewById(R.id.btnClear);

    }
    public void setEventClickViews(){
        btnNumber0.setOnClickListener(this);
        btnNumber1.setOnClickListener(this);
        btnNumber2.setOnClickListener(this);
        btnNumber3.setOnClickListener(this);
        btnNumber4.setOnClickListener(this);
        btnNumber5.setOnClickListener(this);
        btnNumber6.setOnClickListener(this);
        btnNumber7.setOnClickListener(this);
        btnNumber8.setOnClickListener(this);
        btnNumber9.setOnClickListener(this);

        btnCong.setOnClickListener(this);
        btnTru.setOnClickListener(this);
        btnNhan.setOnClickListener(this);
        btnChia.setOnClickListener(this);
        btnResult.setOnClickListener(this);
        btnPoint.setOnClickListener(this);
        btnDel.setOnClickListener(this);
        btnClear.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnNumber0:
                tvResult.append("0");
                break;
            case R.id.btnNumber1:
                tvResult.append("1");
                break;
            case R.id.btnNumber2:
                tvResult.append("2");
                break;
            case R.id.btnNumber3:
                tvResult.append("3");
                break;
            case R.id.btnNumber4:
                tvResult.append("4");
                break;
            case R.id.btnNumber5:
                tvResult.append("5");
                break;
            case R.id.btnNumber6:
                tvResult.append("6");
                break;
            case R.id.btnNumber7:
                tvResult.append("7");
                break;
            case R.id.btnNumber8:
                tvResult.append("8");
                break;
            case R.id.btnNumber9:
                tvResult.append("9");
                break;
            case R.id.btnCong:
                tvResult.append("+");
                break;
            case R.id.btnTru:
                tvResult.append("-");
                break;
            case R.id.btnNhan:
                tvResult.append("*");
                break;
            case R.id.btnChia:
                tvResult.append("/");
                break;
            case R.id.btnResult:
                tvResult.setText(Solve(tvResult.getText().toString()));
                break;
            case R.id.btnPoint:
                tvResult.append(".");
                break;
            case R.id.btnClear:
                tvResult.setText("");
                break;
            case R.id.btnDel:
                tvResult.setText(delete(tvResult.getText().toString()));
                break;


        }

    }
    public String delete(String number){
        int leng = number.length();
        String tem="";
        if(leng>0){
        tem = number.substring(0,leng-1);}
        return tem;
    }
    public String Solve(String input){
        if (input.split("\\+").length==2){
            String number[]=input.split("\\+");
            try{
                double mul = Double.parseDouble(number[0]) + Double.parseDouble(number[1]);
                input = mul+"";
            }catch (Exception e){

            }

        }
        if (input.split("\\/").length==2){
            String number[]=input.split("\\/");
            try{
                double mul=Double.parseDouble(number[0])/Double.parseDouble(number[1]);
                input = mul+"";
            }catch (Exception e){

            }

        }
        if (input.split("\\-").length==2){
            String number[]=input.split("\\-");
            try{
                double mul=Double.parseDouble(number[0])-Double.parseDouble(number[1]);
                input = mul+"";
            }catch (Exception e){

            }

        }
        if (input.split("\\*").length==2){
            String number[]=input.split("\\*");
            try{
                double mul=Double.parseDouble(number[0])*Double.parseDouble(number[1]);
                input = mul+"";
            }catch (Exception e){

            }

        }
        return input;
    }
}
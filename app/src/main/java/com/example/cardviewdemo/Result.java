package com.example.cardviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.text.DecimalFormat;

    public class Result extends AppCompatActivity {
        TextView res,bmi;
        CardView rc;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_result);
            res=findViewById(R.id.res);
            bmi=findViewById(R.id.bmi);
            rc=findViewById(R.id.recalc);

            rc.setOnClickListener(new ReCalculate());

            Intent intent=getIntent();
            bmi.setText(intent.getStringExtra("bmi"));

            double bm=Double.parseDouble(intent.getStringExtra("bmi"));
            if(bm<18.5){
                res.setText("UNDERWEIGHT");
            }
            else if (bm > 18.5 && bm<24.9) {
                res.setText("NORMAL WEIGHT");
            }
            else if(bm>25 && bm<29.9){
                res.setText("OVER WEIGHT");
            }
            else if(bm>30){
                res.setText("OBESE");
            }
        }
        class ReCalculate implements View.OnClickListener{

            @Override
            public void onClick(View v) {
                Log.d("gg","Re Calculate = ");
                Intent intent=new Intent(Result.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        }
    }
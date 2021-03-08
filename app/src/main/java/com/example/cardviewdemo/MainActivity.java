package com.example.cardviewdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    CardView cv;
    SeekBar sb;
    TextView height,weight,age;
    ImageView wminus,wplus,aminus,aplus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sb=findViewById(R.id.seekBar);

        cv=findViewById(R.id.calculate);

        height=findViewById(R.id.height);
        wminus=findViewById(R.id.wminus);
        wplus=findViewById(R.id.wplus);
        aminus=findViewById(R.id.aminus);
        aplus=findViewById(R.id.aplus);

        weight=findViewById(R.id.weight);
        age=findViewById(R.id.age);

        wminus.setOnClickListener(new Minus());
        aminus.setOnClickListener(new Minus());
        wplus.setOnClickListener(new Plus());
        aplus.setOnClickListener(new Plus());
        cv.setOnClickListener(new Calculate());
        sb.setMax(200);
        setProgress(0);
        sb.setOnSeekBarChangeListener(new Sbar());
    }
    class Sbar implements SeekBar.OnSeekBarChangeListener {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            height.setText(String.valueOf(progress));
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {

        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {

        }
    }
    class Minus implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int w,a;
            String ws;
            Log.d("gg","Minus");
            if(v.equals(wminus)){
                w=Integer.parseInt(weight.getText().toString());
                w--;
                ws=Integer.toString(w);
                weight.setText(ws);
            }
            if(v.equals(aminus)){
                w=Integer.parseInt(age.getText().toString());
                w--;
                ws=Integer.toString(w);
                age.setText(ws);
            }
        }
    }

    class Plus implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            int w;
            String ws;
            if(v.equals(wplus)){
                w=Integer.parseInt(weight.getText().toString());
                w++;
                ws=Integer.toString(w);
                weight.setText(ws);
            }
            if(v.equals(aplus)){
                w=Integer.parseInt(age.getText().toString());
                w++;
                ws=Integer.toString(w);
                age.setText(ws);
            }
        }
    }
    class Calculate implements View.OnClickListener{

        @Override
        public void onClick(View v) {
            Intent intent=new Intent(MainActivity.this,Result.class);
            double h=Double.parseDouble(height.getText().toString());
            double w=Double.parseDouble(weight.getText().toString());
            double bmi=(w/h/h)*10000;
            @SuppressLint("DefaultLocale") String s = String.format("%.1f",bmi);
            Log.d("gg","weight = "+w+" height = "+h+" bmi = "+s);
            intent.putExtra("bmi",s);
            startActivity(intent);
        }
    }
}
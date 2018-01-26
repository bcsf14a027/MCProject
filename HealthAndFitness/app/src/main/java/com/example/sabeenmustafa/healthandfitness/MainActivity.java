package com.example.sabeenmustafa.healthandfitness;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    Button btn_bmi ;
    Button btn_chart , btn_diet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView iv = (ImageView) findViewById(R.id.imageView1) ;
        iv.setImageResource(R.drawable.intro_banner);

        btn_bmi=(Button)findViewById(R.id.BMI);
        btn_bmi.setOnClickListener(this);

        btn_chart=(Button)findViewById(R.id.Chart);
        btn_chart.setOnClickListener(this);

        btn_diet=(Button)findViewById(R.id.Diet);
        btn_diet.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {

        switch (view.getId())
        {
            case R.id.BMI:

                Intent i = new Intent(this, metricCalActivity.class);
                startActivity(i);
                break;

            case R.id.Diet:
                Intent idc=new Intent(this, DietchartActivity.class);
                startActivity(idc);
                break;

            case R.id.Chart:
                try {
                    Intent i2 = new Intent(this, CaloriesChartActivity.class);
                    startActivity(i2);
                    break;
                }
                catch (Exception e)
                {
                    String er = e.getMessage();
                }

            default:
                break;


        }
        }
}

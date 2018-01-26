package com.example.sabeenmustafa.healthandfitness;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

/**
 * Created by Sabeen Mustafa on 1/25/2018.
 */
public class CaloriesChartActivity extends MainActivity{

    int count1 =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calories);

        final ImageButton btn_img = (ImageButton) findViewById(R.id.btn_carbimage) ;
        btn_img.setImageResource(R.drawable.images);

        btn_img.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                count1++;
                if(count1%2!=0) {
                    final ImageView iv = (ImageView) findViewById(R.id.logoImageView);

                    iv.setImageResource(R.drawable.chart1);
                }
                else
                {
                    final ImageView iv = (ImageView) findViewById(R.id.logoImageView);

                    iv.setImageResource(0);
                }

            }
        });



        ImageButton btn_img2 = (ImageButton) findViewById(R.id.btn_fruit) ;
        btn_img2.setImageResource(R.drawable.fruits);



        btn_img2.setOnClickListener( new View.OnClickListener()
        {

            int count2 =0;
            public void CaloriesChartActivity(int count2) {
                this.count2 = count2;
            }
            @Override
            public void onClick(View view)
            {
                count2++;
                if(count2%2!=0) {


                    final ImageView iv2 = (ImageView) findViewById(R.id.calories_fruit);

                    iv2.setImageResource(R.drawable.calories_fruit);
                }
                else
                {

                    final ImageView iv2 = (ImageView) findViewById(R.id.calories_fruit);

                    iv2.setImageResource(0);
                }

            }
        });
        ImageButton btn_img3 = (ImageButton) findViewById(R.id.btn_proimage) ;
        btn_img3.setImageResource(R.drawable.pro_image);

        btn_img3.setOnClickListener( new View.OnClickListener()
        {

            int count1 =0;
            public void CaloriesChartActivity(int count1) {
                this.count1 = count1;
            }
            @Override
            public void onClick(View view)
            {
                count1++;
                if(count1%2!=0) {
                    final ImageView iv3 = (ImageView) findViewById(R.id.iv_chart_protein);

                    iv3.setImageResource(R.drawable.chart_protein);
                }
                else
                {
                    final ImageView iv3 = (ImageView) findViewById(R.id.iv_chart_protein);

                    iv3.setImageResource(0);
                }

            }
        });
    }
}

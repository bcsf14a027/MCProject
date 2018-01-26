package com.example.sabeenmustafa.healthandfitness;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by Sabeen Mustafa on 1/25/2018.
 */
public class metricCalActivity extends Activity {

    EditText height_imp, weight_imp ;
    TextView result_imp ;

    Button calculate_imp ;

    EditText height_metric, weight_metric ;
    TextView result_metric ;

    Button calculate_metric ;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.metriccal_activity);

        height_imp = (EditText) findViewById(R.id.height_inches);
        weight_imp = (EditText) findViewById(R.id.weight_pounds);
        calculate_imp = (Button) findViewById(R.id.calculate_imperial);
        result_imp = (TextView) findViewById(R.id.result_imperial);

        height_metric = (EditText) findViewById(R.id.height_centimeter);
        weight_metric = (EditText) findViewById(R.id.weight_kilogram);
        calculate_metric = (Button) findViewById(R.id.calculate_metric);
        result_metric = (TextView) findViewById(R.id.result_metric);

        calculate_imp.setOnClickListener( new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculateBMI_imp();
            }
        });
        calculate_metric.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                calculateBMI_metric();
            }
        });
    }
    public void calculateBMI_imp()
    {
        String h = height_imp.getText().toString();
        String w = weight_imp.getText().toString();

        if( h.equals("") || w.equals(""))        {
            Toast.makeText(getApplicationContext(), "Please fill the fields.", Toast.LENGTH_SHORT).show();
        }
        else if(h != null && h != ""&& w != null && w != "" )
        {
            float hvalue_imp = Float.parseFloat(h);
            float wvalue_imp = Float.parseFloat(w);

            float bmi_imp = (wvalue_imp/ (hvalue_imp*hvalue_imp))*703;
            displayBMI_imp(bmi_imp);
        }


    }
    public void calculateBMI_metric()
    {
        String h = height_metric.getText().toString();
        String w = weight_metric.getText().toString();

        if( h.equals("") || w.equals(""))
        {

            Toast.makeText(this, "Please fill the fields.", Toast.LENGTH_SHORT).show();
        }

        else if(h != null && h != ""&& w != null && w != "" )
        {
            float hvalue_metric = Float.parseFloat(h);
            float wvalue_metric = Float.parseFloat(w);

            float bmi_metric = wvalue_metric/ (hvalue_metric*hvalue_metric);
            displayBMI_metric(bmi_metric);
        }



    }

    public void displayBMI_imp(float bmi)
    {
        String bmilabel= "";
        if(Float.compare(bmi,15f)<=0)
        {
            bmilabel="very severely underweight";
        }
        else if(Float.compare(bmi,15f)>0 && Float.compare(bmi,16f)<=0 )
        {
            bmilabel="severely underweight";
        }
        else if(Float.compare(bmi,16f)>0 && Float.compare(bmi,18.5f)<=0 )
        {
            bmilabel="underweight";
        }
        else if(Float.compare(bmi,18.5f)>0 && Float.compare(bmi,25f)<=0 )
        {
            bmilabel="normal";
        }
        else if(Float.compare(bmi,25f)>0 && Float.compare(bmi,30f)<=0 )
        {
            bmilabel="overweight";
        }
        else if(Float.compare(bmi,30f)>0 && Float.compare(bmi,35f)<=0 )
        {
            bmilabel="obese class I";
        }
        else if(Float.compare(bmi,35f)>0 && Float.compare(bmi,40f)<=0 )
        {
            bmilabel="obese class II";
        }
        else
        {
            bmilabel="obese Class III";
        }

        bmilabel = bmi + "\n"+bmilabel;
        result_imp.setText(bmilabel);

    }
    public void displayBMI_metric(float bmi)
    {
        String bmilabel= "";
        if(Float.compare(bmi,15f)<=0)
        {
            bmilabel="very severely underweight";
        }
        else if(Float.compare(bmi,15f)>0 && Float.compare(bmi,16f)<=0 )
        {
            bmilabel="severely underweight";
        }
        else if(Float.compare(bmi,16f)>0 && Float.compare(bmi,18.5f)<=0 )
        {
            bmilabel="underweight";
        }
        else if(Float.compare(bmi,18.5f)>0 && Float.compare(bmi,25f)<=0 )
        {
            bmilabel="normal";
        }
        else if(Float.compare(bmi,25f)>0 && Float.compare(bmi,30f)<=0 )
        {
            bmilabel="overweight";
        }
        else if(Float.compare(bmi,30f)>0 && Float.compare(bmi,35f)<=0 )
        {
            bmilabel="obese class I";
        }
        else if(Float.compare(bmi,35f)>0 && Float.compare(bmi,40f)<=0 )
        {
            bmilabel="obese class II";
        }
        else
        {
            bmilabel="obese Class III";
        }

        bmilabel = bmi + "\n"+bmilabel;
        result_metric.setText(bmilabel);

    }

}
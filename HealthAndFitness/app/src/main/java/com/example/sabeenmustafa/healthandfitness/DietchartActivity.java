package com.example.sabeenmustafa.healthandfitness;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class DietchartActivity extends AppCompatActivity implements View.OnClickListener{

    TextView breakfast , lunch , supper , snack , dinner ,id;
    EditText et_breakfast , et_lunch , et_supper , et_snack , et_dinner , et_id;
    Button add , reset , show , delete , update;


    DataAdapter dataAdapter;
    DBHelper DB_Helper;


    @Override

    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_dietchart);

        DB_Helper = new DBHelper(this);
        add = (Button) findViewById(R.id.add);
        add.setOnClickListener(this);

        reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(this);

        delete = (Button) findViewById(R.id.delete);
        delete.setOnClickListener(this);

        show = (Button) findViewById(R.id.show);
        show.setOnClickListener(this);

        // ArrayList<DietChart> di = DB_Helper.getAll();

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                Toast.makeText(DietchartActivity.this, "Adding", Toast.LENGTH_SHORT).show();

                long rid = DB_Helper.insert(et_breakfast.getText().toString(), et_supper.getText().toString(),
                        et_lunch.getText().toString(), et_snack.getText().toString(), et_dinner.getText().toString());

                Toast.makeText(DietchartActivity.this, "Successfully added ...", Toast.LENGTH_LONG).show();
                break;

            case R.id.reset:

                Toast.makeText(DietchartActivity.this, "Reset", Toast.LENGTH_SHORT).show();
                et_breakfast.setText(" ");
                et_supper.setText(" ");
                et_lunch.setText(" ");
                et_snack.setText(" ");
                et_dinner.setText(" ");
                et_id.setText("");
                break;

            case R.id.delete:
                DB_Helper.delete_row(et_breakfast.getText().toString());
                break;

            case R.id.update:
               // DietChart dietChart=new DietChart();
                //int ii=DB_Helper.update(dietChart);

            case R.id.show:
                Intent dbmanager = new Intent(DietchartActivity.this, AndroidDatabaseManager.class);
                startActivity(dbmanager);

            default:
                break;

        }
    }
}
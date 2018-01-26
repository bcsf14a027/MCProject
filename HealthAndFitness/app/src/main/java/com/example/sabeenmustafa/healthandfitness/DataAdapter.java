package com.example.sabeenmustafa.healthandfitness;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Sabeen Mustafa on 1/26/2018.
 */
public class DataAdapter  extends RecyclerView.Adapter<DataAdapter.ViewHolder> {


    ArrayList<DietChart> dietchart;
    Context context;


    public DataAdapter(Context context, ArrayList<DietChart> dietchart) {

        this.dietchart = dietchart;
        this.context = context;
    }
    @Override

    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_dietchart,parent, false);
        return new ViewHolder(v);
    }


    @Override

    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {

        DietChart dc = dietchart.get(position);

        Toast.makeText(context, ""+dc.getId(), Toast.LENGTH_SHORT).show();

        holder.id.setText(dc.getId()+"");
        holder.snack.setText(dc.getSnack() +"");
        holder.breakfast.setText(dc.getBreakFast()+"");
        holder.supper.setText(dc.getSupper()+"");
        holder.lunch.setText(dc.getLunch()+"");
        holder.dinner.setText(dc.getDinner()+"");


    }

    @Override
    public int getItemCount() {
        return DietChart.size();
    }

    /**

     * DataAdapter.ViewHolder Class is below It will be used for designing

     * and setting the data entries in the adapter for recyclerview

     */

    public class ViewHolder extends RecyclerView.ViewHolder
    {

        public TextView id;
        public EditText  et_breakfast , et_lunch , et_supper , et_snack , et_dinner;
        public TextView breakfast;
        public TextView supper;
        public TextView lunch;
        public TextView snack;
        public TextView dinner;

        public LinearLayout ll_ui;
       // public Toast snack;
        public ViewHolder(View view)
        {

            super(view);

            id = (TextView) view.findViewById(R.id.id);
            breakfast = (TextView) view.findViewById(R.id.breakfast);
            lunch = (TextView) view.findViewById(R.id.lunch);

            supper = (TextView) view.findViewById(R.id.supper);
            snack = (TextView) view.findViewById(R.id.snack);
            dinner = (TextView) view.findViewById(R.id.dinner);

            ll_ui = (LinearLayout) view.findViewById(R.id.ll_ui_layout);

        }

    }
}

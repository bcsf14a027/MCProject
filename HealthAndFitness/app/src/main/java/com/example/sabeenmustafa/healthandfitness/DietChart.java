package com.example.sabeenmustafa.healthandfitness;

/**
 * Created by Sabeen Mustafa on 1/26/2018.
 */
public class DietChart {

    private String breakfast;
    private String lunch;
    private String snack;
    private String supper;
    private String dinner;
    private int id;


    public DietChart(int id,String breakfast,String supper,String lunch,String snack,String dinner ) {

        setId(id);
        setBreakfast(breakfast);
        setLunch(lunch);
        setDinner(dinner);
        setSupper(supper);
        setSnack(snack);
    }

    public void setLunch(String lunch) {
        this.lunch = lunch;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String setBreakfast(String breakfast) {
        this.breakfast = breakfast;
        return breakfast;
    }

    public void setDinner(String dinner) {
        this.dinner = dinner;
    }

    public void setSnack(String snack) {
        this.snack = snack;
    }
    public void setSupper(String supper) {
        this.supper = supper;
    }
    public String getBreakFast() {

        return breakfast;
    }
    public String getLunch() {

        return lunch;
    }
    public String getDinner() {

        return dinner;
    }
    public String getSupper() {

        return supper;
    }
    public int getId() {

        return id;
    }
    public String getSnack() {

        return snack;

    }

    public static int size() {
        return 0;
    }
}

package com.example.sabeenmustafa.healthandfitness;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.MatrixCursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Sabeen Mustafa on 1/26/2018.
 */
public class DBHelper extends SQLiteOpenHelper{
    
    
    public static final String TABLE_NAME = "DietChart";

    

    //COLUMN NAMES

    public static final String ID = "id";

    public static final String BREAKFAST = "breakfast";
    public static final String SUPPER = "supper";
    public static final String LUNCH = "lunch";
    public static final String SNACK="snack";
    public static final String DINNER = "dinner";


    //COLUMN TYPES

    public static final String TYPE_TEXT = " TEXT ";

    public static final String TYPE_INT = " INTEGER ";

    public static final String SEPERATOR = ", ";

    private static final String DATABASE_NAME = "dietchart.db";


    public DBHelper(Context context) {

        super(context, DATABASE_NAME, null, 1);

    }


    @Override

    public void onCreate(SQLiteDatabase db) {

        String create_query = "Create table " + TABLE_NAME + " ("

                //need to make primary key NOT NULL

// and AUTOINCREMENT instead of AUTO_INCREMENT

                + ID + TYPE_INT + " PRIMARY KEY AUTOINCREMENT NOT NULL " + SEPERATOR

                + BREAKFAST + TYPE_TEXT + SEPERATOR  + SUPPER + TYPE_TEXT + SEPERATOR

                + LUNCH + TYPE_TEXT + SEPERATOR  + SNACK + TYPE_TEXT + SEPERATOR

                + DINNER + TYPE_TEXT + ");";

        db.execSQL(create_query);

    }


    @Override

    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        if (oldVersion < newVersion)
        {

            String drop_query = "drop database if exists " + DATABASE_NAME;

            db.execSQL(drop_query);

            onCreate(db);

        }

    }


    /**

     * This function inserts data into database

     *

     * @param lunch   takes a string lunch

     * @param breakfast   takes a string type breakfast

     * @param dinner takes a string type dinner

     * @return true when data inserted false when failed
     */

    public long insert(String breakfast,String supper,String lunch , String snack , String dinner) {

        SQLiteDatabase db = getWritableDatabase();

        ContentValues cv = new ContentValues();

        cv.put(BREAKFAST,breakfast);
        cv.put(SUPPER,supper);
        cv.put(LUNCH,lunch);
        cv.put(SNACK,snack);
        cv.put(DINNER,dinner);
        long i = db.insert(TABLE_NAME, null, cv);

        Log.d("Database_helper", String.valueOf(i));
        //be sure to close database after work is done
        db.close();
        return i;

    }


    /*
        tableColumns"
        null for all columns as in SELECT * FROM ...

        just like whereClause the statement after the keyword or null if you don't use it.

    */

    public Cursor read(long id) {

        SQLiteDatabase db = getReadableDatabase();

        Cursor c = db.query(TABLE_NAME, new String[]{ID, BREAKFAST}, null, null, null, null, null);
//"SELECT * FROM " + TABLE_NAME + " WHERE " + ID + " = " + id);

        return c;
    }


    /**

     * Deletes Record Based On breakfast

     *

     * @param breakfast

     * @return

     */

    public boolean delete_row(String breakfast) {

        SQLiteDatabase db = getWritableDatabase();

        db.delete(TABLE_NAME, ID + "=" + breakfast, null);

        db.close();

        return false;

    }
//Updating the rows on the basis of breakfast
    public int update(DietChart f) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        
        values.put(BREAKFAST, f.getBreakFast());
        values.put(SUPPER, f.getSupper());
        values.put(LUNCH, f.getLunch());
        values.put(SNACK, f.getSnack());
        values.put(DINNER, f.getDinner());
        // updating row
        return db.update("DietChart" , values , "Breakfast = ?", new String[]{BREAKFAST});
    }


    public ArrayList getAll() {

        ArrayList<DietChart> ui = new ArrayList<>();

        SQLiteDatabase db = getReadableDatabase();

        Cursor cursor = db.query(TABLE_NAME, null, null, null, null, null, null);

        while (cursor.moveToNext()) {

            Log.d(Globals.LOG_TAG, cursor.getColumnNames()[0] + ":"
                    + cursor.getString(cursor.getColumnIndex(ID)));

            Log.d(Globals.LOG_TAG, cursor.getColumnNames()[1] + ":"
                    + cursor.getString(cursor.getColumnIndex(BREAKFAST)));

            Log.d(Globals.LOG_TAG, cursor.getColumnNames()[2]
                    + ":" + cursor.getString(cursor.getColumnIndex(SUPPER)));

            Log.d(Globals.LOG_TAG, cursor.getColumnNames()[3]
                    + ":" + cursor.getString(cursor.getColumnIndex(LUNCH)));
            Log.d(Globals.LOG_TAG, cursor.getColumnNames()[4]
                    + ":" + cursor.getString(cursor.getColumnIndex(SNACK)));
            Log.d(Globals.LOG_TAG, cursor.getColumnNames()[5]
                    + ":" + cursor.getString(cursor.getColumnIndex(DINNER)));


            ui.add(new DietChart(cursor.getInt(cursor.getColumnIndex(ID)),

                    cursor.getString(cursor.getColumnIndex(BREAKFAST)),
                    cursor.getString(cursor.getColumnIndex(SUPPER)),
                    cursor.getString(cursor.getColumnIndex(LUNCH)),
                    cursor.getString(cursor.getColumnIndex(SNACK)),
                    cursor.getString(cursor.getColumnIndex(DINNER))));
        }

        return ui;
    }
        public ArrayList<Cursor> getData(String Query){
            //get writable database
            SQLiteDatabase sqlDB = this.getWritableDatabase();
            String[] columns = new String[] { "message" };
            //an array list of cursor to save two cursors one has results from the query
            //other cursor stores error message if any errors are triggered
            ArrayList<Cursor> alc = new ArrayList<Cursor>(2);
            MatrixCursor Cursor2= new MatrixCursor(columns);
            alc.add(null);
            alc.add(null);

            try{
                String maxQuery;
                maxQuery = Query;
                //execute the query results will be save in Cursor c
                Cursor c = sqlDB.rawQuery(maxQuery, null);

                //add value to cursor2
                Cursor2.addRow(new Object[] { "Success" });

                alc.set(1,Cursor2);
                if (null != c && c.getCount() > 0) {

                    alc.set(0,c);
                    c.moveToFirst();

                    return alc ;
                }
                return alc;
            } catch(SQLException sqlEx){
                Log.d("printing exception", sqlEx.getMessage());
                //if any exceptions are triggered save the error message to cursor an return the arraylist
                Cursor2.addRow(new Object[] { ""+sqlEx.getMessage() });
                alc.set(1,Cursor2);
                return alc;
            } catch(Exception ex){
                Log.d("printing exception", ex.getMessage());

                //if any exceptions are triggered save the error message to cursor an return the arraylist
                Cursor2.addRow(new Object[] { ""+ex.getMessage() });
                alc.set(1,Cursor2);
                return alc;
            }
        }


}

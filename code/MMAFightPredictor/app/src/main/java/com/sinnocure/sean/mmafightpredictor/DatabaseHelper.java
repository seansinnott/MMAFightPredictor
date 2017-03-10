package com.sinnocure.sean.mmafightpredictor;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

class DatabaseHelper extends SQLiteOpenHelper {

    private Context context;
    private static String DB_PATH;
    private static String DB_NAME = "fighterdata.db";
    private static final int DB_VERSION = 24;

    DatabaseHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
        DB_PATH = context.getFilesDir().getParentFile().getPath() + "/databases/";
    }


    // required class when using SQLiteOpenHelper
    @Override
    public void onCreate(SQLiteDatabase db) {

    }


    // required class when using SQLiteOpenHelper
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }


    // check whether or not the fightersdata database exists on the user's device
    private boolean checkIfDatabaseOnDevice() {
        SQLiteDatabase tempDB = null;
        try {
            String myPath = DB_PATH + DB_NAME;
            tempDB = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (SQLiteException e) {
            e.printStackTrace();
        }
        if (tempDB != null)
            tempDB.close();
        return tempDB != null;
    }


    // copy the fightersdata database to the data folder of the user's device from the assets folder of the apk
    private void copyDatabaseToDevice() throws IOException {
        try {
            InputStream input = context.getAssets().open(DB_NAME);
            String outputName = DB_PATH + DB_NAME;
            OutputStream output = new FileOutputStream(outputName);

            byte[] buff = new byte[1024];
            int length = input.read(buff);

            while(length >0){
                output.write(buff, 0, length);
                length = input.read(buff);
            }

            output.flush();
            output.close();
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    // called every time the app is launched - checks if database is on device, if it isn't, it copies it to the data folder of the device
    void createDatabaseOnDevice() throws IOException {
        boolean databaseExists = checkIfDatabaseOnDevice();

        if (!databaseExists) {
            this.getReadableDatabase();

            try {
                copyDatabaseToDevice();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    // all the getter methods...

    int getReach(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT reach FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int reach = c.getInt(0);
        db.close();
        c.close();
        return reach;

    }


    int getWeight(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT weight FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int weight = c.getInt(0);
        db.close();
        c.close();
        return weight;
    }


    int getHeight(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT height FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int height = c.getInt(0);
        db.close();
        c.close();
        return height;
    }


    int getAge(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT age FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int age = c.getInt(0);
        db.close();
        c.close();
        return age;
    }


    int getNumKos(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT knockouts FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int kos = c.getInt(0);
        db.close();
        c.close();
        return kos;
    }


    int getNumKnockedOut(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT knocked_out FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int kod = c.getInt(0);
        db.close();
        c.close();
        return kod;
    }


    int getNumSubs(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT submissions FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int subs = c.getInt(0);
        db.close();
        c.close();
        return subs;
    }


    int getNumSubbed(String s) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT submitted FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int subbed = c.getInt(0);
        db.close();
        c.close();
        return subbed;
    }


    int getWinstreak(String s){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT win_streak FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int winstreak = c.getInt(0);
        db.close();
        c.close();
        return winstreak;
    }


    int getLosestreak(String s){
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c = db.rawQuery("SELECT lose_streak FROM fighters WHERE name = " + "\"" + s + "\"", null);
        c.moveToFirst();
        int losestreak = c.getInt(0);
        db.close();
        c.close();
        return losestreak;
    }


    List<String> getFighterABasedOnWeight(String s) {
        List<String> listOfFighters = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT name FROM fighters WHERE division = " + "\"" + s + "\"" + " ORDER BY name ASC", null);
            String name;
            c.moveToFirst();
            do {
                name = c.getString(0);
                listOfFighters.add(name);
            } while (c.moveToNext());
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return listOfFighters;
    }


    List<String> getFighterBBasedOnA(String s, String d) {
        List<String> listOfFighters = new ArrayList<>();
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor c;
        try {
            c = db.rawQuery("SELECT name FROM fighters WHERE division = " + "\"" + s + "\"" + " ORDER BY name ASC", null);
            String name;
            c.moveToFirst();
            do {
                name = c.getString(0);
                if(!name.equals(d)) {
                    listOfFighters.add(name);
                }
            } while (c.moveToNext());
            c.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        db.close();
        return listOfFighters;
    }
}


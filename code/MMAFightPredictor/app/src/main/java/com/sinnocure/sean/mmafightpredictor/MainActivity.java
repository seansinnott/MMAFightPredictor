package com.sinnocure.sean.mmafightpredictor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // Ensure database is on user's phone
        DatabaseHelper dbHelper = new DatabaseHelper(getApplicationContext());
        try {
            dbHelper.createDatabaseOnDevice();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void onClickUseOurAlgorithm(View view) {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        globalVariable.setUserChoseToBuildAlgorithm(false);
        Intent intent = new Intent(this, ChooseFighters.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
    }


    public void onClickCreateAlgorithm(View view) {
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();
        globalVariable.setUserChoseToBuildAlgorithm(true);
        Intent intent = new Intent(this, ChooseFighters.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.contactbutt) {
            Intent intent = new Intent(MainActivity.this, Contact.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
        }
        if(id == R.id.helpbutt){
            Intent intent = new Intent(MainActivity.this, Welcome1.class);
            startActivity(intent);
            overridePendingTransition(R.anim.upfrombottom, R.anim.outtop);
        }

        return super.onOptionsItemSelected(item);
    }
}
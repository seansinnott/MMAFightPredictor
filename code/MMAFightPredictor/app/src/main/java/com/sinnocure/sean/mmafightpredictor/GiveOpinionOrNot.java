package com.sinnocure.sean.mmafightpredictor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class GiveOpinionOrNot extends AppCompatActivity {

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.give_opinion_or_not);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
    }


    // user clicked button choosing to give their opinion
    public void onClickOpinion(View view) {
        //create globalVariable to work with getters and setters from GlobalClass..
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // set a boolean to record the fact that user is chose to give opinion
        globalVariable.setUserGivingOpinion(true);

        // start the activity which allows user to give opinion
        Intent intent = new Intent(this, UserOpinion.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
    }


    // user clicked button choosing to not give their opinion
    public void onClickStatsOnly(View view) {
        //create globalVariable to work with getters and setters from GlobalClass..
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // ensure this boolean is set to false before proceeding to next screen
        globalVariable.setUserGivingOpinion(false);

        // start the activity which allows user to receive a prediction
        // without having to enter opinion about the fighter's striking,
        // wrestling, and jiu jitsu skills
        Intent intent = new Intent(this, ResultLoadScreen.class);
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

        if(id == android.R.id.home){
            finish();
            overridePendingTransition(R.anim.backslidein, R.anim.backslideout);
        }

        //noinspection SimplifiableIfStatement
        if (id == R.id.contactbutt) {
            Intent intent = new Intent(GiveOpinionOrNot.this, Contact.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
        }
        if(id == R.id.helpbutt){
            Intent intent = new Intent(GiveOpinionOrNot.this, Welcome1.class);
            startActivity(intent);
            overridePendingTransition(R.anim.upfrombottom, R.anim.outtop);
        }

        return super.onOptionsItemSelected(item);
    }


    @Override
    public void onBackPressed(){
        super.onBackPressed();
        overridePendingTransition(R.anim.backslidein, R.anim.backslideout);
    }
}

package com.sinnocure.sean.mmafightpredictor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;


public class Welcome2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_2);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);


    }

    public void onClickBackWelcomeTwo(View view) {

        Intent intent = new Intent(this, Welcome1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.backslidein, R.anim.backslideout);
    }

    public void onClickNextWelcomeTwo(View view) {

        Intent intent = new Intent(this, Welcome3.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
    }

}

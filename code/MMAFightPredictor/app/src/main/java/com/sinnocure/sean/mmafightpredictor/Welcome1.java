package com.sinnocure.sean.mmafightpredictor;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;

public class Welcome1 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.welcome_1);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        final CheckBox checkmessage = (CheckBox) findViewById(R.id.checkbutt);

        SharedPreferences sharedpref = getSharedPreferences("welcomeinfo", Context.MODE_PRIVATE);
        final SharedPreferences.Editor editor = sharedpref.edit();

        checkmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(checkmessage.isChecked()){
                    editor.putString("welcomebool", "true");
                    editor.apply();
                }
                else{
                    editor.putString("welcomebool", "false");
                    editor.apply();
                }
            }
        });
    }


    public void onClickSkipWelcome(View view) {

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
    }


    public void onClickNextWelcomeOne(View view) {

        Intent intent = new Intent(this, Welcome2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
    }

}

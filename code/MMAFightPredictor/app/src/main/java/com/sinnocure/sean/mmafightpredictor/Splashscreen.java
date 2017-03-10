package com.sinnocure.sean.mmafightpredictor;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class Splashscreen extends Activity {

    Thread splashThread;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        StartAnimations();
    }


    private void StartAnimations() {

        SharedPreferences sharedpref = getSharedPreferences("welcomeinfo", Context.MODE_PRIVATE);
        final String welcomebool = sharedpref.getString("welcomebool", "");

        Animation anim = AnimationUtils.loadAnimation(this, R.anim.fadein);
        anim.reset();
        LinearLayout l=(LinearLayout) findViewById(R.id.lin_lay);
        l.clearAnimation();
        l.startAnimation(anim);

        splashThread = new Thread() {
            @Override
            public void run() {
                try {
                    int waited = 0;
                    // Splash screen pause time
                    while (waited < 3500) {
                        sleep(100);
                        waited += 100;
                    }

                    if(welcomebool.equals("true")) {
                        Intent intent = new Intent(Splashscreen.this,
                                MainActivity.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                        Splashscreen.this.finish();
                    }
                    else{
                        Intent intent = new Intent(Splashscreen.this,
                                Welcome1.class);
                        intent.setFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
                        startActivity(intent);
                        Splashscreen.this.finish();
                    }

                } catch (InterruptedException e) {
                } finally {
                    Splashscreen.this.finish();
                }
            }
        };
        splashThread.start();
    }
}

package com.sinnocure.sean.mmafightpredictor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

public class ResultLoadScreen extends AppCompatActivity {
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
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        anim.reset();
        LinearLayout l =(LinearLayout) findViewById(R.id.lin_lay);
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

                    // depending on which mode the user is in, this animation ending
                    // will bring the user to a different results screen

                    // create globalVariable to work with getters and setters from GlobalClass
                    final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

                    // if user chose to build their own algorithm
                    if (globalVariable.isUserChoseToBuildAlgorithm()) {
                        Intent intent = new Intent(ResultLoadScreen.this, UserAlgorithmResult.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
                    }
                    // else user is getting prediction from our algorithm
                    else {
                        Intent intent = new Intent(ResultLoadScreen.this, OurAlgorithmResult.class);
                        startActivity(intent);
                        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
                    }


                    ResultLoadScreen.this.finish();
                } catch (InterruptedException e) {
                } finally {
                    ResultLoadScreen.this.finish();
                }
            }
        };
        splashThread.start();

    }
}

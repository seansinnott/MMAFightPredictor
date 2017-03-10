package com.sinnocure.sean.mmafightpredictor;


import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class CreateAlgorithm extends AppCompatActivity {

    private TextView reachText;
    private TextView heightText;
    private TextView weightText;
    private TextView ageText;
    private TextView strikingText;
    private TextView BJJText;
    private TextView wrestlingText;
    private TextView streakText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.create_algorithm);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // create globalVariable to work with getters and setters from GlobalClass
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // Seekbar for Importance of Reach
        reachText = (TextView) findViewById(R.id.reachtext);
        SeekBar reachBar = (SeekBar) findViewById(R.id.reachbar);
        reachBar.setProgress(globalVariable.getUserChosenReach());
        reachText.setText(getString(R.string.reach_importance) + " " + reachBar.getProgress());
        reachBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        reachBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        reachBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                reachText.setText(getString(R.string.reach_importance) + " " + i);
                globalVariable.setUserChosenReach(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Seekbar for Importance of Height
        heightText = (TextView) findViewById(R.id.heightText);
        SeekBar heightBar = (SeekBar) findViewById(R.id.heightBar);
        heightBar.setProgress(globalVariable.getUserChosenHeight());
        heightText.setText(getString(R.string.height_importance) + " " + heightBar.getProgress());
        heightBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        heightBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        heightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                heightText.setText(getString(R.string.height_importance) + " " + i);
                globalVariable.setUserChosenHeight(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Seekbar for Importance of Weight
        weightText = (TextView) findViewById(R.id.weightText);
        SeekBar weightBar = (SeekBar) findViewById(R.id.weightBar);
        weightBar.setProgress(globalVariable.getUserChosenWeight());
        weightText.setText(getString(R.string.weight_importance) + " " + weightBar.getProgress());
        weightBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        weightBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        weightBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                weightText.setText(getString(R.string.weight_importance) + " " + i);
                globalVariable.setUserChosenWeight(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Seekbar for Importance of Age
        ageText = (TextView) findViewById(R.id.ageText);
        SeekBar ageBar = (SeekBar) findViewById(R.id.ageBar);
        ageBar.setProgress(globalVariable.getUserChosenAge());
        ageText.setText(getString(R.string.age_importance) + " " + ageBar.getProgress());
        ageBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        ageBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        ageBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                ageText.setText(getString(R.string.age_importance) + " " + i);
                globalVariable.setUserChosenAge(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Seekbar for Importance of Striking
        strikingText = (TextView) findViewById(R.id.strikeText);
        SeekBar strikingBar = (SeekBar) findViewById(R.id.strikeBar);
        strikingBar.setProgress(globalVariable.getUserChosenStriking());
        strikingText.setText(getString(R.string.striking_importance) + " " + strikingBar.getProgress());
        strikingBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        strikingBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        strikingBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                strikingText.setText(getString(R.string.striking_importance) + " " + i);
                globalVariable.setUserChosenStriking(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Seekbar for Importance of Brazilian Jiu Jitsu
        BJJText = (TextView) findViewById(R.id.BJJText);
        SeekBar BJJBar = (SeekBar) findViewById(R.id.BJJBar);
        BJJBar.setProgress(globalVariable.getUserChosenBJJ());
        BJJText.setText(getString(R.string.bjj_importance) + " " + BJJBar.getProgress());
        BJJBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        BJJBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        BJJBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                BJJText.setText(getString(R.string.bjj_importance) + " " + i);
                globalVariable.setUserChosenBJJ(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Seekbar for Importance of Wrestling
        wrestlingText = (TextView) findViewById(R.id.wrestlingText);
        SeekBar wrestlingBar = (SeekBar) findViewById(R.id.wrestlingBar);
        wrestlingBar.setProgress(globalVariable.getUserChosenWrestling());
        wrestlingText.setText(getString(R.string.wrestling_importance) + " " + wrestlingBar.getProgress());
        wrestlingBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        wrestlingBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        wrestlingBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                wrestlingText.setText(getString(R.string.wrestling_importance) + " " + i);
                globalVariable.setUserChosenWrestling(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });


        // Seekbar for Importance of Fighter's Current Form
        streakText = (TextView) findViewById(R.id.streakText);
        SeekBar streakBar = (SeekBar) findViewById(R.id.streakBar);
        streakBar.setProgress(globalVariable.getUserChosenStreak());
        streakText.setText(getString(R.string.current_form_importance) + " " + streakBar.getProgress());
        streakBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        streakBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        streakBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                streakText.setText(getString(R.string.current_form_importance) + " " + i);
                globalVariable.setUserChosenStreak(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    public void OnClickCreateAlgorithmGoButton(View view) {
        Intent intent = new Intent(this, UserOpinion.class);
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
            Intent intent = new Intent(CreateAlgorithm.this, Contact.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
        }
        if(id == R.id.helpbutt){
            Intent intent = new Intent(CreateAlgorithm.this, Welcome1.class);
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

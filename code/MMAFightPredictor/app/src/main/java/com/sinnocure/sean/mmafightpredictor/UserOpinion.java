package com.sinnocure.sean.mmafightpredictor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;

public class UserOpinion extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.user_opinion);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //create globalVariable to work with getters and setters from GlobalClass..
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // get names of fighters that user chose on previous screen
        final String fighterA = globalVariable.getNameFighterA();
        final String fighterB = globalVariable.getNameFighterB();

        TextView nameA = (TextView) findViewById(R.id.nameA);
        TextView nameB = (TextView) findViewById(R.id.nameB);

        nameA.setText(fighterA);
        nameB.setText(fighterB);


        // Get user opinion on Striking

        int strikingAdv = globalVariable.getUserChosenStrikingAdvantage();
        final TextView strikeText = (TextView) findViewById(R.id.strikestatus);
        SeekBar strikeBar = (SeekBar) findViewById(R.id.opinionstrike);
        strikeBar.setProgress(strikingAdv);

        if (strikingAdv == 0) {
            strikeText.setText(getString(R.string.sig_striking_advantage) + " " + fighterA);
        }
        else if (strikingAdv == 1) {
            strikeText.setText(getString(R.string.slight_striking_advantage) + " " + fighterA);
        }
        else if (strikingAdv == 3){
            strikeText.setText(getString(R.string.slight_striking_advantage) + " " + fighterB);
        }
        else if (strikingAdv == 4) {
            strikeText.setText(getString(R.string.sig_striking_advantage) + " " + fighterB);
        }
        else {
            strikeText.setText(getString(R.string.neutral));
        }


        // design SeekBar
        strikeBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        strikeBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        // record any changes made to the SeekBar by the user
        strikeBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if (i == 0) {
                    strikeText.setText(getString(R.string.sig_striking_advantage) + " " + fighterA);
                } else if (i == 1) {
                    strikeText.setText(getString(R.string.slight_striking_advantage) + " " + fighterA);
                } else if (i == 2) {
                    strikeText.setText(getString(R.string.neutral));
                } else if (i == 3) {
                    strikeText.setText(getString(R.string.slight_striking_advantage) + " " + fighterB);
                } else if (i == 4) {
                    strikeText.setText(getString(R.string.sig_striking_advantage) + " " + fighterB);
                }
                // set the change globally
                globalVariable.setUserChosenStrikingAdvantage(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        // Get user Opinion on Brazilian Jiu Jitsu
        int bjjAdv = globalVariable.getUserChosenJiuJitsuAdvantage();
        final TextView bjjText = (TextView) findViewById(R.id.bjjstatus);
        SeekBar bjjBar = (SeekBar) findViewById(R.id.opinionbjj);
        bjjBar.setProgress(bjjAdv);

        if (bjjAdv == 0) {
            bjjText.setText(getString(R.string.sig_bjj_advantage) + " " + fighterA);
        }
        else if (bjjAdv == 1) {
            bjjText.setText(getString(R.string.slight_bjj_advantage) + " " + fighterA);
        }
        else if (bjjAdv == 3){
            bjjText.setText(getString(R.string.slight_bjj_advantage) + " " + fighterB);
        }
        else if (bjjAdv == 4) {
            bjjText.setText(getString(R.string.sig_bjj_advantage) + " " + fighterB);
        }
        else {
            bjjText.setText(getString(R.string.neutral));
        }

        // design SeekBar
        bjjBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        bjjBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        // record any changes made to the SeekBar by the user
        bjjBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(i == 0) {
                    bjjText.setText(getString(R.string.sig_bjj_advantage) + " " + fighterA);
                }
                else if(i == 1){
                    bjjText.setText(getString(R.string.slight_bjj_advantage) + " " + fighterA);
                }
                else if(i == 2){
                    bjjText.setText(getString(R.string.neutral));
                }
                else if(i == 3){
                    bjjText.setText(getString(R.string.slight_bjj_advantage) + " " + fighterB);
                }
                else if(i == 4){
                    bjjText.setText(getString(R.string.sig_bjj_advantage) + " " + fighterB);
                }
                // set the change globally
                globalVariable.setUserChosenJiuJitsuAdvantage(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



        // Get user opinion on Wrestling
        int wrestlingAdv = globalVariable.getUserChosenWrestlingAdvantage();
        final TextView wrestlingText = (TextView) findViewById(R.id.wrestlingstatus);
        SeekBar wrestlingBar = (SeekBar) findViewById(R.id.opinionwrestling);
        wrestlingBar.setProgress(wrestlingAdv);

        if (wrestlingAdv == 0) {
            wrestlingText.setText(getString(R.string.sig_wrestling_advantage) + " " + fighterA);
        }
        else if (wrestlingAdv == 1) {
            wrestlingText.setText(getString(R.string.slight_wrestling_advantage) + " " + fighterA);
        }
        else if (wrestlingAdv == 3){
            wrestlingText.setText(getString(R.string.slight_wrestling_advantage) + " " + fighterB);
        }
        else if (wrestlingAdv == 4) {
            wrestlingText.setText(getString(R.string.sig_wrestling_advantage) + " " + fighterB);
        }
        else {
            wrestlingText.setText(getString(R.string.neutral));
        }

        // start the opinion on neutral and allow user to change from there
        wrestlingText.setText(getString(R.string.neutral));

        // design SeekBar
        wrestlingBar.getProgressDrawable().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);
        wrestlingBar.getThumb().setColorFilter(Color.RED, PorterDuff.Mode.SRC_IN);

        // record any changes made to the SeekBar by the user
        wrestlingBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                if(i == 0) {
                    wrestlingText.setText(getString(R.string.sig_wrestling_advantage) + " " + fighterA);
                }
                else if(i == 1){
                    wrestlingText.setText(getString(R.string.slight_wrestling_advantage) + " " + fighterA);
                }
                else if(i == 2){
                    wrestlingText.setText(getString(R.string.neutral));
                }
                else if(i == 3){
                    wrestlingText.setText(getString(R.string.slight_wrestling_advantage) + " " + fighterB);
                }
                else if(i == 4){
                    wrestlingText.setText(getString(R.string.sig_wrestling_advantage) + " " + fighterB);
                }
                // set the change globally
                globalVariable.setUserChosenWrestlingAdvantage(i);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void onClickUserOpinionNext(View view) {
        Intent intent = new Intent(this, ResultLoadScreen.class);
        startActivity(intent);
        overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
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

        if (id == R.id.contactbutt) {
            Intent intent = new Intent(UserOpinion.this, Contact.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
        }
        if(id == R.id.helpbutt){
            Intent intent = new Intent(UserOpinion.this, Welcome1.class);
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

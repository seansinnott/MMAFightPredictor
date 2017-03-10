package com.sinnocure.sean.mmafightpredictor;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class UserAlgorithmResult extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.result);

        //lock screen orientation to portrait..
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // create globalVariable to work with getters and setters from GlobalClass..
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // get names of fighters from global class
        String fighterA = globalVariable.getNameFighterA();
        String fighterB = globalVariable.getNameFighterB();

        // all the info that will be shown to the user on the screen
        TextView textView = (TextView) findViewById(R.id.nametxt);
        TextView resultstxt = (TextView) findViewById(R.id.resulttxt);
        ImageView resultimg = (ImageView) findViewById(R.id.resultimg);
        TextView percent = (TextView) findViewById(R.id.percenttotal);

        int [] results = calculateWinner();

        // if fighter A should beat fighter B
        if(results[0] > results[1]){
            resultstxt.setText(getString(R.string.winner_msg));
            textView.setText(fighterA);
            if (results[0] >= 100) {
                results[0] = 99;
            }
            percent.setText(Integer.toString(results[0]) + "%");
            resultimg.setImageResource(R.drawable.championbelt);
        }
        // else if fighter B should beat fighter A
        else if(results[1] > results[0]){
            resultstxt.setText(getString(R.string.winner_msg));
            textView.setText(fighterB);
            if (results[1] >= 100) {
                results[1] = 99;
            }
            percent.setText(Integer.toString(results[1]) + "%");
            resultimg.setImageResource(R.drawable.championbelt);
        }
        // else it is a draw
        else {
            resultstxt.setText(getString(R.string.draw_msg));
            textView.setText(getString(R.string.draw));
            resultimg.setImageResource(R.drawable.handshake);
        }
    }


    public int [] calculateWinner() {

        // create globalVariable to work with getters and setters from GlobalClass..
        final GlobalClass globalVariable = (GlobalClass) getApplicationContext();

        // start the totals of both fighters on 50
        int totalFighterA = 50;
        int totalFighterB = 50;

        // get all the algorithm building info that the user entered and store it in variables
        final String fighterA = globalVariable.getNameFighterA();
        final String fighterB = globalVariable.getNameFighterB();
        final int reachWeight = globalVariable.getUserChosenReach();
        final int heightWeight = globalVariable.getUserChosenHeight();
        final int weightWeight = globalVariable.getUserChosenWeight();
        final int ageWeight = globalVariable.getUserChosenAge();
        final int strikingWeight = globalVariable.getUserChosenStriking();
        final int BJJWeight = globalVariable.getUserChosenBJJ();
        final int wrestlingWeight = globalVariable.getUserChosenWrestling();
        final int streakWeight = globalVariable.getUserChosenStreak();
        final int strikeOpinion = globalVariable.getUserChosenStrikingAdvantage();
        final int opinionBJJ = globalVariable.getUserChosenJiuJitsuAdvantage();
        final int wrestlingOpinion = globalVariable.getUserChosenWrestlingAdvantage();

        // Database object to retrieve fighter info from database
        DatabaseHelper dbhelper = new DatabaseHelper(getApplicationContext());

        // retrieve all data about the two chosen fighters from the database and store it in these variables
        int reachA = dbhelper.getReach(fighterA);
        int reachB = dbhelper.getReach(fighterB);
        int heightA = dbhelper.getHeight(fighterA);
        int heightB = dbhelper.getHeight(fighterB);
        int weightA = dbhelper.getWeight(fighterA);
        int weightB = dbhelper.getWeight(fighterB);
        int ageA = dbhelper.getAge(fighterA);
        int ageB = dbhelper.getAge(fighterB);
        int koA = dbhelper.getNumKos(fighterA);
        int koB = dbhelper.getNumKos(fighterB);
        int kodA = dbhelper.getNumKnockedOut(fighterA);
        int kodB = dbhelper.getNumKnockedOut(fighterB);
        int subA = dbhelper.getNumSubs(fighterA);
        int subB = dbhelper.getNumSubs(fighterB);
        int subdA = dbhelper.getNumSubbed(fighterA);
        int subdB = dbhelper.getNumSubbed(fighterB);
        int winstreakA = dbhelper.getWinstreak(fighterA);
        int winstreakB = dbhelper.getWinstreak(fighterB);
        int losestreakA = dbhelper.getLosestreak(fighterA);
        int losestreakB = dbhelper.getLosestreak(fighterB);


        // THE USER'S CALCULATION ALGORITHM:.....

        // calculate reach
        if (reachA > reachB) {
            if ( (reachA - reachB) >= 2) {
                totalFighterA += reachWeight;
                totalFighterB -= reachWeight;
            }
        }
        if (reachB > reachA) {
            if ( (reachB - reachA) >= 2) {
                totalFighterA -= reachWeight;
                totalFighterB += reachWeight;
            }
        }

        // calculate weight
        if (weightA > weightB) {
            if ( (weightA - weightB) >= 5) {
                totalFighterA += weightWeight;
                totalFighterB -= weightWeight;
            }
        }
        if (weightB > weightA) {
            if ( (weightB - weightA) >= 5) {
                totalFighterA -= weightWeight;
                totalFighterB += weightWeight;
            }
        }

        // calculate height
        if (heightA > heightB) {
            if ( (heightA - heightB) >= 5) {
                totalFighterA += heightWeight;
                totalFighterB -= heightWeight;
            }
        }
        if (heightB > heightA) {
            if ( (heightB - heightA) >= 5) {
                totalFighterA -= heightWeight;
                totalFighterB += heightWeight;
            }
        }

        // calculate age
        boolean badAgeFighterA = false;
        boolean badAgeFighterB = false;
        if (ageA >= 35 || ageA <= 23) {
            badAgeFighterA = true;
            totalFighterA -= ageWeight;
            totalFighterB += ageWeight;
        }

        if (ageB >= 35 || ageB <= 23) {
            badAgeFighterB = true;
            totalFighterA += ageWeight;
            totalFighterB -= ageWeight;
        }
        if (badAgeFighterA && !badAgeFighterB) {
            totalFighterA -= ageWeight;
            totalFighterB += ageWeight;
        }
        if (badAgeFighterB && !badAgeFighterA) {
            totalFighterA += ageWeight;
            totalFighterB -= ageWeight;
        }

        // calculate striking
        if (strikeOpinion == 0) { // fighter A has much better striking
            totalFighterA += strikingWeight;
            totalFighterB -= strikingWeight;
        }
        if (strikeOpinion == 1) { // fighter A has better striking
            totalFighterA += (strikingWeight*0.625);                // multiply by 0.625 because Genetic Algorithm for this algorithm came up with 5 for better striking
            totalFighterB -= (strikingWeight*0.625);                // and 8 for much better striking so we take the value chosen by the user and divide it by 5/8
        }
        if (strikeOpinion == 3) { // fighter B has better striking
            totalFighterA -= (strikingWeight*0.625);
            totalFighterB += (strikingWeight*0.625);
        }
        if (strikeOpinion == 4) { // fighter B has much better striking
            totalFighterA -= strikingWeight;
            totalFighterB += strikingWeight;
        }

        // calculate jiu jitsu
        if (opinionBJJ == 0) { // fighter A has much better jiu jitsu
            totalFighterA += BJJWeight;
            totalFighterB -= BJJWeight;
        }
        if (opinionBJJ == 1) { // fighter A has better jiu jitsu
            totalFighterA += (BJJWeight*0.125);                // multiply by 0.125 because Genetic Algorithm for this algorithm came up with 1 for better striking
            totalFighterB -= (BJJWeight*0.125);                // and 8 for much better striking so we take the value chosen by the user and divide it by 1/8
        }
        if (opinionBJJ == 3) { // fighter B has better jiu jitsu
            totalFighterA -= (BJJWeight*0.125);
            totalFighterB += (BJJWeight*0.125);
        }
        if (opinionBJJ == 4) { // fighter B has much better jiu jitsu
            totalFighterA -= BJJWeight;
            totalFighterB += BJJWeight;
        }

        // calculate wrestling
        if (wrestlingOpinion == 0) { // fighter A has much better wrestling
            totalFighterA += wrestlingWeight;
            totalFighterB -= wrestlingWeight;
        }
        if (wrestlingOpinion == 1) { // fighter A has better wrestling
            totalFighterA += (wrestlingWeight*0.166);                // multiply by 0.166 because Genetic Algorithm for this algorithm came up with 1 for better striking
            totalFighterB -= (wrestlingWeight*0.166);                // and 6 for much better striking so we take the value chosen by the user and divide it by 1/6
        }
        if (wrestlingOpinion == 3) { // fighter B has better wrestling
            totalFighterA -= (wrestlingWeight*0.166);
            totalFighterB += (wrestlingWeight*0.166);
        }
        if (wrestlingOpinion == 4) { // fighter B has much better wrestling
            totalFighterA -= wrestlingWeight;
            totalFighterB += wrestlingWeight;
        }

        // calculate knockouts
        if (kodA >= 4) {
            totalFighterA -= strikingWeight;
            totalFighterB += strikingWeight;
        }
        if (kodB >= 4) {
            totalFighterA += strikingWeight;
            totalFighterB -= strikingWeight;
        }
        if (koA >= 3 && kodB >= 3) {
            totalFighterA += strikingWeight;
            totalFighterB -= strikingWeight;
        }
        if (koB >= 3 && kodA >= 3) {
            totalFighterA -= strikingWeight;
            totalFighterB += strikingWeight;
        }

        // calculate submissions
        if (subA >= 3 && subdB >= 3) {
            totalFighterA += BJJWeight;
            totalFighterB -= BJJWeight;
        }
        if (subB >= 3 && subdA >= 3) {
            totalFighterA -= BJJWeight;
            totalFighterB += BJJWeight;
        }

        // calculate win/lose streaks
        if (winstreakA == 1) {
            totalFighterA += streakWeight;
            totalFighterB -= streakWeight;
        }
        if (winstreakB == 1) {
            totalFighterB += streakWeight;
            totalFighterA -= streakWeight;
        }
        if (losestreakA == 1) {
            totalFighterB += streakWeight;
            totalFighterA -= streakWeight;
        }
        if (losestreakB == 1) {
            totalFighterA += streakWeight;
            totalFighterB -= streakWeight;
        }

        return new int[]{totalFighterA, totalFighterB};
    }

    public void onClickReturnHomeButton(View view) {
        Intent intent = new Intent(this, MainActivity.class);
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

        //noinspection SimplifiableIfStatement
        if (id == R.id.contactbutt) {
            Intent intent = new Intent(UserAlgorithmResult.this, Contact.class);
            startActivity(intent);
            overridePendingTransition(R.anim.slidenewactin, R.anim.slideoldactout);
        }
        if(id == R.id.helpbutt){
            Intent intent = new Intent(UserAlgorithmResult.this, Welcome1.class);
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

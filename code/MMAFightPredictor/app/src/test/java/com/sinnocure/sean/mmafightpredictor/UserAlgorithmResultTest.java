package com.sinnocure.sean.mmafightpredictor;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by Sean on 03/03/2017.
 */
public class UserAlgorithmResultTest {
    @Test
    public void calculateWinner() throws Exception {
        // unit test involving just values, no getters, no setters, no calls to database..

        // data weights:
        int reachWeight = 1;
        int weightWeight = 3;
        int heightWeight = 1;
        int ageWeight = 1;
        int strikingWeight = 10;
        int BJJWeight = 8;
        int wrestlingWeight = 8;
        int knockoutsWeight = 2;
        int submissionsWeight = 1;
        int streakWeight = 3;
        int strikeOpinion = 4; // meaning fighterB has much better striking
        int opinionBJJ = 0; // meaning fighterA has much better jiu jitsu
        int wrestlingOpinion = 2; // meaning neither fighter is better at wrestling


        // fighter attributes:
        int reachA = 72;
        int reachB = 75;
        int heightA = 185;
        int heightB = 180;
        int weightA = 170;
        int weightB = 170;
        int ageA = 39;
        int ageB = 34;
        int koA = 3;
        int koB = 7;
        int kodA = 1;
        int kodB = 0;
        int subA = 12;
        int subB = 1;
        int subdA = 0;
        int subdB = 0;
        int winstreakA = 1;
        int winstreakB = 1;
        int losestreakA = 0;
        int losestreakB = 0;


        // set the fighter totals:
        int totalFighterA = 50;
        int totalFighterB = 50;


        // copy/paste the code from this method to here:

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

        // fighterA should now be on a total of 49
        // and fighterB should be on a total of 51:
        assertEquals(49, totalFighterA);
        assertEquals(51, totalFighterB);


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

        // fighterA should now be on a total of 49
        // and fighterB should be on a total of 51:
        assertEquals(49, totalFighterA);
        assertEquals(51, totalFighterB);

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

        // fighterA should now be on a total of 50
        // and fighterB should be on a total of 50:
        assertEquals(50, totalFighterA);
        assertEquals(50, totalFighterB);

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

        // fighterA should now be on a total of 48
        // and fighterB should be on a total of 52:
        assertEquals(48, totalFighterA);
        assertEquals(52, totalFighterB);

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

        // fighterA should now be on a total of 38
        // and fighterB should be on a total of 62:
        assertEquals(38, totalFighterA);
        assertEquals(62, totalFighterB);

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

        // fighterA should now be on a total of 46
        // and fighterB should be on a total of 54:
        assertEquals(46, totalFighterA);
        assertEquals(54, totalFighterB);

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

        // fighterA should now be on a total of 46
        // and fighterB should be on a total of 54:
        assertEquals(46, totalFighterA);
        assertEquals(54, totalFighterB);

        // calculate knockouts
        if (kodA >= 4) {
            totalFighterA -= knockoutsWeight;
            totalFighterB += knockoutsWeight;
        }
        if (kodB >= 4) {
            totalFighterA += knockoutsWeight;
            totalFighterB -= knockoutsWeight;
        }
        if (koA >= 3 && kodB >= 3) {
            totalFighterA += knockoutsWeight;
            totalFighterB -= knockoutsWeight;
        }
        if (koB >= 3 && kodA >= 3) {
            totalFighterA -= knockoutsWeight;
            totalFighterB += knockoutsWeight;
        }

        // fighterA should now be on a total of 46
        // and fighterB should be on a total of 54:
        assertEquals(46, totalFighterA);
        assertEquals(54, totalFighterB);

        // calculate submissions
        if (subA >= 3 && subdB >= 3) {
            totalFighterA += submissionsWeight;
            totalFighterB -= submissionsWeight;
        }
        if (subB >= 3 && subdA >= 3) {
            totalFighterA -= submissionsWeight;
            totalFighterB += submissionsWeight;
        }

        // fighterA should now be on a total of 46
        // and fighterB should be on a total of 54:
        assertEquals(46, totalFighterA);
        assertEquals(54, totalFighterB);

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


        // after performing this calculation with this data and weights
        // fighterA should be on a total of 46
        // and fighterB should be on a total of 54:
        assertEquals(46, totalFighterA);
        assertEquals(54, totalFighterB);
    }

}
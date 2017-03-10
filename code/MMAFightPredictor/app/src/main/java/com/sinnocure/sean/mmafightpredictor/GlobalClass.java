package com.sinnocure.sean.mmafightpredictor;
import android.app.Application;

public class GlobalClass extends Application{
    private boolean userChoseToBuildAlgorithm = false;
    private String nameFighterA;
    private String nameFighterB;
    private int userChosenReach;
    private int userChosenHeight;
    private int userChosenWeight;
    private int userChosenAge;
    private int userChosenStriking;
    private int userChosenBJJ;
    private int userChosenWrestling;
    private int userChosenStreak;
    private int userChosenStrikingAdvantage;
    private int userChosenJiuJitsuAdvantage;
    private int userChosenWrestlingAdvantage;
    private boolean userGivingOpinion = false;


    public void resetAllValues() {
        userChosenReach = 5;
        userChosenHeight = 5;
        userChosenWeight = 5;
        userChosenAge = 5;
        userChosenStriking = 5;
        userChosenBJJ = 5;
        userChosenWrestling = 5;
        userChosenStreak = 5;
        userChosenStrikingAdvantage = 2;
        userChosenJiuJitsuAdvantage = 2;
        userChosenWrestlingAdvantage = 2;
    }


    // all getters and setters..

    public boolean isUserChoseToBuildAlgorithm() {
        return userChoseToBuildAlgorithm;
    }


    public void setUserChoseToBuildAlgorithm(boolean userChoseToBuildAlgorithm) {
        this.userChoseToBuildAlgorithm = userChoseToBuildAlgorithm;
    }


    public String getNameFighterA() {
        return nameFighterA;
    }


    public void setNameFighterA(String nameFighterA) {
        this.nameFighterA = nameFighterA;
    }


    public String getNameFighterB() {
        return nameFighterB;
    }


    public void setNameFighterB(String nameFighterB) {
        this.nameFighterB = nameFighterB;
    }

    public int getUserChosenReach() {
        return userChosenReach;
    }


    public void setUserChosenReach(int userChosenReach) {
        this.userChosenReach = userChosenReach;
    }


    public int getUserChosenHeight() {
        return userChosenHeight;
    }


    public void setUserChosenHeight(int userChosenHeight) {
        this.userChosenHeight = userChosenHeight;
    }


    public int getUserChosenWeight() {
        return userChosenWeight;
    }


    public void setUserChosenWeight(int userChosenWeight) {
        this.userChosenWeight = userChosenWeight;
    }


    public int getUserChosenAge() {
        return userChosenAge;
    }


    public void setUserChosenAge(int userChosenAge) {
        this.userChosenAge = userChosenAge;
    }


    public int getUserChosenStriking() {
        return userChosenStriking;
    }


    public void setUserChosenStriking(int userChosenStriking) {
        this.userChosenStriking = userChosenStriking;
    }


    public int getUserChosenBJJ() {
        return userChosenBJJ;
    }


    public void setUserChosenBJJ(int userChosenBJJ) {
        this.userChosenBJJ = userChosenBJJ;
    }


    public int getUserChosenWrestling() {
        return userChosenWrestling;
    }


    public void setUserChosenWrestling(int userChosenWrestling) {
        this.userChosenWrestling = userChosenWrestling;
    }


    public int getUserChosenStreak() {
        return userChosenStreak;
    }


    public void setUserChosenStreak(int userChosenStreak) {
        this.userChosenStreak = userChosenStreak;
    }


    public int getUserChosenStrikingAdvantage() {
        return userChosenStrikingAdvantage;
    }


    public void setUserChosenStrikingAdvantage(int userChosenStrikingAdvantage) {
        this.userChosenStrikingAdvantage = userChosenStrikingAdvantage;
    }


    public int getUserChosenJiuJitsuAdvantage() {
        return userChosenJiuJitsuAdvantage;
    }


    public void setUserChosenJiuJitsuAdvantage(int userChosenJiuJitsuAdvantage) {
        this.userChosenJiuJitsuAdvantage = userChosenJiuJitsuAdvantage;
    }


    public int getUserChosenWrestlingAdvantage() {
        return userChosenWrestlingAdvantage;
    }


    public void setUserChosenWrestlingAdvantage(int userChosenWrestlingAdvantage) {
        this.userChosenWrestlingAdvantage = userChosenWrestlingAdvantage;
    }


    public boolean isUserGivingOpinion() {
        return userGivingOpinion;
    }


    public void setUserGivingOpinion(boolean userGivingOpinion) {
        this.userGivingOpinion = userGivingOpinion;
    }
}

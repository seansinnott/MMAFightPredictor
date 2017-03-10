package com.sinnocure.sean.mmafightpredictor;

import org.junit.Test;

import static org.junit.Assert.*;


public class GlobalClassTest {
    GlobalClass gc = new GlobalClass();

    @Test
    public void isUserChoseToBuildAlgorithm() throws Exception {
        boolean shouldBeFalse = gc.isUserChoseToBuildAlgorithm();
        // should be false from the start
        assertFalse(shouldBeFalse);
    }

    @Test
    public void setUserChoseToBuildAlgorithm() throws Exception {
        gc.setUserChoseToBuildAlgorithm(true);
        boolean shouldNowBeTrue = gc.isUserChoseToBuildAlgorithm();
        // should now be equal to true after the setter did it's job
        assertTrue(shouldNowBeTrue);
    }

    @Test
    public void getNameFighterA() throws Exception {
        String s = gc.getNameFighterA();
        // should be null from the start
        assertEquals(null, s);
    }

    @Test
    public void setNameFighterA() throws Exception {
        gc.setNameFighterA("test");
        String s = gc.getNameFighterA();
        // should now be "test" after the setter did it's job
        assertEquals("test", s);
    }

    @Test
    public void getNameFighterB() throws Exception {
        String s = gc.getNameFighterB();
        // should be null from the start
        assertEquals(null, s);
    }

    @Test
    public void setNameFighterB() throws Exception {
        gc.setNameFighterB("test");
        String s = gc.getNameFighterB();
        // should now be "test" after the setter did it's job
        assertEquals("test", s);
    }

    @Test
    public void getUserChosenReach() throws Exception {
        int i = gc.getUserChosenReach();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenReach() throws Exception {
        gc.setUserChosenReach(7357);
        int i = gc.getUserChosenReach();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenHeight() throws Exception {
        int i = gc.getUserChosenHeight();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenHeight() throws Exception {
        gc.setUserChosenHeight(7357);
        int i = gc.getUserChosenHeight();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenWeight() throws Exception {
        int i = gc.getUserChosenWeight();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenWeight() throws Exception {
        gc.setUserChosenWeight(7357);
        int i = gc.getUserChosenWeight();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenAge() throws Exception {
        int i = gc.getUserChosenAge();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenAge() throws Exception {
        gc.setUserChosenAge(7357);
        int i = gc.getUserChosenAge();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenStriking() throws Exception {
        int i = gc.getUserChosenStriking();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenStriking() throws Exception {
        gc.setUserChosenStriking(7357);
        int i = gc.getUserChosenStriking();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenBJJ() throws Exception {
        int i = gc.getUserChosenBJJ();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenBJJ() throws Exception {
        gc.setUserChosenBJJ(7357);
        int i = gc.getUserChosenBJJ();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenWrestling() throws Exception {
        int i = gc.getUserChosenWrestling();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenWrestling() throws Exception {
        gc.setUserChosenWrestling(7357);
        int i = gc.getUserChosenWrestling();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenStreak() throws Exception {
        int i = gc.getUserChosenStreak();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenStreak() throws Exception {
        gc.setUserChosenStreak(7357);
        int i = gc.getUserChosenStreak();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenStrikingAdvantage() throws Exception {
        int i = gc.getUserChosenStrikingAdvantage();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenStrikingAdvantage() throws Exception {
        gc.setUserChosenStrikingAdvantage(7357);
        int i = gc.getUserChosenStrikingAdvantage();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenJiuJitsuAdvantage() throws Exception {
        int i = gc.getUserChosenJiuJitsuAdvantage();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenJiuJitsuAdvantage() throws Exception {
        gc.setUserChosenJiuJitsuAdvantage(7357);
        int i = gc.getUserChosenJiuJitsuAdvantage();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void getUserChosenWrestlingAdvantage() throws Exception {
        int i = gc.getUserChosenWrestlingAdvantage();
        // should be null from the start
        assertEquals(0, i);
    }

    @Test
    public void setUserChosenWrestlingAdvantage() throws Exception {
        gc.setUserChosenWrestlingAdvantage(7357);
        int i = gc.getUserChosenWrestlingAdvantage();
        // should now be 7357 after the setter did it's job
        assertEquals(7357, i);
    }

    @Test
    public void isUserGivingOpinion() throws Exception {
        boolean shouldBeFalse = gc.isUserGivingOpinion();
        // should be false from the start
        assertFalse(shouldBeFalse);
    }

    @Test
    public void setUserGivingOpinion() throws Exception {
        gc.setUserGivingOpinion(true);
        boolean shouldNowBeTrue = gc.isUserGivingOpinion();
        // should now be equal to true after the setter did it's job
        assertTrue(shouldNowBeTrue);
    }


    @Test
    public void resetAllValues() throws Exception {
        // give a new value to all variables that this method should reset
        gc.setUserChosenReach(7357);
        gc.setUserChosenHeight(7357);
        gc.setUserChosenWeight(7357);
        gc.setUserChosenAge(7357);
        gc.setUserChosenStriking(7357);
        gc.setUserChosenBJJ(7357);
        gc.setUserChosenWrestling(7357);
        gc.setUserChosenStreak(7357);
        gc.setUserChosenStrikingAdvantage(7357);
        gc.setUserChosenJiuJitsuAdvantage(7357);
        gc.setUserChosenWrestlingAdvantage(7357);

        // call the reset method
        gc.resetAllValues();

        // now check that all the variables have been reset to what they were originally
        assertEquals(5, gc.getUserChosenReach());
        assertEquals(5, gc.getUserChosenHeight());
        assertEquals(5, gc.getUserChosenWeight());
        assertEquals(5, gc.getUserChosenAge());
        assertEquals(5, gc.getUserChosenStriking());
        assertEquals(5, gc.getUserChosenBJJ());
        assertEquals(5, gc.getUserChosenWrestling());
        assertEquals(5, gc.getUserChosenStreak());
        assertEquals(2, gc.getUserChosenStrikingAdvantage());
        assertEquals(2, gc.getUserChosenJiuJitsuAdvantage());
        assertEquals(2, gc.getUserChosenWrestlingAdvantage());
    }
}
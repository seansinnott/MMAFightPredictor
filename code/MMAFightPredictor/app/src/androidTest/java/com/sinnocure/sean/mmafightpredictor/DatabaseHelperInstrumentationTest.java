package com.sinnocure.sean.mmafightpredictor;

import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.io.IOException;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertNotEquals;

@RunWith(AndroidJUnit4.class)
public class DatabaseHelperInstrumentationTest {

    private DatabaseHelper db;

    // Before each test, create the database on the target test device
    @Before
    public void setUp(){
        db = new DatabaseHelper(InstrumentationRegistry.getTargetContext());
        try {
            db.createDatabaseOnDevice();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // After each test, close the database on the target test device
    @After
    public void tearDown() {
        db.close();
    }


    @Test
    public void createDatabaseOnDevice() throws Exception {
        // before this test, this method will have been called
        // and if it did it's job, a database should now exist on
        // the target test device.. to test that this is true,
        // just check that the database object is not null
        assertNotNull(db);
    }


    @Test
    public void getReach() throws Exception {
        // get the reach of Henry Cejudo and ensure that it returns
        // the correct value of 64
        int reach = db.getReach("Henry Cejudo");
        assertEquals(reach, 64);
    }


    @Test
    public void getWeight() throws Exception {
        // get the weight of Cody Garbrandt and ensure that it returns
        // the correct value of 135
        int weight = db.getWeight("Cody Garbrandt");
        assertEquals(weight, 135);
    }


    @Test
    public void getHeight() throws Exception {
        // get the height of Chris Weidman and ensure that it returns
        // the correct value of 187
        int height = db.getHeight("Chris Weidman");
        assertEquals(height, 187);
    }


    @Test
    public void getAge() throws Exception {
        // get the age of Jose Aldo and ensure that it returns
        // the correct value of 30
        int age = db.getAge("Jose Aldo");
        assertEquals(age, 30);
    }


    @Test
    public void getNumKos() throws Exception {
        // get the number of knockouts for Ray Borg and ensure that it returns
        // the correct value of 1
        int kos = db.getNumKos("Ray Borg");
        assertEquals(kos, 1);
    }


    @Test
    public void getNumKnockedOut() throws Exception {
        // get the number of knockouts of Jessica Penne and ensure that it returns
        // the correct value of 2
        int kod = db.getNumKnockedOut("Jessica Penne");
        assertEquals(kod, 2);
    }


    @Test
    public void getNumSubs() throws Exception {
        // get the number of submissions for Stephen Thompson and ensure that it returns
        // the correct value of 1
        int subs = db.getNumSubs("Stephen Thompson");
        assertEquals(subs, 1);
    }


    @Test
    public void getNumSubbed() throws Exception {
        // get the number of sumbissins of Demian Maia and ensure that it returns
        // the correct value of 0
        int subbed = db.getNumSubbed("Demian Maia");
        assertEquals(subbed, 0);
    }


    @Test
    public void getWinstreak() throws Exception {
        // get the number signifying whether or not Demetrious Johnson
        // is on a win streak, which should be 1 (meaning true)
        int winstreak = db.getWinstreak("Demetrious Johnson");
        assertEquals(winstreak, 1);
    }


    @Test
    public void getLosestreak() throws Exception {
        // get the number signifying whether or not Mark Hunt
        // is on a lose, which should be 0 (meaning false)
        int losestreak = db.getLosestreak("Mark Hunt");
        assertEquals(losestreak, 0);
    }


    @Test
    public void getFighterABasedOnWeight() throws Exception {
        // get a list of all middleweights
        List<String> firstList = db.getFighterABasedOnWeight("Middleweight");

        // ensure that the first fighter in the middleweight division alphabetically
        // Anderson Silva is now the first item in firstList
        String fighterA = firstList.get(0);

        assertEquals(fighterA, "Anderson Silva");

    }


    @Test
    public void getFighterBBasedOnA() throws Exception {
        // get a list of all middleweights, but the list should not include the fighter
        // that we picked in the previous list, as you cannot pick the same fighter for both fields
        List<String> secondList = db.getFighterBBasedOnA("Middleweight", "Anderson Silva");

        // ensure that the first fighter in the middleweight division alphabetically is no longer
        // Anderson Silva, but is in fact Chris Weidman
        String fighterB = secondList.get(0);

        assertNotEquals(fighterB, "Anderson Silva");
        assertEquals(fighterB, "Chris Weidman");
    }

}
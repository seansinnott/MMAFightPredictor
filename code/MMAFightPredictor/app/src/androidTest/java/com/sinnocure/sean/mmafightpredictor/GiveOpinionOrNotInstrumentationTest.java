package com.sinnocure.sean.mmafightpredictor;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class GiveOpinionOrNotInstrumentationTest {

    // before running these tests ensure that the GiveOpinionOrNot activity is launched
    @Rule
    public ActivityTestRule<GiveOpinionOrNot> myActivity =
            new ActivityTestRule<GiveOpinionOrNot>(GiveOpinionOrNot.class);


    @Test
    public void onCreate() throws Exception {
        // ensure that the correct items are displayed on screen when onCreate is called..

        // check to see that some image from the GiveOpinionOrNot activity is displayed
        onView(withId(R.id.statsonly))
                .check(matches(isDisplayed()));
    }


    @Test
    public void onClickOpinion() throws Exception {
        // upon clicking this button, the UserOpinion activity should be launched
        onView(withId(R.id.opinionandstats))
                .perform(click());

        // check to see that some text from the UserOpinion activity is displayed after clicking the button
        onView(withId(R.id.weighttxt))
                .check(matches(isDisplayed()));
    }


    @Test
    public void onClickStatsOnly() throws Exception {
        // use the GlobalClass object to place arbitrary names into the prediction
        // so that we can check that we get to the result screen after clicking stats only button
        GlobalClass gc = (GlobalClass) myActivity.getActivity().getApplicationContext();
        gc.setNameFighterA("Conor McGregor");
        gc.setNameFighterB("Eddie Alvarez");

        // upon clicking this button, the animation screen activity should be launched
        onView(withId(R.id.statsonly))
                .perform(click());

        // check to see that an image from the Splashscreen activity is displayed after clicking the button
        onView(withId(R.id.splash))
                .check(matches(isDisplayed()));

        // wait for the animation on the splash screen to finish and the result screen to be displayed
        Thread.sleep(3500);

        // ensure that the name of the winner is displayed after the animation has finished
        onView(withText("Eddie Alvarez"))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onCreateOptionsMenu() throws Exception {

        // try to expand the menu icon
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        // upon clicking the menu icon, the options CONTACT and HELP should be displayed

        onView(withText("Contact"))
                .check(matches(isDisplayed()));

        onView(withText("Help"))
                .check(matches(isDisplayed()));
    }


    @Test
    public void onOptionsItemSelected() throws Exception {
        // try to expand the menu icon
        openActionBarOverflowOrOptionsMenu(getInstrumentation().getTargetContext());

        // upon clicking the CONTACT button, the Contact activity should be launched
        onView(withText("Contact"))
                .perform(click());

        // check to see that some text from the Contact activity is displayed after clicking the button
        onView(withId(R.id.contact_msg))
                .check(matches(isDisplayed()));
    }

}
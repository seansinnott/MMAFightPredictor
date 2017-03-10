package com.sinnocure.sean.mmafightpredictor;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;


public class CreateAlgorithmInstrumentationTest {

    // before running these tests ensure that the CreateAlgorithm activity is launched
    @Rule
    public ActivityTestRule<CreateAlgorithm> myActivity =
            new ActivityTestRule<CreateAlgorithm>(CreateAlgorithm.class);


    @Test
    public void onCreate() throws Exception {
        // ensure that the correct items are displayed on screen when onCreate is called..

        // check to see that some text from the CreateAlgorithm activity is displayed
        onView(withId(R.id.weighttxt))
                .check(matches(isDisplayed()));

    }

    @Test
    public void onClickCreateAlgorithmGoButton() throws Exception {
        // upon clicking this button, the UserOpinion activity should be launched
        onView(withId(R.id.gobuttonweight))
                .perform(scrollTo(), click());

        // check to see that textfrom the UserOpinion activity is displayed after clicking the button
        onView(withId(R.id.weighttxt))
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
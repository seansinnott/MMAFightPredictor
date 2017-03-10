package com.sinnocure.sean.mmafightpredictor;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;


public class Welcome3InstrumentationTest {

    // before running these tests ensure that the Welcome3 activity is launched
    @Rule
    public ActivityTestRule<Welcome3> myActivity =
            new ActivityTestRule<Welcome3>(Welcome3.class);


    @Test
    public void onCreate() throws Exception {
        // ensure that the correct items are displayed on screen when onCreate is called..

        // check to see that some image from the Welcome3 activity is displayed
        onView(withId(R.id.welc3txt))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onClickBackWelcomeThree() throws Exception {
        // upon clicking this button, the Welcome2 activity should be launched
        onView(withId(R.id.welc3back))
                .perform(click());

        // check to see that an image from the Welcome2 activity is displayed after clicking the button
        onView(withId(R.id.welc2txt))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onClickNextWelcomeThree() throws Exception {
        // upon clicking this button, the MainActivity activity should be launched
        onView(withId(R.id.welc3next))
                .perform(click());

        // check to see that an image from the MainActivity activity is displayed after clicking the button
        onView(withId(R.id.calculate))
                .check(matches(isDisplayed()));
    }

}
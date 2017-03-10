package com.sinnocure.sean.mmafightpredictor;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Welcome2InstrumentationTest {

    // before running these tests ensure that the Welcome2 activity is launched
    @Rule
    public ActivityTestRule<Welcome2> myActivity =
            new ActivityTestRule<Welcome2>(Welcome2.class);

    @Test
    public void onCreate() throws Exception {
        // ensure that the correct items are displayed on screen when onCreate is called..

        // check to see that some image from the Welcome2 activity is displayed
        onView(withId(R.id.welc2txt))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onClickBackWelcomeTwo() throws Exception {
        // upon clicking this button, the Welcome1 activity should be launched
        onView(withId(R.id.welc2back))
                .perform(click());

        // check to see that an image from the Welcome1 activity is displayed after clicking the button
        onView(withId(R.id.welcome1txt))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onClickNextWelcomeTwo() throws Exception {
        // upon clicking this button, the Welcome3 activity should be launched
        onView(withId(R.id.welc2next))
                .perform(click());

        // check to see that an image from the Welcome3 activity is displayed after clicking the button
        onView(withId(R.id.welc3txt))
                .check(matches(isDisplayed()));
    }

}
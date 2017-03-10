package com.sinnocure.sean.mmafightpredictor;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

public class Welcome1InstrumentationTest {

    // before running these tests ensure that the ChooseFighters activity is launched
    @Rule
    public ActivityTestRule<Welcome1> myActivity =
            new ActivityTestRule<Welcome1>(Welcome1.class);

    @Test
    public void onCreate() throws Exception {
        // ensure that the correct items are displayed on screen when onCreate is called..

        // check to see that some image from the Welcome1 activity is displayed
        onView(withId(R.id.welcome1txt))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onClickSkipWelcome() throws Exception {
        // upon clicking this button, the MainActivity activity should be launched
        onView(withId(R.id.welc1skip))
                .perform(click());

        // check to see that an image from the MainActivity activity is displayed after clicking the button
        onView(withId(R.id.calculate))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onClickNextWelcomeOne() throws Exception {
        // upon clicking this button, the Welcome2 activity should be launched
        onView(withId(R.id.welc1next))
                .perform(click());

        // check to see that an image from the Welcome2 activity is displayed after clicking the button
        onView(withId(R.id.welc2txt))
                .check(matches(isDisplayed()));
    }

}
package com.sinnocure.sean.mmafightpredictor;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasToString;

public class DataOnlyPredictionSystemTest {
    // before running this test ensure that the MainActivity activity is launched
    @Rule
    public ActivityTestRule<MainActivity> myActivity =
            new ActivityTestRule<MainActivity>(MainActivity.class);

    @Test
    public void runThroughDataOnlyOptionAndReceivePrediction() throws Exception {

        // click the button to receive a prediction using our algorithm, this should launch the ChooseFighters activity
        onView(withId(R.id.calculate))
                .perform(click());

        // fill out all required fields in the ChooseFighters activity with information
        onView(withId(R.id.weight_division_spinner))
                .perform(click());
        onData(hasToString("Welterweight")).perform(click());

        onView(withId(R.id.fighter_a_spinner))
                .perform(click());
        onData(hasToString("Jake Ellenberger")).perform(click());

        onView(withId(R.id.fighter_b_spinner))
                .perform(click());
        onData(hasToString("Gunnar Nelson")).perform(click());

        // then click the GO button which should launch the GiveOpinionOrNot activity
        onView(withId(R.id.gobutton))
                .perform(click());

        // now choose to just use statistics and give no opinion which should launch the UserOpinion activity
        onView(withId(R.id.statsonly))
                .perform(click());

        // wait for the animation on the splash screen to finish and the result screen to be displayed
        Thread.sleep(3500);

        // ensure that the correct percentage of 61% is being displayed to the user
        onView(withText("61%"))
                .check(matches(isDisplayed()));

        // finally ensure that the correct winner (Gunnar Nelson) is displayed to the user
        onView(withText("Gunnar Nelson"))
                .check(matches(isDisplayed()));
    }
}

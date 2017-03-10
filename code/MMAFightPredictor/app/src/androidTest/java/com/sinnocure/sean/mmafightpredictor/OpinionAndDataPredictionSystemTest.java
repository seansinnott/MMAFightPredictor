package com.sinnocure.sean.mmafightpredictor;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasToString;

@RunWith(AndroidJUnit4.class)
public class OpinionAndDataPredictionSystemTest {

    // before running this test ensure that the MainActivity activity is launched
    @Rule
    public ActivityTestRule<MainActivity> myActivity =
            new ActivityTestRule<MainActivity>(MainActivity.class);



    @Test
    public void runThroughOpinionAndDataOptionAndReceivePrediction() throws Exception {

        // click the button to receive a prediction using our algorithm, this should launch the ChooseFighters activity
        onView(withId(R.id.calculate))
                .perform(click());

        // fill out all required fields in the ChooseFighters activity with information
        onView(withId(R.id.weight_division_spinner))
                .perform(click());
        onData(hasToString("Women's Strawweight")).perform(click());

        onView(withId(R.id.fighter_a_spinner))
                .perform(click());
        onData(hasToString("Joanna Jedrzejczyk")).perform(click());

        onView(withId(R.id.fighter_b_spinner))
                .perform(click());
        onData(hasToString("Tecia Torres")).perform(click());

        // then click the GO button which should launch the GiveOpinionOrNot activity
        onView(withId(R.id.gobutton))
                .perform(click());

        // use the GlobalClass object to simulate the user choosing that fighterA has much better striking
        // and fighterB has better jiu jitsu and better wrestling
        GlobalClass gc = (GlobalClass) myActivity.getActivity().getApplicationContext();
        gc.setUserChosenStrikingAdvantage(0);
        gc.setUserChosenWrestlingAdvantage(3);
        gc.setUserChosenJiuJitsuAdvantage(3);

        // now choose to use opinion and statistics which should launch the UserOpinion activity
        onView(withId(R.id.opinionandstats))
                .perform(click());

        // now click the PREDICT button which should launch the animation for calculation taking place
        onView(withId(R.id.gobuttonopinion))
                .perform(click());

        // wait for the animation on the splash screen to finish and the result screen to be displayed
        Thread.sleep(3500);

        // ensure that the correct percentage of 61% is being displayed to the user
        onView(withText("61%"))
                .check(matches(isDisplayed()));

        // finally ensure that the correct winner (Joanna Jedrzejczyk) is displayed to the user
        onView(withText("Joanna Jedrzejczyk"))
                .check(matches(isDisplayed()));

        gc.resetAllValues();
    }
}

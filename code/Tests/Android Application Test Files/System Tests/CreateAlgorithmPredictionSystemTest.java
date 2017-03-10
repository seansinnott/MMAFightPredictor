package com.sinnocure.sean.mmafightpredictor;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasToString;

@RunWith(AndroidJUnit4.class)
public class CreateAlgorithmPredictionSystemTest {

    // before running this test ensure that the MainActivity activity is launched
    @Rule
    public ActivityTestRule<MainActivity> myActivity =
            new ActivityTestRule<MainActivity>(MainActivity.class);



    @Test
    public void runThroughCreateAlgorithmAndReceivePrediction() throws Exception {

        // click the button to receive a prediction by creating an algorithm, this should launch the ChooseFighters activity
        onView(withId(R.id.create_algo))
                .perform(click());

        // fill out all required fields in the ChooseFighters activity with information
        onView(withId(R.id.weight_division_spinner))
                .perform(click());
        onData(hasToString("Heavyweight")).perform(click());

        onView(withId(R.id.fighter_a_spinner))
                .perform(click());
        onData(hasToString("Travis Browne")).perform(click());

        onView(withId(R.id.fighter_b_spinner))
                .perform(click());
        onData(hasToString("Stefan Struve")).perform(click());


        // then click the GO button which should launch the CreateAlgorithm activity
        onView(withId(R.id.gobutton))
                .perform(click());

        // use the GlobalClass object to simulate the user choosing the importance of certain attributes
        // and which fighter (if either) is more skilled at striking, BJJ or wrestling
        GlobalClass gc = (GlobalClass) myActivity.getActivity().getApplicationContext();
        gc.setUserChosenReach(6);
        gc.setUserChosenWeight(4);
        gc.setUserChosenHeight(6);
        gc.setUserChosenAge(2);
        gc.setUserChosenStriking(8);
        gc.setUserChosenBJJ(3);
        gc.setUserChosenWrestling(7);
        gc.setUserChosenStreak(2);
        gc.setUserChosenStrikingAdvantage(1);
        gc.setUserChosenWrestlingAdvantage(3);
        gc.setUserChosenJiuJitsuAdvantage(2);


        // upon clicking this button, the UserOpinion activity should be launched
        onView(withId(R.id.gobuttonweight))
                .perform(scrollTo(), click());

        // now click the PREDICT button which should launch the animation for calculation taking place
        onView(withId(R.id.gobuttonopinion))
                .perform(click());

        // wait for the animation on the splash screen to finish and the result screen to be displayed
        Thread.sleep(3500);

        // ensure that the correct percentage of 64% is being displayed to the user
        onView(withText("64%"))
                .check(matches(isDisplayed()));

        // finally ensure that the correct winner (Stefan Struve) is displayed to the user
        onView(withText("Stefan Struve"))
                .check(matches(isDisplayed()));

        gc.resetAllValues();
    }
}

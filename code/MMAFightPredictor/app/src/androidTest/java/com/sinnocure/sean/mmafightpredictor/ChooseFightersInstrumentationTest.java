package com.sinnocure.sean.mmafightpredictor;

import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;
import org.junit.Test;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.espresso.Espresso.onData;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.openActionBarOverflowOrOptionsMenu;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.doesNotExist;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.hasToString;


public class ChooseFightersInstrumentationTest {

    // before running these tests ensure that the ChooseFighters activity is launched
    @Rule
    public ActivityTestRule<ChooseFighters> myActivity =
            new ActivityTestRule<ChooseFighters>(ChooseFighters.class);

    @Test
    public void onCreate() throws Exception {

        // ensure that the correct items are displayed on screen when onCreate is called..

        // check to see that some image from the MainActivity activity is displayed
        onView(withId(R.id.choosecalctxt))
                .check(matches(isDisplayed()));
    }

    @Test
    public void onItemSelectedFighterNameMatchesDivision() throws Exception {

        // click on the spinner to select a weight division
        onView(withId(R.id.weight_division_spinner))
                .perform(click());

        // choose the Lightweight division from the drop down menu
        onData(hasToString("Lightweight")).perform(click());

        // click on the spinner to select the name of fighter A
        onView(withId(R.id.fighter_a_spinner))
                .perform(click());

        // ensure that one of the fighter's displayed is known to be in the chosen division
        onData(hasToString("Conor McGregor")).check(matches(isDisplayed()));
    }


    @Test
    public void onItemSelectedFighterNameNotDisplayedAgainAfterBeingChosen() throws Exception {

        // click on the spinner to select a weight division
        onView(withId(R.id.weight_division_spinner))
                .perform(click());

        // choose the Heavyweight division from the drop down menu
        onData(hasToString("Heavyweight")).perform(click());

        // click on the spinner to select the name of fighter A
        onView(withId(R.id.fighter_a_spinner))
                .perform(click());

        // ensure that one of the fighter's displayed is known to be in the chosen division and select it
        onData(hasToString("Stipe Miocic")).perform(click());

        // click on the spinner to select the name of fighter B
        onView(withId(R.id.fighter_b_spinner))
                .perform(click());

        // ensure that the name selected above is not displayed as an option for the user when choosing a second fighter name
        onView(withText("Stipe Miocic"))
                .check(doesNotExist());
    }

    @Test
    public void onClickChooseFightersNextAfterFillingOutAllRequiredFields() throws Exception {

        // fill out all required fields with information
        onView(withId(R.id.weight_division_spinner))
                .perform(click());
        onData(hasToString("Flyweight")).perform(click());

        onView(withId(R.id.fighter_a_spinner))
                .perform(click());
        onData(hasToString("Demetrious Johnson")).perform(click());

        onView(withId(R.id.fighter_b_spinner))
                .perform(click());
        onData(hasToString("Joseph Benavidez")).perform(click());

        // then click the GO button which should launch the GiveOpinionOrNot activity
        onView(withId(R.id.gobutton))
                .perform(click());

        // check to see that some image from the GiveOpinionOrNot activity is displayed after clicking the button
        onView(withId(R.id.statsonly))
                .check(matches(isDisplayed()));
    }


    @Test
    public void onClickChooseFightersNextWithoutFillingOutAllRequiredFields() throws Exception {

        // fill out all 2 out of 3 required fields with information
        onView(withId(R.id.weight_division_spinner))
                .perform(click());
        onData(hasToString("Women's Bantamweight")).perform(click());

        onView(withId(R.id.fighter_a_spinner))
                .perform(click());
        onData(hasToString("Amanda Nunes")).perform(click());

        // then click the GO button which should not bring you to a new activity as you have not filled out all requried fields
        // and should show a warning message to the user telling them to fill out all required fields before moving on
        onView(withId(R.id.gobutton))
                .perform(click());

        // check to see that some text from the current ChooseFighters activity is displayed after clicking the button
        onView(withId(R.id.choosecalctxt))
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
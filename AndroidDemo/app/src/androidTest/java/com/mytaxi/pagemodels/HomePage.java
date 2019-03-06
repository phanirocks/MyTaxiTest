package com.mytaxi.pagemodels;

import android.support.test.espresso.ViewInteraction;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import android.support.test.espresso.matcher.RootMatchers;


public class HomePage extends BasePage {

    ViewInteraction searchBox;

    public void verifyScreen() {
        searchBox = onView(
                allOf(withId(R.id.textSearch),
                        isDisplayed()));

    }

    public void typeSearchText(String text) {
        searchBox.perform(typeText("sa"));
        sleepForLongTime();
    }

    public void selectSearchSuggestionByText(String text) {
        onView(withText(text))
                .inRoot(RootMatchers.isPlatformPopup())
                .perform(click());

    }
}

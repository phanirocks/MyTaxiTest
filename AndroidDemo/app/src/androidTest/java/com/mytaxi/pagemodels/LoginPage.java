package com.mytaxi.pagemodels;

import android.support.test.espresso.ViewInteraction;

import com.mytaxi.android_demo.R;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.replaceText;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

public class LoginPage extends BasePage {

    public void verifyScreen() {
        onView(
                allOf(withId(R.id.edt_username),
                        isDisplayed()));
    }

    public void enterUserID(String userID) {
        ViewInteraction userIDTextField = onView(
                allOf(withId(R.id.edt_username),
                        isDisplayed()));
        userIDTextField.perform(click());
        userIDTextField.perform(replaceText(userID), closeSoftKeyboard());
    }

    public void enterPassword(String password) {
        ViewInteraction passwordTextField = onView(
                allOf(withId(R.id.edt_password),
                        isDisplayed()));
        passwordTextField.perform(click());
        passwordTextField.perform(replaceText(password), closeSoftKeyboard());
    }

    public void clickLoginButton() {
        onView(
                allOf(withId(R.id.btn_login), withText("Login")
                )).perform(click());
        sleepForShortTime();
    }
}

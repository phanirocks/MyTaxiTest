package com.mytaxi.pagemodels;

import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import junit.framework.Assert;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;

import com.mytaxi.android_demo.activities.MainActivity;
import android.support.test.rule.ActivityTestRule;

import org.junit.Rule;


public abstract class BasePage{


    @Rule
    public ActivityTestRule<MainActivity> mActivityRule = new ActivityTestRule(MainActivity.class);

    /**
     * Function to verify that a page has loaded. To be implemented by all page helpers
     */
    public abstract void verifyScreen();

    protected static final long LONGTIMEOUT = 15000;

    protected static final long MEDIUMTIMEOUT = 7000;

    protected static final long SHORTTIMEOUT = 3000;

    protected void sleepForShortTime(){
        try{
            Thread.sleep(SHORTTIMEOUT);
        } catch(Exception e){
            Assert.fail("Test failed due to Interrupted Exception");
        }
    }

    protected void sleepForMediumTime(){
        try{
            Thread.sleep(MEDIUMTIMEOUT);
        } catch(Exception e){
            Assert.fail("Test failed due to Interrupted Exception");
        }
    }

    protected void sleepForLongTime(){
        try{
            Thread.sleep(LONGTIMEOUT);
        } catch(Exception e){
            Assert.fail("Test failed due to Interrupted Exception");
        }
    }

    protected static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }



}

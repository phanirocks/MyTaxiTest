package com.mytaxi.tests;

import com.mytaxi.pagemodels.HomePage;
import com.mytaxi.pagemodels.LoginPage;
import com.mytaxi.pagemodels.DriverDetailPage;
import com.mytaxi.android_demo.activities.MainActivity;
import android.support.test.rule.ActivityTestRule;
import android.support.test.rule.GrantPermissionRule;

import org.junit.Rule;

public class BaseTest {

    protected HomePage homePageHelper;
    protected LoginPage loginPageHelper;
    protected DriverDetailPage driverDetailPageHelper;

    @Rule
    public ActivityTestRule<MainActivity> activityRule =
            new ActivityTestRule<>(MainActivity.class);

    @Rule
    public GrantPermissionRule mGrantPermissionRule =
            GrantPermissionRule.grant(
                    "android.permission.ACCESS_FINE_LOCATION");

    BaseTest(){
        homePageHelper = new HomePage();
        loginPageHelper = new LoginPage();
        driverDetailPageHelper = new DriverDetailPage();
    }
}

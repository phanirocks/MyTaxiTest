package com.mytaxi.tests;

import org.junit.Test;


public class MyTaxiTests extends BaseTest{

    private static String USERID = "crazydog335";
    private static String PASSWORD = "venture";

    @Test
    public void verifyDriverCallFromSearchResults(){
         loginPageHelper.verifyScreen();
         loginPageHelper.enterUserID(USERID);
         loginPageHelper.enterPassword(PASSWORD);
         loginPageHelper.clickLoginButton();
         homePageHelper.verifyScreen();
         homePageHelper.typeSearchText("sa");
         homePageHelper.selectSearchSuggestionByText("Sarah Scott");
         driverDetailPageHelper.verifyScreen();
         driverDetailPageHelper.clickCallButton();

    }
}

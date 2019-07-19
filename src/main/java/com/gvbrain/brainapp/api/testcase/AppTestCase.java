package com.gvbrain.brainapp.api.testcase;

import com.gvbrain.brainapp.api.driver.Driver;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;



public class AppTestCase {

    @BeforeAll
    public static void beforeAllTestCase(){
        Driver.getInstance().start();
    }

    @AfterAll
    public static void afterAllTestCase(){
        Driver.getInstance().appiumDriver.quit();
    }
}

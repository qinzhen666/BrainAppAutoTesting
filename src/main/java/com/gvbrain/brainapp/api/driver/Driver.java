package com.gvbrain.brainapp.api.driver;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;


public class Driver {
    public AppiumDriver appiumDriver;
    static Driver driver;
    public static Driver getInstance(){
        if (driver == null){
            driver = new Driver();
        }
        return driver;
    }

    public void start(){
        DesiredCapabilities capabilities = new DesiredCapabilities();
        GlobalConfig globalConfig = GlobalConfig.load("/data/globalConfig.yaml");
        globalConfig.appiumConfig.capabilities.keySet().forEach(key->{
            Object value = globalConfig.appiumConfig.capabilities.get(key);
            capabilities.setCapability(key,value);
        });
        URL remoteUrl = null;
        try {
            remoteUrl = new URL(globalConfig.appiumConfig.url);
            appiumDriver = new AndroidDriver(remoteUrl,capabilities);
            appiumDriver.manage().timeouts().implicitlyWait(globalConfig.appiumConfig.wait, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

    }

    public String getPlatform(){
        String platformName = appiumDriver.getCapabilities().getCapability("platformName").toString();
        return platformName;
    }

    public WebElement find(By by){
        return appiumDriver.findElement(by);
    }

    public List findElements(By by){
        return appiumDriver.findElements(by);
    }


}

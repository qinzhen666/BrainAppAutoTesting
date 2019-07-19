package com.gvbrain.brainapp.api.page;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Demo {


    private static AppiumDriver<MobileElement> driver;
//    private static AppiumDriver<MobileElement> driver;
    @BeforeAll
    public static void start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        /*capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "emulator-5554");//emulator-5554,2c8e6af4
        capabilities.setCapability("appPackage", "com.example.android.apis");
        capabilities.setCapability("appActivity",".ApiDemos");*/

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "2c8e6af4");//emulator-5554,2c8e6af4
        capabilities.setCapability("appPackage", "com.leo");
        capabilities.setCapability("appActivity",".activity.WelcomeActivity");

        capabilities.setCapability("automationName","uiautomator2");
        capabilities.setCapability("autoGrantPermissions","true");
//        capabilities.setCapability("unicodeKeyboard", "true");
//        capabilities.setCapability("resetKeyboard", "true");
        capabilities.setCapability("chromedriverExecutableDir","D:\\QinZhen\\TestDev\\chromedrivers\\");


        URL remoteUrl = new URL("http://127.0.0.1:4723/wd/hub");
        driver =new AndroidDriver<MobileElement>(remoteUrl,capabilities);
        driver.manage().timeouts().implicitlyWait(6, TimeUnit.SECONDS);
    }

    @Test
    public void gvLogin(){
        driver.findElement(By.id("edit_phone_Login")).sendKeys("123456");
    }

    @Test
    public void testWebview() throws InterruptedException {
       /* if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            WebView.setWebContentsDebuggingEnabled(true);
        }*/
        /*Thread.sleep(5000);
        driver.findElementByXPath("//android.widget.TextView[@text='沪深' and @resource-id='com.xueqiu.android:id/button_text']").click();
        driver.findElementByAccessibilityId("立即开户").click();*/

        driver.findElementByXPath("//*[@text='Views']").click();
        //利用Android的API进行滑屏操作
        ((AndroidDriver<MobileElement>)driver).
                findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                                "scrollIntoView(new UiSelector().text(\"WebView\").instance(0))").click();
        driver.findElementByAccessibilityId("Hello World! - 1").click();
    }

    @Test
    public void context() throws InterruptedException {
        for (Object c : driver.getContextHandles()){//查看上下文在Android里还是webview里
            System.out.println(c.toString());
        }
        System.out.println(driver.getPageSource());
        Thread.sleep(5000);
//        driver.findElementByXPath("//android.widget.TextView[@text='沪深' and @resource-id='com.xueqiu.android:id/button_text']").click();
        driver.findElementByXPath("//*[@text='Views']").click();
        //利用Android的API进行滑屏操作
        ((AndroidDriver<MobileElement>)driver).
                findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                                "scrollIntoView(new UiSelector().text(\"WebView\").instance(0))").click();
        for (Object c : driver.getContextHandles()){
            System.out.println(c.toString());
        }
//        Thread.sleep(3000);
        for (Object c : driver.getContextHandles()){
            System.out.println(c.toString());
        }
        //开始往webview里面进行切换
//        driver.context("WEBVIEW_com.xueqiu.android");
        driver.context("WEBVIEW_com.example.android.apis");
        //切换完成后可以用css进行定位
//        driver.findElementByCssSelector(".btn-submit").click();
        driver.findElementByCssSelector("body > a").click();

    }

    @Test
    public void toastXueqiu() throws InterruptedException {
//        System.out.println( driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
        System.out.println("1111111");
        Thread.sleep(8000);
        PointOption pointOption = new PointOption();
//        pointOption.withCoordinates(540,900);
        //todo:拖动屏幕待确认
        Duration duration=Duration.ofMillis(500);//滑动300ms
        new TouchAction(driver).press(pointOption.point(540,730))
                               .waitAction(WaitOptions.waitOptions(duration))
                               .moveTo(pointOption.point(540,1434))
                               .release().perform();
//        System.out.println( "333"+driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
//        System.out.println( driver.findElementByXPath("//*[@class='android.app.Dialog']").getText());
//          System.out.println( driver.findElementByXPath("//*[contains(@text,'更新')]").getText());
//          System.out.println( "333"+driver.findElementByXPath("//*[@class='android.widget.RelativeLayout']").getText());
    }

    @Test
    public void testToast(){
        driver.findElementByXPath("//*[@text='Views']").click();
        //利用Android的API进行滑屏操作
        ((AndroidDriver<MobileElement>)driver).
                findElementByAndroidUIAutomator(
                        "new UiScrollable(new UiSelector().scrollable(true).instance(0))." +
                                "scrollIntoView(new UiSelector().text(\"Popup Menu\").instance(0))").click();
        driver.findElementByXPath("//*[contains(@text,'MAKE')]").click();
        driver.findElementByXPath("//*[@text='Search']").click();
        //识别Toast
        System.out.println( driver.findElementByXPath("//*[@class='android.widget.Toast']").getText());
    }

    @Test
    public void testSwipe() throws InterruptedException {
        Thread.sleep(3000);
        for (int i = 0;i < 10; i++){
//            swipe(0.8,0.8,0.4,0.4);
        }
    }

    @Test
    void waitTest(){
        //分析显示等待方法原理
        RemoteWebDriver driver = null;
        WebDriverWait wait = new WebDriverWait(driver,10);
        WebElement webElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("someid")));
    }

    @Test
    public void testscreenshot(){
        driver.findElementByAccessibilityId("Views").click();
//        saveScreen();
    }
}

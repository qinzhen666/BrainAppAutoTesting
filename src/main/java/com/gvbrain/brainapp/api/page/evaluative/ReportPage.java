package com.gvbrain.brainapp.api.page.evaluative;

import com.gvbrain.brainapp.api.driver.Driver;
import com.gvbrain.brainapp.api.page.BasePage;
import com.gvbrain.brainapp.api.util.ZoomUtil;
import io.appium.java_client.MobileElement;
import io.appium.java_client.MultiTouchAction;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;

import java.time.Duration;

import static io.appium.java_client.touch.offset.PointOption.point;

public class ReportPage extends BasePage {

    //Android定位elements
    private By A二维码 = By.id("image_erweima");
    private By A扫一扫 = byText("扫一扫获取报告");
    private By A查看详情2 = By.xpath("(//*[@text='查看详情'])[2]");
//    private By A查看详情1 = By.id("relative_detail");
    private By A返回 = By.id("bar_btn_left");
    private By A返回首页 = By.id("text_backHome");

    //ios定位elements


    public MyAssessmentPlanPage checkReport() {
        find(A二维码, null);
        click(A扫一扫, null);
        click(A查看详情2, null);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        try {
            new ZoomUtil().ZoomInAndOut();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
//        MultiTouch();
        click(A返回, null);
        click(A返回首页, null);
        return new MyAssessmentPlanPage();
    }

    public void MultiTouch(){
        PointOption pointOption = new PointOption();
        PointOption a1 = pointOption.withCoordinates(960,600);
        PointOption a2 = pointOption.withCoordinates(480,600);
        PointOption a3= pointOption.withCoordinates(960,600);
        PointOption a4 = pointOption.withCoordinates(1440,600);
        /*Point a2 = new Point(480,600);
        Point a3 = new Point(960,600);
        Point a4 = new Point(1440,600);*/
        Duration duration = Duration.ofMillis(1000);
        TouchAction touchAction = new TouchAction((AndroidDriver<MobileElement>)(Driver.getInstance().appiumDriver));
        TouchAction action1 = touchAction
                .press(a1)
                .moveTo(a2)
                .release();
        TouchAction action2 = touchAction
                .press(a3)
                .moveTo(a4)
                .release();
        TouchAction action3 = touchAction
                .press(a2).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(a1).waitAction(WaitOptions.waitOptions(duration))
                .release();
        TouchAction action4 = touchAction
                .press(a4).waitAction(WaitOptions.waitOptions(duration))
                .moveTo(a3).waitAction(WaitOptions.waitOptions(duration))
                .release();
        MultiTouchAction multiTouchAction = new MultiTouchAction((AndroidDriver<MobileElement>)Driver.getInstance().appiumDriver);
        multiTouchAction.add(action1).add(action2).perform();
//        multiTouchAction.add(action3).add(action4).perform();
    }

}

package com.gvbrain.brainapp.api.page.evaluative;

import com.gvbrain.brainapp.api.driver.Driver;
import com.gvbrain.brainapp.api.page.BasePage;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import java.time.Duration;

public class TestPage extends BasePage {

    //Android定位elements
    private By A确认同意书 = By.id("ImageCheckbox");
    private By A查看同意书 = By.id("text_xieAndZ");
    private By A同意筛查 = By.id("text_action");
    private By A返回 = By.id("bar_btn_image_left");
    private By A点击签名 = By.id("text_moren");
    private By AgetToast = By.xpath("//*[@class='android.widget.Toast']");

    //ios定位elements

    public TestPage 签名(int startX,int startY,int endX,int endY){
        click(A点击签名,null);
        PointOption pointOption = new PointOption();
        Duration duration=Duration.ofMillis(500);//滑动500ms
        new TouchAction(Driver.getInstance().appiumDriver)
                .press(pointOption.point(startX,startY))
                .waitAction(WaitOptions.waitOptions(duration))
                .moveTo(pointOption.point(endX,endY))
                .release().perform();
        return this;
    }

    public void back(){
        click(A返回,null);
    }

    public String 未签名(){
        click(A同意筛查,null);
        return find(AgetToast,null).getText();
    }

    public TestPage 确认同意书(){
        click(A查看同意书,null);
        back();
        click(A确认同意书,null);
        return this;
    }

    public String 未确认同意书(){
        click(A同意筛查,null);
        return find(AgetToast,null).getText();
    }


}

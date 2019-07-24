package com.gvbrain.brainapp.api.page.evaluative;

import com.gvbrain.brainapp.api.driver.Driver;
import com.gvbrain.brainapp.api.page.BasePage;
import com.gvbrain.brainapp.api.page.record.CreateUserPage;
import com.gvbrain.brainapp.api.page.record.RecordPage;
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
    private By A开始测评 = byText("开始测评");
    private By A完成 = By.id("text_ok");
    //下面的两种定位封闭圆的写法均可成功
    private By A封闭圆错 = By.xpath("((//*[@text='画好一个封闭的圆'])[2]/following-sibling::android.widget.RelativeLayout)[2]");
//    private By A封闭圆 = By.xpath("((//*[@text='画好一个封闭的圆'])[2]/following-sibling::*[@class='android.widget.RelativeLayout'])[2]");
    private By A数字遗漏对 = By.id("relative_shuzi_yes");
    private By A数字顺序对 = By.id("relative_adre_yes");
    private By A指针位置错 = By.id("relative_zhen_no");
    private By A下一个or提交 = By.id("btn_pos");
    private By A根本做不到 = byText("根本做不到");
    private By A需要帮助 = byText("需要帮助");

    //ios定位elements

    public TestPage 签名or画钟(int startX, int startY, int endX, int endY){
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

    public CreateUserPage 确认同意书(){
        click(A查看同意书,null);
        back();
        click(A确认同意书,null);
        click(A同意筛查,null);
        return new CreateUserPage();
    }

    public String 未确认同意书(){
        click(A同意筛查,null);
        return find(AgetToast,null).getText();
    }

    public ReportPage startTestCTD4(int startX, int startY, int endX, int endY){
        click(A开始测评,null);
        签名or画钟(startX,startY,endX,endY);
        click(A完成,null);
        click(A封闭圆错,null);
        click(A数字遗漏对,null);
        click(A数字顺序对,null);
        click(A指针位置错,null);
        click(A下一个or提交,null);
        return new ReportPage();
    }

    public ReportPage startTestADL(){
        click(A开始测评,null);
        for (int i = 0;i < 19;i++){
            click(A根本做不到,null);
        }
        click(A需要帮助,null);
        click(A下一个or提交,null);
        return new ReportPage();
    }


}

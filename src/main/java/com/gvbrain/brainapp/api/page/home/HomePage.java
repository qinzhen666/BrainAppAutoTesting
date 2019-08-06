package com.gvbrain.brainapp.api.page.home;

import com.gvbrain.brainapp.api.page.BasePage;
import com.gvbrain.brainapp.api.page.record.CreateUserPage;
import org.openqa.selenium.By;

public class HomePage extends BasePage {
    //Android定位elements
    private By A方案名称 = By.xpath("(//*[@resource-id='com.leo:id/text_title'])[1]");


    public String checkAssessmentName(){
        try {
            String assessmentName = find(A方案名称,null).getText();
            return assessmentName;
        }catch (Exception e){
            String result = "方案已成功取消在首页的展示";
            System.out.println("方案已成功取消在首页的展示");
            return result;
        }

    }

    public CreateUserPage intoNewestAssessment(){
        click(A方案名称,null);
        return new CreateUserPage();
    }
}

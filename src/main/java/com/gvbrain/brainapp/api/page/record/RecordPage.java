package com.gvbrain.brainapp.api.page.record;

import com.gvbrain.brainapp.api.page.BasePage;
import org.openqa.selenium.By;

public class RecordPage extends BasePage {

    //android定位elements
    private By A输入密码 = By.id("edit_passWord");
    private By A创建用户 = byText("创建新用户");
    private By A编辑按钮 = By.xpath("(//*[@resource-id='com.leo:id/relative_editor'])[1]");
    private By A报告 = By.xpath("(//*[@resource-id='com.leo:id/relative_baog'])[1]");
    private By A编辑操作 = byText("编辑");
    private By A删除 = byText("删除");

    //iOS定位elements

    public RecordPage IntoByPassword(String password){
        sendKeys(A输入密码,null,password);
        click(byText("确认"),null);
        return this;
    }

    public CreateUserPage gotoCreateUser() {
        click(A创建用户,null);
        return new CreateUserPage();
    }

    public String deletePatient(){
        click(A编辑按钮,null);
        click(A删除,null);
        click(byText("确定"),null);
        return getToastText();
    }

    public CreateUserPage editPatient() {
        click(A编辑按钮, null);
        click(A编辑操作, null);
        return new CreateUserPage();
    }
}

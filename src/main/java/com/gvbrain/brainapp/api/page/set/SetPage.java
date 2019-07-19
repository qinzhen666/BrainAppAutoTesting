package com.gvbrain.brainapp.api.page.set;

import com.gvbrain.brainapp.api.page.BasePage;
import com.gvbrain.brainapp.api.page.login.LoginPage;
import org.openqa.selenium.By;

public class SetPage extends BasePage {

    //android定位elements
    private By A退出登录 = byText("退出登录");

    public String logout(){
        click(A退出登录,null);
        click(byText("确定"),null);
        return LoginPage.getInstance().find(By.id("edit_phone_Login"),null).getText();
    }
}

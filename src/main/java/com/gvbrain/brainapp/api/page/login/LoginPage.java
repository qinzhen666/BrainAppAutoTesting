package com.gvbrain.brainapp.api.page.login;

import com.gvbrain.brainapp.api.driver.Driver;
import com.gvbrain.brainapp.api.page.BasePage;
import com.gvbrain.brainapp.api.page.MainPage;
import org.openqa.selenium.By;

public class LoginPage extends BasePage {

    //android定位elements
    private By A输入账号 = By.id("edit_phone_Login");
    private By A输入密码 = By.id("edit_passWord_Login");
    private By A查看协议书  =By.id("text_xieAndZ");
    private By A协议书返回 = By.id("bar_btn_image_left");
    private By A确认协议书 = By.id("ImageCheckbox");
    private By A忘记密码 = By.id("text_forgetPassWord");
    private By A登录 = By.id("animButton_login");
    private By A登录信息不正确 = By.id("text_remind_login");

    //ios定位elements
    private By I输入账号 = By.id("edit_phone_Login");


    public MainPage 登录成功(String username, String password) {
        sendKeys(A输入账号,I输入账号,username);
        sendKeys(A输入密码,null,password);
        click(A查看协议书,null);
        click(A协议书返回,null);
        if (attribute(A确认协议书,null,"selected").equals("false")){
            click(A确认协议书,null);
        }
        click(A登录,null);
        return new MainPage();
    }

    public String 账号或密码错误(String username, String password){
        sendKeys(A输入账号,I输入账号,username);
        sendKeys(A输入密码,null,password);
        if (attribute(A确认协议书,null,"selected").equals("false")){
            click(A确认协议书,null);
        }
        click(A登录,null);
        return find(A登录信息不正确,null).getText();
    }

    public String 协议书未选登录(String username, String password){
        sendKeys(A输入账号,I输入账号,username);
        sendKeys(A输入密码,null,password);
        click(A登录,null);
        return find(A登录信息不正确,null).getText();
    }

    static LoginPage loginPage;
    public static LoginPage getInstance(){
        if (loginPage == null){
            loginPage = new LoginPage();
        }
        return loginPage;
    }

    public LoginPage gotoLogin(){
        Driver.getInstance().start();
        return getInstance();
    }
}

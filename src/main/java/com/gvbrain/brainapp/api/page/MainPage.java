package com.gvbrain.brainapp.api.page;

import com.gvbrain.brainapp.api.page.evaluative.EvaluativePage;
import com.gvbrain.brainapp.api.page.home.HomePage;
import com.gvbrain.brainapp.api.page.login.LoginPage;
import com.gvbrain.brainapp.api.page.record.RecordPage;
import com.gvbrain.brainapp.api.page.set.SetPage;
import org.openqa.selenium.By;

public class MainPage extends BasePage{
    //android定位elements
    public By A首页 = byText("首页");
    private By A设置 = By.id("iv_setting");
    private By A测评 = By.xpath("//*[@text='测评' and @focusable='false']");
    private By A档案 = byText("档案");
    private By A康复 = byText("康复");

    //ios定位elements

    static MainPage mainPage;
    public static MainPage getInstance(){
        if (mainPage == null){
            mainPage = new MainPage();
        }
        return mainPage;
    }

    public HomePage gotoHome(){
        click(A首页,null);
        return new HomePage();
    }

    public EvaluativePage gotoEvaluative(){
        click(A测评,null);
        return new EvaluativePage();
    }

    public RecordPage gotoRecord(){
        click(A档案,null);
        return new RecordPage();
    }

    public SetPage gotoSet(){
        click(A设置,null);
        return new SetPage();
    }


}

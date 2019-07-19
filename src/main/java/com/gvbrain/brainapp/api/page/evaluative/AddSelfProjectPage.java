package com.gvbrain.brainapp.api.page.evaluative;

import com.gvbrain.brainapp.api.page.BasePage;
import org.openqa.selenium.By;

public class AddSelfProjectPage extends BasePage {
    //Android定位elements
    private By A输入方案名称 = By.id("edit_name");
    private By A输入方案简介 = By.id("edit_content");
    private By ACDT4画钟测验 = byText("CDT4（画钟测验）");
    private By AADL日常生活能力 = byText("ADL（日常生活能力）");
    private By A保存方案 = byText("保存方案");
//    private By A保存成功 = By.xpath("//*[@class='android.widget.Toast']");

    //ios定位elements

    //todo:完善量表选择传参
    public String  addSelfProject(String projectname,String projectcontext){
        sendKeys(A输入方案名称,null,projectname);
        sendKeys(A输入方案简介,null,projectcontext);
        click(ACDT4画钟测验,null);
        click(AADL日常生活能力,null);
        click(A保存方案,null);
        return getToastText();
    }
}

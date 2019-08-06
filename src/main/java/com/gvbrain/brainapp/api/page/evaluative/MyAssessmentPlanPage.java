package com.gvbrain.brainapp.api.page.evaluative;

import com.gvbrain.brainapp.api.page.BasePage;
import com.gvbrain.brainapp.api.page.home.HomePage;
import com.gvbrain.brainapp.api.util.ScrollSelectUtil;
import org.openqa.selenium.By;

public class MyAssessmentPlanPage extends BasePage {

    //Android定位elements
    private By A删除方案 = By.id("relative_delete");
    private By AgetToast = By.xpath("//*[@class='android.widget.Toast']");
    private By A方案展示 = By.xpath("((//*[@resource-id='com.leo:id/relative_main'])[1]/android.widget.RelativeLayout)[3]");

    //ios定位elements

    public String homeDisplay(){
        click(A方案展示,null);
        return find(AgetToast,null).getText();//已在首页展示
    }

    public String cancelHomeDisplay(){
        click(A方案展示,null);
        return find(AgetToast,null).getText();//取消首页展示
    }

    public TestPage gotoTest(String myProjectName,String nameTypeContext,String type){
        new ScrollSelectUtil().scrollSelect(myProjectName,nameTypeContext,type);
        return new TestPage();
    }

    public MyAssessmentPlanPage deleteProject(){
        click(A删除方案,null);
        click(byText("确定"),null);
        System.out.println(find(AgetToast, null).getText());
        return new MyAssessmentPlanPage();
    }

}

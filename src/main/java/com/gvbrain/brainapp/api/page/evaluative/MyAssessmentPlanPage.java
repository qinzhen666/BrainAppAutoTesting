package com.gvbrain.brainapp.api.page.evaluative;

import com.gvbrain.brainapp.api.page.BasePage;
import com.gvbrain.brainapp.api.util.ScrollSelectUtil;
import org.openqa.selenium.By;

public class MyAssessmentPlanPage extends BasePage {

    //Android定位elements
    private By A删除方案 = By.id("relative_delete");
    private By AgetToast = By.xpath("//*[@class='android.widget.Toast']");

    //ios定位elements

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

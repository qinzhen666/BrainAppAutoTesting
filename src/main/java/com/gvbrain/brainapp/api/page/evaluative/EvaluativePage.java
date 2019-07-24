package com.gvbrain.brainapp.api.page.evaluative;

import com.gvbrain.brainapp.api.page.BasePage;
import org.openqa.selenium.By;

public class EvaluativePage extends BasePage {
    //Android定位elements
    private By A添加自定义方案 = By.id("relative_addPlan");
    private By A测评 = By.xpath("//*[@text='测评' and @focusable='true']");
    private By A我的方案 = byText("我的方案");

    //ios定位elements


    public EvaluationListPage gotoEvaluationList(){
        click(A测评,null);
        return new EvaluationListPage();
    }

    public MyAssessmentPlanPage gotoMyProject(){
        click(A我的方案,null);
        return new MyAssessmentPlanPage();
    }

    public AddSelfProjectPage togoAddSelfProject(){
        click(A添加自定义方案,null);
        return new AddSelfProjectPage();
    }
}

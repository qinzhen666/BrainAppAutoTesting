package com.gvbrain.brainapp.api.page.evaluative;

import com.gvbrain.brainapp.api.driver.Driver;
import com.gvbrain.brainapp.api.page.MainPage;
import com.gvbrain.brainapp.api.page.login.LoginPage;
import com.gvbrain.brainapp.api.testcase.AppTestCase;
import com.gvbrain.brainapp.api.util.BaseUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;

import java.time.Duration;
import java.util.Date;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class EvaluativePageTest extends AppTestCase {

    BaseUtil baseUtil = new BaseUtil();
    @BeforeAll
    static void beforeEvaluativePageTest(){
        String username = "18616210504";
        String password = "suiren123";
        LoginPage.getInstance().登录成功(username,password);
        if (MainPage.getInstance().find(new MainPage().A首页,null).getSize().toString().length() > 0){
            assertThat(1,equalTo(1));
        }else {
            System.out.println("[ERROR:未处于首页,登录失败]");
            assertThat(1,equalTo(0));
        }
    }

    @BeforeEach
    void beforeEach(){
        MainPage.getInstance().gotoHome();
    }

    @Test
    void 添加自定义方案() {
        String expectation = "操作成功";
        String testResult = MainPage.getInstance().gotoEvaluative().togoAddSelfProject()
                .addSelfProject(baseUtil.getRandomProjectName(),baseUtil.getRandomIntro());
        assertThat(testResult,equalTo(expectation));
    }

    @Test
    void 未签名测试() {
        String projectName = baseUtil.getRandomProjectName();
        String projectContext = baseUtil.getRandomIntro();
        String expectation = "请签名~";
        MainPage.getInstance().gotoEvaluative().togoAddSelfProject().addSelfProject(projectName,projectContext);
        String testResult = MainPage.getInstance().gotoEvaluative().gotoMyProject().gotoTest(projectName,projectContext,"text").未签名();
        new TestPage().back();
        assertThat(testResult,equalTo(expectation));
    }

    @Test
    void 未确认同意书(){
        int startX = 960;int startY = 426;
        int endX = 960;int endY = 808;
        String projectName = baseUtil.getRandomProjectName();
        String projectContext = baseUtil.getRandomIntro();
        String expectation = "请确认已阅读知情同意书~";
        MainPage.getInstance().gotoEvaluative().togoAddSelfProject().addSelfProject(projectName,projectContext);
        String testResult = MainPage.getInstance().gotoEvaluative().gotoMyProject().gotoTest(projectName,projectName,"text")
                .签名(startX,startY,endX,endY).未确认同意书();
        new TestPage().back();
        assertThat(testResult,equalTo(expectation));
    }

    @Test
    void 开始筛查(){

    }


}
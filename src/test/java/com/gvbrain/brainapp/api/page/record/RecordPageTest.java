package com.gvbrain.brainapp.api.page.record;

import com.gvbrain.brainapp.api.page.MainPage;
import com.gvbrain.brainapp.api.page.login.LoginPage;
import com.gvbrain.brainapp.api.testcase.AppTestCase;
import com.gvbrain.brainapp.api.util.BaseUtil;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

class RecordPageTest extends AppTestCase {

    BaseUtil baseUtil = new BaseUtil();

    @BeforeAll
    static void beforeEvaluativePageTest(){
        String username = "18616210504";
        String password = "suiren123";
        LoginPage.getInstance().登录成功(username,password);
        try {
            MainPage.getInstance().find(new MainPage().A首页,null);
        }catch (Exception e) {
            System.out.println("[ERROR]:未成功进入首页,登录失败]");
        }
    }

    @BeforeEach
    void beforeEach(){
            MainPage.getInstance().gotoHome();
    }

    @Test
    void 创建患者(){
        //todo:对参数进行封装,配置驱动
        String password = "suiren123";
        String context = "其他药物";
        String expectation = "操作成功";
        String testResult = MainPage.getInstance().gotoRecord().IntoByPassword(password).gotoCreateUser()
                .FileInBaseInfo()
                .FileInMedicalRecord(context);
        assertThat(testResult,equalTo(expectation));
    }

    @Test
    void deletePatient() {
        String patientName = baseUtil.getRandomPatientName();
        String phoneNumber = baseUtil.getRandomPhoneNumber();
        String expectation = "操作成功";
        String password = "suiren123";
        String context = "其他药物";
        MainPage.getInstance().gotoRecord().IntoByPassword(password).gotoCreateUser().FileInBaseInfo(patientName,phoneNumber).FileInMedicalRecord(context);
        String testResult = null;
        try {
            testResult = MainPage.getInstance().gotoRecord().editPatient().checkPatient(patientName,phoneNumber).deletePatient();
        } catch (Exception e) {
            e.printStackTrace();
        }
        assertThat(testResult,equalTo(expectation));
    }
}
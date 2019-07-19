package com.gvbrain.brainapp.api.page.login;

import com.gvbrain.brainapp.api.page.MainPage;
import com.gvbrain.brainapp.api.page.login.LoginPage;
import com.gvbrain.brainapp.api.testcase.AppTestCase;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LoginPageTest extends AppTestCase {

    @BeforeEach
    void setUp(){
//        LoginPage.getInstance().gotoLogin();
    }

    @Test
    @Order(4)
    void 登录成功() {
        String username = "18616210504";
        String password = "suiren123";
        LoginPage.getInstance().登录成功(username,password);
        try {
            MainPage.getInstance().find(new MainPage().A首页,null);
        }catch (Exception e) {
            System.out.println("[ERROR]:未成功进入首页,登录失败]");
            e.printStackTrace();
            assertThat(1,equalTo(0));
        }
    }

    @Order(2)
    @ParameterizedTest
    @CsvSource({
            "123456,123456,用户信息不存在",
            "18616210504,123456,密码错误"
    })
    void 账号或密码错误登录(String username,String password,String expectation){
        String testResult = LoginPage.getInstance().账号或密码错误(username,password);
        assertThat(testResult,equalTo(expectation));
    }

    @Test
    @Order(1)
    void 未选协议书登录(){
        String username = "18616210504";
        String password = "suiren123";
        String expectation = "请阅读并勾选使用协议书";
        String testResult =LoginPage.getInstance().协议书未选登录(username,password);
        assertThat(testResult,equalTo(expectation));
    }

    @Test
    @Order(3)
    void 退出登录(){
        String username = "18616210504";
        String password = "suiren123";
        MainPage mainPage = LoginPage.getInstance().登录成功(username, password);
        String testResult = mainPage.gotoSet().logout();
        assertThat(testResult,equalTo(username));
    }
}
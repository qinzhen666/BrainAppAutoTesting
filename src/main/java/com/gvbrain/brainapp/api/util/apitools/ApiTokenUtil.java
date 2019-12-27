package com.gvbrain.brainapp.api.util.apitools;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class ApiTokenUtil extends ApiUtil{

    private static String token;
    private static String BrainPlatformTestUrl = "http://192.168.1.103/brain/rest/user/login";
    private static String BrainPlatformDevUrl = "http://47.103.47.170/brain/rest/user/login";

    @Override
    public RequestSpecification getDefaultRequestSpecification(String tokenPattern){
        RequestSpecification requestSpecification = super.getDefaultRequestSpecification(tokenPattern);
        try {
            requestSpecification.header("Token",ApiTokenUtil.getToken(tokenPattern)).contentType(ContentType.JSON);
            return requestSpecification;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String getBrainPlatformAppToken(){
        String url = setLoginEnv();
        String body = "{\"userName\":\"18616210504\",\"password\":\"suiren123\",\"userType\":1}";
        return RestAssured.given().log().all()
                .body(body)
                .when().post(url)
                .then().log().all().statusCode(200)
                .extract().response().getHeader("Token");
    }

    //todo:适应不同登录方式或权限的不同类型token
    public static String getBrainAppSpecialToken(){
        return null;
    }

    public static String setLoginEnv(){
        String url = "";
        String currentEnv = ApiConfig.getInstance().currentEnv;
        if (currentEnv.equals("brainPlatformTest")){
            url = BrainPlatformTestUrl;
            return url;
        }
        if (currentEnv.equals("brainPlatformDev")){
            url = BrainPlatformDevUrl;
            return url;
        }
        return url;
    }

    public static String getToken(String tokenPattern) throws Exception {
        //todo:支持两种类型的token
            if (token == null){
                    if (tokenPattern.equals("brainPlatform")){
                        token = getBrainPlatformAppToken();
                        return token;
                    }
                    if (tokenPattern.equals("specialToken")){
                        token = getBrainAppSpecialToken();
                        return token;
                    }else {
                    throw new Exception("[Error]未找到匹配的tokenPattern");
                }
        }return token;
    }
}

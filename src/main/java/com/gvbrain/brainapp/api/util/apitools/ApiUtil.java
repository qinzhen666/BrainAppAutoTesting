package com.gvbrain.brainapp.api.util.apitools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import java.io.IOException;
import java.util.HashMap;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.useRelaxedHTTPSValidation;

public class ApiUtil {
    public HashMap<String,Object> query = new HashMap<>();

    //信任HTTPS证书
    public ApiUtil(){
        useRelaxedHTTPSValidation();
    }

    public RequestSpecification getDefaultRequestSpecification(String tokenPattern){
        RequestSpecification requestSpecification = given().log().all();
        return requestSpecification;
    }

    public static String template(String path,HashMap<String,Object> map){
        DocumentContext documentContext = JsonPath.parse(ApiUtil.class.getResourceAsStream(path));
        if (map == null){
            return documentContext.jsonString();
        }
        map.entrySet().forEach(entry->{
            documentContext.set(entry.getKey(),entry.getValue());
        });
        return documentContext.jsonString();
    }

    public Restful getApiFromYaml(String yamlPath){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(ApiUtil.class.getResource(yamlPath),Restful.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    public Restful updateApiFromMap(Restful restful, HashMap<String,Object> map){
        if (map == null){
            return restful;
        }
        if (restful.method.toLowerCase().contains("get")) {
            map.entrySet().forEach(entry -> {
                System.out.println("+++++++++++++++++"+entry.getKey()+"="+entry.getValue());
//                restful.query.replace(entry.getKey(),entry.getValue());
                restful.query.put(entry.getKey(),entry.getValue());
                System.out.println("==================================="+restful.query);
            });
        }
        if (restful.method.toLowerCase().contains("post")) {
            if (map.containsKey("_body")) {
                restful.body = map.get("_body").toString();
            }
            if (map.containsKey("_file")) {
                String filePath = map.get("_file").toString();
                map.remove("_file");
                restful.body = template(filePath, map);
            }
        }
        return restful;
    }

    public Response getResponseFromApi(Restful restful,String tokenPattern){
        RequestSpecification requestSpecification = getDefaultRequestSpecification(tokenPattern);
        if (restful.query != null) {
            restful.query.entrySet().forEach(entry -> {
                requestSpecification.queryParam(entry.getKey(), entry.getValue());
            });
        }
        if (restful.body != null){
            requestSpecification.body(restful.body);
        }

        String[] upUrl = updateUrl(restful.url);
        return requestSpecification.log().all()
                .header("Host",upUrl[0])
                .request(restful.method,upUrl[1])
                .then().log().all().extract().response();
    }

    public static String[] updateUrl(String url){
        //fixed:多环境支持，替换url，更新header的Host
        HashMap<String,String> Hosts = ApiConfig.getInstance().env.get(ApiConfig.getInstance().currentEnv);
        final String[] Host = {""};
        final String[] urlNew = {""};
        Hosts.entrySet().forEach(entry->{
            if (url.contains(entry.getKey())){
                Host[0] = entry.getKey();
                urlNew[0] = url.replace(entry.getKey(),entry.getValue());
            }
        });
        return new String[]{Host[0], urlNew[0]};
    }

    public Response getResponseFromYaml(String yamlPath,HashMap<String,Object> map,String tokenPattern){
        //fixed:根据yaml生成接口定义并发送
        Restful restful = getApiFromYaml(yamlPath);
        restful = updateApiFromMap(restful, map);
        return getResponseFromApi(restful,tokenPattern);
    }
}

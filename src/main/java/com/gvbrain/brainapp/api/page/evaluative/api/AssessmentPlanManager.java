package com.gvbrain.brainapp.api.page.evaluative.api;

import com.gvbrain.brainapp.api.util.apitools.ApiTokenUtil;
import com.gvbrain.brainapp.api.util.apitools.ApiUtil;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;

public class AssessmentPlanManager extends ApiTokenUtil {
    private String tokenPattern = "brainPlatform";

    public Response getAllAssessmentPlanInfo(){
        HashMap<String,Object> map = new HashMap<>();
        return getResponseFromYaml(
                "/data/api/restAssessmentPlanList.yaml",
                map,
                tokenPattern
        );
    }

    public Response deleteAssessmentPlan(Integer uid){
        HashMap<String,Object> map = new HashMap<>();
        map.put("uid",uid);
        return getResponseFromYaml(
                "/data/api/deleteAssessmentPlan.yaml",
                map,
                tokenPattern
        );
    }

    public void deleteAllAssessmentPlan(){
        List<Integer> idList = getAllAssessmentPlanInfo().then().log().all().extract().path("body.uid");
        idList.forEach(uid->{
            deleteAssessmentPlan(uid);
        });
    }


}

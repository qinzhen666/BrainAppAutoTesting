package com.gvbrain.brainapp.api.page.record.api;

import com.gvbrain.brainapp.api.util.apitools.ApiTokenUtil;
import io.restassured.response.Response;
import java.util.HashMap;
import java.util.List;

public class PatientManger extends ApiTokenUtil {
    private String tokenPattern = "brainPlatform";


    public Response deletePatient(Integer id){
        HashMap<String,Object> map = new HashMap<>();
        map.put("uid",id);
        return getResponseFromYaml(
                "/data/api/deletePatient.yaml",
                map,
                tokenPattern
        );
    }

    public Response deleteAllPatients(){
        List<Integer> idList = getAllPatientInfoByList().then().log().all()
                                     .extract().path("body.patient.uid");
        System.out.println("idList是"+idList);
        for (Integer uid: idList) {
            System.out.println("遍历IDList");
            deletePatient(uid);
        }
        return null;
    }

    public Response getAllPatientInfoByList(){
        HashMap<String,Object> map = new HashMap<>();
        map.put("_file","/data/apijson/getPatientByList.json");
        return getResponseFromYaml(
                "/data/api/restpatientsList.yaml",
                map,
                tokenPattern
        );
    }
}

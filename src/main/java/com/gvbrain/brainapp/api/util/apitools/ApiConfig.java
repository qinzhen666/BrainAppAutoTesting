package com.gvbrain.brainapp.api.util.apitools;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import java.io.IOException;
import java.util.HashMap;

public class ApiConfig {

    private static ApiConfig apiConfig;
    public String currentEnv = "brainPlatformDev";
    public HashMap<String,HashMap<String,String>> env;

    public static ApiConfig getInstance(){
        if (apiConfig == null){
            apiConfig = load("/data/brainPlatformApiConfig.yaml");
        }
        return apiConfig;
    }

    public static ApiConfig load(String path){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        try {
            return mapper.readValue(ApiConfig.class.getResource(path),ApiConfig.class);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}

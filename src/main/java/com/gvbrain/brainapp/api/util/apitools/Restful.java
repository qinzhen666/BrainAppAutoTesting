package com.gvbrain.brainapp.api.util.apitools;

import java.util.HashMap;

public class Restful {
    public String url;
//    public String path;//swagger中API的地址
    public String method;
    public HashMap<String,Object> headers;
    public HashMap<String,Object> query = new HashMap<>();
    public String body;
}

package com.gvbrain.brainapp.api.driver;

import java.util.HashMap;

public class AppiumConfig {
    public String app = "";
    public String url = "";
    public Integer wait = 6;
    public HashMap<String,Object> capabilities = new HashMap<String, Object>();
}

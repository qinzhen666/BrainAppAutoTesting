package com.gvbrain.brainapp.api.page.record.pojo;

import com.gvbrain.brainapp.api.util.BaseUtil;

public class CreateUserInfo {

    BaseUtil baseUtil = new BaseUtil();

    public String patientName = baseUtil.getRandomPatientName();
    public String sex = "男";
    public String phoneNumber = baseUtil.getRandomPhoneNumber();
    public String marriageText = "其它";
    public String marriageTypeContext = "其它";
    public String marriageType = "TEXT";
    public String jobText = "公务员";
    public String jobTypeContext = "公务员";
    public String jobType = "TEXT";
    public String educationText = "大学";
    public String educationTypeContext = "大学";
    public String educationType = "TEXT";
    public String eduTimeText = "6";
    public String eduTimeTypeContext = "6";
    public String eduTimeType = "TEXT";
}

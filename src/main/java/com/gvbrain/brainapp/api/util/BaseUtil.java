package com.gvbrain.brainapp.api.util;

import java.util.Random;

public class BaseUtil {
    Random random = new Random();

    public String getRandomAlphabet(){
        String randomName = "";
        String s = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
        char[] c = s.toCharArray();
        Random random = new Random();
        for( int i = 0; i < 8; i ++) {
            randomName +=  c[random.nextInt(c.length)];
//            System.out.println(c[random.nextInt(c.length)]);
        }
        return randomName;
    }

    public String getRandomPatientName(){
        return "患者" +getRandomAlphabet();
    }

    public String getRandomPhoneNumber(){
        String mobilephone = "139";
        for (int i = 0;i < 8; i++){
            mobilephone+= random.nextInt(9);
        }
        return mobilephone;
    }

    public String getRandomProjectName(){
        return "方案名称"+ System.currentTimeMillis();
    }

    public String getRandomIntro(){
        return "auto方案简介"+ System.currentTimeMillis();
    }
}

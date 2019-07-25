package com.gvbrain.brainapp.api.util;

import com.gvbrain.brainapp.api.driver.Driver;
import org.apache.commons.io.FileUtils;
import org.aspectj.util.FileUtil;
import org.openqa.selenium.OutputType;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class BaseUtil {
    Random random = new Random();

    public String  ScreenshotAsDate(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd-HHmmss");
        String picName = sdf.format(new Date());//获取当前系统时间作为截图名
        String picOriginalPath = "D:\\QinZhen\\TestDev\\appium\\AppiumTest\\BrainAppTesting\\src\\main\\resources\\data\\image\\"
                + picName + ".png";
        File screen = Driver.getInstance().appiumDriver.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(screen,new File(picOriginalPath));
            return picOriginalPath;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

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

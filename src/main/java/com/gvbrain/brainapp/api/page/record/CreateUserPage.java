package com.gvbrain.brainapp.api.page.record;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLFactory;
import com.gvbrain.brainapp.api.driver.Driver;
import com.gvbrain.brainapp.api.page.BasePage;
import com.gvbrain.brainapp.api.page.record.pojo.CreateUserInfo;
import com.gvbrain.brainapp.api.util.BaseUtil;
import com.gvbrain.brainapp.api.util.JavaCVUtil;
import com.gvbrain.brainapp.api.util.ScrollSelectUtil;
import io.appium.java_client.TouchAction;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class CreateUserPage extends BasePage {

    //android定位elements
    //基本信息
    private By A姓名 = By.id("edit_name");
    private By A性别男 = By.id("image_boy");
    private By A性别女 = By.id("image_girl");
    private By A联系电话 = By.id("edit_phone");
    private By A出生日期 = By.id("relative_date");
    private By A婚姻状况 = By.id("text_huny");
    private By A职业 = By.id("text_vocation");
    private By A受教育程度 = By.id("text_edu");
    private By A受教育年限 = By.id("text_eduyears");
    private By A常驻地 = By.id("text_city");
    private By A确定 = By.id("tv_finish");
    private By A下一步 = By.id("text_next");
    private By A返回 = By.id("bar_btn_image_left");
    //病历
    private By A认知障碍MCI = By.xpath("//*[contains(@resource-id,'linear_mci')]/android.widget.ImageView");
//    private By AMCI其它 = By.xpath("//*[contains(@resource-id,'linearSon9')]//android.widget.ImageView");
    private By AMCI其它 = By.id("linearSon9");
    private By AMCI非必填 = By.id("edit_other_yongyao");
    private By A脑外伤是 = By.xpath("//*[contains(@resource-id,'linear_yesNaow')]/android.widget.ImageView");
    private By A家族史否 = By.xpath("//*[contains(@resource-id,'linear_noFam')]/android.widget.ImageView");
    private By A保存 = By.id("text_save");
    private By A保存成功 = By.xpath("//*[@class='android.widget.Toast']");

    //ios定位elements


    public CreateUserInfo loadYamlData(String dataPath){
        ObjectMapper mapper = new ObjectMapper(new YAMLFactory());
        CreateUserInfo createUserInfo = null;
        try {
            createUserInfo = mapper.readValue(CreateUserInfo.class.getResource(dataPath), CreateUserInfo.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return createUserInfo;
    }

    public CreateUserPage FileInBaseInfo(){
        CreateUserInfo createUserInfo = loadYamlData("/data/record/creatUserInfo.yaml");
        sendKeys(A姓名,null,createUserInfo.patientName);
        if (createUserInfo.sex.equals("男")){
            click(A性别男,null);
        }else {
            click(A性别女,null);
        }
        sendKeys(A联系电话,null,createUserInfo.phoneNumber);
        click(A出生日期,null);
        //select出生日期
        click(A确定,null);
        click(A婚姻状况,null);
        ScrollSelectUtil selectUtil = new ScrollSelectUtil();
        //滑动查找所选婚姻状况marriageText
        selectUtil.scrollSelect(createUserInfo.marriageText,createUserInfo.marriageTypeContext,createUserInfo.marriageType);
        click(A职业,null);
        //滑动查找所选职业jobText
        selectUtil.scrollSelect(createUserInfo.jobText,createUserInfo.jobTypeContext,createUserInfo.jobType);
        click(A受教育程度,null);
        //滑动查找所选受教育程度educationText
        selectUtil.scrollSelect(createUserInfo.educationText,createUserInfo.educationTypeContext,createUserInfo.educationType);
        click(A受教育年限,null);
        //滑动查找所选受教育年限eduTimeText
        selectUtil.scrollSelect(createUserInfo.eduTimeText,createUserInfo.eduTimeTypeContext,createUserInfo.eduTimeType);
        click(A常驻地,null);
        click(A确定,null);
        click(A下一步,null);
        return this;
    }

    public CreateUserPage FileInBaseInfo(String patientName,String phoneNumber){
        String comparisonPicPath = "D:\\QinZhen\\TestDev\\appium\\AppiumTest\\BrainAppTesting\\src\\main\\resources\\data\\image\\addressComparisonPic.png";
        ScrollSelectUtil selectUtil = new ScrollSelectUtil();
        CreateUserInfo createUserInfo = loadYamlData("/data/record/creatUserInfo.yaml");
        sendKeys(A姓名,null,patientName);
        if (createUserInfo.sex.equals("男")){
            click(A性别男,null);
        }else {
            click(A性别女,null);
        }
        sendKeys(A联系电话,null,phoneNumber);
        click(A出生日期,null);
        //select出生日期
        click(A确定,null);
        click(A婚姻状况,null);
        //滑动查找所选婚姻状况marriageText
        selectUtil.scrollSelect(createUserInfo.marriageText,createUserInfo.marriageTypeContext,createUserInfo.marriageType);
        click(A职业,null);
        //滑动查找所选职业jobText
        selectUtil.scrollSelect(createUserInfo.jobText,createUserInfo.jobTypeContext,createUserInfo.jobType);
        click(A受教育程度,null);
        //滑动查找所选受教育程度educationText
        selectUtil.scrollSelect(createUserInfo.educationText,createUserInfo.educationTypeContext,createUserInfo.educationType);
        click(A受教育年限,null);
        //滑动查找所选受教育年限eduTimeText
        selectUtil.scrollSelect(createUserInfo.eduTimeText,createUserInfo.eduTimeTypeContext,createUserInfo.eduTimeType);
        click(A常驻地,null);
        click(By.id("options1"),null);
        swipeByCoordinate(comparisonPicPath);
        click(A下一步,null);
        return this;
    }

    public String FileInMedicalRecord(String context){
        click(A认知障碍MCI,null);
        click(AMCI其它,null);
        sendKeys(AMCI非必填,null,context);
        ScrollSelectUtil selectUtil = new ScrollSelectUtil();
        selectUtil.scrollSelect("*是否有老年痴呆家族史 : ","*是否有老年痴呆家族史 : ","text");
        click(A脑外伤是,null);
        click(A家族史否,null);
        click(A保存,null);
        return find(A保存成功,null).getText();
    }


    public RecordPage checkPatient(String patientName,String phoneNumber) throws Exception {
        String checkName = getText(A姓名,null);
        String checkPhone = getText(A联系电话,null);
        if (patientName.equals(checkName) && phoneNumber.equals(checkPhone)) {
            click(A返回,null);
            click(byText("确定"),null);
            return new RecordPage();
        }else {
            click(A返回,null);
            click(byText("确定"),null);
            throw new Exception("[ERROR]患者信息不匹配,列表首位患者与目标删除患者不一致!");
        }
    }

    private void swipeByCoordinate(String comparisonPicPath){
        int startX = 740; int startY = 692;
        int endX = 740; int endY = 630;
        boolean check = false;
        for (int i = 0;i<34; i++){
            String originalPicPath = new BaseUtil().ScreenshotAsDate();//获取原图片文件
            System.out.println(originalPicPath);
            check = new JavaCVUtil().javaCVTest(comparisonPicPath,originalPicPath);
            new File(originalPicPath).delete();//每次匹配完成后将截图删除
            if (check){ //如果匹配到了浙江省就确定
                click(A确定,null);
                break;
            }else {
                new TouchAction<>(Driver.getInstance().appiumDriver)
                        .press(PointOption.point(startX,startY))
                        .waitAction(WaitOptions.waitOptions(Duration.ofMillis(500)))
                        .moveTo(PointOption.point(endX,endY))
                        .release().perform();
            }

        }
    }



}

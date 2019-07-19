package com.gvbrain.brainapp.api.driver;

import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class Element {

    public By android;
    public By ios;
    public By h5;

    public Element(By android,By ios){
        this.android = android;
        this.ios = ios;
    }

    public Element(String path){
        //load(path)
    }

    public WebElement find(){
        WebElement element = null;
        if (Driver.getInstance().getPlatform().equals("Android")){
            element = getWebElement(android);
        }else if (Driver.getInstance().getPlatform().equals("ios")){
            element = getWebElement(ios);
        }
        return element;
    }

    public List<WebElement> findElements(){
        List<WebElement> element = new ArrayList<WebElement>();
        if (Driver.getInstance().getPlatform().equals("android")){
            element = getWebElements(android);
        }else if (Driver.getInstance().getPlatform().equals("ios")){
            element = getWebElements(ios);
        }
        return element;
    }

    private WebElement getWebElement(By platformEle) {
            if (Driver.getInstance().find(platformEle) != null){
                 return  Driver.getInstance().find(platformEle);
            }try {
                //todo:弹框处理,getPageSource + xpath
                //弹框xpath列表
//            System.out.println("弹框处理");
            }
            catch (Exception e){
                System.out.println(platformEle+"不是当前所需定位元素");
            }
            return null;
        }

    private List<WebElement> getWebElements(By platformEle) {
        if (Driver.getInstance().find(platformEle) != null){
            return Driver.getInstance().findElements(platformEle);
        }try {
            //todo:弹框处理,getPageSource + xpath
            //弹框xpath列表
//            System.out.println("弹框处理");
        }
        catch (Exception e){
            System.out.println(platformEle+"不是当前所需定位元素");
        }
        return null;
    }
}

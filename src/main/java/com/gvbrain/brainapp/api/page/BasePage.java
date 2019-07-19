package com.gvbrain.brainapp.api.page;

import com.gvbrain.brainapp.api.driver.Element;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class BasePage {

    public WebElement find(By android,By ios){
       WebElement element =  new Element(android,ios).find();
       return element;
    }

    public List<WebElement> findElements(By android,By ios){
        List<WebElement> elements = new Element(android,ios).findElements();
        return elements;
    }

    public By byText(String text){
        //todo:特殊字符处理
        return By.xpath("//*[@text='"+ text + "']");
    }

    public void click(By android,By ios){
        find(android,ios).click();
    }

    public void sendKeys(By android,By ios,String context){
        find(android,ios).sendKeys(context);
    }

    public String attribute(By android,By ios,String name){
        return find(android,ios).getAttribute(name);
    }

    public String getToastText(){
        return find(By.xpath("//*[@class='android.widget.Toast']"),null).getText();
    }

    public String getText(By android,By ios){
        return find(android,ios).getText();
    }

}

package com.gvbrain.brainapp.api.util;

import com.gvbrain.brainapp.api.driver.Driver;
import com.gvbrain.brainapp.api.page.BasePage;
import io.appium.java_client.MobileBy;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.openqa.selenium.By;

@Data
@AllArgsConstructor
public class ScrollSelectUtil extends BasePage {
    /*// find element by text
    public static final String TEXT = "TEXT";

    // find element by id
    public static final String ID = "ID";

    // find element by classname
    public static final String CLASSNAME = "CLASSNAME";

    // find element by AccessibilityId
    public static final String ACCESSIBILITYID = "AccessibilityId";

    public static final String INDEX = "INDEX";

    public static final String INSTENCE = "INSTENCE";
*/
    // name,id,AccessibilityId method
    private String scrollTo(String content, String type)
    {
        String uiautomatorStr = null;

        if (type.equals("text"))
        {
            uiautomatorStr =
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().text(\"" + content
                            + "\"))";
        }

        else if (type.equals("id"))
        {
            uiautomatorStr =
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().resourceId(\""
                            + content + "\"))";
        }

        else if (type.equals("AccessibilityId"))
        {
            uiautomatorStr =
                    "new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(new UiSelector().description(\""
                            + content + "\"))";
        }
        return uiautomatorStr;
    }

    // className method
    private String scrollTo(String className, String classType, String type, int number)
    {
        String uiautomatorStr = null;

        // find element by classname && index
        if (classType.equals("classname") && type.equals("index"))
        {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true).index(" + number
                    + ")).getChildByText(new UiSelector().className(\"" + className + "\")";
        }
        // find element by classname && instance
        else if (classType.equals("classname") && type.equals("instance"))
        {
            uiautomatorStr = "new UiScrollable(new UiSelector().scrollable(true).instance(" + number
                    + ")).getChildByText(new UiSelector().className(\"" + className + "\")";
        }
        return uiautomatorStr;
    }

    public void scrollSelect(String clickText,String content, String type){
        By selectName = MobileBy.AndroidUIAutomator(scrollTo(content,type));
        find(selectName,null);
        click(byText(clickText),null);
    }

    public void scrollSelect(String clickText,String className, String classType, String type, int number){
        By selectName = MobileBy.AndroidUIAutomator(scrollTo(className, classType, type,number));
        find(selectName,null);
        click(byText(clickText),null);
    }
}


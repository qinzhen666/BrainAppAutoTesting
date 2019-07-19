package com.gvbrain.brainapp.api.page.evaluative;

import com.gvbrain.brainapp.api.page.BasePage;
import com.gvbrain.brainapp.api.util.ScrollSelectUtil;

public class MyProjectPage extends BasePage {

    //Android定位elements

    //ios定位elements

    public TestPage gotoTest(String myProjectName,String nameTypeContext,String type){
        new ScrollSelectUtil().scrollSelect(myProjectName,nameTypeContext,type);
        return new TestPage();
    }

}

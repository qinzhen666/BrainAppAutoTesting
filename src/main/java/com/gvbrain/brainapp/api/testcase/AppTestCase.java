package com.gvbrain.brainapp.api.testcase;

import com.gvbrain.brainapp.api.driver.Driver;
import com.gvbrain.brainapp.api.page.evaluative.api.AssessmentPlanManager;
import com.gvbrain.brainapp.api.page.record.api.PatientManger;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;



public class AppTestCase {

    static PatientManger patientManger;
    static AssessmentPlanManager assessmentPlanManager;
    @BeforeAll
    public static void beforeAllTestCase(){
        if (patientManger == null){
            patientManger = new PatientManger();
            patientManger.deleteAllPatients();
        }

        if (assessmentPlanManager == null){
            assessmentPlanManager = new AssessmentPlanManager();
            assessmentPlanManager.deleteAllAssessmentPlan();
        }
        Driver.getInstance().start();
    }

    @AfterAll
    public static void afterAllTestCase(){
        Driver.getInstance().appiumDriver.quit();
    }
}

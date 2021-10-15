package com.sagemcom.steps;

import com.sagemcom.pageObjects.ActivityPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class ActivityStep implements En {

    public ActivityStep(ActivityPage activityPage){

        When("Click on the right  chevron of the carousel", activityPage::clickOnBtnNext);

        Then("No image displayed", ()-> {
            activityPage.saveScreenShotPNG();
            Assert.assertTrue(activityPage.imageIsLoad());
        });

    }

}

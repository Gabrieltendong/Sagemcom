package com.sagemcom.steps;

import com.sagemcom.Enum.Context;
import com.sagemcom.context.ScenarioContext;
import com.sagemcom.pageObjects.SitePlanPage;
import io.cucumber.java8.En;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;

public class SitePlanStep implements En {

    public SitePlanStep(
            SitePlanPage sitePlanPage,
            ScenarioContext scenarioContext
    ){
        When("Click on \"Autres\"", ()-> {
            scenarioContext.set(Context.TITLE, sitePlanPage.getTitle());
            sitePlanPage.clickOnOrderLink();
            sitePlanPage.waiter();
        });

        Then("the site plan reload", ()-> {
            sitePlanPage.saveScreenShotPNG();
            Assert.assertFalse(
                    sitePlanPage.getTitle()
                    .contains(scenarioContext.get(Context.TITLE))
            );
        });
    }

}

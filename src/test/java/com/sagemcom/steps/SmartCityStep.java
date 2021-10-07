package com.sagemcom.steps;

import com.sagemcom.pageObjects.SmartCityPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class SmartCityStep implements En {

    public SmartCityStep(SmartCityPage smartCityPage){

        And("Click on the logo Sagemcom in the navigation bar", smartCityPage::clickOnLogo);

        Then("Redirection to an 404 error page", ()-> {
            smartCityPage.saveScreenShotPNG();
            Assert.assertFalse(smartCityPage.pageIsNotFound());
        });

    }

}

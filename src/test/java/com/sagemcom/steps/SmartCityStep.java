package com.sagemcom.steps;

import com.sagemcom.pageObjects.SmartCityPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class SmartCityStep implements En {

    public SmartCityStep(SmartCityPage smartCityPage){

        And("Click on the logo Sagemcom in the navigation bar", smartCityPage::clickOnLogo);

        And("Click on \"Acceptez tout\" located on top at the right side", smartCityPage::clickOnAcceptAll);

        When("Scroll to the footer", smartCityPage::scrollToFooter);

        Then("Redirection to an 404 error page", ()-> {
            smartCityPage.saveScreenShotPNG();
            Assert.assertFalse(smartCityPage.pageIsNotFound());
        });

        Then("Display of the homepage in a new tab", ()-> {
            smartCityPage.saveScreenShotPNG();
            Assert.assertFalse(smartCityPage.isHomePage());
        });

        Then("Social network icons are replaced by squares", ()-> {
            smartCityPage.saveScreenShotPNG();
            Assert.assertFalse(smartCityPage.isDisplayIcons());
        });

    }

}

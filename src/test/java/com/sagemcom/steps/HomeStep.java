package com.sagemcom.steps;

import com.sagemcom.pageObjects.HomePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class HomeStep implements En {

    public HomeStep(HomePage homePage){

        Given("Go to Sagemcom homepage", ()-> {
            homePage.openHomePage();
            homePage.handleCookie();
        });

        When("Click on \"smart city\"", homePage::clickOnSmartCity);

        When("Fly over the link \"Activitéz\"", homePage::hoverActivityLink);

        Then("The cursor changes to a text selector", ()-> {
            homePage.saveScreenShotPNG();
            Assert.assertTrue(homePage.ispPointerCursor());
        });

    }
}

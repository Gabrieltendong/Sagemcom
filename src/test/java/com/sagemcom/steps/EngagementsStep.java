package com.sagemcom.steps;

import com.sagemcom.pageObjects.EngagementsPage;
import com.sagemcom.pageObjects.HomePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class EngagementsStep implements En {

    public EngagementsStep(
            EngagementsPage engagementsPage,
            HomePage homePage
    ){

        Given("^Go to the page ([^\"]*)$", (String url)-> {
            engagementsPage.openHome(url);
            homePage.handleCookie();

        });

        When("Click on \"Nos certifications\"", engagementsPage::clickOnOurCertificatLink);

        And("Go back to the tab of the page \"Engagements\"", engagementsPage::goBackTabs);

        Then("Presence of a dialogue box", ()-> {
            Assert.assertFalse(engagementsPage.modalIsDisplay());
        });

    }

}

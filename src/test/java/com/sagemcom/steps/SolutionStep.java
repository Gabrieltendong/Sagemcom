package com.sagemcom.steps;

import com.sagemcom.Enum.Context;
import com.sagemcom.context.ScenarioContext;
import com.sagemcom.pageObjects.SolutionPage;
import io.cucumber.java8.En;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class SolutionStep implements En {

    public SolutionStep(
            SolutionPage solutionPage,
            ScenarioContext scenarioContext
    ) {

        When("Scroll down to the section \"Decouvrez nos différentes solutions de comptage\"", solutionPage::scrollToBloc);

        And("^Click on one of the (.*)$", (String button)-> {
            scenarioContext.set(Context.TITLE, solutionPage.getTitle());
            solutionPage.clickOnLink(button);
            Thread.sleep(5000);
        });

        Then("No reaction", ()-> {
            solutionPage.saveScreenShotPNG();
            Assert.assertFalse(solutionPage.getTitle().contains(scenarioContext.get(Context.TITLE)));
        });

    }

}

package com.sagemcom.steps;

import com.sagemcom.pageObjects.CareerPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class CareerStep implements En {

    public CareerStep(CareerPage careerPage){

        When("Clik on \"Type de contract\" in the filter", careerPage::clickOnTypeContrat);

        Then("The third checkbox has no text", () -> {
            careerPage.saveScreenShotPNG();
            Assert.assertTrue(careerPage.isVisibleTextLabel());
        });

    }

}

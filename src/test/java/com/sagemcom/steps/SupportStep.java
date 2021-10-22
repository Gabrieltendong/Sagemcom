package com.sagemcom.steps;

import com.sagemcom.pageObjects.SupportPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class SupportStep implements En {

    public SupportStep(SupportPage supportPage){

        When("Scroll down to the section \"Recherche par catégorie\" and click on \"Décodeurs-Son\"", supportPage::clickOnDecoderLink);

        When("Scroll down to the section \"recherche par catégorie\"", supportPage::scrollToBloc);

        And("Unroll the list \"Gamme\"", supportPage::clickOnSelect);

        Then("\"Decodeur satellite\" displayed twice", ()-> {
            supportPage.saveScreenShotPNG();
            Assert.assertFalse(supportPage.isDuplicate());
        });

        Then("There is \"Read more\" under each category", ()-> {
            supportPage.saveScreenShotPNG();
            Assert.assertTrue(supportPage.isEnglishText());
        });

    }

}

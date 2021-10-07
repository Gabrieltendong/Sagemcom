package com.sagemcom.steps;

import com.sagemcom.pageObjects.IncidentPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class IncidentStep implements En {

    public IncidentStep(IncidentPage incidentPage){

        And("Click on the search icon in the navigation bar", incidentPage::clickOnBtnSearch);

        When("^Enter ([^\"]*) in the field \"search\" and validate$", (String term)-> {
            incidentPage.setTermSearch(term);
            incidentPage.submitSearchTerm();
        });

        Then("Display of an error page 404 with the title \"Not found\"", ()-> {
            Assert.assertTrue(incidentPage.pageIsFound());
        });

    }

}

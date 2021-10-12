package com.sagemcom.steps;

import com.sagemcom.pageObjects.IncidentPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java8.En;
import org.testng.Assert;

public class IncidentStep implements En {

    public IncidentStep(IncidentPage incidentPage){

        And("Click on the search icon in the navigation bar", incidentPage::clickOnBtnSearch);

        And("Click on \"Déclarer un nouvel incident\"", incidentPage::clickOnbtnReportIncident);

        And("^Enter the ([^\"]*) and ([^\"]*)$", (String reference, String password)-> {
            incidentPage.setReference(reference);
            incidentPage.setPassword(password);
        });

        When("^Enter ([^\"]*) in the field \"search\" and validate$", (String term)-> {
            incidentPage.setTermSearch(term);
            incidentPage.submitSearchTerm();
        });

        When("Click on \"suivant\"", incidentPage::clickOnNext);

        When("Click on \"Envoyer\"", incidentPage::clickOnLoginSubmit);

        And("Fill the form and click on \"Envoyer\"", (DataTable table)-> {
                incidentPage.createIncident(table);
        });

        And("Scroll down to the buttom of the page and click on one of the buttom \"Quitter sans modifications\"", incidentPage::clickOnClose);

        Then("Display of an error page 404 with the title \"Not found\"", ()-> {
            incidentPage.pageIsFound();
            Assert.assertTrue(incidentPage.pageIsFound());
        });

        Then("Display of the dialogue box containing the reference and the password to access at the incident", ()-> {
            incidentPage.saveScreenShotPNG();
            Assert.assertTrue(incidentPage.iscorrectIncident());
        });

        Then("Display of a blank page", ()-> {
            incidentPage.saveScreenShotPNG();
            Assert.assertTrue(incidentPage.pageIsFound());
        });

    }

}

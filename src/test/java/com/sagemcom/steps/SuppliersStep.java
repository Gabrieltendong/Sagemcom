package com.sagemcom.steps;

import com.sagemcom.pageObjects.HomePage;
import com.sagemcom.pageObjects.SuppliersPage;
import io.cucumber.java8.En;

public class SuppliersStep implements En {

    public SuppliersStep(
            SuppliersPage suppliersPage,
            HomePage homePage
    ){

        Given("Go to the homepage", ()-> {
            suppliersPage.openPage();
            homePage.handleCookie();
        });

        And("Click on \"Accéder au PIM2\"", suppliersPage::clickOnPIM2);

        And("Click on \"recevoir vos commandes d'achats et saisir vos confirmations application Portail-2G\"", suppliersPage::clickOnGetCommand);
    }

}

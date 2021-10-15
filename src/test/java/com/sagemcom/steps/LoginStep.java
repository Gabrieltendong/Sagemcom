package com.sagemcom.steps;

import com.sagemcom.pageObjects.LoginPage;
import io.cucumber.java8.En;

public class LoginStep implements En {

    public LoginStep(LoginPage loginPage){

        When("Click on \"Mot de passe oublié?\"", loginPage::clickOnForgotPassLink);

        When("Click on \"Nouveau fournisseurs? Se référencer\"", ()-> {
            loginPage.clickOnBtnNewProvider();
        });

    }

}

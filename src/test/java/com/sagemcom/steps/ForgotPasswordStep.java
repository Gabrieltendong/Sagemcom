package com.sagemcom.steps;

import com.sagemcom.pageObjects.ForgotPasswordPage;
import io.cucumber.java8.En;

public class ForgotPasswordStep implements En {

    public ForgotPasswordStep(
            ForgotPasswordPage forgotPasswordPage
    ){

        And("^Enter the (.*) and click on \"suivant\"$", (String identifiant)-> {
            forgotPasswordPage.waitLoadPage();
            forgotPasswordPage.setEmail(identifiant);
            forgotPasswordPage.handleSubmit();
        });

        And("Click on the unroll list \"Choisir une question secrète\"", ()-> {
            forgotPasswordPage.selectSecretQuestion();
        });

        Then("The list does not run", ()-> {

        });

    }

}

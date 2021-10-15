package com.sagemcom.steps;

import com.sagemcom.pageObjects.RegisterPage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class RegisterStep implements En {

    public RegisterStep(RegisterPage registerPage){

        And("^Change the ([^\"]*) page on top right in Italy or in Germany$", (String language)-> {
            registerPage.selectLang(language);
        });

        Then("Some items of the page are not in the select language", ()-> {
            registerPage.saveScreenShotPNG();
            Assert.assertFalse(registerPage.isBadTranslate());
        });

    }

}

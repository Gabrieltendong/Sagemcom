package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends Page{

    @FindBy(css = "div#authenticator a")
    private WebElement forgot_pass_link;

    @FindBy(css = "button.new-provider a")
    private WebElement btn_new_provider;

    public void clickOnForgotPassLink(){
        if(longUntil(ExpectedConditions.visibilityOf(forgot_pass_link)))
            clickOnJs(forgot_pass_link);
    }

    public void clickOnBtnNewProvider() throws InterruptedException {
        Thread.sleep(30000);
        navigateTo(btn_new_provider);
    }

}

package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

public class ForgotPasswordPage extends Page{

    @FindBy(id = "forgot_password_step_one_form_email")
    private WebElement emailInput;

    @FindBy(css = "button[type=\"submit\"]")
    private WebElement btn_submit;

    @FindBy(id = "forgot_password_step_two_form_secretQuestion")
    private WebElement secretQuestion;

    public void setEmail(String identifiant){
        emailInput.sendKeys(identifiant);
    }

    public void handleSubmit(){
        clickOn(btn_submit);
    }

    public void selectSecretQuestion(){
        action.moveToElement(secretQuestion).click().perform();
    }

}

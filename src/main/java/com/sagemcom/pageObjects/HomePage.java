package com.sagemcom.pageObjects;

import com.sagemcom.config.Properties;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class HomePage extends Page{

    @FindBy(css = "div#cookiesjsr button.important")
    private WebElement btn_accepte_cookie;

    public void openHomePage(){
        get(Properties.Config.getEnvironment());
    }

    public void handleCookie(){
        if(longUntil(ExpectedConditions.visibilityOf(btn_accepte_cookie)))
            clickOn(btn_accepte_cookie);
    }

}

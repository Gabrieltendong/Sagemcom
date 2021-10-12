package com.sagemcom.pageObjects;

import com.sagemcom.config.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends Page{

    @FindBy(css = "div#cookiesjsr button.important")
    private WebElement btn_accepte_cookie;

    @FindBy(id = "4449")
    private WebElement smart_city;

    @FindBy(css = "li[data-id=\"ba8acabe-f1e1-46ff-b57d-0892d29d09d1\"]>span")
    private WebElement link_activity;

    public void openHomePage(){
        get(Properties.Config.getEnvironment());
    }

    public void hoverActivityLink(){
        action.moveToElement(link_activity).perform();
    }

    public void handleCookie(){
        if(longUntil(ExpectedConditions.visibilityOf(btn_accepte_cookie)))
            clickOn(btn_accepte_cookie);
    }

    public void clickOnSmartCity(){
        clickOn(smart_city);
    }

    public boolean ispPointerCursor(){
        return link_activity.getCssValue("cursor").contains("pointer");
    }

}

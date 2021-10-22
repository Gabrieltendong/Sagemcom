package com.sagemcom.pageObjects;

import com.sagemcom.config.Properties;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class HomePage extends Page{

    @FindBy(css = "div#cookiesjsr button.important")
    private WebElement btn_accepte_cookie;

    @FindBy(id = "4449")
    private WebElement smart_city;

    @FindBy(css = "li[data-id=\"ba8acabe-f1e1-46ff-b57d-0892d29d09d1\"]>span")
    private WebElement link_activity;

    @FindBy(css = "ul.tt-menu-nav a[title=\"de\"]")
    private WebElement de_lang;

    @FindBy(id = "menuCollapse")
    private WebElement menu;

    @FindBy(css = "div.footer-bottom-col-left a")
    private WebElement text_reset_cookie;

    @FindBy(css = "li[data-id=\"c5366493-e63f-4516-846f-072116cb5dd8\"]")
    private WebElement text_header;

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

    public void clickOnDeLang(){
        clickOn(de_lang);
    }

    public boolean isBadTranslate() throws InterruptedException {
       Thread.sleep(10000);
        return !getLanguage(menu.getText()).contains("de");
    }

    public boolean isDifferentLanguage(){
        return getLanguage(text_header.getText()).contains("fr")
                || getLanguage(text_reset_cookie.getText()).contains("fr");
    }

}

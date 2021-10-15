package com.sagemcom.pageObjects;

import org.apache.tika.language.LanguageIdentifier;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class SmartCityPage extends Page{

    @FindBy(css =  "a.navbar-brand")
    private WebElement logo_link;

    @FindBy(css = "a.btn-info")
    private WebElement btn_accept_all;

    @FindBy(id = "c31368")
    private WebElement footer;

    @FindBy(css = "div#c31368 ul>li>a>i")
    private List<WebElement> icons;

    public void clickOnLogo(){
        clickOn(logo_link);
    }

    public boolean pageIsNotFound(){
        return driver.getCurrentUrl().contains("404");
    }

    public void clickOnAcceptAll(){
        if(longUntil(ExpectedConditions.visibilityOf(btn_accept_all)))
            navigateTo(btn_accept_all);
    }

    public void scrollToFooter(){
        scrollTo(footer);
    }

    public boolean isDisplayIcons(){
        return icons.stream().anyMatch(element -> !element.isDisplayed());
    }

    public boolean isHomePage(){
        return driver.getTitle().contains("Page d'accueil | Sagemcom");
    }

}

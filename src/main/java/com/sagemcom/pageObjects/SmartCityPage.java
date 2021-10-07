package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SmartCityPage extends Page{

    @FindBy(css =  "a.navbar-brand")
    private WebElement logo_link;

    public void clickOnLogo(){
        clickOn(logo_link);
    }

    public boolean pageIsNotFound(){
        String url = driver.getCurrentUrl();
        if(url.contains("404")){
            return true;
        }
        return false;
    }

}

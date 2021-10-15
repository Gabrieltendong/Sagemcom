package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.concurrent.TimeUnit;

public class SitePlanPage extends Page{

    @FindBy(linkText = "Autres")
    private WebElement order_link;

    public void clickOnOrderLink(){
        scrollTo(order_link);
        clickOn(order_link);
    }

    public String getTitle(){
        return driver.getTitle();
    }

    public void waiter() {
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

}

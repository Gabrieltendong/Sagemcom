package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuppliersPage extends Page{

    @FindBy(id = "4773")
    private WebElement pim2_link;

    @FindBy(id = "4756")
    private WebElement command;

    private final static String URL = BASE_URL + "/fournisseurs";

    public void openPage(){
        driver.navigate().to(URL);
    }

    public void clickOnPIM2(){
        clickOn(pim2_link);
    }

    public void clickOnGetCommand(){
        clickOn(command);
    }

}

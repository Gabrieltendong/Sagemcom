package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SolutionPage extends Page{

    @FindBy(id = "portfolio-list-section")
    private WebElement portfolio_list;

    @FindBy(id = "6419")
    private WebElement lelectricite;

    @FindBy(id = "6420")
    private WebElement le_gaz;

    public void scrollToBloc(){
        scrollTo(portfolio_list);
    }

    public void clickOnLink(String button){
        if(button == "le_gaz")
            clickOn(le_gaz);
        else if(button == "lelectricite")
            clickOn(lelectricite);
    }

    public String getTitle(){
        return driver.getTitle();
    }

}

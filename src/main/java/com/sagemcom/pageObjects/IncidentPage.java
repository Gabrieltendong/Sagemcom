package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class IncidentPage extends Page{

    @FindBy(css = "ul#menu-right>li:first-child")
    private WebElement btn_search;

    @FindBy(css = "input[name=\"tx_indexedsearch[sword]\"]")
    private WebElement input_search;

    @FindBy(css = "div.dropdown-menu button[type=\"submit\"]")
    private WebElement btn_submit;

    public void clickOnBtnSearch(){
        action.moveToElement(btn_search).perform();
    }

    public void setTermSearch(String term){
        input_search.sendKeys(term);
    }

    public void submitSearchTerm(){
        clickOn(btn_submit);
    }

}

package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class EngagementsPage extends Page{

    @FindBy(css = "div[id=\"6253\"]")
    private WebElement our_certificat;

    @FindBy(id = "myModal")
    private WebElement myModal;

    public void openHome(String url){
        get(url);
    }

    public void clickOnOurCertificatLink(){
        clickOn(our_certificat);
    }

    public void goBackTabs(){
        driver.switchTo().defaultContent();
    }

    public boolean modalIsDisplay(){
        if(myModal.isDisplayed()) return true;
        return false;
    }

}

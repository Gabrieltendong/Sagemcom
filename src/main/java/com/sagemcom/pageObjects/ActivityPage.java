package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ActivityPage extends Page{

    @FindBy(css = "div.owl-stage figure>a")
    private List<WebElement> figures;

    @FindBy(css = "div.owl-next")
    private WebElement btn_next;

    public boolean imageIsLoad(){
        for (WebElement figure: figures){
            if(!verifyLink(figure.getAttribute("href"))) return false;
        }
        return true;
    }

    public void clickOnBtnNext(){
        scrollTo(btn_next);
        clickOnJs(btn_next);
    }

}

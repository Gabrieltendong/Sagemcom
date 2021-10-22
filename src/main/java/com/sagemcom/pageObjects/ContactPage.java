package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactPage extends Page{

    @FindBy(css = "div.a11y-paragraphs-tabs__wrapper")
    private WebElement bloc_tab;

    @FindBy(id = "section3221-3")
    private WebElement section_germany;

    @FindBy(id = "tab3221-3")
    private WebElement tab_germany;

    private static final String URL = BASE_URL + "/contactez-nous";

    public void openHome(){
        get(URL);
    }

}

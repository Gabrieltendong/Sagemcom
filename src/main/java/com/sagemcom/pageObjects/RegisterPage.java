package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;

public class RegisterPage extends Page{

    @FindBy(id = "ddlLang")
    private WebElement list_language;

    @FindBy(id = "content")
    private WebElement content;

    ArrayList<String> texts=new ArrayList<String>();

    @FindBy(css = "span#literal_sup_registration_0 p")
    private WebElement text1;

    @FindBy(id = "lblPasswordHelper")
    private WebElement text2;

    public void selectLang(String language){
        Select options = new Select(list_language);
        options.selectByVisibleText(language);
    }

    public boolean isBadTranslate(){
        return getListText().stream().anyMatch(element -> !getLanguage(element).contains(getSelectedLanguage()));
    }

    public String getSelectedLanguage(){
        Select options = new Select(list_language);
        return options.getOptions()
                .stream()
                .filter(element -> element.isSelected())
                .findFirst().get()
                .getAttribute("value");
    }

    public ArrayList<String> getListText(){
        texts.add(text1.getText());
        texts.add(text2.getText());
        return texts;
    }

}

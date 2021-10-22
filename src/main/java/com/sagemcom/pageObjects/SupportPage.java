package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class SupportPage extends Page{

    @FindBy(css = "div#views-bootstrap-family-block-block-1>div>div:nth-child(2) div.service-title a")
    private WebElement decoder;

    @FindBy(id = "edit-field-gamme-de-produit")
    private WebElement select_decoder;

    @FindBy(css = "div.service-box>div.linkMore a")
    private List<WebElement> readmore;

    @FindBy(id = "views-bootstrap-family-block-block-1")
    private WebElement block_views;

    public void clickOnDecoderLink(){
        navigateTo(decoder);
    }

    public void clickOnSelect(){
        action.moveToElement(select_decoder).click().perform();
    }

    public boolean isDuplicate(){
        Select decoders = new Select(select_decoder);
        List<WebElement> options = decoders.getOptions();
        for(int i = 0; i<options.size(); i++){
            for(int j = i + 1; j<options.size(); j++){
               if(options.get(i).getText().contains(options.get(j).getText())) return  true;
            }
        }
        return false;
    }

    public boolean isEnglishText(){
        return readmore.stream()
                .anyMatch(element -> getLanguage(element.getText()).contains("fr"));
    }

    public void scrollToBloc() {
        scrollTo(block_views);
    }

}

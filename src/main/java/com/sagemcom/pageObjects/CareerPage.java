package com.sagemcom.pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class CareerPage extends Page{

    @FindBy(css = "a[aria-controls=\"collapseTwo\"]")
    private WebElement type_contrat;

    @FindBy(css = "div#collapseTwo ul>li label")
    private List<WebElement> list_type_contrat;

    @FindBy(css = "footer>div.container")
    private WebElement footer;

    public void clickOnTypeContrat(){
        clickOn(type_contrat);
    }

    public boolean isVisibleTextLabel(){
        for (WebElement typeContrat : list_type_contrat){
            if(typeContrat.getText().length() == 0) return false;
        }
        return true;
    }

    public void scrollToFooter(){
        scrollTo(footer);
    }

    public boolean iscorrectEncodeChar(){
        return !footer.getText().contains("�");
    }

}

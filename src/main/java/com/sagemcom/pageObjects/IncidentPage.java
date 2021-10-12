package com.sagemcom.pageObjects;

import com.sagemcom.Enum.Context;
import com.sagemcom.context.ScenarioContext;
import io.cucumber.datatable.DataTable;
import io.restassured.RestAssured;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class IncidentPage extends Page{

    @FindBy(css = "ul#menu-right>li:first-child")
    private WebElement btn_search;

    @FindBy(css = "input[name=\"tx_indexedsearch[sword]\"]")
    private WebElement input_search;

    @FindBy(css = "div.dropdown-menu button[type=\"submit\"]")
    private WebElement btn_submit;

    @FindBy(css = "div.form-group button[type=\"submit\"]")
    private WebElement btn_next;

    @FindBy(css = "div.contact-form-details button[type=\"submit\"]")
    private WebElement btn_submit_incident;

    @FindBy(id = "pays")
    private WebElement country;

    @FindBy(id = "nom")
    private WebElement first_name;

    @FindBy(id = "prenom")
    private WebElement last_name;

    @FindBy(id = "email")
    private WebElement email;

    @FindBy(id = "phone")
    private WebElement phone;

    @FindBy(id = "avlienselector")
    private WebElement link;

    @FindBy(id = "av_daterecep")
    private WebElement startdate;

    @FindBy(id = "av_daterecepau")
    private WebElement enddate;

    @FindBy(id = "description")
    private WebElement description;

    @FindBy(id = "submit")
    private WebElement btn_report_incident;

    @FindBy(css = "div.bootbox-body")
    private WebElement bootbox_body;

    @FindBy(id = "suivi")
    private WebElement reference;

    @FindBy(id = "password")
    private WebElement password;

    @FindBy(css = "button[name=\"loginSubmit\"]")
    private WebElement loginSubmit;

    @FindBy(css = "button[name=\"quitter\"]")
    private WebElement close;

    ScenarioContext scenarioContext;

    public IncidentPage(ScenarioContext scenarioContext){
        this.scenarioContext = scenarioContext;
    }

    public void clickOnBtnSearch(){
        action.moveToElement(btn_search).perform();
    }

    public void setTermSearch(String term){
        input_search.sendKeys(term);
    }

    public void submitSearchTerm(){
        clickOn(btn_submit);
    }

    public void clickOnbtnReportIncident(){
        clickOn(btn_report_incident);
    }

    public void clickOnNext() {
        if(longUntil(ExpectedConditions.visibilityOf(btn_next)))
            clickOn(btn_next);
    }

    public void createIncident(
          DataTable table
    ){
        List<String> data = table.asList();
        setCountry(data.get(0));
        first_name.sendKeys(data.get(1));
        last_name.sendKeys(data.get(2));
        email.sendKeys(data.get(3));
        phone.sendKeys(data.get(4));
        setLink(data.get(5));
        description.sendKeys(data.get(6));
        setStartDate(data.get(7));
        setEndDate(data.get(8));
        clickOn(btn_submit_incident);
    }

    private void setCountry(String cntry){
        Select ctry = new Select(country);
        ctry.selectByVisibleText(cntry);
    }

    private void setLink(String lnk){
        new Select(link).selectByVisibleText(lnk);
    }

    private void setStartDate(String date){
        this.scenarioContext.set(Context.START_DATE, date);
        startdate.sendKeys(date);
    }

    private void setEndDate(String date){
        this.scenarioContext.set(Context.END_DATE, date);
        enddate.sendKeys(date);
    }

    public void setReference(String ref){
        reference.sendKeys(ref);
    }

    public void setPassword(String pwd){
        password.sendKeys(pwd);
    }

    private String getStartDate(){
        return this.scenarioContext.get(Context.START_DATE);
    }

    private String getEnDate(){
        return this.scenarioContext.get(Context.END_DATE);
    }

    private Date getCurrentDate() throws ParseException {
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date(System.currentTimeMillis());
        return format(formatter.format(date));
    }

    private Date format(String date) throws ParseException {
        SimpleDateFormat formatter= new SimpleDateFormat("dd-MM-yyyy");
        return formatter.parse(date);
    }

    public boolean iscorrectIncident() throws ParseException {
        return (format(getEnDate()).compareTo(format(getStartDate())) > 0 &&
                (getCurrentDate().compareTo(format(getStartDate())) >= 0 ||
                getCurrentDate().compareTo(format(getEnDate())) >= 0) &&
                bootbox_body.isDisplayed()
        );
    }

    public void clickOnLoginSubmit(){
        clickOn(loginSubmit);
    }

    public void clickOnClose(){
        clickOn(close);
    }

}

package com.sagemcom.pageObjects;

import com.sagemcom.config.Configuration;
import com.sagemcom.config.Properties;
import io.qameta.allure.Allure;
import io.qameta.allure.Attachment;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.ByteArrayInputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.function.Function;

import static org.openqa.selenium.support.ui.ExpectedConditions.elementToBeClickable;
import static org.openqa.selenium.support.ui.ExpectedConditions.visibilityOf;

public class Page {

    /***
     *
     */
    protected WebDriver driver;
    protected JavascriptExecutor js;
    protected Actions action;
    /***
     * waiter
     */
    protected WebDriverWait wait;
    protected WebDriverWait shortWait;
    protected WebDriverWait middleWait;
    protected WebDriverWait longWait;

    protected Configuration config = Properties.Config;

    public static final String BASE_URL = Properties.Config.getEnvironment();

    Page(){
        // Init
        driver = Properties.DriverManager.getDriver();
        PageFactory.initElements(driver, this);

        js = (JavascriptExecutor) driver;
        action = new Actions(driver);

        //Waiter
        wait        = new WebDriverWait(driver, Duration.ofSeconds(4));
        shortWait   = new WebDriverWait(driver, Duration.ofSeconds(10));
        middleWait  = new WebDriverWait(driver, Duration.ofSeconds(20));
        longWait    = new WebDriverWait(driver, Duration.ofSeconds(30));

    }

    protected <V>boolean waitUntil(Function<? super WebDriver, V> isTrue){
        try{
            wait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    protected <V>boolean shortUntil(Function<? super WebDriver, V> isTrue){
        try{
            shortWait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /***
     *
     * @param isTrue
     * @param <V>
     * @return
     */
    protected <V>boolean middleUntil(Function<? super WebDriver, V> isTrue){
        try{
            middleWait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    /***
     *
     * @param isTrue
     * @param <V>
     * @return
     */
    protected <V>boolean longUntil(Function<? super WebDriver, V> isTrue){
        try{
            longWait.until(isTrue);
            return true;
        }catch (Exception e){
            return false;
        }
    }
    /***
     *
     */
    protected void waitForLoadingPage( ){
        if(!longUntil(driver->js.executeScript("return document.readyState").equals("complete") || js.executeScript("return document.readyState").equals("interactive") )){
            throw new RuntimeException(driver.getCurrentUrl()+" not loaded");
        }
    }
    /***
     *
     * @param url
     */
    protected void get(String url){
        driver.get(url);
        waitForLoadingPage();
    }

    protected void checkVisibilityElement(WebElement element){
        if( !shortUntil(visibilityOf(element)) ){
            // Logger
            throw new RuntimeException("Element not visible after click");
        }

        if( !shortUntil(elementToBeClickable(element))){
            // Logger
            throw new RuntimeException("Element not clickable");
        }
    }

    protected void clickOn(WebElement element){
        checkVisibilityElement(element);
        element.click();
    }

    protected void clickOnJs(WebElement element){
//        checkVisibilityElement(element);
        js.executeScript("arguments[0].click();", element);
    }

    protected void navigateTo(WebElement element){
        String url = element.getAttribute("href");
        driver.navigate().to(url);
    }

    protected void scrollTo(WebElement element){
        js.executeScript("arguments[0].scrollIntoView(true);", element);
    }

    protected Boolean verifyLink(String url) {
        try{
            HttpURLConnection c= (HttpURLConnection)new URL(url).openConnection();
            c.setRequestMethod("HEAD");
            c.connect();
            int r = c.getResponseCode();
            System.out.println("-------------------- status code ---------------: " + r);
            if(r == 200) return true;
            saveScreenShotPNG();
            return false;
        }catch (Exception e){
            saveScreenShotPNG();
            return false;
        }
    }

    public boolean pageIsFound(){
        return verifyLink(driver.getCurrentUrl());
    }

    @Attachment(value = "screenshot", type = "image/png")
    public void saveScreenShotPNG(){
        Allure.addAttachment("screenshot", new ByteArrayInputStream(((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES)));
    }
}
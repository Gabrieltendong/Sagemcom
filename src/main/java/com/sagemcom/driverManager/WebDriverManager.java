package com.sagemcom.driverManager;

import com.sagemcom.config.Properties;
import com.sagemcom.drivers.DriverFactory;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;


public class WebDriverManager {

    private static final WebDriverManager INSTANCE = new WebDriverManager();

    private ThreadLocal<DriverFactory> driver = new ThreadLocal<>();

    private WebDriverManager() { }

    public WebDriver getDriver() { return driver.get().getDriver(); }

    public void setDriver(String browser) {
        driver.set(new DriverFactory(browser));
        setWindowSize();
    }

    private void setWindowSize() {
        WebDriver webDriver = driver.get().getDriver();
        WebDriver.Window window =  webDriver.manage().window();

        if(Properties.Config.getHeadless()) window.setPosition(new Point(0, 0));
        if (!Properties.Config.getDevice().isReal()) {
            window.setSize(Properties.Config.getDevice().getDimension());
        } else {
            window.maximize();
        }
    }
    /***
     *
     * @static
     */
    public static WebDriverManager getInstance() { return INSTANCE; }
}

package com.sagemcom.steps;

import com.sagemcom.pageObjects.HomePage;
import io.cucumber.java8.En;
import org.testng.Assert;

public class HomeStep implements En {

    public HomeStep(HomePage homePage){

        Given("user connect to the homePage", homePage::openHomePage);

    }
}

package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class BasePage {
    /**
     * Initialization of the webelement with "FindBy" annotation
     */
    @FindBy(xpath = "//div[@id='page']")
    WebElement divPage;

    //Instances of the WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor of the base page for initialize wait, driver and make divPage to be noticeable for driver
     *
     * @param driver
     */
    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
        //Makes visible all webelements initialized by "Find by" annotation
        PageFactory.initElements(driver, this);
        //Wait until home page is visible
        wait.until(ExpectedConditions.visibilityOf(divPage));
    }


}

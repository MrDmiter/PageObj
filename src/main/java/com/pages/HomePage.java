package com.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends BasePage {
    /**
     * Initializatoin of the login button
     */
    @FindBy(xpath = "//div/a[@class='login']")
    private WebElement stickySignInBtn;

    //Instances of the WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor of the HomePage class
     *
     * @param driver
     */
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Click on "Sign in" button
     *
     * @return instance of the LoginPage
     */
    public LoginPage clickOnStickyLoginBtn() {
        stickySignInBtn.click();
        return new LoginPage(driver);
    }
}

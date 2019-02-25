package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage extends BasePage {

    /**
     * Initialization of the webelements which present on the login page and we interact with
     */
    @FindBy(xpath = "//input[@id='email']")
    private WebElement emailTextField;

    @FindBy(xpath = "//input[@id='passwd']")
    private WebElement passTextField;

    @FindBy(xpath = "//button[@id='SubmitLogin']/span")
    private WebElement signInBtn;

    //Instances of the WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Constructor of the LoginPage
     *
     * @param driver
     */
    public LoginPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    /**
     * Perform login activities
     */
    public MyAccountPage performLogin() {
        emailTextField.sendKeys("gavuyabavu@digitalmail.info");
        passTextField.sendKeys("12345");
        wait.until(ExpectedConditions.elementToBeClickable(signInBtn));
        signInBtn.click();
        return new MyAccountPage(driver);
    }

    /**
     * Verify presence on the login page
     */
    public void verifyPresenceOnLoginPage() {
        Assert.assertEquals("Login - My Store", driver.getTitle());
    }
}

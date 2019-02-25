package com.pages;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MyAccountPage extends BasePage {

    /**
     * Initialization of the webelements whch present on the MyAccount page and we interact with
     */
    @FindBy(xpath = "//div[@class='header_user_info']/descendant::span")
    private WebElement name;

    @FindBy(xpath = "//div/a[@class='logout']")
    private WebElement logoutBtn;

    //Instances of the WebDriver and WebDriverWait
    private WebDriver driver;

    private WebDriverWait wait;

    /**
     * Constructor of the MyAccountPage
     *
     * @param driver
     */
    public MyAccountPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }


    /**
     * Verify correctness of the account name
     */
    public void verifyName() {
        Assert.assertEquals(name.getText(), "Dmytro Terentyev");
    }

    /**
     * Logout from the account
     *
     * @return
     */
    public LoginPage logout() {
        logoutBtn.click();
        return new LoginPage(driver);
    }


}

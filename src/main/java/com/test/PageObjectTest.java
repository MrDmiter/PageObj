package com.test;

import com.pages.HomePage;
import com.pages.LoginPage;
import com.pages.MyAccountPage;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class PageObjectTest {
    //Instances of the WebDriver and WebDriverWait
    private WebDriver driver;
    private WebDriverWait wait;

    /**
     * Initialization of the driver, wait and configuring activities
     */
    @Before
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("disable-infobars");
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, 10);
        driver.manage().window().maximize();
    }

    /**
     * Test of the site using page object pattern
     */
    @Test
    public void testPageObjectTest() {
        //Go to the site
        driver.get("http://automationpractice.com/index.php");
        //Create instance of the home page
        HomePage homePage = new HomePage(driver);
        //Click on the sign in button and go to the login page
        LoginPage loginPage = homePage.clickOnStickyLoginBtn();
        //Enter login
        MyAccountPage myAccountPage = loginPage.performLogin();
        //Verify that we are logged in under the right user
        myAccountPage.verifyName();
        //Logout from the account
        loginPage = myAccountPage.logout();
        //Verify that user logged out
        loginPage.verifyPresenceOnLoginPage();

    }

    /**
     * Quit the test
     */
    @After
    public void tearDown() {
        driver.quit();
    }
}

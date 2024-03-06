package framework;

import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pageModels.*;

import java.io.IOException;

public class TutorialApplication extends BaseClass {
    public WebDriver driver;
    UrlPage url;
    LoginPage login;
    AccountPage ap;
    SearchPage sp;
    AddToCart ac;
    Logger log;

    @BeforeMethod
    public void openApplication() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url"));
    }

    @Test(dataProvider = "getData")
    public void login(String email, String password, String expectedResult) throws IOException, InterruptedException {
        url = new UrlPage(driver);
        url.AccountDropdown().click();
        url.LoginButton().click();

        login = new LoginPage(driver);
        login.emailId().sendKeys(email);
        login.password().sendKeys(password);
        login.login().click();

        ap = new AccountPage(driver);
        String actualResult = null;
        try {
            if (ap.editAccount().isDisplayed()) {
                actualResult = "success";
            }
        } catch (Exception e) {
            actualResult = "failure";
        }
        Assert.assertEquals(actualResult, expectedResult);
        ap.SearchBar().sendKeys(prop.getProperty("model"));
        ap.SearchButton().click();

        sp = new SearchPage(driver);
        sp.HpLaptop().click();

        ac = new AddToCart(driver);
        ac.quantity().clear();
        ac.quantity().sendKeys(prop.getProperty("quan"));
        ac.AddToCart().click();
    }
    @DataProvider
    public Object[][] getData() {
        Object[][] data = {{"harika.selenium1@gmail.com", "harika0803", "success"}, {"dummy.selenium@gmail.com", "harika0803", "failure"}};
        return data;
    }
    @AfterMethod
    public void tearDown() {
        driver.close();

    }
}

package stepDefinitions;

import framework.BaseClass;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.bouncycastle.crypto.agreement.jpake.JPAKERound1Payload;
import org.openqa.selenium.WebDriver;
import pageModels.*;

import java.io.IOException;
import java.util.Properties;

public class searchingProduct extends BaseClass {
    WebDriver driver;
    Properties prop;
    UrlPage url;
    LoginPage login;
    AccountPage ap;
    SearchPage sp;
    AddToCart ac;

    @Given("user navigates to the tutorialNinja")
    public void user_navigates_to_the_tutorial_ninja() throws IOException {
        driver = initializeDriver();
        driver.get("https://tutorialsninja.com/demo/");
    }
    @When("user enter the page should able to login page with valid credential")
    public void user_enter_the_page_should_able_to_login_page_with_valid_credential() {
        url = new UrlPage(driver);
        url.AccountDropdown().click();
        url.LoginButton().click();
    }
    @When("^user enter the email as \"([^\"]*)\" and password as \"([^\"]*)\" into the fields$")
    public void user_enter_the_email_as_harika_selenium1_gmail_com_and_password_as_harika0803_into_the_fields(String email,String password) {
        login = new LoginPage(driver);
        login.emailId().sendKeys(email);
        login.password().sendKeys(password);
    }
    @When("clicks on the login button")
    public void clicks_on_the_login_button() throws InterruptedException {
        login.login().click();
        Thread.sleep(2000);
    }
    @Then("search for the required product")
    public void search_for_the_required_product() {
        ap = new AccountPage(driver);
        ap.SearchBar().sendKeys("HP LP3065");
        ap.SearchButton().click();
        sp = new SearchPage(driver);
        sp.HpLaptop().click();

    }
    @Then("user added to the cart")
    public void user_added_to_the_cart() {
        ac = new AddToCart(driver);
        ac.quantity().clear();
        ac.quantity().sendKeys("2");
        ac.AddToCart().click();
    }
    @After
    public void tearDown(){
        driver.close();
    }
}

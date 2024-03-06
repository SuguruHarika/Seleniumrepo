package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
    WebDriver driver;
    public AccountPage(WebDriver driver) {
        this.driver=driver;
        PageFactory.initElements(driver,this);
    }

    @FindBy(linkText = "Edit your account information")
    WebElement editAccount;
    @FindBy(name = "search")
    WebElement SearchBar;
    @FindBy(xpath = "//i[@class='fa fa-search']")
    WebElement SearchButton;



    public WebElement editAccount() {
        return editAccount;
    }

    public WebElement SearchBar() {
        return SearchBar;
    }

    public WebElement SearchButton() {
        return SearchButton;
    }

}

package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UrlPage {
    WebDriver driver;
    public UrlPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[@title='My Account']")
    private WebElement AccountDropdown;
    @FindBy(xpath = "//a[text()='Login']")
    private WebElement LoginButton;

    public WebElement AccountDropdown() {
        return AccountDropdown;
    }

    public WebElement LoginButton() {
        return LoginButton;
    }
}

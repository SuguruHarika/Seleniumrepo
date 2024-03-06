package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddToCart {
    WebDriver driver;
    public AddToCart(WebDriver driver) {
        this.driver= driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(id = "input-quantity")
    WebElement quantity;
    @FindBy(id = "button-cart")
    WebElement AddToCart;
    public WebElement AddToCart() {

        return AddToCart;
    }

    public WebElement quantity() {

        return quantity;
    }
}

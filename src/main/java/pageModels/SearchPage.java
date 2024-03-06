package pageModels;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchPage {
    WebDriver driver;
    public SearchPage(WebDriver driver) {

        this.driver=driver;
        PageFactory.initElements(driver,this);
    }
    @FindBy(xpath = "//a[text()='HP LP3065']")
    WebElement HpLaptopProduct;
    public WebElement HpLaptopProduct(){
        return HpLaptopProduct;

    }
    @FindBy(xpath = "//img[@class='img-responsive']")
    WebElement HpLaptop;
    public WebElement HpLaptop(){
        return HpLaptop;

    }
}

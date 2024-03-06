package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DummyClass1 extends BaseClass {
    public WebDriver driver;
    @Test
    public void application() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url2"));
        driver.findElement(By.name("q")).sendKeys("harika");
    }
    @AfterMethod
    public void closer(){
        driver.close();
    }
}

package framework;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.SkipException;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DummyClass3 extends BaseClass{
    WebDriver driver;
    
    @Test
    public void skipTheTest() throws IOException {
        driver = initializeDriver();
        driver.get("https://omayo.blogspot.com/");
        String text = driver.findElement(By.id("pah")).getText();
        if (text.equalsIgnoreCase("PracticeAutomationHere")){
            throw new SkipException("text is not equals to the amazon");
        }
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }
}

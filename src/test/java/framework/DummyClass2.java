package framework;

import junit.framework.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import java.io.IOException;

public class DummyClass2 extends BaseClass {
    public WebDriver driver;
    @Test
    public void dummy() throws IOException {
        driver = initializeDriver();
        driver.get(prop.getProperty("url3"));
        Assert.assertTrue(false);
    }
    @AfterMethod
    public void closer(){
        driver.close();
    }
}

package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class Home_Page {
    WebDriver driver;

    public Home_Page(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver,this);
    }

    public WebElement Navigate_to_LoginPage() {
        return driver.findElement(By.cssSelector("a[class=\"ico-login\"]"));
    }

    public WebElement Navigate_to_RegisterPage() {
        return driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }
}

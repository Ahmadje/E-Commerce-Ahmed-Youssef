package org.example.StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;

    @Before
    public static void openBrowser(){
        //1.bridge between test script and browser
//        String edgePath = System.getProperty("user.dir") + "\\src\\main\\resources\\msedgedriver.exe";
//        System.setProperty("webdriver.edge.driver", edgePath);

        //2.Object
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();

        //3.Navigate to nopcommerce
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @After
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(3000);
        driver.quit();
    }
}

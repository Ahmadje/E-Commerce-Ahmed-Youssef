package StepDefinition;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

import java.util.concurrent.TimeUnit;

public class Hooks {
    WebDriver driver;

    @Before
    public void openBrowser(){
        //1.bridge between test script and browser
        String edgePath = System.getProperty("user.dir") + "\\src\\main\\resources\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", edgePath);

        //2.Object
        driver = new EdgeDriver();

        //3.Navigate
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(2000);
        driver.quit();
    }
}

package StepDefinition;

import Pages.Home_Page;
import Pages.Login_Page;
import Pages.Register_Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver = null;

    @Before
    public static void openBrowser(){
        //1.bridge between test script and browser
        String edgePath = System.getProperty("user.dir") + "\\src\\main\\resources\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", edgePath);

        //2.Object
        driver = new EdgeDriver();

        //3.Navigate to nopcommerce
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @After
    public static void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}

package StepDefinition;

import Pages.Login_Page;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class loginDef {
    WebDriver driver;
    Login_Page login;


    @When("user navigate to login page")
    public void user_navigate_to_login_page() {
        login.Navigate_to_LoginPage().click();
    }

    @And("user enter \"(.*)\" and \"(.*)\"$")
    public void vaild_data(String email, String password) throws InterruptedException {
        login.LoginSteps(email, password);
        Thread.sleep(1000);
    }

    @Then("user click on login button")
    public void click_Login() {
        login.passwordE().sendKeys(Keys.ENTER);
    }

    @And("user could login successfully and go to home page")
    public void login_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertEquals(driver.getCurrentUrl(),"https://demo.nopcommerce.com/","First Assertion");
        // Second Assertion
        driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed();
        soft.assertTrue(driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed(), "Second Assertion");
        // Assert All
        soft.assertAll();
    }

    @Before
    public void openBrowser(){
        //1.bridge between test script and browser
        String edgePath = System.getProperty("user.dir") + "\\src\\main\\resources\\msedgedriver.exe";
        System.setProperty("webdriver.edge.driver", edgePath);

        //2.Object
        driver = new EdgeDriver();
        login = new Login_Page(driver);

        //3.Navigate to nopcommerce
        driver.manage().window().maximize();
        driver.navigate().to("https://demo.nopcommerce.com/");
        driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);
    }

    @After
    public void closeBrowser() throws InterruptedException {
        Thread.sleep(1000);
        driver.quit();
    }
}

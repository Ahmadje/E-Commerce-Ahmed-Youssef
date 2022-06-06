package StepDefinition;

import Pages.Home_Page;
import Pages.Login_Page;
import Pages.Register_Page;
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

import java.sql.PreparedStatement;
import java.util.concurrent.TimeUnit;

public class D01_Register {
    Register_Page register;
    Home_Page home;

    @Given("user navigate to register page")
    public void user_navigate_to_register_page() {
        register = new Register_Page(Hooks.driver);
        home = new Home_Page(Hooks.driver);
        home.Navigate_to_RegisterPage().click();
    }

    @And("user choose male or female")
    public void user_choose_Gender_Option (){
        register.maleGender().click();
}

    @And("user enter first name")
    public void user_enter_first_name(){
        register.firstName().sendKeys("Ahmed");
    }

    @And("user enter last name")
    public void user_enter_last_name(){
        register.lastName().sendKeys("Youssef");
    }

    @And("user enter Date of Birth")
    public void user_enter_date_of_birth(){
        register.birthDay().sendKeys("21");
        register.birthDay().sendKeys(Keys.ENTER);

        register.birthMonth().sendKeys("December");
        register.birthMonth().sendKeys(Keys.ENTER);

        register.birthYear().sendKeys("1993");
        register.birthYear().sendKeys(Keys.ENTER);
    }

    @And("user enter email")
    public void user_enter_email(){
        register.email().sendKeys("Ahmed_Youssef@Live.com");
    }

    @And("user enter company name")
    public void user_enter_company_name(){
        register.companyName().sendKeys("Udacity");
    }

    @And("user enter password")
    public void user_enter_password(){
        register.password().sendKeys("P@ssw0rd");
        register.confirmPassword().sendKeys("P@ssw0rd");
    }

    @Then("user press on register button")
    public void user_register_successfully(){
        register.registerB().click();
    }

    @And("user could register successfully")
    public void register_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(register.successfulMsg().isDisplayed(), "Successful Message");
        // Second Assertion
        String actual = register.successfulMsg().getCssValue("color");
        String expected = "rgba(76, 177, 124, 1)";
        soft.assertEquals(actual, expected, "Message color");
        // Assert All
        soft.assertAll();
    }
}

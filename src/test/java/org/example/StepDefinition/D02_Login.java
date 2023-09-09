package org.example.StepDefinition;

import org.example.Runners.Pages.Home_Page;
import org.example.Runners.Pages.Login_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.asserts.SoftAssert;

public class D02_Login {
    Login_Page login = new Login_Page();
    Home_Page home = new Home_Page();

    @When("user navigate to login page")
    public void user_navigate_to_login_page() {
        home.Navigate_to_LoginPage().click();
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
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/"),"URL after login");
        // Second Assertion

        soft.assertTrue(Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]")).isDisplayed(), "My Account");
        // Assert All
        soft.assertAll();
    }

    @And("user could not login successfully and go to home page")
    public void cannot_login_successfully() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        login.wrongMsg().isDisplayed();
        String actual = login.wrongMsg().getText();
        soft.assertEquals(actual,"Login was unsuccessful. Please correct the errors and try again.\n" +
                "No customer account found","Wrong Msg");
        // Second Assertion
        actual = login.wrongMsg().getCssValue("color");
        String expected = "rgb(228, 67, 75)";
        soft.assertEquals(actual, expected, "Wrong Message color");
        // Assert All
        soft.assertAll();
    }
}

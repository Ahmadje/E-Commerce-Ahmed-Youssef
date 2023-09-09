package org.example.StepDefinition;

import org.example.Runners.Pages.Home_Page;
import org.example.Runners.Pages.Register_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.support.ui.Select;
import org.testng.asserts.SoftAssert;

public class D01_Register {
    Register_Page register = new Register_Page();
    Home_Page home = new Home_Page();

    @Given("user navigate to register page")
    public void user_navigate_to_register_page() {
        home.Navigate_to_RegisterPage().click();
    }

    @And("user choose male or female")
    public void user_choose_Gender_Option (){
        register.maleGender().click();
}

    @And("user enter valid data")
    public void user_enter_first_name(){
        register.firstName().sendKeys("Ahmed");

        register.lastName().sendKeys("Youssef");

        Select select = new Select(register.birthDay());
        select.selectByIndex(21);

        select = new Select(register.birthMonth());
        select.selectByVisibleText("December");

        select = new Select(register.birthYear());
        select.selectByValue("1993");

//        Other way to choose data
//        register.birthDay().sendKeys("21");
//        register.birthMonth().sendKeys("December");
//        register.birthYear().sendKeys("1993");

        register.email().sendKeys("Ahmed_Youssef@live.com");

        register.companyName().sendKeys("Udacity");

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
        String expected = "rgb(76, 177, 124)";
        soft.assertEquals(actual, expected, "Message color");
        // Assert All
        soft.assertAll();
    }
}

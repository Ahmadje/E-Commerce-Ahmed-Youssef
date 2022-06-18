package org.example.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Login_Page {

//    public Login_Page(WebDriver driver) {
//        this.driver = driver;
//        PageFactory.initElements(driver,this);
//    }

    public WebElement emailE()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement passwordE()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public void LoginSteps(String email ,String password)
    {
        emailE().clear();
        passwordE().clear();

        emailE().sendKeys( email );
        passwordE().sendKeys( password );
    }

    public WebElement myAccount() {
       return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-account\"]"));
    }

    public WebElement wrongMsg() {
        return Hooks.driver.findElement(By.cssSelector("div[class=\"message-error validation-summary-errors\"]"));
    }
}

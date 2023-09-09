package org.example.Runners.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Register_Page {

    public WebElement Navigate_to_RegisterPage() {
        return Hooks.driver.findElement(By.cssSelector("a[class=\"ico-register\"]"));
    }

    public WebElement maleGender()
    {
        return Hooks.driver.findElement(By.id("gender-male"));
    }

    public WebElement firstName()
    {
        return Hooks.driver.findElement(By.id("FirstName"));
    }

    public WebElement lastName()
    {
        return Hooks.driver.findElement(By.id("LastName"));
    }

    public WebElement birthDay()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthDay"));
    }

    public WebElement birthMonth()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthMonth"));
    }

    public WebElement birthYear()
    {
        return Hooks.driver.findElement(By.name("DateOfBirthYear"));
    }

    public WebElement email()
    {
        return Hooks.driver.findElement(By.id("Email"));
    }

    public WebElement companyName()
    {
        return Hooks.driver.findElement(By.id("Company"));
    }

    public WebElement password()
    {
        return Hooks.driver.findElement(By.id("Password"));
    }

    public WebElement confirmPassword()
    {
        return Hooks.driver.findElement(By.id("ConfirmPassword"));
    }

    public WebElement registerB()
    {
        return Hooks.driver.findElement(By.id("register-button"));
    }

    public WebElement successfulMsg()
    {
        return Hooks.driver.findElement(By.xpath("//div[@class=\"result\"]"));
    }


}

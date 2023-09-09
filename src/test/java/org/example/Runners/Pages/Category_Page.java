package org.example.Runners.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class Category_Page {

    public WebElement categoryList(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"page-title\"]"));
    }
}

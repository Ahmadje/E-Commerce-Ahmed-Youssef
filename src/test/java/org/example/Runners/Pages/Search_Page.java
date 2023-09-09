package org.example.Runners.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;


public class Search_Page {

    public int productsList(){
        int size = Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        return size;
    }

    public void scrollToResults(){
        ((JavascriptExecutor) Hooks.driver).executeScript("window.scrollTo(0, 400);");
    }

    public WebElement noProducts(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"no-result\"]"));
    }
}

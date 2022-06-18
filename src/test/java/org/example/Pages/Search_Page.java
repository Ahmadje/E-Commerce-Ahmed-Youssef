package org.example.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class Search_Page {

    public int productsList(){
        int size = Hooks.driver.findElements(By.cssSelector("h2[class=\"product-title\"]")).size();
        return size;
    }

    public WebElement noProducts(){
        return Hooks.driver.findElement(By.cssSelector("div[class=\"no-result\"]"));
    }
}

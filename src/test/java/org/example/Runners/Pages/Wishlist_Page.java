package org.example.Runners.Pages;

import org.example.StepDefinition.Hooks;
import org.openqa.selenium.By;


public class Wishlist_Page {

    public int wishListItems(){
        int size = Hooks.driver.findElements(By.cssSelector("div[class=\"wishlist-content\"]")).size();
        return size;
    }
}

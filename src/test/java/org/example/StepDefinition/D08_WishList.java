package org.example.StepDefinition;

import org.example.Runners.Pages.Home_Page;
import org.example.Runners.Pages.Wishlist_Page;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class D08_WishList {
    Home_Page home= new Home_Page();
    Wishlist_Page wish= new Wishlist_Page();
    int num;

    @Given("user add item to wishlist")
    public void user_add_item_to_wishlist() {
        home.addWishList().get(2).click();
    }

    @Then("wishlist notification success is visible")
    public void success_notification() {
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(home.wishSuccessMsg().isDisplayed(), "Success Message displayed");

        String actual = home.wishSuccessMsg().getCssValue("background-color");
        String expected = "rgba(75, 176, 122, 1)";
        soft.assertEquals(actual, expected, "Success Message color");
    }

    @And("user get the number of wishlist items after adding item")
    public void items_increased() {
        String text = home.wishList().getText();
        text = text.replaceAll("[^0-9]", "");
        num = Integer.parseInt(text);
    }

    @Then("the number of wishlist increased")
    public void number_of_items_of_wishlist() throws InterruptedException {
        Assert.assertTrue(num > 0, "wishlist increased");
    }

    @And("user go to wishlist page")
    public void user_go_to_wishlist() throws InterruptedException {
        home.closeB().click();
        Thread.sleep(1000);
        home.wishList().click();
    }

    @Then("the number of items greater than zero in wishlist page")
    public void wishlist_Page_Assertion() {
        // First Assertion
        SoftAssert soft = new SoftAssert();
        soft.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/wishlist"), "URL after click on wishlist");
        // Second Assertion
        int size = wish.wishListItems();
        soft.assertTrue(size > 0,"Items of wishlist");
        // Assert All
        soft.assertAll();
    }
}

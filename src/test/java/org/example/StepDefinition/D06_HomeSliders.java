package org.example.StepDefinition;

import org.example.Runners.Pages.Home_Page;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;

public class D06_HomeSliders {
    Home_Page home = new Home_Page();

    @When("user clicks on first slider")
    public void click_on_first_slider(){
        Hooks.driver.findElement(By.cssSelector("a[rel=\"0\"]")).click();
        home.slider("1").click();
    }

    @Then("relative product for first slider is displayed")
    public void first_slide_displayed() throws InterruptedException {
        Thread.sleep(1500);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/nokia-lumia-1020","URL after click on First Slide");
    }

    @When("user clicks on second slider")
    public void click_on_second_slider() {
        Hooks.driver.findElement(By.cssSelector("a[rel=\"1\"]")).click();
        home.slider("2").click();
    }

    @Then("relative product for second slider is displayed")
    public void second_slide_displayed() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/iphone-6","URL after click on Second Slide");
    }
}

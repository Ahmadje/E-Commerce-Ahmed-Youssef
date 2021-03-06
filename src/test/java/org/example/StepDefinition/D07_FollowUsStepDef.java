package org.example.StepDefinition;

import org.example.Pages.Home_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Assert;

import java.util.ArrayList;

public class D07_FollowUsStepDef {
    Home_Page home = new Home_Page();

    @Given("user opens facebook link")
    public void user_opens_facebook() {
        home.facebook().click();
    }

    @Then("^\"([^\"]*)\" is opened in new tab$")
    public void opens_new_tab(String linkType) throws InterruptedException {
        Thread.sleep(2000);
        ArrayList<String> Tabs = new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));

        switch (linkType) {

            case "facebook":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce","facebook follow us link");
                break;

            case "twitter":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://twitter.com/nopCommerce","twitter follow us link");
                break;

            case "rss":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/new-online-store-is-open","rss follow us link");
                break;

            case "youtube":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.youtube.com/user/nopCommerce","youtube follow us link");
                break;
        }

        Hooks.driver.close();

        Hooks.driver.switchTo().window(Tabs.get(0));
    }

    @Given("user opens twitter link")
    public void user_opens_twitter() {
        home.twitter().click();
    }

    @Given("user opens rss link")
    public void user_opens_rss() {
        home.rss().click();
    }

    @Given("user opens youtube link")
    public void user_opens_youtube() {
//        home = new Home_Page(Hooks.driver);
        home.youtube().click();
    }

}

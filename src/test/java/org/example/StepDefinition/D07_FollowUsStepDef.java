package org.example.StepDefinition;

import org.example.Runners.Pages.Home_Page;
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
        linkType = Hooks.driver.getCurrentUrl();
        if (linkType.contains("facebook")){
            linkType="facebook";
        } else if (linkType.contains("twitter")) {
            linkType="twitter";
        } else if (linkType.contains("rss")) {
            linkType="rss";
        }else if (linkType.contains("youtube")){
            linkType="youtube";
        }

        switch (linkType) {

            case "facebook":
                Thread.sleep(1000);
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://www.facebook.com/nopCommerce","facebook follow us link");
                break;

            case "twitter":
                Thread.sleep(1000);
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://twitter.com/nopCommerce","twitter follow us link");
                break;

            case "rss":
                Assert.assertEquals(Hooks.driver.getCurrentUrl(), "https://demo.nopcommerce.com/news/rss/1","rss follow us link");
                break;

            case "youtube":
                Thread.sleep(1000);
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
        home.youtube().click();
    }

}

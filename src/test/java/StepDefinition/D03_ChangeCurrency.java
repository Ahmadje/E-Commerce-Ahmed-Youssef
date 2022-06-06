package StepDefinition;

import Pages.Home_Page;
import Pages.Register_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

public class D03_ChangeCurrency {
    Home_Page home;

    @Given("user select “Euro” from currency dropdown list")
    public void user_select_Euro() {
        home = new Home_Page(Hooks.driver);
        home.currency().click();
        home.currencyEuro().click();
    }

    @When("user select “Dollar” from currency dropdown list")
    public void user_select_Dollar() {
        home = new Home_Page(Hooks.driver);
        home.currency().click();
        home.currencyDollar().click();
    }
}

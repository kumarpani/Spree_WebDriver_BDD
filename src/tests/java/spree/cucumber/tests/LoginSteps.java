package spree.cucumber.tests;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.junit.Assert.assertTrue;
import static spree.cucumber.tests.Constants.*;

public class LoginSteps {
    @When("^When I click on the Login Link$")
    public void When_I_click_on_the_Login_Link() throws Throwable {
        //webDriver.findElement(By.id("link-to-login")).click();
        webDriver.findElement(By.linkText("LOGIN")).click();
        Thread.sleep(5000);
    }

    @Then("^User should be navigated to Login Page$")
    public void User_should_be_navigated_to_Login_Page() throws Throwable {
        // Express the Regexp above with the code you wish you had
        assertTrue(webDriver.findElement(By.id("password-credentials")).isDisplayed());

    }

    @Given("^I am on Login Page$")
    public void I_am_on_Login_Page() throws Throwable {
        webDriver.get(SpreeHostName);
        Thread.sleep(5000);
        webDriver.findElement(By.linkText("LOGIN")).click();
        Thread.sleep(5000);
        assertTrue(webDriver.findElement(By.id("password-credentials")).isDisplayed());
    }

    @And("^I Enter Valid Email ID$")
    public void When_I_Enter_Valid_Email_ID() throws Throwable {
        webDriver.findElement(By.id("spree_user_email")).sendKeys("test@test.com");
    }

    @And("^I Enter Valid Password$")
    public void I_Enter_Valid_Password() throws Throwable {
        webDriver.findElement(By.id("spree_user_password")).sendKeys("password");
    }


    @When("^I click on the Login Button$")
    public void I_click_on_the_Login_Button() throws Throwable {
        webDriver.findElement(By.className("button")).click();
    }
}

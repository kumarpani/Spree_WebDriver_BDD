package spree.cucumber.tests;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

import static org.junit.Assert.assertTrue;

public class SearchSteps {
    public static WebDriver webDriver;

    @cucumber.api.java.en.Given("^I am on HomePage$")
    public void I_am_on_HomePage() throws Throwable {
        webDriver = new FirefoxDriver();
        webDriver.get("localhost:3000");


    }

    @When("^I search for \"([^\"]*)\"$")
    public void I_search_for(String product) throws Throwable {
        // Express the Regexp above with the code you wish you had
        webDriver.findElement(By.id("keywords")).sendKeys(product);
        webDriver.findElement(By.cssSelector("input[type='submit']")).click();

    }

    @Then("^I should see product with name \"([^\"]*)\" in the results$")
    public void I_should_see_product_with_name_in_the_results(String productName) throws Throwable {
        // Express the Regexp above with the code you wish you had
        List<WebElement> products = webDriver.findElements(By.id("products"));

        for(WebElement p : products) {
            assertTrue("PRODUCT NAME" + p.getText(), p.findElement(By.className("info")).getText().toLowerCase().contains(productName));
        }
    }
}

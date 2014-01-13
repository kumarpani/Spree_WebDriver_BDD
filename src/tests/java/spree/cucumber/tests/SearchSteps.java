package spree.cucumber.tests;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static spree.cucumber.tests.Constants.SpreeHostName;
import static spree.cucumber.tests.Constants.webDriver;

public class SearchSteps {

    @Given("^I am on HomePage$")
    public void I_am_on_HomePage() throws Throwable {
        webDriver.get(SpreeHostName);
        Thread.sleep(5000);
//        wait.until(ExpectedConditions.visibilityOfElementLocated(By.linkText("LOGIN")));
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void I_search_for_product(String product) throws Throwable {
        // Express the Regexp above with the code you wish you had
        webDriver.findElement(By.id("keywords")).sendKeys(product);
        webDriver.findElement(By.cssSelector("input[type='submit']")).click();

    }

    @Then("^I should see product with name \"([^\"]*)\" in the results$")
    public void I_should_see_product_with_name_in_the_results(String productName) throws Throwable {
        // Express the Regexp above with the code you wish you had
        List<WebElement> products = webDriver.findElements(By.id("products"));

        for (WebElement p : products) {
            assertTrue("PRODUCT NAME" + p.getText(), p.findElement(By.className("info")).getText().toLowerCase().contains(productName));

        }
    }


    @Then(value = "^I should see product with name \"([^\"]*)\" in the results with the count of \"([^\"]*)\"$")
    public void I_should_see_item_in_the_results_with_the_count_of(String productName, String productCount) throws Throwable {
        // Express the Regexp above with the code you wish you had
        List<WebElement> products = webDriver.findElements(By.xpath("//li[starts-with(@id,'product_')]"));

        // Assert count of the products in the result */
        assertTrue("Product count matches",products.size()==Integer.parseInt(productCount));

        // Assert product name 
        for (WebElement p : products)
            assertTrue("PRODUCT NAME" + p.getText() + " is not matching", p.findElement(By.className("info")).getText().toLowerCase().contains(productName));
    }


}



package spree.cucumber.tests.Step;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import spree.cucumber.tests.Pages.BasePage;
import spree.cucumber.tests.Pages.SearchPage;
//import static spree.cucumber.tests.Constants.SpreeHostName;
//import static spree.cucumber.tests.Constants.webDriver;

public class SearchSteps extends BasePage {

    SearchPage searchPage = new SearchPage();

    @Given("^I am on HomePage$")
    public void I_am_on_HomePage() throws Throwable {
        webDriver.get(SpreeHostName);
        Thread.sleep(5000);
    }

    @When("^I search for product \"([^\"]*)\"$")
    public void I_search_for_product(String product) throws Throwable {
        // Express the Regexp above with the code you wish you had
        webDriver.findElement(By.id("keywords")).sendKeys(product);
        webDriver.findElement(By.cssSelector("input[type='submit']")).click();

    }

    @Then(value = "^I should see product with name \"([^\"]*)\" in the results with the count of \"([^\"]*)\"$")
    public void I_should_see_item_in_the_results_with_the_count_of(String productName, String productCount) throws Throwable {

        // Express the Regexp above with the code you wish you had
        // Assert count of the products in the result */
        searchPage.verifySearchResultsCount(Integer.parseInt(productCount));

        // Assert product name
        searchPage.verifySearchResults(productName);
    }


    @When("^I click on Product Category \"([^\"]*)\"$")
    public void I_click_on_Product_Category(String productCategory) throws Throwable {
        // Express the Regexp above with the code you wish you had
        //        webDriver.findElement(By.linkText(productCategory)).click();
        //        Thread.sleep(2000);
        searchPage.selectCategory(productCategory);

    }


    @Then("^I should see all Products with Category \"([^\"]*)\" in the results with the count of \"([^\"]*)\"$")
    public void I_should_see_all_Products_with_Category_in_the_results_with_the_count_of(String categoryName, String productsCount) throws Throwable {
        // Express the Regexp above with the code you wish you had
        searchPage.verifyCategoryNameCountInSearchResults(1);
        searchPage.verifySearchResultsCount(Integer.parseInt(productsCount));
        searchPage.verifyCategoryNameInSearchResults(categoryName);
    }
}



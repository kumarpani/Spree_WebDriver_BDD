package spree.cucumber.tests.Step;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import spree.cucumber.tests.Pages.SearchPage;
import spree.cucumber.tests.TestData.product;

import java.util.List;

/**
 * Created by Admin on 13/01/14.
 */
public class ShoppingCartSteps {

    SearchPage searchPage = new SearchPage();

//    private String categoryLink = "//ul[contains(@class,'list')]/li/a[contains(.,'%s')]";
//    private String productLink = "//ul[@id='products']/li/a[contains(.,'%s')]";
//    private String addToCartButton = "add-to-cart-button";
//    private String quantityTextbox = "//input[contains(@id,'variants')]";
//    private String continueShoppingLink = "//a[contains(.,'Continue shopping')]";
//
//
//    @When("^I add the following products$")
//    public void I_add_the_following_products(List<Product> products ) throws Throwable {
//        for (Product product: products)
//        {
//            String categoryLinkLocator = String.format(categoryLink, product.category);
//            webDriver.findElement(By.xpath(categoryLinkLocator)).click();
//
//            String productLinkLocator = String.format(productLink, product.productName);
//            webDriver.findElement(By.xpath(productLinkLocator)).click();
//
//            WebElement quantity = webDriver.findElement(By.xpath(quantityTextbox));
//            quantity.sendKeys(product.quantity);
//            webDriver.findElement(By.id(addToCartButton)).click();
//
//            webDriver.findElement(By.xpath(continueShoppingLink)).click();
//
//            System.out.println(product.category + " ... " + product.productName);
//        }
//    }

//class Product {
//    public String category;
//    public String productName;
//    public String quantity;
//}


    @When("^I add the following products$")
    public void I_add_the_following_products(List<product> products) throws Throwable {
//        SearchPage searchPage = new SearchPage();
        for (spree.cucumber.tests.TestData.product product : products) {
            searchPage
                    .selectCategory(product.category)
                    .selectProduct(product.productName)
                    .setQuantity(product.quantity)
                    .addToCart()
                    .verifyProductDetails(product.productName, product.quantity)
                    .continueShopping();
        }

    }

    @Then("^I should see \"([^\"]*)\" Items in the Cart of Price \"([^\"]*)\"$")
    public void I_should_see_Items_in_the_Cart_of_Price(String totalItemQuantity, String price) throws Throwable {
        searchPage.verifyCartItemsAndAmount(totalItemQuantity, price);
    }

    @And("^I should be able to checkout as Guest$")
    public void I_should_be_able_to_checkout_as_Guest() throws Throwable {
        searchPage.clickOnCartLink().checkoutFromCart();
    }
}

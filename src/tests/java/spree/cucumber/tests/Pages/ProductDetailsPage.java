package spree.cucumber.tests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import static spree.cucumber.tests.Constants.webDriver;

/**
 * Created by Admin on 13/01/14.
 */
public class ProductDetailsPage extends BasePage {

    private String addToCartButton = "add-to-cart-button";
    private String quantityTextbox = "//input[contains(@id,'variants')]";

    public ProductDetailsPage setQuantity(String quantity) {
        WebElement quantityLocator = getElementByXpath(quantityTextbox);
        quantityLocator.clear();
        quantityLocator.sendKeys(quantity);
        return this;
    }

    public ShoppingCartPage addToCart() {
        getElementById(addToCartButton).click();
        return new ShoppingCartPage();
    }

}

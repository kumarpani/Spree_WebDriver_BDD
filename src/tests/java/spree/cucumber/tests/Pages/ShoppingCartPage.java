package spree.cucumber.tests.Pages;

import org.openqa.selenium.WebElement;
import static org.junit.Assert.assertTrue;

/**
 * Created by Admin on 13/01/14.
 */
public class ShoppingCartPage extends BasePage {
    private String continueShoppingLink = "//a[contains(.,'Continue shopping')]";
    private String productNameColumn = "td[contains(@class,'cart-item-description')]/h4/a[contains(.,'%s')]";
    private String productPriceColumn = "td[contains(@class,'cart-item-quantity')]/input[@value='%s']";
    private String productRow = "//tr[%s and %s]";
    private String checkoutButton = "checkout-link";
    private String orderEmailTextBox = "order_email";
    private String continueButton = "//input[@value='Continue']";



    public SearchPage continueShopping()
    {
        getElementByXpath(continueShoppingLink).click();
        return new SearchPage();
    }

    public ShoppingCartPage verifyProductDetails(String productName, String quantity)
    {
        String productNameLoctor = String.format(productNameColumn, productName);
        String productQuantityLoctor = String.format(productPriceColumn, quantity);
        String productRowLoctor = String.format(productRow, productNameLoctor, productQuantityLoctor);
        WebElement productRow = getElementByXpath(productRowLoctor);
        String errorMessage = String.format("Product not found for %s with quantity %s",productName,quantity);
        assertTrue(errorMessage,null != productRow);
        return this;
    }

    public void checkoutFromCart(){
        getElementById(checkoutButton).click();
        WebElement emailTextBox = getElementById(orderEmailTextBox);
        emailTextBox.sendKeys("a@b.com");
        getElementByXpath(continueButton).click();
    }

}

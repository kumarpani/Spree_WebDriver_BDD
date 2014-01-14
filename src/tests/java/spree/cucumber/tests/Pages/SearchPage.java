package spree.cucumber.tests.Pages;

import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertTrue;

/**
 * Created by Admin on 13/01/14.
 */
public class SearchPage extends BasePage{

    private String categoryLink = "//ul[contains(@class,'list')]/li/a[contains(.,'%s')]";
    private String productLink = "//ul[@id='products']/li/a[contains(.,'%s')]";
    private String cartLinkWithItemAndPrice = "//li[@id='link-to-cart']/a[contains(normalize-space(.),'Cart: (%s)')]/span[contains(.,'$%s')]";
    private String cartLink = "//li[@id='link-to-cart']/a";


    public SearchPage selectCategory(String category){
        String categoryLinkLocator = String.format(categoryLink, category);
        getElementByXpath(categoryLinkLocator).click();
        return this;
    }

    public ProductDetailsPage selectProduct(String productName){
        String productLinkLocator = String.format(productLink, productName);
        getElementByXpath(productLinkLocator).click();
        return new ProductDetailsPage();
    }

    public ProductDetailsPage verifyCartItemsAndAmount(String numberOfItems, String amount){
        String cartLocator = String.format(cartLinkWithItemAndPrice, numberOfItems, amount);
        WebElement element = getElementByXpath(cartLocator);
        assertTrue("Cart Link incorrect",null != element);
        return new ProductDetailsPage();
    }


    public ShoppingCartPage clickOnCartLink() {
        getElementByXpath(cartLink).click();
        return new ShoppingCartPage();
    }
}

package spree.cucumber.tests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

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

    public SearchPage  verifySearchResults(String productName)
    {
        List<WebElement> products = getElementListByXpath("//li[starts-with(@id,'product_')]");
        // Assert product name
        for (WebElement p : products)
            assertTrue("PRODUCT NAME" + p.getText() + " is not matching", p.findElement(By.className("info")).getText().toLowerCase().contains(productName));
        return this;

    }

    public SearchPage  verifySearchResultsCount(int productCount)
    {
        List<WebElement> products = getElementListByXpath("//li[starts-with(@id,'product_')]");
        // Assert product count
        assertTrue("Product count is not matching",products.size()==productCount);
        return this;

    }

    public SearchPage verifyCategoryNameInSearchResults(String categoryName){

        assertTrue("Category Name is not matching", getElementListByXpath("//h1[@class='taxon-title']").get(0).getText().equals(categoryName));
        return this;
    }

    public SearchPage verifyCategoryNameCountInSearchResults(int categoryCount){

        assertTrue("Category count is not matching", getElementListByXpath("//h1[@class='taxon-title']").size()==categoryCount);
        return this;
    }

    }




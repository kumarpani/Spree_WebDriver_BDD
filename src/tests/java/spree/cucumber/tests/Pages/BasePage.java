package spree.cucumber.tests.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

/**
 * Created by Admin on 13/01/14.
 */
public class BasePage {


    protected static WebDriver webDriver = new FirefoxDriver();
    public static String SpreeHostName ="http://localhost:3000";

    public WebElement getElementById(String Id) {
        return webDriver.findElement(By.id(Id));
    }

    public WebElement getElementByXpath(String xpath) {
        return webDriver.findElement(By.xpath(xpath));
    }

    public List<WebElement> getElementListByXpath(String xpath) {
        return webDriver.findElements(By.xpath(xpath));
    }

}

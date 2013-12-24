package spree.cucumber.tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created with IntelliJ IDEA.
 * User: sramalin
 * Date: 24/12/13
 * Time: 2:28 PM
 * To change this template use File | Settings | File Templates.
 */
public class Constants {
    public static WebDriver webDriver = new FirefoxDriver();
    public static WebDriverWait wait;
    public static String SpreeHostName ="http://10.4.32.99:3000";
}

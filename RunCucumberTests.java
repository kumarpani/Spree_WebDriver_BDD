package spree.cucumber.tests;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

/**
 * Created with IntelliJ IDEA.
 * User: panikumar
 * Date: 03/12/13
 * Time: 4:46 PM
 * To change this template use File | Settings | File Templates.
 */

@RunWith(Cucumber.class)
@CucumberOptions(format = {"html:target/cucumber-html-report"})
public class RunCucumberTests {
}

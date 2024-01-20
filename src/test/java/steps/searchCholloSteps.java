package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.RunTests;

import java.time.Duration;

public class searchCholloSteps {

    WebDriver driver = RunTests.driver;

    @When("^the user enters (.*) on the search bar")
    public void theUserEntersProduct(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(product);
    }

    @And("the user press enter")
    public void theUserPressEnter() {
        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(Keys.ENTER);
    }

    @Then("^a list of (.*) or related are shown")
    public void aListOfProductOrRelatedAreShown(String product) {
        By elementLocator = By.cssSelector(".cept-tt.thread-link.linkPlain.thread-title--list.js-thread-title");

        Assert.assertTrue(isElementPresent(elementLocator));
    }

    private boolean isElementPresent(By locator) {
        try {
            return driver.findElement(locator).isDisplayed();
        } catch (org.openqa.selenium.NoSuchElementException | org.openqa.selenium.StaleElementReferenceException e) {
            return false;
        }
    }

}

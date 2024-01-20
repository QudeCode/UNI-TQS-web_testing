package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.Assert;
import tests.RunTests;

public class LoginSteps {

    WebDriver driver = RunTests.driver;

    @When("the user clicks the login option")
    public void theUserClicksTheLoginOption() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("button.button--type-primary.button--mode-brand")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginModalForm")));
    }

    @And("^the user enters (.*) and (.*)")
    public void theUserEntersUsernameAndPassword(String username, String password) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(By.id("loginModalForm-identity")).sendKeys(username);
        driver.findElement(By.id("loginModalForm-password")).sendKeys(password);
    }

    @And("the user clicks the submit button")
    public void theUserClicksTheSubmitButton() {
        driver.findElement(By.cssSelector("button.cept-login-submit")).click();
    }

    @Then("^session starts with the username (.*)")
    public void sessionStarts(String username) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-t='userDropdown']"))).click();
        String web_username = driver.findElement(By.className("navDropDown-head")).getText();

        Assert.assertEquals(web_username, username);
    }

    @Then("an error appears")
    public void anErrorAppears() {
        By errorMessageLocator = By.cssSelector("p.formList-info.formList-info--error");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement errorMessageElement = wait.until(ExpectedConditions.visibilityOfElementLocated(errorMessageLocator));

        Assert.assertTrue(errorMessageElement.isDisplayed(), "El mensaje de error no está presente o no es visible.");
    }
}

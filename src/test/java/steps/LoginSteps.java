package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;

import org.testng.Assert;

public class LoginSteps {

    WebDriver driver;

    @Given("the user is in the index page")
    public void theUserIsInTheIndexPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.chollometro.com");
    }

    @And("the user accepts the cookies")
    public void theUserAcceptsTheCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-t-click=''][data-t='continueWithoutAcceptingBtn']"))).click();
    }


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



    @Then("session starts")
    public void sessionStarts() {

    }


}

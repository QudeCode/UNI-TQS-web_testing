package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.RunTests;

import java.time.Duration;

public class CommonSteps {

    WebDriver driver = RunTests.driver;

    @Given("the user is in the index page")
    public void theUserIsInTheIndexPage() {
        driver.navigate().to("https://www.chollometro.com");
    }

    @And("the user accepts the cookies")
    public void theUserAcceptsTheCookies() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-t-click=''][data-t='continueWithoutAcceptingBtn']"))).click();
    }

    @And("the user logs in")
    public void theUserLogsIn() {
        String username = "tqs_testing";
        String password = "testing_123321";

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        driver.findElement(By.cssSelector("button.button--type-primary.button--mode-brand")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginModalForm")));

        driver.findElement(By.id("loginModalForm-identity")).sendKeys(username);
        driver.findElement(By.id("loginModalForm-password")).sendKeys(password);

        driver.findElement(By.cssSelector("button.cept-login-submit")).click();
    }
}

package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.*;
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
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(1));
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button[data-t-click=''][data-t='continueWithoutAcceptingBtn']")));
            element.click();
        } catch (TimeoutException e) {
            System.out.println("El elemento no se encontró en 1 segundo. Continuando con la ejecución.");
        }
    }


    @And("the user logs in")
    public void theUserLogsIn() {

        if(!isSessionStarted()) {
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

    public boolean isSessionStarted() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement userDropdownButton = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-t='userDropdown']")));

            return userDropdownButton.isDisplayed();
        } catch (TimeoutException | NoSuchElementException e) {
            return false;
        }
    }

}

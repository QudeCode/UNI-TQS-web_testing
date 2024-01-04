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
}

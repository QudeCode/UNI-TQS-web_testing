package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.RunTests;

import java.time.Duration;

public class applyCouponSteps {

    WebDriver driver = RunTests.driver;

    @When("the user clicks the menu option")
    public void theUserClicksTheMenuOption() {
        driver.findElement(By.cssSelector("button.navMenu-trigger")).click();
    }

    @And("clicks the codigos de descuento option")
    public void clicksTheCodigosDeDescuentoOption() {
        driver.findElement(By.cssSelector("a.button--type-tertiary.button--mode-white.button--shape-circle.space--l-0.space--ml-2.space--mt-1")).click();
    }

    @And("clicks on No button")
    public void clicksOnNoButton() {

    }

    @Then("can get a coupon")
    public void canGetACoupon() {
        driver.findElement(By.cssSelector("span.voucher-label")).click();

        WebElement voucherDiv = driver.findElement(By.cssSelector("div.voucher"));
        WebElement textElement = voucherDiv.findElement(By.cssSelector("input"));
        String voucherText = textElement.getAttribute("value");

        System.out.println("CODIGO DE DESCUENTO: " + voucherText);

    }
}

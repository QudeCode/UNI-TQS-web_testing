package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.RunTests;

import java.time.Duration;

public class getCouponSteps {

    WebDriver driver = RunTests.driver;

    @When("the user clicks the menu option")
    public void theUserClicksTheMenuOption() {
        driver.findElement(By.cssSelector("button.navMenu-trigger")).click();
    }

    @And("clicks the codigos de descuento option")
    public void clicksTheCodigosDeDescuentoOption() {
        // Haz clic en el enlace "codigos de descuento" para abrir una nueva pestaña
        driver.findElement(By.cssSelector("a.button--type-tertiary.button--mode-white.button--shape-circle.space--l-0.space--ml-2.space--mt-1")).click();
    }
    @And("clicks on No button")
    public void clicksOnNoButton() {

        Actions actions = new Actions(driver);
        actions.sendKeys("\uE00C").perform(); // Código de tecla "Esc"
    }

    @Then("can get a coupon")
    public void canGetACoupon() {
        driver.findElement(By.cssSelector("span.voucher-label")).click();

        WebElement voucherDiv = driver.findElement(By.cssSelector("div.voucher"));
        WebElement textElement = voucherDiv.findElement(By.cssSelector("input"));
        String voucherText = textElement.getAttribute("value");

        System.out.println("CODIGO DE DESCUENTO: " + voucherText);

    }

    @And("the user selects a store for a coupon")
    public void theUserSelectsAStoreForACoupon() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.button--type-text.button--mode-white.space--v-2.boxAlign-jc--all-fs.width--all-12.space--r-1")));
        button.click();
    }

    @And("the user copies the discount code to clipboard")
    public void theUserCopiesTheDiscountCodeToClipboard() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement copyCodeButton = driver.findElement(By.cssSelector(".button.button--type-primary.button--shape-circle.button--size-s.button--code.hide--copy-command-off.flex--shrink-0.space--mr-1.button--mode-brand"));
        copyCodeButton.click();
    }
}

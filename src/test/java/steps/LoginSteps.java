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

    @And("the user clicks on Forgot Password")
    public void theUserClicksOnForgotPassword() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Encontrar y hacer clic en el botón "Forgot Password"
       wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".button.button--type-text.button--mode-secondary.button--size-s.height--all-auto.text--trans-n"))).click();
    }

    @And("^the user enters (.*) for password recovery")
    public void theUserEntersEmailForPasswordRecovery(String email) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Encontrar el campo de entrada de correo electrónico y escribir la dirección de correo electrónico
        WebElement emailInput = wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.width--all-12.size--all-s")));
        emailInput.sendKeys(email);
    }

    @And("the user clicks the Recover Password button")
    public void theUserClicksTheRecoverPasswordButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("width--all-12 button button--shape-circle button--type-primary button--mode-brand cept-submit-reset-password"))).click();
    }

    @And("without login")
    public void withoutLogin() {
        By loginButtonSelector = By.cssSelector("button[data-t='userDropdown']");

        // Comprueba si el elemento de inicio de sesión/registrar existe
        if (isElementPresent(loginButtonSelector)) {
            // Si no existe, realiza las acciones adicionales
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Hacer clic en el botón de inicio de sesión/registrar
            driver.findElement(loginButtonSelector).click();

            // Esperar a que aparezca el formulario de inicio de sesión
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("loginModalForm")));

            // Realizar otras acciones necesarias, como ingresar credenciales, etc.

            pressesLogOut();
        }
    }
    private boolean isElementPresent(By selector) {
        try {
            driver.findElement(selector);
            return true;
        } catch (org.openqa.selenium.NoSuchElementException e) {
            return false;
        }
    }

    @And("logged in")
    public void loggedIn() {
        By loginButtonSelector = By.cssSelector("button[data-t='userDropdown']");

        // Comprueba si el elemento de inicio de sesión existe
        if (!isElementPresent(loginButtonSelector)) {
            // Si no existe, ejecuta la función para iniciar sesión

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

    @And("presses log out")
    public void pressesLogOut() {
        WebElement logoutButton = driver.findElement(By.cssSelector("button[data-t='logout']"));
        logoutButton.click();
    }

    @Then("it should log out")
    public void itShouldLogOut() {
        By elementSelector = By.cssSelector("button.button--toW5-square");

        if (isElementPresent(elementSelector)) {
            Assert.assertTrue(true, "El elemento está presente.");
        } else {
            Assert.fail("El elemento no debería estar presente.");
        }
    }

    @When("the user clicks the user option")
    public void theUserClicksTheUserOption() {
        By userDropdownBy = By.cssSelector("button[data-t='userDropdown']");
        WebElement userDropdown = driver.findElement(userDropdownBy);
        userDropdown.click();
    }

}

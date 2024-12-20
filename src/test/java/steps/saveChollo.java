package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import tests.RunTests;


import java.time.Duration;


public class saveChollo {

    WebDriver driver = RunTests.driver;

    @And("the user clicks on the save button")
    public void theUserClicksOnSaveButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        // Encontrar y hacer clic en el botón de guardar
        WebElement saveButton = driver.findElement(By.cssSelector(".button--shape-circle.button--type-secondary.button--mode-default.button--square.cept-off.flex--inline.space--mr-2"));
        saveButton.click();
        // Puedes usar wait.until(...) para esperar a que algún elemento aparezca o cambie.
    }

    @And("the user goes to their saved deals")
    public void theUserGoesToUserProfile() {
        WebElement navDropDownTrigger = driver.findElement(By.cssSelector("button.avatar js-avatar navDropDown-avatar avatar--type-nav avatar--type-nav--selected js-navDropDown-avatar-selected"));
        navDropDownTrigger.click();

        // Esperar a que se cargue la página o realizar otras acciones según sea necesario.

        // Encontrar y hacer clic en el enlace "Chollos Guardados" en el menú de navegación
        WebElement misOfertasLink = driver.findElement(By.cssSelector("button.navDropDown-link lbox--v-8 lbox--f text--b navDropDown-link--selected router-link-active"));
        misOfertasLink.click();
    }


    @When("^the user enters (.*) on the search")
    public void theUserEntersProductOnTheSearch(String product) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement searchInput = driver.findElement(By.name("q"));
        searchInput.sendKeys(product);
    }
}
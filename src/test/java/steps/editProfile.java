package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.RunTests;

import java.time.Duration;
import java.util.List;

public class editProfile {

    WebDriver driver = RunTests.driver;

    @When("the user navigates to the profile edit page")
    public void theUserNavigatesToTheProfileEditPage() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("button[data-t='userDropdown']"))).click();

        driver.findElement(By.cssSelector("a[href='/profile/tqs_testing/settings'].navDropDown-link.lbox--v-8.lbox--f.text--b")).click();

    }

    @And("^the user changes the description to (.*)")
    public void theUserChangesTheDescriptionToNewDescription(String newDescription) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

        WebElement changeDescriptionButton = driver.findElement(By.xpath("//button[text()='Cambiar descripción']"));

        // Desplazar a la vista del botón
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", changeDescriptionButton);

        changeDescriptionButton.click();


        WebElement descriptionElement = driver.findElement(By.cssSelector("input#profile-description-description.input.width--all-12.size--all-s"));
        wait.until(ExpectedConditions.visibilityOf(descriptionElement));

        descriptionElement.clear();
        descriptionElement.sendKeys(newDescription);
    }

    @And("the user saves the changes")
    public void theUserSavesTheChanges() {
        WebElement updateButton = driver.findElement(By.xpath("//button[text()='Actualizar descripción']"));

        updateButton.click();

        // Sleep 2s
        try {
            Thread.sleep(2000);
            driver.navigate().refresh();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Then("^the profile should be updated with (.*)")
    public void theProfileShouldBeUpdatedWithTheNewDescription(String newDescription) {
        List<WebElement> spans = driver.findElements(By.cssSelector("span.formList-static.formList-static--em.box--all-b.space--b-2"));
        String actualDescription = "";
        if (spans.size() >= 2) {
            WebElement segundoSpan = spans.get(1); // El segundo span (índice 1)
            actualDescription = segundoSpan.getText();
            //System.out.println(actualDescription);
        } else {
            System.out.println("No se encontraron suficientes elementos span");
        }

        Assert.assertEquals(newDescription, actualDescription);
    }
}

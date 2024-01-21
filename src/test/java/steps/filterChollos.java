package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import tests.RunTests;

import java.time.Duration;
import java.util.List;

public class filterChollos {

    WebDriver driver = RunTests.driver;

    @When("the user clicks the filter option")
    public void theUserClicksTheFilterOption() {
        driver.findElement(By.cssSelector("span[data-t='showFilterMenu'][data-t-click='']")).click();
    }

    @And("^selects (.*) view")
    public void selectsTheNewVisionType(String view) {
        if (view.equals("list")) {
            driver.findElement(By.cssSelector("button[name='layout'][title='Mostrar chollos en sólo texto']")).click();
        }

        if (view.equals("text")) {
            driver.findElement(By.cssSelector("button[name='layout'][title='Mostrar chollos en lista']")).click();
        }
    }
    @Then("^the products should be shown as (.*)")
    public void theProductsShouldBeShownInADifferentWay(String view) {
        if (view.equals("text")) {
            try {
                driver.findElement(By.className("thread--compact"));
                System.out.println("Se encontró al menos un elemento con la clase 'thread--compact'");
            } catch (Exception e) {
                System.out.println("No se encontró ningún elemento con la clase 'thread--compact'");
            }
        } else if (view.equals("list")) {
            // Si es "list", verifica si existe el elemento y lanza un Assert.fail si se encuentra
            try {
                WebElement element = driver.findElement(By.className("thread--compact"));
                System.out.println("Se encontró al menos un elemento con la clase 'thread--compact' en vista 'list'");
                Assert.fail("Se encontró al menos un elemento con la clase 'thread--compact' y no debería");
            } catch (Exception e) {
                // No se encontró el elemento, lo cual es lo esperado en vista 'list'
            }
        } else {
            System.out.println("Vista no reconocida: " + view);
        }

    }

    @And("the user applies the filter to hide sold-out products")
    public void theUserAppliesTheFilterToHideSoldOutProducts() {
        WebElement element = driver.findElement(By.name("hide_expired"));
        if (element.isDisplayed() && element.isEnabled()) {
            element.click();
        }
    }

    @Then("sold-out products should not be displayed")
    public void soldOutProductsShouldNotBeDisplayed() {
        By soldOutLocator = By.xpath("//span[text()='Agotado']");
        WebElement soldOutElement = null;

        try {
            soldOutElement = driver.findElement(soldOutLocator);
        } catch (Exception ignored) {
        }

        Assert.assertNull(soldOutElement, "Se encontró un producto agotado, pero no debería");
    }
}

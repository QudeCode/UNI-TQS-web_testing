package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import tests.RunTests;

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
            driver.findElement(By.cssSelector("button[name='layout'][value='horizontal']")).click();
        }

        if (view.equals("text")) {
            driver.findElement(By.cssSelector("button[name='layout'][value='text']")).click();
        }
    }
    @Then("^the products should be shown as (.*)")
    public void theProductsShouldBeShownInADifferentWay(String view) {
        List<WebElement> articles;

        if (view.equals("list")) {
            articles = driver.findElements(By.xpath("//div[@class='scrollBox-item']//a"));
            Assert.assertTrue(articles.size() > 0, "No se encontraron artículos en formato de lista");
        }

        if (view.equals("text")) {
            articles = driver.findElements(By.xpath("//div[@class='threadGrid-title']//a"));
            Assert.assertTrue(articles.size() > 0, "No se encontraron artículos en formato de texto");
        }
    }

    @When("the user applies the filter to hide sold-out products")
    public void theUserAppliesTheFilterToHideSoldOutProducts() {
        
    }

    @Then("sold-out products should not be displayed")
    public void soldOutProductsShouldNotBeDisplayed() {

    }
}

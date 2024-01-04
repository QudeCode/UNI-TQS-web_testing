package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;


public class LoginSteps {

    WebDriver driver;

    @Given("the user is in the index page")
    public void theUserIsInTheIndexPage() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");
        driver = new ChromeDriver();
        driver.navigate().to("https://www.chollometro.com");
    }

    @And("the user accepts the cookies")
    public void theUserAcceptsTheCookies() {
        driver.findElement(By.cssSelector("button[data-t-click=''][data-t='continueWithoutAcceptingBtn']")).click();
    }

    @When("the user clicks the login option")
    public void theUserClicksTheLoginOption() {
        driver.findElement(By.cssSelector("button.button--toW5-square")).click();
    }

    @And("^the user enters (.*) and (.*)")
    public void theUserEntersUserAndPassword(String user, String password) {
        driver.findElement(By.id("loginModalForm-identity")).sendKeys(user);
        driver.findElement(By.id("loginModalForm-password")).sendKeys(password);;
    }

    @And("the user clicks the submit button")
    public void theUserClicksTheSubmitButton() {
        
    }

    @Then("session starts")
    public void sessionStarts() {

    }


}

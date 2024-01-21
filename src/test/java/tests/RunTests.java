package tests;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

//@CucumberOptions(features="src/test/java/features/", glue="steps")
@CucumberOptions(features="src/test/java/features", glue="steps")
public class RunTests extends AbstractTestNGCucumberTests {

    boolean quitDrivers = false;
    public static WebDriver driver;

    // Inicializar el driver antes de ejecutar cualquier escenario
    @BeforeClass
    public void setupClass() {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        System.setProperty("webdriver.http.factory", "jdk-http-client");

        driver = new ChromeDriver();
    }

    // Crear una instancia nueva de WebDriver para cada escenario
    @Before
    public void setup(Scenario scenario) {

        driver = new ChromeDriver();
    }

    @After
    public void clear() {

        if(quitDrivers){
            driver.quit();
        }
    }

    // Cerrar el driver después de que se hayan ejecutado todos los escenarios
    @AfterClass
    public void clearAll() {

        if(quitDrivers){
            driver.quit();
        }
    }
}

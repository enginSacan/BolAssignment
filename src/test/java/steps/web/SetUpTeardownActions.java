package steps.web;

import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static steps.web.pages.Base.driver;
import static steps.web.pages.Base.goToMainPage;

public class SetUpTeardownActions {
    @BeforeAll
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        //WebDriverManager.firefoxdriver().setup();
        if (driver == null) {
            driver = new ChromeDriver();
            //driver = new FirefoxDriver();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.manage().window().maximize();
        }
    }

    @After
    public static void checkFailure(Scenario scenario) throws IOException {
        if (scenario.isFailed()) {
            /* File source = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.FILE);
            byte[] screenshot = ((FirefoxDriver)driver).getFullPageScreenshotAs(OutputType.BYTES);
            FileHandler.copy(source, new File("Full_Page_Screenshot.png"));
            scenario.attach(screenshot,"image/png", scenario.getName());
             */
            goToMainPage();
        }
    }
    @AfterAll
    public static void teardown() {
        if (driver != null) {
            driver.quit();
        }
    }

}

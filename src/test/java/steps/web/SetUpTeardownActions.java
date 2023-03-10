package steps.web;

import generic.WebProperties;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.BeforeAll;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

import static generic.PropertyNames.WEB_BROWSER;
import static generic.PropertyNames.WEB_URL;
import static steps.web.pages.Base.driver;
import static steps.web.pages.Base.goToMainPage;

public class SetUpTeardownActions {
    public static final String BROWSER = WebProperties.getProperties().getProperty(WEB_BROWSER);
    @BeforeAll
    public static void setUp() {
        if(BROWSER.equals("chrome")) {
            WebDriverManager.chromedriver().setup();
            if (driver == null) {
                driver = new ChromeDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.manage().window().maximize();
            }
        }
        if(BROWSER.equals("firefox")) {
            WebDriverManager.firefoxdriver().setup();
            if (driver == null) {
                driver = new FirefoxDriver();
                driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
                driver.manage().window().maximize();
            }
        }
        if (BROWSER.equals("headless")) {
            WebDriverManager.chromedriver().setup();
            ChromeOptions options=new ChromeOptions();
            options.setHeadless(true);
            options.addArguments("window-size=1920,1080");
            driver = new ChromeDriver(options);
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

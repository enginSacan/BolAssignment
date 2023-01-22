package steps.web.pages;

import generic.WebProperties;
import org.openqa.selenium.*;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import steps.web.model.Product;

import java.time.Duration;
import java.util.List;

import static generic.PropertyNames.WEB_URL;


public class Base {
    private final long timeoutInSeconds = 5;
    public static WebDriver driver;

    public static final String BASE_URL = WebProperties.getProperties().getProperty(WEB_URL);

    protected static Product product;
    protected WebElement findElement(By by)  throws NotFoundException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElement(by);
    }

    protected List<WebElement> findElements(By by)  throws NotFoundException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.visibilityOfElementLocated(by));
        return driver.findElements(by);
    }

    protected void clickElement(WebElement element) throws NotFoundException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(ExpectedConditions.elementToBeClickable(element));
        element.click();
    }

    protected WebElement findBelowElementWithClassName(By by,String className)  throws NotFoundException {
        return findElement(RelativeLocator.with(By.className(className)).below(findElement(by)));
    }
    protected WebElement findBelowElementWithXpath(By by,String xpath)  throws NotFoundException {
        return findElement(RelativeLocator.with(By.xpath(xpath)).below(findElement(by)));
    }
    protected WebElement findAboveElementWithXpath(By by,String xpath)  throws NotFoundException {
        return findElement(RelativeLocator.with(By.xpath(xpath)).above(findElement(by)));
    }

    public static void goToMainPage() {
        driver.navigate().to(BASE_URL);
    }
    public static void goToPage(String website) throws NotFoundException {
        driver.navigate().to(website);
    }
    protected void scrollPageDown(String pixel) {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,"+pixel+")");
    }

}

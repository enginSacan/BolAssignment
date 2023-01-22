package steps.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.sound.midi.Soundbank;
import java.sql.SQLOutput;

public class Home extends Base{

    private final String customerServiceXpath = "//a[@data-test='Klantenservice']";
    private final String acceptCookieButtonId = "js-first-screen-accept-all-button";

    private final String giftCardXpath = "//a[@data-test='Cadeaukaart']";

    private final String basketId = "basket";

    public void goToCustomerServicePage() {
        clickElement(findElement(By.xpath(customerServiceXpath)));
    }

    public void goToGiftCardPage() {
        clickElement(findElement(By.xpath(giftCardXpath)));
    }
    private static Logger logger = LoggerFactory.getLogger(Home.class);
    public void acceptCookies() {
        try {
            clickElement(findElement(By.id(acceptCookieButtonId)));
        } catch (TimeoutException e) {
            logger.info("No Cookies continue to the test");
        }

    }
    public void goToBasket() {
        clickElement(findElement(By.id(basketId)));
    }
}

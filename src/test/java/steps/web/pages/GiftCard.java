package steps.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import steps.web.model.Product;

import java.util.List;

public class GiftCard extends Base{

    private final String productId = "js_items_content";

    private final String productTitle ="//span[@data-test='title']";

    private final String productPageXpath = "//a[@data-test='product-title']";

    private final String featureBoxesXpath = "//div[@data-test='feature-list']";

    private final String selectedFeatureXpath = "//div[@class='feature-list js_feature_list is-active']";
    private final String forYouThemeXpath = "//a[@data-test='item-4']";

    private final String addToBasketButtonXpath = "//a[@data-test='add-to-basket']";

    private final String togetherSlotXpath = "//div[@data-test='often_bought_together-slot']";
    private final String goToBasketButtonXpath = "//a[@class='ui-btn  ui-btn--primary add-on-page-header__button']";


    public void selectProduct () {
        scrollPageDown("400");
        clickElement(findBelowElementWithXpath(By.id(productId),productPageXpath));
    }

    public void selectProduct (String amount) {
        scrollPageDown("400");
        List<WebElement> productLinks = findElements(By.xpath(productPageXpath));
        for (WebElement productLink : productLinks) {
            if (productLink.getText().contains(amount)) {
                clickElement(productLink);
                break;
            }
        }
    }

    public void chooseTheme () {
        scrollPageDown("200");
        List<WebElement> themeBoxes = findElements(By.xpath(featureBoxesXpath));
        clickElement(themeBoxes.get(1));
        clickElement(findBelowElementWithXpath(By.xpath(selectedFeatureXpath),forYouThemeXpath));
    }

    public void addToBasket() {
        scrollPageDown("300");
        product = Product.builder().title(findElement(By.xpath(productTitle)).getText()).build();
        clickElement(findAboveElementWithXpath(By.xpath(togetherSlotXpath),addToBasketButtonXpath));
    }
    public void goToBasket() {
        clickElement(findElement(By.xpath(goToBasketButtonXpath)));
    }
}

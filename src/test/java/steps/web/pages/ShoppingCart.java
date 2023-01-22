package steps.web.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;

import java.util.List;


public class ShoppingCart extends Base{

    private final String productTitlesXpath = "//a[@class='product-details__title']";
    private final String removeButtonXpath = "//button[@data-testid='remove-item']";

    public boolean checkProduct(){
        try{
            List<WebElement> productTitles = findElements(By.xpath(productTitlesXpath));
            return productTitles.stream().anyMatch(x -> x.getText().equals(product.getTitle()));
        } catch (TimeoutException e) {
            return false;
        }
    }


    public void removeProduct() {
        clickElement(findElement(By.xpath(removeButtonXpath)));
    }
}

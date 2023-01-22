package steps.web.pages;

import org.openqa.selenium.By;

public class WarrantyRepair extends Base{

    private final String goToOrderXPath = "//a[@data-analytics-tag='klantenservice:Garantie & Reparatie:regelhetzelf:Naar je bestellingen']";

    public void goToMyOrder() {
        clickElement(findElement(By.xpath(goToOrderXPath)));
    }
}

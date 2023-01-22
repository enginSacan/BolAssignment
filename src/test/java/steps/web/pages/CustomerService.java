package steps.web.pages;

import org.openqa.selenium.By;


public class CustomerService extends Base{

    private final String  returnPageXpath = "//a[@data-analytics-tag='klantenservice:topic:return:Retouren & annuleren']";

    private final String warrantyPageXpath = "//a[@data-analytics-tag='klantenservice:topic:guarantee_reparation:Garantie & reparatie']";

    public void goToReturnPage() {
        clickElement(findElement(By.xpath(returnPageXpath)));
    }

    public void goToWarrantyPage() {clickElement(findElement(By.xpath(warrantyPageXpath)));}
}

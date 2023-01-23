package steps.web.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;


public class CustomerService extends Base{

    @FindBy(how=How.XPATH,using="//a[@data-analytics-tag='klantenservice:topic:return:Retouren & annuleren']")
    private WebElement returnPageXpath;
    @FindBy(how=How.XPATH,using="//a[@data-analytics-tag='klantenservice:topic:guarantee_reparation:Garantie & reparatie']")
    private WebElement warrantyPageXpath;

    public void goToReturnPage() {clickElement(returnPageXpath);}

    public void goToWarrantyPage() {clickElement(warrantyPageXpath);}
}

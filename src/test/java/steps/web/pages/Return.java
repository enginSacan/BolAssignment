package steps.web.pages;

import org.openqa.selenium.By;

public class Return extends Base{

    private final String  startReturnXpath = "//a[@data-analytics-tag='klantenservice:Retourneren & Annuleren:regelhetzelf:Start een retour']";

    public void startReturnProcess(){
        clickElement(findElement(By.xpath(startReturnXpath)));
    }

}

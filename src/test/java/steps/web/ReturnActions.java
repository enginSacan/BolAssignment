package steps.web;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import steps.web.pages.*;


import static steps.web.pages.Base.*;

public class ReturnActions {

    Home homePage = new Home();
    Return returnPage = new Return();
    Login loginPage = new Login();
    CustomerService customerServicePage = new CustomerService();
    WarrantyRepair warrantyRepairPage = new WarrantyRepair();
    @Given("User opens web page")
    public void userOpensWebPage() {
        goToMainPage();
        homePage.acceptCookies();
    }

    @When("User starts the {word} process")
    public void userStartsTheReturnProcess(String customerProcess) {
        homePage.goToCustomerServicePage();
        if (customerProcess.equalsIgnoreCase("return"))
        {
            customerServicePage.goToReturnPage();
            returnPage.startReturnProcess();
        }
        if (customerProcess.equalsIgnoreCase("warranty")) {
            customerServicePage.goToWarrantyPage();
            warrantyRepairPage.goToMyOrder();
        }
    }

    @Then("User should redirected to {word} page")
    public void userCanSeeTheCardInTheToDoSection(String page) {
        if (page.equalsIgnoreCase("login")) {
            Assert.assertTrue(loginPage.checkLoginPageUrl());
        }
    }
}

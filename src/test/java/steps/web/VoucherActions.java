package steps.web;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.TimeoutException;
import steps.web.pages.CustomerService;
import steps.web.pages.GiftCard;
import steps.web.pages.Home;
import steps.web.pages.ShoppingCart;

import static steps.web.pages.Base.goToMainPage;

public class VoucherActions {

    Home homePage = new Home();
    GiftCard giftCardPage = new GiftCard();

    ShoppingCart shoppingCart = new ShoppingCart();

    @When("User {word} voucher in the card")
    public void userVoucherActıons(String action) {
        if (action.equalsIgnoreCase("add")){
            homePage.goToGiftCardPage();
            giftCardPage.selectProduct("25");
            giftCardPage.chooseTheme();
            giftCardPage.addToBasket();
            giftCardPage.goToBasket();
        }
        if (action.equalsIgnoreCase("remove")){
            homePage.goToBasket();
            shoppingCart.removeProduct();
        }
    }

    @Then("Voucher should be {word} in the card")
    public void userCanSeeTheCardWithComment(String expectedAction) {
        if (expectedAction.equalsIgnoreCase("added")){
            Assert.assertTrue("Product cannot be found in shopping cart",shoppingCart.checkProduct());
        }
        if (expectedAction.equalsIgnoreCase("removed")){
            Assert.assertFalse("Product should not be found in shopping cart",shoppingCart.checkProduct());
        }
    }

}

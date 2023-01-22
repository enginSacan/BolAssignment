package steps.web.pages;



public class Login extends Base{

    public boolean checkLoginPageUrl() {
        return driver.getCurrentUrl().contains("account/login.html");
    }


}

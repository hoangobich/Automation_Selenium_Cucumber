package stepdifinition;

import core.DriverBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.login.LoginPage;

public class LoginStep extends DriverBase {
    LoginPage  loginPage;
    @Given("navigate to the php travels home page")
    public void navigateToThePhpTravelsHomePage() {
        loginPage =new LoginPage(getDriver());
        loginPage.navigatePhpTravels();
    }

    @When("login to the php travels with {string} and {string}")
    public void loginToThePhpTravelsWithAnd(String email, String password) {
        loginPage.inputEmail(email);
        loginPage.inputPass(password);
        loginPage.clickBtnLogin();
    }

    @Then("login display default screen dashboard is correct")
    public void loginDisplayDefaultScreenDashboardIsCorrect() {
        loginPage.verifyDashboardIsDisplayed();
    }

    @When("click button remember me")
    public void clickButtonRememberMe() {
        loginPage.clickCheckBoxRememberMe();
    }

    @Then("verify information placeholder email and password is correct")
    public void verifyInformationPlaceholderEmailAndPasswordIsCorrect() {
        loginPage.verifyPlaceholderEmailAndPass();
    }

    @Then("verify button remember me selected success")
    public void verifyButtonRememberMeSelectedSuccess() {
        loginPage.verifyRememberMeIsSelected();
    }

    @Given("navigate to {string}")
    public void navigateTo(String url) {
        loginPage.navigateToPage(url);
    }
}

package pages.login;

import common.BasePage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class LoginPage extends BasePage {
    public LoginPage(WebDriver driver){
        super(driver);
    }
    @FindBy(xpath = "//input[@name='email']")
    private WebElement input_email;
    @FindBy(xpath = "//input[@name='password']")
    private WebElement input_password;
    @FindBy(xpath = "//button[text()='Login']")
    private WebElement btn_login;
    @FindBy(xpath = "//span[text()='Dashboard']")
    private WebElement dashboard_screen;
    @FindBy(xpath = "//input[@name='remember']//parent::div")
    private WebElement check_box_remember_me;
    public void navigatePhpTravels(){
        navigateToPage("https://phptravels.net/admin");
    }
    public void inputEmail(String email){
        sendKeysToElement(input_email,email);
    }
    public void inputPass(String password){
        sendKeysToElement(input_password,password);
    }
    public void clickBtnLogin(){
        clickToElement(btn_login);
    }

    public void clickCheckBoxRememberMe(){
        clickToElement(check_box_remember_me);
    }

    public void verifyDashboardIsDisplayed(){
        checkElementDisplayed(dashboard_screen);
    }

    public void verifyPlaceholderEmailAndPass(){
        String placeholderEmail = input_email.getAttribute("placeholder");
        String placeholderPass = input_password.getAttribute("placeholder");
        Assert.assertEquals(placeholderEmail,"Email");
        Assert.assertEquals(placeholderPass,"Password");
    }

    public void verifyRememberMeIsSelected(){
        String attributeCheckBox = check_box_remember_me.getAttribute("class");
        Assert.assertTrue(attributeCheckBox.contains("checked"));
    }
}

package core;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;

public class BasePage {
    private WebDriver driver;
    private WebDriverWait wait;

    public BasePage(WebDriver driver) {
        this.driver = driver;
        wait=new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public BasePage() {
        super();
    }

    public void checkElementDisplayed(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
        if (element.isDisplayed()) {
            Assert.assertTrue(true);
        } else {
            Assert.assertTrue(false);
        }
    }

    public void senkeysToElement(WebElement element, String value) {
        getWait().until(ExpectedConditions.visibilityOf(element));
        element.clear();
        element.sendKeys(value);
    }

    public void navigateToPage(String url) {
        getDriver().navigate().to(url);
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getValueProperty(By element, String propertyName) {
        String text = getDriver().findElement(element).getAttribute(propertyName);
        return text;
    }

    public void clickToElement(WebElement element) {
        getWait().until(ExpectedConditions.visibilityOf(element));
        element.click();
    }

    public void seleclByValue(WebElement dropdown, String value) {
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByValue(value);
    }

    public String getTitle() {
        String title = getDriver().getTitle();
        return title;
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }
}
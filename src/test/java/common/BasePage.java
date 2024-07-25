package common;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
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
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        PageFactory.initElements(driver, this);
    }

    public WebDriver getDriver() {
        return driver;
    }

    public WebDriverWait getWait() {
        return wait;
    }

    public void waitForElementClickable(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public void waitForElementVisibility(WebElement element, int timeoutInSeconds) {
        WebDriverWait customWait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        customWait.until(ExpectedConditions.visibilityOf(element));
    }

    public void waitForPageLoaded(int timeoutInSeconds) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(timeoutInSeconds));
        wait.until(driver -> ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete"));
    }

    public void navigateToPage(String url) {
        getDriver().navigate().to(url);
        waitForPageLoaded(30); // Example: Wait for page to fully load after navigation (timeout: 30 seconds)
    }

    public String getText(WebElement element) {
        return element.getText();
    }

    public String getValueProperty(By locator, String propertyName) {
        return getDriver().findElement(locator).getAttribute(propertyName);
    }

    public void clickToElement(WebElement element) {
        waitForElementClickable(element, 30);
        element.click();
    }

    public void sendKeysToElement(WebElement element, String value) {
        waitForElementVisibility(element, 30);
        element.clear();
        element.sendKeys(value);
    }

    public void selectByValue(WebElement dropdown, String value) {
        Select selectDropdown = new Select(dropdown);
        selectDropdown.selectByValue(value);
    }

    public String getTitle() {
        return getDriver().getTitle();
    }

    public void checkElementDisplayed(WebElement element) {
        waitForElementVisibility(element, 30);
        Assert.assertTrue(element.isDisplayed(), "Element is not displayed.");
    }
}

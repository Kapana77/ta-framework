package epam.training.pages;

import epam.training.utils.WaitUtils;
import java.time.Duration;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

  protected static final String BASE_URL = "https://qa.training.epam.com";
  protected WebDriver driver;

  protected AbstractPage(WebDriver driver) {
    this.driver = driver;
    driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    PageFactory.initElements(driver, this);
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public String getCurrentUrl() {
    return driver.getCurrentUrl();
  }

  public void navigateBack() {
    driver.navigate().back();
  }

  public void navigateForward() {
    driver.navigate().forward();
  }

  public void refreshPage() {
    driver.navigate().refresh();
  }

  protected WebElement waitAndClick(By locator) {
    WebElement element = WaitUtils.waitForClickability(driver, locator);
    element.click();
    return element;
  }

  protected void waitAndType(By locator, String text) {
    WebElement element = WaitUtils.waitForVisibility(driver, locator);
    element.clear();
    element.sendKeys(text);
  }

  protected void clickJs(By locator) {
    WebElement element = WaitUtils.waitForClickability(driver, locator);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);
  }

  public abstract AbstractPage openPage();

}

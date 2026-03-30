package epam.training.pages;

import epam.training.utils.ConfigReader;
import epam.training.utils.WaitUtils;
import java.time.Duration;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public abstract class AbstractPage {

  protected final Logger logger = LogManager.getLogger(this.getClass());

  protected static final String BASE_URL = ConfigReader.get("base.url");
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

  protected void click(WebElement element) {
    WaitUtils.waitForClickability(driver, element);
    element.click();
  }

  protected void type(WebElement element, String text) {
    WaitUtils.waitForVisibility(driver, element);
    element.clear();
    element.sendKeys(text);
  }

  protected WebElement waitAndClick(By locator) {
    WebElement element = WaitUtils.waitForClickability(driver, locator);
    element.click();
    return element;
  }

  protected void clickJs(By locator) {
    WebElement element = WaitUtils.waitForClickability(driver, locator);
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);
  }

  protected void clickJs(WebElement element) {
    JavascriptExecutor js = (JavascriptExecutor) driver;
    js.executeScript("arguments[0].click();", element);
  }

  public abstract AbstractPage openPage();

}

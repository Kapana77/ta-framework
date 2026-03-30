package epam.training.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class WaitUtils {

  private static final Duration DEFAULT_TIMEOUT = Duration.ofSeconds(10);

  private WaitUtils() {
  }

  public static WebElement waitForVisibility(WebDriver driver, By locator) {
    return new WebDriverWait(driver, DEFAULT_TIMEOUT)
        .until(ExpectedConditions.visibilityOfElementLocated(locator));
  }

  public static WebElement waitForClickability(WebDriver driver, By locator) {
    return new WebDriverWait(driver, DEFAULT_TIMEOUT)
        .until(ExpectedConditions.elementToBeClickable(locator));
  }

  public static WebElement waitForVisibility(WebDriver driver, WebElement element) {
    return new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(ExpectedConditions.visibilityOf(element));
  }

  public static WebElement waitForClickability(WebDriver driver, WebElement element) {
    return new WebDriverWait(driver, Duration.ofSeconds(15))
        .until(ExpectedConditions.elementToBeClickable(element));
  }
}

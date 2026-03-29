package epam.training.utils;

import static epam.training.utils.WaitUtils.waitForClickability;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class CookieHandler {
  
  public static void acceptCookies(WebDriver driver) {
    if(hasCookiesConsentAppeared(driver)){
      WebElement element = waitForClickability(driver,By.cssSelector("button#onetrust-accept-btn-handler"));
      element.click();
    }
  }
  
  private static boolean hasCookiesConsentAppeared(WebDriver driver) {
    return driver.findElement(By.cssSelector("div.ot-sdk-container")).isDisplayed();
  }

}

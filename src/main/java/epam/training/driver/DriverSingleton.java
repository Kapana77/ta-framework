package epam.training.driver;

import epam.training.driver.decorator.LoggingWebDriver;
import epam.training.driver.factory.BrowserFactory;
import epam.training.utils.ConfigReader;
import org.openqa.selenium.WebDriver;

public class DriverSingleton {

  private static WebDriver driver;

  private DriverSingleton() {
  }

  public static WebDriver getDriver() {
    if (driver == null) {
      String browser = System.getProperty("browser",
          ConfigReader.get("browser")).toLowerCase();

      BrowserFactory factory = BrowserFactory.getFactory(browser);
      WebDriver rawDriver = factory.createDriver();

      driver = new LoggingWebDriver(rawDriver);
    }
    return driver;
  }

  public static void closeDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}

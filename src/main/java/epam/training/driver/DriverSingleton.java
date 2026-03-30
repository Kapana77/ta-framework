package epam.training.driver;

import epam.training.utils.ConfigReader;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class DriverSingleton {

  private static WebDriver driver;

  private DriverSingleton() {
  }

  public static WebDriver getDriver() {
    if (driver == null) {
      String browser = System.getProperty("browser", ConfigReader.get("browser")).toLowerCase();
      driver = createDriver(browser);
    }
    return driver;
  }

  private static WebDriver createDriver(String browser) {
    switch (browser.toLowerCase()) {
      case "firefox":
        WebDriverManager.firefoxdriver().setup();
        FirefoxOptions ffOptions = new FirefoxOptions();
        ffOptions.setAcceptInsecureCerts(true);
        return new FirefoxDriver(ffOptions);

      case "edge":
        WebDriverManager.edgedriver().setup();
        EdgeOptions edgeOptions = new EdgeOptions();
        edgeOptions.addArguments("--start-maximized");
        edgeOptions.setAcceptInsecureCerts(true);

        return new EdgeDriver(edgeOptions);

      case "chrome":
      default:
        WebDriverManager.chromedriver().setup();
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--start-maximized");
        chromeOptions.addArguments("--disable-search-engine-choice-screen");
        chromeOptions.setAcceptInsecureCerts(true);
        return new ChromeDriver(chromeOptions);
    }
  }

  public static void closeDriver() {
    if (driver != null) {
      driver.quit();
      driver = null;
    }
  }
}
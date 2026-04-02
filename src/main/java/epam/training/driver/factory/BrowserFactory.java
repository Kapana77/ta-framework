package epam.training.driver.factory;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public abstract class BrowserFactory {
  private static final Logger logger = LogManager.getLogger(BrowserFactory.class);

 
  public abstract WebDriver createDriver();
  
  public static BrowserFactory getFactory(String browser) {
    return switch (browser.toLowerCase()) {
      case "firefox" -> {
        logger.info("Selected FirefoxBrowserFactory");
        yield new FirefoxBrowserFactory();
      }
      case "edge" -> {
        logger.info("Selected EdgeBrowserFactory");
        yield new EdgeBrowserFactory();
      }
      default -> {
        logger.info("Selected ChromeBrowserFactory");
        yield new ChromeBrowserFactory();
      }
    };
  }
}

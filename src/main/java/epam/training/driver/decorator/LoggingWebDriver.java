package epam.training.driver.decorator;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class LoggingWebDriver extends WebDriverDecorator {

  private static final Logger logger = LogManager.getLogger(LoggingWebDriver.class);

  public LoggingWebDriver(WebDriver driver) {
    super(driver);
  }

  @Override
  public void get(String url) {
    logger.info("[LoggingDriver] Navigating to: {}", url);
    super.get(url);
  }

  @Override
  public void quit() {
    logger.info("[LoggingDriver] Quitting browser");
    super.quit();
  }
}


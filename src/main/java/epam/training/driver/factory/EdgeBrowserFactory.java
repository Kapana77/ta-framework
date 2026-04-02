package epam.training.driver.factory;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class EdgeBrowserFactory extends BrowserFactory {

  @Override
  public WebDriver createDriver() {
    WebDriverManager.edgedriver().setup();
    EdgeOptions options = new EdgeOptions();
    options.addArguments("--start-maximized");
    options.setAcceptInsecureCerts(true);
    return new EdgeDriver(options);
  }
}


package epam.training.tests;

import epam.training.driver.DriverSingleton;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public abstract class BaseTest {

  protected WebDriver driver;

  @BeforeClass
  public void setUp() {
    driver = DriverSingleton.getDriver();
  }

  @AfterClass(alwaysRun = true)
  public void tearDown() {
    DriverSingleton.closeDriver();
  }
  
  public WebDriver getDriver() {
    return driver;
  }
}

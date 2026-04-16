package epam.training.hooks;

import epam.training.driver.DriverSingleton;
import io.cucumber.java.After;
import io.cucumber.java.Before;

public class CucumberHooks {

  @Before
  public void setUpScenario() {
    DriverSingleton.getDriver();
  }

  @After
  public void tearDownScenario() {
    DriverSingleton.closeDriver();
  }
}
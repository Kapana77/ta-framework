package epam.training.pages;

import org.openqa.selenium.WebDriver;

public class EventsPage extends AbstractPage {

  public EventsPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public EventsPage openPage() {
    return this;
  }
}

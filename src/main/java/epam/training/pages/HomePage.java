package epam.training.pages;

import static epam.training.utils.WaitUtils.waitForVisibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends AbstractPage {

  private static final By NAV_BAR = By.cssSelector("div[class*='nav-bar']");
  private static final By MAIN_LOGO = By.cssSelector("div.main-logo");
  private static final By TRAINING_LINK = By.xpath("//div[@data-name='Trainings']");
  private static final By EVENTS_LINK = By.xpath("//div[@data-name='Events']");
  private static final By FIND_BUTTON = By.cssSelector("div.uui-caption");
  public static final By SKILLS_LINK = By.xpath("//div[@data-name='Skills']");

  public HomePage(WebDriver driver) {
    super(driver);
  }

  @Override
  public HomePage openPage() {
    driver.get(BASE_URL);
    return this;
  }

  public boolean isLogoDisplayed() {
    return waitForVisibility(driver, MAIN_LOGO).isDisplayed();
  }

  public boolean isNavBarDisplayed() {
    return waitForVisibility(driver, NAV_BAR).isDisplayed();
  }


  public TrainingPage clickTrainingLink() {
    waitAndClick(TRAINING_LINK);
    return new TrainingPage(driver);
  }

  public EventsPage clickEventsLink() {
    waitAndClick(EVENTS_LINK);
    return new EventsPage(driver);
  }

  public HomePage waitForSkillsLink() {
    waitForVisibility(driver, SKILLS_LINK);
    return this;
  }

  public SkillsPage clickSkillsLink() {
    waitAndClick(SKILLS_LINK);
    return new SkillsPage(driver);
  }

  public HomePage waitPageLoaded() {
    waitForVisibility(driver, FIND_BUTTON);
    return this;
  }
}

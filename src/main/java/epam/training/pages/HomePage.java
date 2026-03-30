package epam.training.pages;

import static epam.training.utils.WaitUtils.waitForVisibility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends AbstractPage {

  @FindBy(css = "div[class*='nav-bar']")
  private WebElement navBar;

  @FindBy(css = "div.main-logo")
  private WebElement mainLogo;

  @FindBy(xpath = "//div[@data-name='Trainings']")
  private WebElement trainingLink;

  @FindBy(xpath = "//div[@data-name='Events']")
  private WebElement eventsLink;

  @FindBy(xpath = "//div[@data-name='Skills']")
  private WebElement skillsLink;

  @FindBy(css = "div.uui-caption")
  private WebElement findButton;

  public HomePage(WebDriver driver) {
    super(driver);
    logger.debug("HomePage initialized");
  }

  @Override
  public HomePage openPage() {
    logger.info("Opening Home page: {}", BASE_URL);
    driver.get(BASE_URL);
    return this;
  }

  public boolean isLogoDisplayed() {
    logger.debug("Checking if main logo is displayed");
    boolean displayed = waitForVisibility(driver, mainLogo).isDisplayed();
    logger.info("Main logo displayed: {}", displayed);
    return displayed;
  }

  public boolean isNavBarDisplayed() {
    logger.debug("Checking if navigation bar is displayed");
    boolean displayed = waitForVisibility(driver, navBar).isDisplayed();
    logger.info("Navigation bar displayed: {}", displayed);
    return displayed;
  }

  public TrainingPage clickTrainingLink() {
    logger.info("Clicking 'Trainings' link");
    click(trainingLink);
    return new TrainingPage(driver);
  }

  public EventsPage clickEventsLink() {
    logger.info("Clicking 'Events' link");
    click(eventsLink);
    return new EventsPage(driver);
  }

  public HomePage waitForSkillsLink() {
    logger.debug("Waiting for 'Skills' link to become visible");
    waitForVisibility(driver, skillsLink);
    return this;
  }

  public SkillsPage clickSkillsLink() {
    logger.info("Clicking 'Skills' link");
    click(skillsLink);
    return new SkillsPage(driver);
  }

  public HomePage waitPageLoaded() {
    logger.debug("Waiting for Home page to fully load");
    waitForVisibility(driver, findButton);
    logger.info("Home page loaded successfully");
    return this;
  }
}

package epam.training.pages;

import static epam.training.utils.WaitUtils.waitForVisibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainingPage extends AbstractPage {

  @FindBy(xpath = "//h1[text()='Training programs']")
  private WebElement trainingHeading;

  @FindBy(xpath = "//div[text()='Subscribe']")
  private WebElement subscribeButton;

  public TrainingPage(WebDriver driver) {
    super(driver);
    logger.debug("TrainingPage initialized");
  }

  @Override
  public TrainingPage openPage() {
    logger.info("TrainingPage opened via navigation");
    return this;
  }

  public String getHeadingText() {
    logger.debug("Getting heading text");
    String text = waitForVisibility(driver, By.tagName("h1")).getText();
    logger.info("Heading text: '{}'", text);
    return text;
  }

  public boolean isContentDisplayed() {
    logger.debug("Checking if training content is displayed");
    boolean displayed = waitForVisibility(driver, trainingHeading).isDisplayed();
    logger.info("Training content displayed: {}", displayed);
    return displayed;
  }

  public TrainingPage waitForContent() {
    logger.debug("Waiting for training content to load");
    waitForVisibility(driver, trainingHeading);
    logger.info("Training content loaded");
    return this;
  }

  public HomePage navigateBackToHome() {
    logger.info("Navigating back to Home page");
    navigateBack();
    return new HomePage(driver);
  }

  public SubscribePage clickSubscribeButton() {
    logger.info("Clicking 'Subscribe' button");
    clickJs(subscribeButton);
    return new SubscribePage(driver);
  }
}
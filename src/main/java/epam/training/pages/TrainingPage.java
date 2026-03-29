package epam.training.pages;

import static epam.training.utils.WaitUtils.waitForVisibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TrainingPage extends AbstractPage {

  private static final By HEADING = By.xpath("//h1[text()='Training programs']");
  private static final By SUBSCRIBE_BUTTON = By.xpath("//div[text()='Subscribe']");
  
  @FindBy(xpath = "//h1[text()='Training programs']")
  private WebElement trainingHeading;

  public TrainingPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public TrainingPage openPage() {
    return this;
  }

  public String getHeadingText() {
    return waitForVisibility(driver, By.tagName("h1")).getText();
  }

  public boolean isContentDisplayed() {
    return waitForVisibility(driver, HEADING).isDisplayed();
  }

  public TrainingPage waitForContent() {
    waitForVisibility(driver, HEADING);
    return this;
  }

  public HomePage navigateBackToHome() {
    navigateBack();
    return new HomePage(driver);
  }

  public SubscribePage clickSubscribeButton() {
    clickJs(SUBSCRIBE_BUTTON);
    return new SubscribePage(driver);
  }

}

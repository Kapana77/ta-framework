package epam.training.pages;

import static epam.training.utils.WaitUtils.waitForVisibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SubscribePage extends AbstractPage {

  private static final String INPUT_PATTERN = "//input[@placeholder='";

  private static final By SEARCH_INPUT = By.xpath(
      "//input[@type='search' and @placeholder='Search']");
  private static final By SUBSCRIBE_HEADER = By.cssSelector("div.uui-modal-title");
  public static final By FIRST_OPTION = By.xpath("//div[@role='option']");
  private static final By SUCCESS_POPUP = By.cssSelector("div[role='alert'].uui-color-success");
  private static final By FIRST_NAME_INPUT = By.xpath(INPUT_PATTERN + "First name']");
  private static final By LAST_NAME_INPUT = By.xpath(INPUT_PATTERN + "Last name']");
  private static final By EMAIL_INPUT = By.xpath(INPUT_PATTERN + "mail@example.com']");
  private static final By COUNTRY_DROPDOWN =
      By.xpath("//label[contains(text(),'Country')]/ancestor::div[@class='uui-label-top']"
          + "//div[contains(@class,'uui-picker_toggler')]");
  private static final By SKILL_DROPDOWN =
      By.xpath("//label[contains(text(),'Skill')]/ancestor::div[@class='uui-label-top']"
          + "//div[contains(@class,'uui-picker_toggler')]");
  private static final By SUBSCRIBE_BUTTON =
      By.xpath("//div[contains(@class,'uui-modal-footer')]//button[.//div[text()='Subscribe']]");


  public SubscribePage(WebDriver driver) {
    super(driver);
  }

  @Override
  public AbstractPage openPage() {
    return this;
  }

  public SubscribePage typeFirstName(String firstName) {
    waitAndType(FIRST_NAME_INPUT, firstName);
    return this;
  }

  public SubscribePage typeLastName(String lastName) {
    waitAndType(LAST_NAME_INPUT, lastName);
    return this;
  }

  public SubscribePage waitForSubscribeScreen() {
    waitForVisibility(driver, SUBSCRIBE_HEADER);
    return this;
  }

  public SubscribePage typeEmail(String email) {
    waitAndType(EMAIL_INPUT, email);
    return this;
  }

  public SubscribePage clickCountryDropdown() {
    waitAndClick(COUNTRY_DROPDOWN);
    return this;
  }

  public SubscribePage selectFirstCountry() {
    waitAndClick(FIRST_OPTION);
    return this;
  }


  public SubscribePage clickSkillsDropdown() {
    waitAndClick(SKILL_DROPDOWN);
    return this;
  }

  public SubscribePage selectFirstSkill() {
    waitAndClick(FIRST_OPTION);
    return this;
  }

  public SubscribePage clickSubscribeButton() {
    waitAndClick(SUBSCRIBE_BUTTON);
    return this;
  }

  public SubscribePage verifySuccessPopup() {
    waitForVisibility(driver, SUCCESS_POPUP);
    return this;
  }
}

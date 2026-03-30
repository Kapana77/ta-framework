package epam.training.pages;

import static epam.training.utils.WaitUtils.waitForVisibility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SubscribePage extends AbstractPage {

  @FindBy(xpath = "//input[@placeholder='First name']")
  private WebElement firstNameInput;

  @FindBy(xpath = "//input[@placeholder='Last name']")
  private WebElement lastNameInput;

  @FindBy(xpath = "//input[@placeholder='mail@example.com']")
  private WebElement emailInput;

  @FindBy(css = "div.uui-modal-title")
  private WebElement subscribeHeader;

  @FindBy(xpath = "//div[@role='option']")
  private WebElement firstOption;

  @FindBy(css = "div[role='alert'].uui-color-success")
  private WebElement successPopup;

  @FindBy(xpath = "//label[contains(text(),'Country')]/ancestor::div[@class='uui-label-top']"
      + "//div[contains(@class,'uui-picker_toggler')]")
  private WebElement countryDropdown;

  @FindBy(xpath = "//label[contains(text(),'Skill')]/ancestor::div[@class='uui-label-top']"
      + "//div[contains(@class,'uui-picker_toggler')]")
  private WebElement skillDropdown;

  @FindBy(xpath = "//div[contains(@class,'uui-modal-footer')]//button[.//div[text()='Subscribe']]")
  private WebElement subscribeButton;

  public SubscribePage(WebDriver driver) {
    super(driver);
    logger.debug("SubscribePage initialized");
  }

  @Override
  public SubscribePage openPage() {
    logger.info("SubscribePage opened via navigation");
    return this;
  }

  public SubscribePage waitForSubscribeScreen() {
    logger.debug("Waiting for subscribe modal to appear");
    waitForVisibility(driver, subscribeHeader);
    logger.info("Subscribe modal is visible");
    return this;
  }

  public SubscribePage typeFirstName(String firstName) {
    logger.info("Typing first name: '{}'", firstName);
    type(firstNameInput, firstName);
    return this;
  }

  public SubscribePage typeLastName(String lastName) {
    logger.info("Typing last name: '{}'", lastName);
    type(lastNameInput, lastName);
    return this;
  }

  public SubscribePage typeEmail(String email) {
    logger.info("Typing email: '{}'", email);
    type(emailInput, email);
    return this;
  }

  public SubscribePage clickCountryDropdown() {
    logger.info("Clicking country dropdown");
    click(countryDropdown);
    return this;
  }

  public SubscribePage selectFirstCountry() {
    logger.info("Selecting first country from dropdown");
    click(firstOption);
    return this;
  }

  public SubscribePage clickSkillsDropdown() {
    logger.info("Clicking skills dropdown");
    click(skillDropdown);
    return this;
  }

  public SubscribePage selectFirstSkill() {
    logger.info("Selecting first skill from dropdown");
    click(firstOption);
    return this;
  }

  public SubscribePage clickSubscribeButton() {
    logger.info("Clicking 'Subscribe' button");
    click(subscribeButton);
    return this;
  }

  public SubscribePage verifySuccessPopup() {
    logger.debug("Waiting for success popup to appear");
    waitForVisibility(driver, successPopup);
    logger.info("Success popup is displayed");
    return this;
  }
}
package epam.training.pages;

import static epam.training.utils.WaitUtils.waitForVisibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SkillsPage extends AbstractPage {

  private static final String SKILL_PATTERN = "//h3[text()='";

  @FindBy(css = "div.skill-container")
  private WebElement skillsContainer;

  @FindBy(xpath = "//input[@type='search']")
  private WebElement searchInput;

  @FindBy(xpath = "//img[@alt='skill cover picture']")
  private WebElement skillCover;

  public SkillsPage(WebDriver driver) {
    super(driver);
    logger.debug("SkillsPage initialized");
  }

  @Override
  public SkillsPage openPage() {
    logger.info("SkillsPage opened via navigation");
    return this;
  }

  public SkillsPage waitForSkillsLoaded() {
    logger.debug("Waiting for skills container to load");
    waitForVisibility(driver, skillsContainer);
    logger.info("Skills container loaded");
    return this;
  }

  public SkillsPage waitForSearchInput() {
    logger.debug("Waiting for search input to become visible");
    waitForVisibility(driver, searchInput);
    return this;
  }

  public SkillsPage typeSkill(String skill) {
    logger.info("Typing skill name: '{}'", skill);
    type(searchInput, skill);
    return this;
  }

  public SkillsPage validateSkillCard(String skill) {
    logger.info("Validating skill card is visible: '{}'", skill);
    By dynamicLocator = By.xpath(SKILL_PATTERN + skill + "']");
    waitForVisibility(driver, dynamicLocator);
    logger.debug("Skill card '{}' found", skill);
    return this;
  }

  public SkillsPage clickOnSkillCard(String skill) {
    logger.info("Clicking on skill card: '{}'", skill);
    By dynamicLocator = By.xpath(SKILL_PATTERN + skill + "']");
    clickJs(dynamicLocator);
    return this;
  }

  public SkillsPage waitForCoverToLoad() {
    logger.debug("Waiting for skill cover image to load");
    waitForVisibility(driver, skillCover);
    logger.info("Skill cover image loaded");
    return this;
  }
}
package epam.training.pages;

import static epam.training.utils.WaitUtils.waitForVisibility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SkillsPage extends AbstractPage {

  private static final String SKILL_PATTER = "//h3[text()='";
  private static final By SKILLS_CONTAINER = By.cssSelector("div.skill-container");
  private static final By SEARCH_INPUT = By.xpath("//input[@type='search']");
  private static final By SKILL_COVER = By.xpath("//img[@alt='skill cover picture']");

  public SkillsPage(WebDriver driver) {
    super(driver);
  }

  @Override
  public SkillsPage openPage() {
    return this;
  }

  public SkillsPage waitForSkillsLoaded() {
    waitForVisibility(driver, SKILLS_CONTAINER);
    return this;
  }

  public SkillsPage waitForSearchInput() {
    waitForVisibility(driver, SEARCH_INPUT);
    return this;
  }

  public SkillsPage typeSkill(String skill) {
//    driver.findElement(SEARCH_INPUT).sendKeys(skill);
    waitAndType(SEARCH_INPUT, skill);
    return this;
  }

  public SkillsPage validateSkillCard(String skill) {
    waitForVisibility(driver, By.xpath(SKILL_PATTER + skill + "']"));
    return this;
  }

  public SkillsPage clickOnSkillCard(String skill) {
    clickJs(By.xpath(SKILL_PATTER + skill + "']"));
    return this;
  }

  public SkillsPage waitForCoverToLoad() {
    waitForVisibility(driver, SKILL_COVER);
    return this;
  }

}

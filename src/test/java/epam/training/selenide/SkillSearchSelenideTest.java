package epam.training.selenide;

import static org.testng.Assert.assertTrue;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SkillSearchSelenideTest {

  private static final String EXPECTED_URL = "skill";
  private static final String SKILL = ".NET";
  private static final String SKILL_URL = "NET";

  private SelenideHomePage homePage;
  private SelenideSkillsPage skillsPage;

  @BeforeClass
  public void setUp() {
    Configuration.browser = "chrome";
    Configuration.browserSize = "1920x1080";
    Configuration.timeout = 10000;
  }

  @Test(priority = 1)
  public void waitForPageToLoad() {
    homePage = new SelenideHomePage().openPage();
    assertTrue(homePage.isLogoDisplayed() && homePage.isNavBarDisplayed(),
        "Home page is not displayed");
  }

  @Test(priority = 2)
  public void verifyOnSkillsButton() {
    skillsPage = homePage.waitForSkillsLink()
        .clickSkillsLink()
        .waitForSkillsLoaded();

    assertTrue(skillsPage.getCurrentUrl().contains(EXPECTED_URL),
        "Skills page URL does not contain expected value");
  }

  @Test(priority = 3)
  public void verifySkillsCard() {
    skillsPage.waitForSkillsLoaded()
        .waitForSearchInput()
        .typeSkill(SKILL)
        .validateSkillCard(SKILL)
        .clickOnSkillCard(SKILL)
        .waitForCoverToLoad();

    assertTrue(skillsPage.getCurrentUrl().contains(SKILL_URL),
        "Skill details page URL does not contain expected value");
  }
}
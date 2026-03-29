package epam.training.tests;

import epam.training.pages.HomePage;
import epam.training.pages.SkillsPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SkillSearchScenarioTest extends BaseTest {

  private static final String EXPECTED_URL = "skill";
  private static final String SKILL = ".NET";
  private static final String SKILL_URL = "NET";

  private HomePage homePage;
  private SkillsPage skillsPage;

  @Test(priority = 1)
  public void waitForPageToLoad() {
    homePage = new HomePage(driver).openPage();
    Assert.assertTrue(homePage.isLogoDisplayed() && homePage.isNavBarDisplayed(),
        "Home page is not displayed");
  }

  @Test(priority = 2)
  public void verifyOnSkillsButton() {
    skillsPage = homePage.waitForSkillsLink()
        .clickSkillsLink()
        .waitForSkillsLoaded();
    Assert.assertTrue(skillsPage.getCurrentUrl().contains(EXPECTED_URL));
  }

  @Test(priority = 3)
  public void verifySkillsCard() {
    skillsPage.waitForSkillsLoaded()
        .waitForSearchInput()
        .typeSkill(SKILL)
        .validateSkillCard(SKILL)
        .clickOnSkillCard(SKILL)
        .waitForCoverToLoad();
    Assert.assertTrue(skillsPage.getCurrentUrl().contains(SKILL_URL));
  }
}

package epam.training.stepdefinitions;

import epam.training.pages.HomePage;
import epam.training.pages.SkillsPage;
import epam.training.driver.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SkillsSteps {

  private static final String EXPECTED_SKILLS_URL_PART = "skill";

  private final WebDriver driver = DriverSingleton.getDriver();

  private HomePage homePage;
  private SkillsPage skillsPage;

  @Given("^the user opens the home page$")
  public void openHomePage() {
    homePage = new HomePage(driver).openPage();
  }

  @Given("^the home page is loaded$")
  public void verifyHomePageIsLoaded() {
    homePage.waitPageLoaded();

    Assert.assertTrue(
        homePage.isLogoDisplayed() && homePage.isNavBarDisplayed(),
        "Home page is not displayed"
    );
  }

  @Given("^the user navigates to the Skills page$")
  public void navigateToSkillsPage() {
    skillsPage = homePage
        .waitForSkillsLink()
        .clickSkillsLink()
        .waitForSkillsLoaded();

    Assert.assertTrue(
        skillsPage.getCurrentUrl().contains(EXPECTED_SKILLS_URL_PART),
        "Skills page URL does not contain expected part: " + EXPECTED_SKILLS_URL_PART
    );
  }

  @When("^the user searches for skill \"([^\"]*)\"$")
  public void searchForSkill(String skill) {
    skillsPage.waitForSkillsLoaded()
        .waitForSearchInput()
        .typeSkill(skill);
  }

  @Then("^the skill(?: card)? \"([^\"]*)\" should be displayed$")
  public void verifySkillCardIsDisplayed(String skill) {
    skillsPage.validateSkillCard(skill);
  }

  @When("^the user opens the skill card \"([^\"]*)\"$")
  public void openSkillCard(String skill) {
    skillsPage.clickOnSkillCard(skill)
        .waitForCoverToLoad();
  }

  @Then("^the opened skill page url should contain \"([^\"]*)\"$")
  public void verifyOpenedSkillPageUrl(String skillUrlPart) {
    Assert.assertTrue(
        skillsPage.getCurrentUrl().contains(skillUrlPart),
        "Opened skill page URL does not contain expected part: " + skillUrlPart
    );
  }
}
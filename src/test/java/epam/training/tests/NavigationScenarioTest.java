package epam.training.tests;

import epam.training.pages.HomePage;
import epam.training.pages.TrainingPage;
import org.testng.Assert;
import org.testng.annotations.Test;

public class NavigationScenarioTest extends BaseTest {

  private static final String EXPECTED_URL = "training";
  private static final String EXPECTED_HEADING = "Training programs";
  private static final String EXPECTED_TITLE = "Industry";
  private TrainingPage trainingPage;
  private HomePage homePage;

  @Test(priority = 1)
  public void verifyHomePage() {
    homePage = new HomePage(driver).openPage();
    Assert.assertTrue(homePage.isLogoDisplayed() && homePage.isNavBarDisplayed(),
        "Home page is not displayed");
  }

  @Test(priority = 2)
  public void verifyTrainingPageUrl() {
    trainingPage = homePage.clickTrainingLink();
    Assert.assertTrue(trainingPage.getCurrentUrl().contains(EXPECTED_URL),
        "Expected URL: " + EXPECTED_URL);
  }

  @Test(priority = 3)
  public void verifyTrainingHeading() {
    String heading = trainingPage.waitForContent().getHeadingText();
    Assert.assertEquals(heading, EXPECTED_HEADING, "Heading is not correct");
  }

  @Test(priority = 4)
  public void verifyNavigationBack() {
    HomePage returnedHome = trainingPage.navigateBackToHome().waitPageLoaded();
    Assert.assertTrue(returnedHome.getTitle().contains(EXPECTED_TITLE),
        "Should be back on homepage");
  }
}

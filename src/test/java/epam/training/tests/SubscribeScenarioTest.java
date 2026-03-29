package epam.training.tests;

import epam.training.pages.HomePage;
import epam.training.pages.SubscribePage;
import epam.training.pages.TrainingPage;
import epam.training.utils.CookieHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeScenarioTest extends BaseTest {

  private static final String EXPECTED_URL = "training";
  private static final String FIRST_NAME = "Firstname";
  private static final String LAST_NAME = "Lastname";
  private static final String EMAIL = "email@gmail.com";

  private HomePage homePage;
  private TrainingPage trainingPage;
  private SubscribePage subscribePage;

  @Test(priority = 1)
  public void waitHomePage() {
    homePage = new HomePage(driver).openPage();
    Assert.assertTrue(homePage.isLogoDisplayed() && homePage.isNavBarDisplayed(),
        "Home page is not displayed");
  }

  @Test(priority = 2)
  public void goToTrainingPage() {
    trainingPage = homePage.clickTrainingLink();
    Assert.assertTrue(trainingPage.getCurrentUrl().contains(EXPECTED_URL),
        "Expected URL: " + EXPECTED_URL);
  }

  @Test(priority = 3)
  public void verifySubscription() {
    subscribePage = trainingPage.clickSubscribeButton()
        .waitForSubscribeScreen();
    CookieHandler.acceptCookies(driver);

    subscribePage.typeFirstName(FIRST_NAME)
        .typeLastName(LAST_NAME)
        .clickCountryDropdown()
        .selectFirstCountry()
        .typeEmail(EMAIL)
        .clickSkillsDropdown()
        .selectFirstSkill()
        .clickSubscribeButton()
        .verifySuccessPopup();
  }
}

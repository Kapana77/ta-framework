package epam.training.tests;

import epam.training.bo.User;
import epam.training.pages.HomePage;
import epam.training.pages.SubscribePage;
import epam.training.pages.TrainingPage;
import epam.training.utils.ConfigReader;
import epam.training.utils.CookieHandler;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SubscribeScenarioTest extends BaseTest {

  private static final String EXPECTED_URL = ConfigReader.get("expected.training.url.part");
  private final User user = new User(
      ConfigReader.get("subscriber.firstName"),
      ConfigReader.get("subscriber.lastName"),
      ConfigReader.get("subscriber.email")
  );
  
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

    subscribePage.typeFirstName(user.getFirstName())
        .typeLastName(user.getLastName())
        .clickCountryDropdown()
        .selectFirstCountry()
        .typeEmail(user.getEmail())
        .clickSkillsDropdown()
        .selectFirstSkill()
        .clickSubscribeButton()
        .verifySuccessPopup();}
}

package epam.training.stepdefinitions;

import epam.training.pages.HomePage;
import epam.training.pages.SubscribePage;
import epam.training.pages.TrainingPage;
import epam.training.utils.ConfigReader;
import epam.training.utils.CookieHandler;
import epam.training.driver.DriverSingleton;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class SubscribeSteps {

  private static final String EXPECTED_TRAINING_URL_PART =
      ConfigReader.get("expected.training.url.part");

  private final WebDriver driver = DriverSingleton.getDriver();

  private HomePage homePage;
  private TrainingPage trainingPage;
  private SubscribePage subscribePage;

  @Given("^the visitor opens the home page$")
  public void openHomePage() {
    homePage = new HomePage(driver).openPage();
  }

  @Given("^the home page is displayed$")
  public void verifyHomePageIsLoaded() {
    homePage.waitPageLoaded();

    Assert.assertTrue(
        homePage.isLogoDisplayed() && homePage.isNavBarDisplayed(),
        "Home page is not displayed"
    );
  }

  @Given("^the user navigates to the Training page$")
  public void navigateToTrainingPage() {
    trainingPage = homePage.clickTrainingLink();

    Assert.assertTrue(
        trainingPage.getCurrentUrl().contains(EXPECTED_TRAINING_URL_PART),
        "Expected URL part was not found: " + EXPECTED_TRAINING_URL_PART
    );
  }

  @When("^the user opens the subscription form$")
  public void openSubscriptionForm() {
    subscribePage = trainingPage.clickSubscribeButton()
        .waitForSubscribeScreen();
  }

  @When("^the user accepts cookies$")
  public void acceptCookies() {
    CookieHandler.acceptCookies(driver);
  }

  @When("^the user fills the subscription form with first name \"([^\"]*)\", last name \"([^\"]*)\", and email \"([^\"]*)\"$")
  public void fillSubscriptionForm(String firstName, String lastName, String email) {
    subscribePage.typeFirstName(firstName)
        .typeLastName(lastName)
        .typeEmail(email);
  }

  @When("^the user selects the first country$")
  public void selectFirstCountry() {
    subscribePage.clickCountryDropdown()
        .selectFirstCountry();
  }

  @When("^the user selects the first skill$")
  public void selectFirstSkill() {
    subscribePage.clickSkillsDropdown()
        .selectFirstSkill();
  }

  @When("^the user submits the subscription form$")
  public void submitSubscriptionForm() {
    subscribePage.clickSubscribeButton();
  }

  @Then("^the subscription success popup should be displayed$")
  public void verifySubscriptionSuccessPopup() {
    subscribePage.verifySuccessPopup();
  }
}
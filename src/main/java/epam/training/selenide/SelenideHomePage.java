package epam.training.selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.Selenide.open;

import com.codeborne.selenide.SelenideElement;

public class SelenideHomePage {

  private static final String BASE_URL = "https://qa.training.epam.com";

  private final SelenideElement navBar = $("div[class*='nav-bar']");
  private final SelenideElement mainLogo = $("div.main-logo");
  private final SelenideElement skillsLink = $x("//div[@data-name='Skills']");

  public SelenideHomePage openPage() {
    open(BASE_URL);
    return this;
  }

  public boolean isLogoDisplayed() {
    return mainLogo.shouldBe(visible).isDisplayed();
  }

  public boolean isNavBarDisplayed() {
    return navBar.shouldBe(visible).isDisplayed();
  }

  public SelenideHomePage waitForSkillsLink() {
    skillsLink.shouldBe(visible);
    return this;
  }

  public SelenideSkillsPage clickSkillsLink() {
    skillsLink.shouldBe(visible).click();
    return new SelenideSkillsPage();
  }
}

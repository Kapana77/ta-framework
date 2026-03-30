package epam.training.selenide;

import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;
import static com.codeborne.selenide.WebDriverRunner.url;

import com.codeborne.selenide.SelenideElement;

public class SelenideSkillsPage {

  private final SelenideElement skillsContainer = $("div.skill-container");
  private final SelenideElement searchInput = $x("//input[@type='search']");
  private final SelenideElement skillCover = $x("//img[@alt='skill cover picture']");

  public SelenideSkillsPage waitForSkillsLoaded() {
    skillsContainer.shouldBe(visible);
    return this;
  }

  public SelenideSkillsPage waitForSearchInput() {
    searchInput.shouldBe(visible);
    return this;
  }

  public SelenideSkillsPage typeSkill(String skill) {
    searchInput.shouldBe(visible).setValue(skill);
    return this;
  }

  public SelenideSkillsPage validateSkillCard(String skill) {
    $x("//h3[text()='" + skill + "']").shouldBe(visible);
    return this;
  }

  public SelenideSkillsPage clickOnSkillCard(String skill) {
    $x("//h3[text()='" + skill + "']").shouldBe(visible).click();
    return this;
  }

  public SelenideSkillsPage waitForCoverToLoad() {
    skillCover.shouldBe(visible);
    return this;
  }

  public String getCurrentUrl() {
    return url();
  }
}
package epam.training.driver.decorator;

import java.util.List;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class WebDriverDecorator implements WebDriver, TakesScreenshot, JavascriptExecutor {

  protected final WebDriver wrappedDriver;

  public WebDriverDecorator(WebDriver driver) {
    this.wrappedDriver = driver;
  }

  @Override public void get(String url)                  { wrappedDriver.get(url); }
  @Override public String getCurrentUrl()                { return wrappedDriver.getCurrentUrl(); }
  @Override public String getTitle()                     { return wrappedDriver.getTitle(); }
  @Override public List<WebElement> findElements(By by)  { return wrappedDriver.findElements(by); }
  @Override public WebElement findElement(By by)         { return wrappedDriver.findElement(by); }
  @Override public String getPageSource()                { return wrappedDriver.getPageSource(); }
  @Override public void close()                          { wrappedDriver.close(); }
  @Override public void quit()                           { wrappedDriver.quit(); }
  @Override public Set<String> getWindowHandles()        { return wrappedDriver.getWindowHandles(); }
  @Override public String getWindowHandle()              { return wrappedDriver.getWindowHandle(); }
  @Override public TargetLocator switchTo()              { return wrappedDriver.switchTo(); }
  @Override public Navigation navigate()                 { return wrappedDriver.navigate(); }
  @Override public Options manage()                      { return wrappedDriver.manage(); }

  @Override
  public <X> X getScreenshotAs(OutputType<X> target) {
    return ((TakesScreenshot) wrappedDriver).getScreenshotAs(target);
  }

  @Override
  public Object executeScript(String script, Object... args) {
    return ((JavascriptExecutor) wrappedDriver).executeScript(script, args);
  }

  @Override
  public Object executeAsyncScript(String script, Object... args) {
    return ((JavascriptExecutor) wrappedDriver).executeAsyncScript(script, args);
  }

}

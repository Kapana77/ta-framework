package epam.training.listeners;

import epam.training.tests.BaseTest;
import epam.training.utils.ScreenshotUtil;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class TestListener implements ITestListener {

  private static final Logger logger = LogManager.getLogger(TestListener.class);

  @Override
  public void onTestStart(ITestResult result) {
    logger.info("starting test: {}", result.getMethod().getMethodName());
  }

  @Override
  public void onTestSuccess(ITestResult result) {
    logger.info("test passed: {}", result.getMethod().getMethodName());
  }

  @Override
  public void onTestFailure(ITestResult result) {
    logger.error("Test failed: {}", result.getMethod().getMethodName());
    logger.error("Failure reason: {}", result.getThrowable() != null
        ? result.getThrowable().getMessage()
        : "Unknown error");

    Object currentClass = result.getInstance();

    if (currentClass instanceof BaseTest baseTest) {
      String screenshotPath = ScreenshotUtil.takeScreenshot(baseTest.getDriver(),
          result.getMethod().getMethodName());

      if (screenshotPath != null) {
        logger.error("Screenshot captured for failed test '{}': {}",
            result.getMethod().getMethodName(), screenshotPath);
      } else {
        logger.error("Screenshot could not be captured for failed test '{}'",
            result.getMethod().getMethodName());
      }
    }
  }

  @Override
  public void onTestSkipped(ITestResult result) {
    logger.warn("test skipped: {}", result.getMethod().getMethodName());
  }
}

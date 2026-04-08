package epam.training.listeners;

import com.epam.reportportal.service.ReportPortal;
import com.epam.reportportal.testng.ReportPortalTestNGListener;
import epam.training.tests.BaseTest;
import epam.training.utils.ScreenshotUtil;
import java.io.File;
import java.util.Date;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.bidi.log.LogLevel;
import org.testng.ITestResult;

public class ReportPortalListener extends ReportPortalTestNGListener {

  private static final Logger logger = LogManager.getLogger(ReportPortalListener.class);

  @Override
  public void onTestFailure(ITestResult result) {
    logger.error("Test failed: {}", result.getMethod().getMethodName());
    logger.error("Failure reason: {}", result.getThrowable() != null
        ? result.getThrowable().getMessage()
        : "Unknown error");

    Object currentClass = result.getInstance();

    if (currentClass instanceof BaseTest baseTest) {
      String screenshotPath = ScreenshotUtil.takeScreenshot(
          baseTest.getDriver(),
          result.getMethod().getMethodName()
      );

      if (screenshotPath != null) {
        logger.error("Screenshot captured for failed test '{}': {}",
            result.getMethod().getMethodName(), screenshotPath);

        File screenshotFile = new File(screenshotPath);

        ReportPortal.emitLog(
            "Screenshot on Failure",
            LogLevel.ERROR.name(), 
            new Date(),
            screenshotFile
        );
      } else {
        logger.error("Screenshot could not be captured for failed test '{}'",
            result.getMethod().getMethodName());
      }
    }

    super.onTestFailure(result);
  }

}

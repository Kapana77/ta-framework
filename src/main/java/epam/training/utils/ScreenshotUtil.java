package epam.training.utils;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

public class ScreenshotUtil {

  private static final Logger logger = LogManager.getLogger(ScreenshotUtil.class);

  private static final String SCREENSHOT_DIR = "screenshots";
  private static final DateTimeFormatter DATE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd");
  private static final DateTimeFormatter FILE_FORMAT = DateTimeFormatter.ofPattern("yyyy-MM-dd_HH-mm-ss");

  public static String takeScreenshot(WebDriver driver, String testName) {
    if (driver == null) {
      logger.error("Cannot take screenshot because WebDriver is null");
      return null;
    }

    try {
      String currentDate = LocalDate.now().format(DATE_FORMAT);
      String timestamp = LocalDateTime.now().format(FILE_FORMAT);

      Path folderPath = Paths.get(SCREENSHOT_DIR, currentDate);
      Files.createDirectories(folderPath);

      String fileName = testName + "_" + timestamp + ".png";
      Path destination = folderPath.resolve(fileName);

      File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
      Files.copy(sourceFile.toPath(), destination);

      logger.info("Screenshot saved: {}", destination.toAbsolutePath());
      return destination.toAbsolutePath().toString();

    } catch (IOException e) {
      logger.error("Failed to save screenshot for test: {}", testName, e);
      return null;
    }
  }
}
package epam.training.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {

  private static final Properties properties = new Properties();

  static {
    String env = System.getProperty("env", "qa");
    String fileName = env + ".properties";

    try (InputStream input = ConfigReader.class.getClassLoader().getResourceAsStream(fileName)) {
      if (input == null) {
        throw new RuntimeException("Configuration file not found: " + fileName);
      }
      properties.load(input);
    } catch (Exception e) {
      throw new RuntimeException("Failed to load configuration file: " + fileName, e);
    }
  }

  public static String get(String key) {
    String value = properties.getProperty(key);
    if (value == null) {
      throw new RuntimeException("Property not found: " + key);
    }
    return value;
  }
}
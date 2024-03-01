package base;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;

public class Base {

    public static WebDriver driver;
    ChromeOptions options = new ChromeOptions();

    public static WebDriver setUp(String browserType) {
        if (driver == null) {
            switch (browserType) {
                case "chrome" -> {
                    ChromeOptions options = new ChromeOptions();
                    options.addArguments("--disable-notifications");
                    WebDriverManager.chromedriver().setup();
                    driver = new ChromeDriver(options);
                    driver.manage().window().maximize();
                }
                case "edge" -> {
                    EdgeOptions options = new EdgeOptions();
                    options.addArguments("--disable-notifications");
                    WebDriverManager.edgedriver().setup();
                    driver = new EdgeDriver(options);
                    driver.manage().window().maximize();
                }
                case "firefox" -> {
                    WebDriverManager.firefoxdriver().setup();
                    driver = new FirefoxDriver();
                    driver.manage().window().maximize();
                }
                case "safari" -> {
                    WebDriverManager.safaridriver().setup();
                    driver = new SafariDriver();
                    driver.manage().window().maximize();
                }
                default -> {
                    WebDriverManager.iedriver().setup();
                    driver = new InternetExplorerDriver();
                    driver.manage().window().maximize();
                }
            }
        }
        return driver;
    }

    public static void tearDown() {
        if (driver != null) {
            driver.close();
            driver.quit();
            driver = null;
        }
    }

}

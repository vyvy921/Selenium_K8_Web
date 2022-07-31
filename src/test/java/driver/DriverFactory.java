package driver;

import org.apache.commons.exec.OS;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.time.Duration;

public class DriverFactory {

    public static WebDriver getChromeDriver() {

        String currentProjectLocation = System.getProperty("user.dir");
        String chromeDriverLocation = "";

        if (OS.isFamilyMac()) {
            chromeDriverLocation = currentProjectLocation + "/src/test/resources/chromedriver";
        }

        if (OS.isFamilyWindows()) {
            chromeDriverLocation = currentProjectLocation + "\\src\\test\\resources\\chromedriver.exe";
        }

        if (chromeDriverLocation.isEmpty()) {
            throw new IllegalArgumentException("Can't detect OS type");
        }

        System.setProperty("webdriver.chrome.driver", chromeDriverLocation);

        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--incognito");

        WebDriver driver = new ChromeDriver(chromeOptions);

        // Intercal time | 500 mili seconds = 0.5s
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

        return driver;

    }

}

package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class FormInteractionMultipleMatching {

    public static void main(String[] args) {

        //Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define selector values
            By loginInputFieldsSel = By.tagName("input");

            // Find elements

            // Interaction
            List<WebElement> loginFormFieldElem = driver.findElements(loginInputFieldsSel);
            final int USERNAME_INDEX = 0;
            final int PASSWORD_INDEX = 1;

            if (!loginFormFieldElem.isEmpty()) {
                loginFormFieldElem.get(USERNAME_INDEX).sendKeys("abc@");
                loginFormFieldElem.get(PASSWORD_INDEX).sendKeys("123456");
            } else {
//                Assert.fail("reason");
            }

            //DEBUG PURPOSE ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //quit the browser session
        driver.quit();

    }
}
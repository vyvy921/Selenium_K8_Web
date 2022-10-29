package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class FormInteraction {

    public static void main(String[] args) {

        //Get a chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to the target page
            driver.get("https://the-internet.herokuapp.com/login");

            // Define selector values
            By usernameSel = By.id("username");
            By passwordSel = By.cssSelector("#password");
            By loginBtnSel = By.cssSelector("[type='submit']");

            // Find elements
            WebElement usernameElem = driver.findElement(usernameSel);
            WebElement passwordElem = driver.findElement(passwordSel);
            WebElement loginElem = driver.findElement(loginBtnSel);

            //Get attribute value

            // Interaction
//          usernameElem.clear();
            usernameElem.sendKeys("tomsmith");
            passwordElem.sendKeys("SuperSecretPassword!");
            loginElem.click();

            // Go back to previous page
            driver.navigate().back();

            // Refresh page
            driver.navigate().refresh();

            // Re-interact with the element again

            usernameElem = driver.findElement(usernameSel);
            passwordElem = driver.findElement(passwordSel);
            loginElem = driver.findElement(loginBtnSel);

            usernameElem.sendKeys("taolaotumlum");
            passwordElem.sendKeys("1234");
            loginElem.click();

            //DEBUG PURPOSE ONLY
            Thread.sleep(2000);
        } catch (Exception e) {
            e.printStackTrace();
        }

        //quit the browser session
        driver.quit();

    }
}
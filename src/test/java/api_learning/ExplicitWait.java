package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import support.ui.WaitMoreThanOneTab;
import url.Urls;

import java.time.Duration;

public class ExplicitWait {

    public static void main(String[] args) {

        //Get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //Navigate to target page
            driver.get(Urls.baseUrl.concat(Urls.loginSlug));

            // Dropdown locator & element
            By taoLaoSel = By.cssSelector("#teo");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            wait.until(ExpectedConditions.visibilityOfElementLocated(taoLaoSel));
            //wait.until(ExpectedConditions.visibilityOf(driver.findElement(taoLaoSel)));
            //=> parameter duoc thuc thi implicitwait truoc

            //windows/tabs ---> wait until > 1
            wait.until(new WaitMoreThanOneTab());

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}

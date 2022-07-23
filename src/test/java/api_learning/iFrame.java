package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import url.Urls;

public class iFrame implements Urls {
    public static void main(String[] args) {

        //Get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            //Navigate to target page
            driver.get(baseUrl.concat(hoverSlug));

            //locate the iframe
            By iFrameSel = By.cssSelector("[id$='ifr']");
            WebElement iFrameElem = driver.findElement(iFrameSel);

            //Switch to the iframe
            driver.switchTo().frame(iFrameElem);
            driver.findElement(By.cssSelector("#tinymce p")).sendKeys("New texts");

            // Locate element inside the iframe
            WebElement editorInputElem = driver.findElement(By.id(("tinymce")));
            editorInputElem.click();
            editorInputElem.clear();
            editorInputElem.sendKeys("input texttttttttt...");
            Thread.sleep(1000);

            // Switch back parent frame
            driver.switchTo().defaultContent();
            driver.findElement(By.linkText("Elemental Selenium")).click();
            Thread.sleep(1000);


        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}

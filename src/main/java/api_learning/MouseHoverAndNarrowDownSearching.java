package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import url.Urls;

import java.util.List;

public class MouseHoverAndNarrowDownSearching implements Urls {

    // Declare selectors
    private final static By figureSel = By.className("figure");
    private final static By profileNameSel = By.cssSelector(".figcaption h5");
    private final static By profileLinkSel = By.cssSelector(".figcaption a");

    public static void main(String[] args) {

        //Get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get(baseUrl.concat(hoverSlug));

            // Normal finding element
//            List<WebElement> figcaptionNamesElem = driver.findElements(By.cssSelector(".figcaption h5"));
//            List<WebElement> figcaptionHrefsElem = driver.findElements(By.cssSelector(".figcaption a"));

            // Target parent elements
            List<WebElement> figuresElems = driver.findElements(figureSel);
            if (figuresElems.isEmpty())
                throw new RuntimeException("There is no profile image to display");

            // Define actions object
            Actions actions = new Actions(driver);


            for (WebElement figuresElem : figuresElems) {
                WebElement profileNameElem = figuresElem.findElement(profileNameSel);
                WebElement profileLinkElem = figuresElem.findElement(profileLinkSel);

                //Before Mouse hover
                System.out.println(profileNameElem.getText() + ": " + profileNameElem.isDisplayed());
                System.out.println(profileLinkElem.getText() + ": " + profileLinkElem.isDisplayed());

                // Mouse hover
                actions.moveToElement(figuresElem).perform();

                // After Mouse hover
                System.out.println(profileNameElem.getText() + ": " + profileNameElem.isDisplayed());
                System.out.println(profileLinkElem.getText() + ": " + profileLinkElem.isDisplayed());

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }
}

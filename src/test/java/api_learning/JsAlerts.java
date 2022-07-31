package api_learning;

import driver.DriverFactory;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import url.Urls;

import java.time.Duration;

public class JsAlerts implements Urls {

    private final static By jsAlertSel = By.cssSelector("[onclick=\"jsAlert()\"]");
    private final static By jsAlertConfirmSel = By.cssSelector("[onclick=\"jsConfirm()\"]");
    private final static By jsAlertPromptSel = By.cssSelector("[onclick=\"jsPrompt()\"]");
    private final static By resultSel = By.id("result");

    public static void main(String[] args) {

        //Get chrome session
        WebDriver driver = DriverFactory.getChromeDriver();

        try {
            // Navigate to target page
            driver.get(baseUrl.concat(jsArlertSlug));
//            WebElement triggerJsAlerBtnElem;
//            Alert alert;
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));


            // JS_ALERT | Ok
//            triggerJsAlerBtnElem = driver.findElement(jsAlertSel);
//            triggerJsAlerBtnElem.click();
//            alert = wait.until(ExpectedConditions.alertIsPresent());
//            System.out.println("Alert Content: " + alert.getText());
//            alert.accept();
            handleAlert(driver, jsAlertSel, true);
            System.out.println("Result: " + driver.findElement(resultSel).getText());

            // JS_CONFIRM | Cancel
//            triggerJsAlerBtnElem = driver.findElement(jsAlertConfirmSel);
//            triggerJsAlerBtnElem.click();
//            alert = wait.until(ExpectedConditions.alertIsPresent());
//            System.out.println("Alert Content: " + alert.getText());
//
            handleAlert(driver, jsAlertConfirmSel, false);
            System.out.println("Result: " + driver.findElement(resultSel).getText());


            // JS_PROMPT
//            triggerJsAlerBtnElem = driver.findElement(jsAlertPromptSel);
//            triggerJsAlerBtnElem.click();
//            alert = wait.until(ExpectedConditions.alertIsPresent());
//            System.out.println("Alert Content: " + alert.getText());
//            alert.dismiss();
            handleAlert(driver, jsAlertPromptSel, "My name is teoooo");
            System.out.println("Result: " + driver.findElement(resultSel).getText());

        } catch (Exception e) {
            e.printStackTrace();
        }

        driver.quit();

    }

    public static void handleAlert(WebDriver driver, By triggerAlertSel, boolean isAccepting) {

//        WebElement triggerJsAlerBtnElem = driver.findElement(triggerAlertSel);
        Alert alert = getAlert(driver, triggerAlertSel);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        triggerJsAlerBtnElem.click();
//        alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Content: " + alert.getText());
        if (isAccepting) alert.accept();
        else alert.dismiss();
    }

    //service method
    public static void handleAlert(WebDriver driver, By triggerAlertSel, String contentToEnter) {
//        WebElement triggerJsAlerBtnElem = driver.findElement(triggerAlertSel);
        Alert alert = getAlert(driver, triggerAlertSel);
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
//        triggerJsAlerBtnElem.click();
//        alert = wait.until(ExpectedConditions.alertIsPresent());
        System.out.println("Alert Content: " + alert.getText());
        alert.sendKeys(contentToEnter);
        alert.accept();

    }

    //support method
    private static Alert getAlert(WebDriver driver, By triggerAlertSel) {
        WebElement triggerJsAlerBtnElem = driver.findElement(triggerAlertSel);
        Alert alert;
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(3));
        triggerJsAlerBtnElem.click();
        return wait.until(ExpectedConditions.alertIsPresent());


    }
}

package test.global.footer;

import driver.DriverFactory;
import models.components.global.footer.FooterColumnComponent;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import test_flows.global.FooterTestFlow;
import url.Urls;

public class FooterTest {

    @Test
    public void testFooterHomePage() {
    }

    @Test
    public void testFooterCategoryPage() {
        WebDriver driver = DriverFactory.getChromeDriver();
        try {
            driver.get(Urls.demoBaseUrl);
            FooterTestFlow footerTestFlow = new FooterTestFlow(driver);
            footerTestFlow.verifyProductCatFooterComponent();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }

    @Test
    public void testFooterRegisterPage() {
    }

    @Test
    public void testFooterLoginPage() {
    }

    private static void testFooterColumn(FooterColumnComponent footerColumnComponent) {
    }

}

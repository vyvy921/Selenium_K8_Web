package test.computer;

import models.components.order.StandardComputerComponent;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import test.BaseTest;
import test_data.DataObjectBuilder;
import test_data.computer.ComputerData;
import test_flows.computer.OrderComputerFlow;
import url.Urls;

public class BuyingStandardComputerTest extends BaseTest implements Urls {

    @Test(dataProvider = "computerData")
    public void testStandardComputerBuying(ComputerData computerData) {
        driver.get(demoBaseUrl.concat("/build-your-own-computer"));
        OrderComputerFlow<StandardComputerComponent> orderComputerFlow =
                new OrderComputerFlow<>(driver, StandardComputerComponent.class, computerData);

        orderComputerFlow.buildCompSpecAndAddToCart();
        orderComputerFlow.verifyShoppingCartPage();
    }

    @DataProvider
    public ComputerData[] computerData() {
        String fileLocation = "/src/test/java/test_data/computer/StandardComputerDataList.json";
        return DataObjectBuilder.buildDataObjectFrom(fileLocation, ComputerData[].class);
    }
}
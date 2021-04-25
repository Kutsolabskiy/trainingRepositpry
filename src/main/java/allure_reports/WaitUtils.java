package allure_reports;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class WaitUtils {

    public static WebElement waitUntilClickable(WebElement element) {
        WebDriverWait waiter = new WebDriverWait(DriverProvider.getDriver(), 15);
        waiter.until(ExpectedConditions.elementToBeClickable(element));
        return element;
    }

    public static void waitUntilValueWillProvided (WebElement element, String expectedValue) {
        WebDriverWait waiter = new WebDriverWait(DriverProvider.getDriver(), 15);
        waiter.until(ExpectedConditions.attributeContains(element, "value", expectedValue));
    }
}

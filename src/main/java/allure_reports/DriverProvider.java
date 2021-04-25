package allure_reports;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class DriverProvider {
    private static ThreadLocal<WebDriver> localDriver = new ThreadLocal<>();

    public WebDriver initializeDriver() {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        localDriver.set(driver);
        return driver;
    }

    public static synchronized WebDriver getDriver() {
        return localDriver.get();
    }
}

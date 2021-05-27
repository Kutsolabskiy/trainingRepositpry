package allure_reports;

import io.qameta.allure.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

@Listeners({AllureListener.class})
public class Tests{

    private WebDriver driver;

    @BeforeClass
    public void setup(){
        DriverProvider driverProvider = new DriverProvider();
        driver = driverProvider.initializeDriver();
        driver.get("https://demo.nopcommerce.com/");
    }

    @Test(priority = 1, description = "Verify Logo presence on Home Page")
    @Description("Verify Logo presence on Home Page........")
    @Epic("EP001")
    @Feature("Feature 1: Logo")
    @Story("Story: Logo Presence")
    @Step("Verify Logo presence")
    @Severity(SeverityLevel.MINOR)
    public void logoPresence() {
        boolean isStatus = driver.findElement(By.xpath("//div[@class =\"header-logo\"]//a//img")).isDisplayed();
        Assert.assertTrue(isStatus);
    }

 //   @Test(priority = 2)
    @Description("Verify Login........")
    @Epic("EP001")
    @Feature("Feature 1: Login")
    @Story("Story: Valid Login")
    @Step("Verify login")
    @Severity(SeverityLevel.BLOCKER)
    public void loginTest() throws InterruptedException {
        WebElement loginButton = driver.findElement(By.xpath("//div[@class =\"header-links\"]//li/a[@class = 'ico-login']"));
        WaitUtils.waitUntilClickable(loginButton).click();

        Thread.sleep(1000);

        WebElement LoginPageHeader = driver.findElement(By.xpath("//div[@class = \"form-fields\"]"));
        WaitUtils.waitUntilClickable(LoginPageHeader);

        WebElement emailInput = driver.findElement(By.xpath("//div[@class =\"inputs\"]/input[@class = \"email\"]"));
        String email = "pavanoltraining@gmail.com";
        WaitUtils.waitUntilClickable(emailInput).sendKeys(email);
        WaitUtils.waitUntilValueWillProvided(emailInput, email);


        WebElement passwordInput = driver.findElement(By.xpath("//div[@class =\"inputs\"]/input[@class = \"password\"]"));
        String password = "Test@123";
        WaitUtils.waitUntilClickable(passwordInput).sendKeys(password);
        WaitUtils.waitUntilValueWillProvided(passwordInput, password);


        WebElement submitButton = driver.findElement(By.xpath("//div[@class =\"buttons\"]/button[@type= \"submit\"]"));
        WaitUtils.waitUntilClickable(submitButton).click();

        Assert.assertEquals(driver.getTitle(), "Success log in");
    }

  //  @Test(priority = 3)
    @Description("Verify Login........")
    @Epic("EP001")
    @Feature("Feature 1: Login")
    @Story("Story: Valid Login")
    @Step("Verify login")
    @Severity(SeverityLevel.NORMAL)
    public void registrationTest() {
        throw new SkipException("Skipping this test");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();

    }

}

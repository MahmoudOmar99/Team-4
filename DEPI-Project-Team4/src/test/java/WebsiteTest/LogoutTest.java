package WebsiteTest;

import Pages.DashboardPage;
import Pages.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.Assert;

import java.time.Duration;

public class LogoutTest {
    WebDriver driver;
    LoginPage loginPage;
    DashboardPage dashboardPage;

    @BeforeMethod
    public void setup() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        dashboardPage = new DashboardPage(driver);
    }

    @Test
    public void userCanLogoutSuccessfully() {
        loginPage.login("Admin", "admin123");
        dashboardPage.logout();

        // Check if redirected to login page
        boolean loginBoxPresent = driver.findElement(By.name("username")).isDisplayed();
        Assert.assertTrue(loginBoxPresent, "Logout failed. Username field not visible.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}

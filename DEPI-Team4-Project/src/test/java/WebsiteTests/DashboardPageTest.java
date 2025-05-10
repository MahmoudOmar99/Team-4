package WebsiteTests;

import Pages.DashboardPage;
import Pages.LoginPage;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.time.Duration;

public class DashboardPageTest extends BaseTest{
    LoginPage loginPage ;
    DashboardPage dashboardPage;
    @Test
    public void loginTest(){
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        dashboardPage = loginPage.clickLoginBtn(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("dashboard/index"));

        String currentUrl = driver.getCurrentUrl();
        assert currentUrl != null;
        Assert.assertTrue(currentUrl.contains("dashboard/index"),
                "Login failed. Current URL: " + currentUrl);
    }

  @Test(dependsOnMethods ="loginTest")
    public void logoutTest(){

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.titleIs("OrangeHRM"));

        // Perform logout
        dashboardPage.clickOnLogoutBtn(driver);

        // Wait for login page to load
        wait.until(ExpectedConditions.urlContains("auth/login"));

        // Verify logout was successful
        String loginHeader = loginPage.getLoginHeaderText();
        Assert.assertTrue(loginHeader.contains("Login"),
                "Logout failed. Page header: " + loginHeader);


    }
}

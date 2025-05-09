package WebsiteTest;


import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.*;
import org.testng.annotations.*;
import Pages.DashboardPage;
import Pages.LoginPage;

import java.time.Duration;

public class LoginTest extends BaseTest {
    LoginPage loginPage;
    DashboardPage DashboardPage;

    @Test
    public void loginTest(){
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admin");
        loginPage.typePassword("admin123");
        DashboardPage = loginPage.clickLoginBtn(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.urlContains("https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index"));

        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index","You have not logged in!");

    }
    @Test
    public void invalidLoginTest(){
        loginPage = new LoginPage(driver);
        loginPage.typeUsername("Admi");
        loginPage.typePassword("admin123");
        DashboardPage = loginPage.clickLoginBtn(driver);


        Assert.assertEquals(driver.getCurrentUrl(),"https://opensource-demo.orangehrmlive.com/web/index.php/auth/login","You have not been blocked!");
        Assert.assertTrue(loginPage.getLoginHeaderText().contains("Login"),"You have not been blocked! 2");


    }



}















//package WebsiteTest;
//import org.testng.annotations.*;
//import Pages.LoginPage;
//public class LoginTest extends BaseTest {
//    @Test
//    public void TestLoginSuccess() {
//        LoginPage loginPage = new LoginPage(driver);
//        loginPage.login("Admin", "admin123");
//        Assert.assertTrue(driver.getCurrentUrl().contains("/dashboard"), "Login failed!");
//    }
//
//}

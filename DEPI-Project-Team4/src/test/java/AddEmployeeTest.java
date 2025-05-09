package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import pages.LoginPage;
import pages.PIMPage;

public class AddEmployeeTest {
    WebDriver driver;
    LoginPage loginPage;
    PIMPage pimPage;

    @BeforeMethod
    public void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://opensource-demo.orangehrmlive.com/");
        loginPage = new LoginPage(driver);
        pimPage = new PIMPage(driver);
    }

    @Test
    public void addEmployeeTest() {
        loginPage.login("Admin", "admin123");
        pimPage.goToPIM();
        pimPage.addEmployee("Test", "User");

        // Simple verification - check if Personal Details form appears
        boolean isFormPresent = driver.findElement(By.xpath("//h6[text()='Personal Details']")).isDisplayed();
        Assert.assertTrue(isFormPresent, "Employee not added successfully.");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}


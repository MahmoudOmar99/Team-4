package WebsiteTests;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import Pages.LoginPage;
import Pages.DashboardPage;
import Pages.PIMPage;
import org.testng.Assert;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;
import java.time.Duration;

public class AddEmployeeTest extends BaseTest {

    @Test
    public void testAddEmployee() {
        LoginPage login = new LoginPage(driver);
        login.typeUsername("Admin");
        login.typePassword("admin123");
        DashboardPage dashboard = login.clickLoginBtn(driver);


        dashboard.clickOnPimBtn();
        PIMPage pim = new PIMPage(driver);

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       wait.until(ExpectedConditions.elementToBeClickable(pim.addEmployeeButton));

        pim.clickAddEmployee();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='firstName']")));
        pim.enterFirstName("John");
        pim.enterMiddleName("Test");
        pim.enterLastName("Doe");
        pim.clickSave();
        
    }
}


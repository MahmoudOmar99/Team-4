package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class DashboardPage {
    //WebDriver of the page
    WebDriver HomeDriver;
    WebDriverWait wait;
    //Locators
    By personalSubMenu = By.className("oxd-userdropdown-tab");
    By logoutBtnLocator = By.xpath("//a[@href='/web/index.php/auth/logout']");
    By pimBtnLocator = By.xpath("//span[text()='PIM']");

    //Constructor
    public DashboardPage(WebDriver driver) {
        HomeDriver = driver;
    }


    //actions on the page
    public void clickOnLogoutBtn(WebDriver driver) {
        wait = new WebDriverWait(HomeDriver, Duration.ofSeconds(10));
        WebElement tempPersonalMenu = wait.until(ExpectedConditions.visibilityOfElementLocated(personalSubMenu));
        tempPersonalMenu.click();

        WebElement templogoutBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(logoutBtnLocator));
        templogoutBtn.click();

        new LoginPage(driver);
    }

    // click on pim
    public DashboardPage clickOnPimBtn(){
        wait = new WebDriverWait(HomeDriver, Duration.ofSeconds(10));
        WebElement tempPimBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(pimBtnLocator));
        tempPimBtn.click();

        return this;
    }


    By dashboardHeader = By.xpath("//h6[text()='Dashboard']");

    public boolean isDashboardDisplayed() {
        return HomeDriver.findElement(dashboardHeader).isDisplayed();
    }

}

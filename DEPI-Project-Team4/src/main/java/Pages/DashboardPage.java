package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class DashboardPage {
    WebDriver driver;

    public DashboardPage(WebDriver driver) {
        this.driver = driver;
    }

    By profileMenu = By.cssSelector(".oxd-userdropdown-name");
    By logoutLink = By.xpath("//a[text()='Logout']");

    public void logout() {
        driver.findElement(profileMenu).click();
        driver.findElement(logoutLink).click();
    }
}


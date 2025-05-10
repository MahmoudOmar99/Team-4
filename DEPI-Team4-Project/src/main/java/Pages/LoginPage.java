package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class LoginPage {
    WebDriver loginDriver;


    //Locators
    By usernameField = By.name("username");
    By passwordField = By.name("password");
    By loginButton = By.cssSelector("button[type='submit']");
    By loginHeaderLocator = By.tagName("h5");

    //constructor
    public LoginPage(WebDriver driver){
        loginDriver = driver;
    }

    //actions on the page
    public void typeUsername(String username){
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));
        WebElement tempUsername = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        tempUsername.sendKeys(username);
    }

    public void typePassword(String password){
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));
        WebElement tempPassword = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        tempPassword.sendKeys(password);
    }

    public DashboardPage clickLoginBtn(WebDriver driver){
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));
        WebElement tempLoginBtnClick = wait.until(ExpectedConditions.visibilityOfElementLocated(loginButton));
        tempLoginBtnClick.click();
        return new DashboardPage(driver);
    }
    public String getLoginHeaderText(){
        WebDriverWait wait = new WebDriverWait(loginDriver, Duration.ofSeconds(10));
        WebElement tempLoginHeader = wait.until(ExpectedConditions.visibilityOfElementLocated(loginHeaderLocator));
        return tempLoginHeader.getText();
    }
}

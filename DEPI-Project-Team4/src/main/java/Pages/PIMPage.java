package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class PIMPage {
    WebDriver driver;

    public PIMPage(WebDriver driver) {
        this.driver = driver;
    }

    private By pimMenu = By.xpath("//span[text()='PIM']");
    private By addButton = By.xpath("//button[text()=' Add ']");
    private By firstNameField = By.name("firstName");
    private By lastNameField = By.name("lastName");
    private By saveButton = By.xpath("//button[@type='submit']");

    public void goToPIM() {
        driver.findElement(pimMenu).click();
    }

    public void addEmployee(String firstName, String lastName) {
        driver.findElement(addButton).click();
        driver.findElement(firstNameField).sendKeys(firstName);
        driver.findElement(lastNameField).sendKeys(lastName);
        driver.findElement(saveButton).click();
    }
}


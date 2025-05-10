package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

    public class PIMPage {

        WebDriver driver;

        public PIMPage(WebDriver driver) {
            this.driver = driver;
        }

       public By addEmployeeButton = By.xpath("//button[text()=' Add ']"); // adjust if needed
        By firstNameField = By.name("firstName");
        By middleNameField = By.name("middleName");
        By lastNameField = By.name("lastName");
        By saveButton = By.xpath("//button[@type='submit']");

        public void clickAddEmployee() {
            driver.findElement(addEmployeeButton).click();
        }

        public void enterFirstName(String firstName) {
            driver.findElement(firstNameField).sendKeys(firstName);
        }

        public void enterMiddleName(String middleName) {
            driver.findElement(middleNameField).sendKeys(middleName);
        }

        public void enterLastName(String lastName) {
            driver.findElement(lastNameField).sendKeys(lastName);
        }

        public void clickSave() {
            driver.findElement(saveButton).click();
        }
    }



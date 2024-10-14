package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginInvoice {

    private WebDriver driver;

    private By usernameField = By.id("email");
    private By passwordField = By.id("password");
    private By loginButton = By.xpath("//button[normalize-space()='Login']");

    public LoginInvoice(WebDriver driver) {
        this.driver = driver;
    }
    public void enterUsername(String username) {
        driver.findElement(usernameField).sendKeys(username);
    }

    public void enterPassword(String password) {
        driver.findElement(passwordField).sendKeys(password);
    }

    public void clickLoginButton() {
        driver.findElement(loginButton).click();
    }

    public DashboardInvoice login(String username, String password){
        enterUsername(username);
        enterPassword(password);
        clickLoginButton();
        return new DashboardInvoice(driver);
    }
}

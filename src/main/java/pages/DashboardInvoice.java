package pages;

import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.util.List;

public class DashboardInvoice extends Util {

    private WebDriver driver;
    private By MenuClassName=By.className("hidden-md");

    private By subMenuName=By.xpath("//a[normalize-space()='Add Client']");

    public DashboardInvoice(WebDriver driver) {
        this.driver = driver;
    }

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getSubMenu(){
       return driver.findElement(subMenuName).getText();
    }

    // Method to interact with main menu items
    public DashboardInvoice Menu(String expected) throws IOException {

    // Find all elements with the specified class name
    List<WebElement> menus = driver.findElements(MenuClassName);

    // Iterate over the menus
    for (WebElement menu : menus) {
        String MenuName = menu.getText();
        System.out.println(MenuName);

        // Use equals() for string comparison
        if (expected.equals(MenuName)) {
            // Click the menu if it matches the expected value
            menu.click();
            break;  // Exit the loop after clicking the expected menu
        }
    }
        return new DashboardInvoice(driver);
    }

}

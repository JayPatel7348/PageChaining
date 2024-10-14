package testInvoice;

import Utilities.ConfigReader;
import Utilities.Util;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardInvoice;
import pages.LoginInvoice;

public class Testlogin extends Util {

    ChromeDriver driver;
    String baseUrl = ConfigReader.getProperty("baseUrl");
    String userName=ConfigReader.getProperty("username");
    String passWord=ConfigReader.getProperty("password");
    String pageTitle=ConfigReader.getProperty("pageTitle");

    @BeforeMethod
    public void browserLaunch() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseUrl);

    }
    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test
    public void loginTest() {
        LoginInvoice lgn=new LoginInvoice(driver);
        DashboardInvoice dashboard=lgn.login(userName,passWord);
       // expliWait(driver,"Dashboard");
        Assert.assertEquals(dashboard.getPageTitle(),pageTitle);
    }
}

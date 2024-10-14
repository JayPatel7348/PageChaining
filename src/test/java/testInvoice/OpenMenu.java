package testInvoice;

import Utilities.ConfigReader;
import Utilities.Util;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.DashboardInvoice;
import pages.LoginInvoice;

import java.awt.*;
import java.io.IOException;

public class OpenMenu extends Util {

    ChromeDriver driver;

    String baseURL= ConfigReader.getProperty("baseUrl");
    String userName=ConfigReader.getProperty("username");
    String passWord=ConfigReader.getProperty("password");
    String mainMenu=ConfigReader.getProperty("mainMenu");
    String subMenu=ConfigReader.getProperty("subMenu");


    @BeforeMethod
    public void browserLaunch() {
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(baseURL);
    }
    @AfterMethod
    public void teardown()
    {
        driver.quit();
    }

    @Test
    public void openMenuTest() throws InterruptedException, IOException {
        LoginInvoice lgn=new LoginInvoice(driver);
        DashboardInvoice dashboard=lgn.login(userName,passWord).Menu(mainMenu);
        expliWait(driver,"Add Client");
        Screenshot(driver);
        Assert.assertEquals(dashboard.getSubMenu(),"Add Client");



    }
}

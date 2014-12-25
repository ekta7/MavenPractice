package adminModulePackage01;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 14/12/2014.
 */
public class Admin01 {

    static WebDriver driver;

    //--------------Test Data--------------------
    String adminUsername="admin",adminPassword="Insoft12";
    //Generate Random no.s


    //Test case 01
    String jobTitle="Automation Test Analyst";
    String jobDesc="Developing Automation test frameworks and maintaining them";
    //Test case 02
    String salaryComp="Sample Salary Component";

    @BeforeClass
    public static void startBrowser() {
        driver = new FirefoxDriver();
        driver.get("http://insoftt.trial47.orangehrmlive.com/");
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();


    }

    @AfterClass
    public static void stopBrowser() {
        driver.quit();
    }

//Generating Random no.s
    public int randomNo()
    {
        Random random1=new Random();
        int randomNumber=random1.nextInt();
        return randomNumber;
    }


    @Test
    public void verifyAdminCanAddJobTitle() {
        Random random1=new Random();
        int randomNumber=random1.nextInt();

        //Login
        driver.findElement(By.id("txtUsername")).sendKeys(adminUsername);
        driver.findElement(By.id("txtPassword")).sendKeys(adminPassword);
        driver.findElement(By.id("btnLogin")).click();

        //checkpoint and navigate to admin menu
        Assert.assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();

        //navigate to jobtitles page
        driver.findElement(By.id("menu_admin_Job")).click();
        driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
        Assert.assertTrue(driver.findElement(By.id("btnAdd")).isDisplayed());
        driver.findElement(By.id("btnAdd")).click();
        //provide the new job title details
        driver.findElement(By.name("jobTitle[jobTitle]")).sendKeys(jobTitle+randomNumber);
        driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc+randomNumber);
        driver.findElement(By.id("btnSave")).click();

        Assert.assertTrue(driver.findElement(By.partialLinkText(jobTitle)).isDisplayed());


        WebDriverWait w = new WebDriverWait(driver,120);
        try {
            w.wait();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        w.until(ExpectedConditions.visibilityOf(driver.findElement(By.id("btnSave"))));


        //Logout
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    @Test
    public void verifyAdminCanAddSalaryComponents(){
        Random random1=new Random();
        int randomNumber=random1.nextInt();

        //Login
        driver.findElement(By.id("txtUsername")).sendKeys(adminUsername);
        driver.findElement(By.id("txtPassword")).sendKeys(adminPassword);
        driver.findElement(By.id("btnLogin")).click();
        //checkpoint
        Assert.assertEquals("Welcome Admin", driver.findElement(By.id("welcome")).getText());
        driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
        //navigate to add salary components page
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        driver.findElement(By.id("menu_admin_Job")).click();
        driver.findElement(By.id("menu_admin_viewSalaryComponentList")).click();
        driver.findElement(By.id("btnAdd")).click();

        //providing the details for salary component
        driver.findElement(By.id("salary_component_name")).sendKeys(salaryComp+randomNumber);
        driver.findElement(By.id("salary_component_type_1")).click();
        driver.findElement(By.id("salary_component_add_to_total_payable")).click();
        driver.findElement(By.id("btnSave")).click();

        //checkpoint
//        Assert.assertTrue(driver.findElement(By.partialLinkText(salaryComp)).isDisplayed());

        //Logout
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
            }
}
package adminModulePackage01;

import org.junit.Assert;
import org.openqa.selenium.By;
import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 14/12/2014.
 */
public class BusinessLibrary extends BaseClass{

    //Login Method
    public void loginAsAdmin(String adminUsername,String adminPassword)
    {
        //Login
        driver.findElement(By.id("txtUsername")).sendKeys(adminUsername);
        driver.findElement(By.id("txtPassword")).sendKeys(adminPassword);
        driver.findElement(By.id("btnLogin")).click();
    }

    //Logout Method
    public void logoutAsAdmin()
    {
        //Logout
        driver.findElement(By.id("welcome")).click();
        driver.findElement(By.linkText("Logout")).click();
    }

    public void navigateToAdminMenu()
    {
        try{
        driver.findElement(By.id("menu_admin_viewAdminModule")).isDisplayed();
        driver.findElement(By.id("menu_admin_viewAdminModule")).click();
        }catch (Exception e){
            System.out.println("Can't find the Admin Menu Link");

        }
    }

    public void addJobTitle(String jobTitle,String jobDesc)
    {
        driver.findElement(By.id("menu_admin_Job")).click();
        driver.findElement(By.id("menu_admin_viewJobTitleList")).click();
        Assert.assertTrue(driver.findElement(By.id("btnAdd")).isDisplayed());
        driver.findElement(By.id("btnAdd")).click();

        //provide the new job title details1
        driver.findElement(By.name("jobTitle[jobTitle]")).sendKeys(jobTitle);
        driver.findElement(By.id("jobTitle_jobDescription")).sendKeys(jobDesc);
        //Wait for 20 Sec
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.findElement(By.id("btnSave")).click();

    }

    public void addSalaryComponent(String salaryComp)
    {
        driver.findElement(By.id("menu_admin_Job")).click();
        driver.findElement(By.id("menu_admin_viewSalaryComponentList")).click();
        driver.findElement(By.id("btnAdd")).click();

        //providing the details for salary component
        driver.findElement(By.id("salary_component_name")).sendKeys(salaryComp);
        driver.findElement(By.id("salary_component_type_1")).click();
        driver.findElement(By.id("salary_component_add_to_total_payable")).click();
        driver.findElement(By.id("btnSave")).click();
    }
}

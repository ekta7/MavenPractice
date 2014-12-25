package adminModulePackage01;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

/**
 * Created by Srikanth on 14/12/2014.
 */
public class SmokeTestSuite_Admin extends BaseTest {
    //--------------Test Data--------------------
    String adminUsername="admin",adminPassword="Insoft12";

    //Test case 01
    String jobTitle="Automation Test Analyst"+Utils.generateRandomNo();
    String jobDesc="Developing Automation test frameworks and maintaining them"+Utils.generateRandomNo();
    //Test case 02
    String salaryComp="Sample Salary Component"+Utils.generateRandomNo();

    //Creating object for BusinessLibrary Class to utilise all the re-usable functions
    BusinessLibrary blib=new BusinessLibrary();

    @Test
    public void verifyAdminCanAddJobTitle() {
         //Login
        blib.loginAsAdmin(adminUsername,adminPassword);
        //checkpoint
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin"));
        blib.navigateToAdminMenu();
        blib.addJobTitle(jobTitle, jobDesc);
        Assert.assertTrue(Utils.isTextPresent("Successfully Saved"));
        Assert.assertTrue(Utils.isTextPresent(jobTitle));
        //Logout
        blib.logoutAsAdmin();
    }
    @Test
    public void verifyAdminCanAddSalaryComponents(){
        //Login
        blib.loginAsAdmin(adminUsername,adminPassword);
        //checkpoint
        Assert.assertTrue(Utils.isTextPresent("Welcome Admin"));
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        blib.navigateToAdminMenu();
        blib.addSalaryComponent(salaryComp);
       Assert.assertTrue(Utils.isTextPresent("Successfully Saved"));
        Assert.assertTrue(Utils.isTextPresent(salaryComp));
         //Logout
       blib.logoutAsAdmin();
    }
}

package adminModulePackage01;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;

/**
 * Created by Srikanth on 14/12/2014.
 */
public class Utils extends BaseClass {
    public static int generateRandomNo()
    {
        Random random1=new Random();
        int randomNumber=random1.nextInt();
        return randomNumber;
    }
    //Method to Select from drop down menu
    public static void selectFromDropDown(By by,String text)
    {
        Select sel = new Select(driver.findElement(by));
        sel.selectByVisibleText(text);

    }

    //Method to check the expected text is presented or not
    public static boolean isTextPresent(String text)
    {
        return driver.findElement(By.tagName("body")).getText().contains(text);
    }



    //Method to check the element is present or not
    public static boolean isElementPresent(By element)
    {
        try
        {
            return driver.findElement(element).isDisplayed();
        }
        catch (Exception e)
        {
            System.out.println("Can not find the Element");
            return false;
                    }
    }

    //Method to wait for a particular element
   public static void waitForElement(By element,int time)
  {
    WebDriverWait w = new WebDriverWait(driver,time);
    try {
        w.wait();
    } catch (InterruptedException e) {
        e.printStackTrace();
    }
    w.until(ExpectedConditions.visibilityOf(driver.findElement(element)));
  }


}

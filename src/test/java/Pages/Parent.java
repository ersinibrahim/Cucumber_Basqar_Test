package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Locale;

public class Parent {

    public void sendKeysFunction(WebElement element, String value)
    {
        waitUntilVisible(element); // element gözükene kadar bekle
        scrollToElement(element); // element e kadar javascript ile kaydır
        element.clear();// elemntin için temizle
        element.sendKeys(value); // valueyi  gönder
    }

    public void clickFunction(WebElement element)
    {
        waitUntilClickable(element); // element clickable kadar bekle
        scrollToElement(element); // element e kadar javascript ile kaydır
        element.click(); // click yap
    }

    public static void waitUntilVisible(WebElement element){
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void scrollToElement(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].scrollIntoView();", element);
    }

    public void scrollToUpElement(WebElement element){
        JavascriptExecutor js= (JavascriptExecutor) BaseDriver.getDriver();
        js.executeScript("arguments[0].setAttribute('style', 'top:0px')", element);
        js.executeScript("arguments[0].scrollIntoView();", element);
    }


    public void waitUntilClickable(WebElement element){
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),10);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }


    public static void delay(int second)
    {
        try {
            Thread.sleep(1000*second);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    public void verifyContainsText(WebElement element, String msg)
    {
        waitUntilVisible(element); // element clickable kadar bekle
        Assert.assertTrue(element.getText().toLowerCase().contains(msg.toLowerCase()));
    }

    public void waitnumberOfElementsToBeLessThan(By selector, int number)
    {
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),20);
        wait.until(ExpectedConditions.numberOfElementsToBeLessThan(selector,number));
    }

    public void listSelectOption(List<WebElement> list,String option)
    {
        for (WebElement element:list)
        {
            if (element.getText().contains(option)){
                element.click();
                break;
            }
        }
    }

    public void RobotEscClick(){

        try {
            Robot rbt=new Robot();
            rbt.keyPress(KeyEvent.VK_ESCAPE);
            rbt.keyRelease(KeyEvent.VK_ESCAPE);
        } catch (AWTException e) {
            e.printStackTrace();
        }
    }

    // Kendisine gönderilen ElementList i gözükene kadar bekleyip,
    // bütün elementler gözüktüğünde geri gönderdi
    public List<WebElement> waitVisibleListAllElement(List<WebElement> elementList){
        WebDriverWait wait=new WebDriverWait(BaseDriver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOfAllElements(elementList));
        return elementList;
    }


}

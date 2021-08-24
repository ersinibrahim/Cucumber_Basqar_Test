package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

public class DialogContent extends Parent {

    public DialogContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(id = "mat-input-0")
    private WebElement username;

    @FindBy(id = "mat-input-1")
    private WebElement password;

    @FindBy(xpath = "(//button[@class='consent-give'])[1]")
    public WebElement cookies;

    @FindBy(css = "button[aria-label='LOGIN']")
    private WebElement loginButton;

    @FindBy(xpath = "(//span[contains(text(),'Dashboard')])[2]")
    public WebElement dashboard;

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement addButton;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement nameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement codeInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='shortName']//input")
    private WebElement shortName;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    public WebElement successMessage;

    @FindBy(xpath = "//div[contains(text(),'error')]")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[contains(text(),'already exists')]")
    public WebElement alreadyExist;

    @FindBy(xpath = "//button[@aria-label='Close dialog']")
    private WebElement closeDialog;


    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    private WebElement searchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement deleteButton;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement deleteDialogBtn;

    @FindBy(xpath = "//mat-chip-list[@formcontrolname='roles']//input")
    private WebElement userType;

    @FindBy(css = "div>mat-option>span")
    private List<WebElement> userTypes;

    @FindBy(xpath = "(//div[@class='ps__rail-y'])[2]")
    private WebElement rightScroll;


    @FindBy(xpath = "//ms-delete-button//button")
    private List<WebElement> garbageButtonsList;


    @FindBy(xpath = "//ms-text-field[@formcontrolname='budgetAccountIntegrationCode']//input")
    private WebElement integrationCode;

    @FindBy(xpath = "//ms-integer-field[@formcontrolname='priority']//input")
    private WebElement priority;

    @FindBy(css = "button[class$='mat-accent ng-star-inserted']")
    private WebElement countryEditButton;


    @FindBy(css = "ms-text-field[placeholder='GENERAL.FIELD.NAME']")
    private WebElement countrySearchName;

    @FindBy(css = "button[class$='mat-button-base mat-accent']")
    private WebElement countrySearchButton;

    @FindBy(xpath = "//tbody/tr/td[2]")
    public List<WebElement> nameList;




    WebElement myElement;

    public void findAndSend(String elementName, String value) {
        switch (elementName) {
            case "username":
                myElement = username;
                break;

            case "password":
                myElement = password;
                break;

            case "nameInput":
                myElement = nameInput;
                break;

            case "codeInput":
                myElement = codeInput;
                break;

            case "shortName":
                myElement = shortName;
                break;


            case "searchInput":
                myElement = searchInput;
                break;

            case "integrationCode":
                myElement = integrationCode;
                break;


            case "priority":
                myElement = priority;
                break;

            case "countrySearchName":
                myElement = countrySearchName;
                break;


        }


        sendKeysFunction(myElement, value);
    }

    public void findAndClick(String elementName) {
        switch (elementName) {
            case "loginButton":
                myElement = loginButton;
                break;

            case "addButton":
                myElement = addButton;
                break;

            case "saveButton":
                myElement = saveButton;
                break;


            case "closeDialog":
                myElement = closeDialog;
                break;

            case "searchButton":
                myElement = searchButton;
                break;

            case "deleteButton":
                myElement = deleteButton;
                break;

            case "deleteDialogBtn":
                myElement = deleteDialogBtn;
                break;

            case "rightScroll":
                myElement = rightScroll;
                break;

            case "countryEditButton":
                myElement = countryEditButton;
                break;

            case "countrySearchButton":
                myElement = countrySearchButton;
                break;

            case "countrySearchName":
                myElement = countrySearchName;
                break;


        }


        clickFunction(myElement);
    }

    public void findAndContainsText(String elementName, String msg) {


        switch (elementName) {
            case "successMessage":
                myElement = successMessage;
                break;

            case "errorMessage":
                myElement = errorMessage;
                break;

            case "alreadyExist":
                myElement = alreadyExist;
                break;
        }

        verifyContainsText(myElement, msg);
    }

    public void findAndDelete(String deleteString) {
        // scrollToUpElement(rightScroll);
        // findAndSend("searchInput",deleteString);
        //  findAndClick("searchButton");

        //waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"),deleteGarbageButtons.size());
        scrollToUpElement(rightScroll);
        List<WebElement> list = new ArrayList<>(garbageButtonsList);
        findAndSend("searchInput", deleteString);
        findAndClick("searchButton");


        // çöp kovaları 5 den az olana kadar bekle: search sonucu gözükene kadar bekle
        waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"), list.size());

        findAndClick("deleteButton");
        findAndClick("deleteDialogBtn");
    }


    List<WebElement> mylist;

    public void ChooseListElement(String listName, String option) {

        switch (listName) {
            case "userTypes":
                mylist = userTypes;
                break;
        }

        userType.click();

        listSelectOption(mylist, option);
    }

    public void findAndEdit(String oldWord,String newWord) {


        //waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"),deleteGarbageButtons.size());
        scrollToUpElement(rightScroll);
        List<WebElement> list = new ArrayList<>(garbageButtonsList);
        findAndSend("searchInput", oldWord);
        findAndClick("searchButton");


        // çöp kovaları 5 den az olana kadar bekle: search sonucu gözükene kadar bekle
        waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"), list.size());

        findAndSend("nameInput",newWord);
        findAndClick("deleteDialogBtn");
    }


}

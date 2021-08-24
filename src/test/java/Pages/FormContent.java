package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.awt.*;
import java.util.WeakHashMap;

public class FormContent extends Parent {

    public FormContent() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "//mat-form-field[@formgroupname='academicPeriod']")
    private WebElement academicPeriod;

    @FindBy(xpath = "//span[class='mat-option-text']")
    private WebElement APselection;

    @FindBy(xpath = "//mat-form-field[@formgroupname='gradeLevel']")
    private WebElement gradeLevel;

    @FindBy(xpath = "//span[@class='mat-option-text'][1]")
    private WebElement gradeSelection1;

    @FindBy(xpath = "//span[@class='mat-option-text'][2]")
    private WebElement gradeSelection2;

    @FindBy(xpath = "//span[@class='mat-option-text'][3]")
    private WebElement gradeSelection3;

    @FindBy(xpath = "//span[@class='mat-option-text'][4]")
    private WebElement gradeSelection4;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement saveButton;

    @FindBy(xpath = "//mat-form-field//input")
    private WebElement formSearchInput;

    @FindBy(xpath = "//ms-search-button//button")
    private WebElement searchButton;

    @FindBy(xpath = "(//div[@class='ps__rail-y'])[2]")
    private WebElement rightScroll;


    @FindBy(xpath = "(//span[text()='Gender'])[1]")
    private WebElement gender;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[2]")
    private WebElement genderSelection;

    @FindBy(xpath = "//span[text()='Employee Type']")
    private WebElement employeeType;

    @FindBy(xpath = "(//span[@class='mat-option-text'])[1]")
    private WebElement employeeSelection;


    @FindBy(xpath = "//mat-select[@formcontrolname='type']") //(//span[text()='Document Type'])[1]
    private WebElement documentType;

    @FindBy(xpath = "//span[contains(text(),'Personal ID')]")
    private WebElement documentTypeSelection;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='firstName']//input")
    private WebElement firstnameInput;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='lastName']//input")
    private WebElement lastnameInput;

    @FindBy(xpath = "(//mat-form-field[@formgroupname='documentInfo']//input)[1]")
    private WebElement documentNumber;

    @FindBy(xpath = "//input[@formcontrolname='employeeId']")
    private WebElement employeeID;


    @FindBy(xpath = "//ms-text-field[@formcontrolname='middleName']")
    private WebElement middleName;


    @FindBy(css = "ms-text-field[formcontrolname='code']")
    private WebElement editCountryCodeBox;

    @FindBy(xpath = "//span[text()='Save']")
    private WebElement editCountrySaveButton;


    WebElement myElement;

    public void findAndClick(String elementName) {
        switch (elementName) {
            case "academicPeriod":
                myElement = academicPeriod;
                break;

            case "APselection":
                myElement = APselection;
                break;

            case "gradeLevel":
                myElement = gradeLevel;
                break;

            case "gradeSelection1":
                myElement = gradeSelection1;
                break;

            case "gradeSelection2":
                myElement = gradeSelection2;
                break;

            case "gradeSelection3":
                myElement = gradeSelection3;
                break;

            case "gradeSelection4":
                myElement = gradeSelection4;
                break;


            case "saveButton":
                myElement = saveButton;
                break;


            case "searchButton":
                myElement = searchButton;
                break;


            case "gender":
                myElement = gender;
                break;

            case "genderSelection":
                myElement = genderSelection;
                break;

            case "employeeType":
                myElement = employeeType;
                break;

            case "employeeSelection":
                myElement = employeeSelection;
                break;


            case "documentType":
                myElement = documentType;
                break;


            case "middleName":
                myElement = middleName;
                break;

            case "editCountrySaveButton":
                myElement = editCountrySaveButton;
                break;
        }

        clickFunction(myElement);
        if (myElement == employeeSelection) {
            RobotEscClick();
        }
    }


    public void findAndSend(String elementName, String value) {
        switch (elementName) {
            case "formSearchInput":
                myElement = formSearchInput;
                break;
            case "firstnameInput":
                myElement = firstnameInput;
                break;

            case "lastnameInput":
                myElement = lastnameInput;
                break;

            case "documentNumber":
                myElement = documentNumber;
                break;

            case "employeeID":
                myElement = employeeID;
                break;

            case "editCountryCodeBox":
                myElement = editCountryCodeBox;
                break;


        }

        sendKeysFunction(myElement, value);
    }

    public void findAndDelete(String deleteString) {
        // tıklatma
        scrollToUpElement(rightScroll);
        findAndSend("formSearchInput", deleteString);
        findAndClick("searchButton");

        // çöp kovaları 5 den az olana kadar bekle: search sonucu gözükene kadar bekle
        waitnumberOfElementsToBeLessThan(By.xpath("//ms-delete-button//button"), 5);

        findAndClick("deleteButton");
        findAndClick("deleteDialogBtn");
    }

}

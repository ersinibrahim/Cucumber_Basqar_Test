package Pages;

import Utilities.BaseDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class LeftNav extends Parent {

    public LeftNav() {
        PageFactory.initElements(BaseDriver.getDriver(), this);
    }

    @FindBy(xpath = "(//span[text()='Setup'])[1]")
    private WebElement setupOne;

    @FindBy(xpath = "//span[text()='Parameters']")
    private WebElement parameters;

    @FindBy(xpath = "//span[text()='Countries']")
    private WebElement country;

    @FindBy(xpath = "//span[text()='Citizenships']")
    private WebElement citizenShip;

    @FindBy(xpath = "//span[text()='Inventory']")
     private WebElement inventories;

    @FindBy(xpath = "(//span[text()='Setup'])[4]")
    private WebElement inventorySetup;

    @FindBy(xpath = "//span[text()='Item Categories']")
     private WebElement itemCategories;

    @FindBy(xpath = "//span[text()='Nationalities']")
    private WebElement nationalities;

    @FindBy(xpath = "//span[text()='Fees']")
    private WebElement fees;

    @FindBy(xpath = "(//div[@class='ps__thumb-y'])[1]")
    private WebElement leftScroll;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[1]")
    private WebElement entranceExams;

    @FindBy(xpath = "(//span[text()='Setup'])[2]")
            private WebElement entranceSetup;

    @FindBy(xpath = "(//span[text()='Entrance Exams'])[2]")
            private WebElement entranceExamsInside;

    @FindBy(xpath ="//span[text()='Human Resources']")
            private WebElement humanResources;

    @FindBy(xpath ="//span[text()='Employees']")
    private WebElement employee;



    WebElement myElement;
    public void findAndClick(String elementName)
    {
        switch (elementName) {
            case "setupOne":
                myElement = setupOne;
                break;

            case "parameters":
                myElement = parameters;
                break;

            case "Countries":
                myElement = country;
                break;

            case "citizenShip":
                myElement = citizenShip;
                break;


            case "inventories":
                myElement = inventories;
                break;

            case "inventorySetup":
                myElement = inventorySetup;
                break;

            case "itemCategories":
                myElement = itemCategories;
                break;

            case "nationalities":
                myElement = nationalities;
                break;


            case "fees":
                myElement = fees;
                break;

            case "leftScroll":
                myElement = leftScroll;
                break;

            case "entranceExams":
                myElement = entranceExams;
                break;

            case "entranceSetup":
                myElement = entranceSetup;
                break;

            case "entranceExamsInside":
                myElement = entranceExamsInside;
                break;


            case "humanResources":
                myElement = humanResources;
                break;

            case "employee":
                myElement = employee;
                break;
        }

        clickFunction(myElement);
    }











}

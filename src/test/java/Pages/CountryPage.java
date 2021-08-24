package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.awt.*;
import java.util.List;

public class CountryPage extends Parent{

    @FindBy(xpath = "//span[text()='Cities']")
    private WebElement buttonCitiesPage;

    public WebElement getButtonCitiesPage() {
        return buttonCitiesPage;
    }

    @FindBy(xpath = "//ms-add-button[contains(@tooltip,'TITLE.ADD')]//button")
    private WebElement buttonAddCountryOrCity;

    public WebElement getButtonAddCountryOrCity() {
        return buttonAddCountryOrCity;
    }


    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement inputCountry;

    @FindBy(xpath = "//ms-text-field[@formcontrolname='code']//input")
    private WebElement inputCountryCode;

    public WebElement getInputCountry() {
        return inputCountry;
    }

    public WebElement getInputCountryCode() {
        return inputCountryCode;
    }

    public WebElement getButtonCountrySave() {
        return buttonCountrySave;
    }

    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessageNewCountry;

    public WebElement getSuccessMessageNewCountry() {
        return successMessageNewCountry;
    }

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement buttonCountrySave;

    @FindBy(css="span[class='mat-option-text']")
    public List<WebElement> dropDownNewCityCountrySelect;

    @FindBy(xpath = "//ms-save-button//button")
    private WebElement buttonNewCitySave;

    public WebElement getButtonNewCitySave() {
        return buttonNewCitySave;
    }

    public WebElement getInputCityName() {
        return inputCityName;
    }

    public WebElement getButtonCityDelete() {
        return buttonCityDelete;
    }

    public WebElement getButtonDeleteDialog() {
        return buttonDeleteDialog;
    }

    @FindBy(xpath = "//ms-text-field[@formcontrolname='name']//input")
    private WebElement inputCityName;


    @FindBy(xpath = "//div[contains(text(),'successfully')]")
    private WebElement successMessageNewCity;

    public WebElement getSuccessMessageNewCity() {
        return successMessageNewCity;
    }

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement buttonCityDelete;

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement buttonDeleteDialog;

    @FindBy(xpath = "(//span[text()='Cities'])[1]")
    private WebElement cities;

    @FindBy(xpath = "(//mat-select[@role='combobox'])[1]")
    private WebElement boxCountrySelect;

    public WebElement getInputCitySearchBox() {
        return inputCitySearchBox;
    }

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    private WebElement inputCitySearchBox;

    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    private WebElement inputCitySearchButton;



    public WebElement getInputCitySearchButton() {
        return inputCitySearchButton;
    }

    public WebElement getBoxCountrySelect() {
        return boxCountrySelect;
    }


    @FindBy(xpath = "//ms-text-field[@placeholder='GENERAL.FIELD.NAME']//input")
    private WebElement inputCountrySearch;

    @FindBy(xpath ="//ms-text-field[@placeholder='GENERAL.FIELD.CODE']//input" )
    private WebElement inputCountryCodeSearch;

    public WebElement getInputCountrySearch() {
        return inputCountrySearch;
    }

    public WebElement getInputCountryCodeSearch() {
        return inputCountryCodeSearch;
    }

    public WebElement getButtonCountrySearch() {
        return buttonCountrySearch;
    }

    @FindBy(xpath = "//span[text()='Search']")
    private WebElement buttonCountrySearch;

    @FindBy(xpath = "//ms-delete-button//button")
    private WebElement buttonCountryDelete;

    public WebElement getButtonCountryDelete() {
        return buttonCountryDelete;
    }

    @FindBy(xpath = "//span[contains(text(),'Delete')]")
    private WebElement buttonCountryDeleteDialog;

    public WebElement getButtonCountryDeleteDialog() {
        return buttonCountryDeleteDialog;
    }

    @FindBy(xpath = "//div[contains(text(),'can't be deleted')]")
    private WebElement failMessageDeleteCountry;

    public WebElement getFailMessageDeleteCountry() {
        return failMessageDeleteCountry;
    }
}



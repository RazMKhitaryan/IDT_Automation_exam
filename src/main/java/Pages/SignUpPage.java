package Pages;

import Pages.Base.BasePage;
import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static ActionsHelper.MyActions.*;
import static Utils.RandomTextUtils.*;

public class SignUpPage extends BasePage {

    @FindBy(css = "[class=\"title text-center\"]")
    List<WebElement> accountInformationText;

    @FindBy(id = "id_gender1")
    WebElement mrGender;

    @FindBy(id = "id_gender2")
    WebElement msGender;

    @FindBy(css = "[data-qa=\"name\"]")
    WebElement name;

    @FindBy(css = "[data-qa=\"email\"]")
    WebElement email;

    @FindBy(css = "[data-qa=\"password\"]")
    WebElement password;

    @FindBy(css = "[data-qa=\"days\"]")
    WebElement dayOfBirth;

    @FindBy(css = "[data-qa=\"months\"]")
    WebElement monthOfBirth;

    @FindBy(css = "[data-qa=\"years\"]")
    WebElement yearOfBirth;

    @FindBy(id = "newsletter")
    WebElement newsLetterCheckBox;

    @FindBy(id = "optin")
    WebElement receiveOfferCheckBox;

    @FindBy(css = "[data-qa=\"first_name\"]")
    WebElement firstName;

    @FindBy(css = "[data-qa=\"last_name\"]")
    WebElement lastName;

    @FindBy(css = "[data-qa=\"company\"]")
    WebElement company;

    @FindBy(css = "[data-qa=\"address\"]")
    WebElement address;

    @FindBy(css = "[data-qa=\"address2\"]")
    WebElement address2;

    @FindBy(css = "[data-qa=\"country\"]")
    WebElement country;

    @FindBy(css = "[data-qa=\"state\"]")
    WebElement state;

    @FindBy(css = "[data-qa=\"city\"]")
    WebElement city;

    @FindBy(css = "[data-qa=\"zipcode\"]")
    WebElement zipcode;

    @FindBy(css = "[data-qa=\"mobile_number\"]")
    WebElement mobileNumber;

    @FindBy(css = "[data-qa=\"create-account\"]")
    WebElement createAccountButton;

    @Override
    protected void isLoaded() {
        if (!WaitHelper.waitTillElementVisible(mrGender) || !WaitHelper.waitTillElementVisible(msGender)) {
            throw new Error("Login and SignUp page is not fully loaded.");
        }
    }

    @Override
    public String getUrl() {
        return "/signup";
    }

    @Override
    public SignUpPage init() {
        PageFactory.initElements(driver, this);
        return this;
    }

    @Override
    public SignUpPage openScreen() {
        driver.get(BASE_URL + getUrl());
        return init();
    }

    public String getAccountInformationText() {
        return accountInformationText.get(0).getText();
    }


    public String chooseMrGender() {
        clickOnElement(mrGender);
        return "Mr";
    }

    public String chooseMsGender() {
        clickOnElement(msGender);
        return "Ms";
    }

    public String writeRandomPassword() {
        String passwordText = "pass" + generateRandomText();
        writeText(password, passwordText);
        return passwordText;
    }

    public String writeRandomDayOfBirth(int min, int max) {
        String dayOfBirthText = String.valueOf(generateRandomNumber(min, max));
        writeText(dayOfBirth, dayOfBirthText);
        return dayOfBirthText;
    }

    public String writeRandomMonthOfBirth() {
        String monthOfBirthText = generateRandomMonth();
        writeText(monthOfBirth, monthOfBirthText);
        return monthOfBirthText;
    }

    public String writeRandomYearOfBirth(int min, int max) {
        String yearOfBirthText = String.valueOf(generateRandomNumber(min, max));
        writeText(yearOfBirth, yearOfBirthText);
        return yearOfBirthText;
    }

    public String clickNewsLetterCheckBox() {
        clickOnElement(newsLetterCheckBox);
        return "Newsletter checkbox clicked";
    }

    public String clickReceiveOfferCheckBox() {
        clickOnElement(receiveOfferCheckBox);
        return "Receive Offer checkbox clicked";
    }

    public String writeRandomFirstName() {
        String firstNameText = "fr"+generateRandomText();
        writeText(firstName, firstNameText);
        return firstNameText;
    }

    public String writeRandomLastName() {
        String lastNameText = "la"+generateRandomText();
        writeText(lastName, lastNameText);
        return lastNameText;
    }

    public String writeRandomCompany() {
        String companyText = "co"+generateRandomText();
        writeText(company, companyText);
        return companyText;
    }

    public String writeRandomAddress() {
        String addressText = "a1"+generateRandomText();
        writeText(address, addressText);
        return addressText;
    }

    public String writeRandomAddress2() {
        String address2Text = "a2"+generateRandomText();
        writeText(address2, address2Text);
        return address2Text;
    }

    public String writeRandomCountry() {
        String countryText = generateRandomCountry();
        writeText(country, countryText);
        return countryText;
    }

    public String writeRandomState() {
        String stateText = "state"+generateRandomText();
        writeText(state, stateText);
        return stateText;
    }

    public String writeRandomCity() {
        String cityText = "city"+generateRandomText();
        writeText(city, cityText);
        return cityText;
    }

    public String writeRandomZipcode(int min, int max) {
        String zipcodeText = String.valueOf(generateRandomNumber(min, max));
        writeText(zipcode, zipcodeText);
        return zipcodeText;
    }

    public String writeRandomMobileNumber(int min, int max) {
        String mobileNumberText = String.valueOf(generateRandomNumber(min, max));
        writeText(mobileNumber, mobileNumberText);
        return mobileNumberText;
    }

    public AccountCreatedPage clickCreateAccountButton() {
        createAccountButton.click();
        return new AccountCreatedPage().init();
    }

}

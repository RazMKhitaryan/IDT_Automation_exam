package Pages;

import Utils.RandomTextUtils;
import WaitManager.WaitHelper;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

import static ActionsHelper.Actions.*;
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
    protected void isLoaded()  {
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


    public SignUpPage chooseMrGender(){
        clickOnElement(mrGender);
        return this;
    }

    public SignUpPage chooseMsGender(){
        clickOnElement(msGender);
        return this;
    }


    public String  writeRandomPassword(){
        String passwordText = generateRandomText();
        writeText(password, passwordText);
        return passwordText;
    }

    public SignUpPage writeRandomDayOfBirth(int min , int max){
        writeText(dayOfBirth, String.valueOf(generateRandomNumber(min,max)));
        return this;
    }

    public SignUpPage writeRandomMonthOfBirth(){
        writeText(monthOfBirth,generateRandomMonth());
        return this;
    }

    public SignUpPage writeRandomYearOfBirth(int min, int max ){
        writeText(yearOfBirth,String.valueOf(generateRandomNumber(min,max)));
        return this;
    }


    public SignUpPage clickNewsLetterCheckBox(){
        clickOnElement(newsLetterCheckBox);
        return this;
    }

    public SignUpPage clickReceiveOfferCheckBox(){
        clickOnElement(receiveOfferCheckBox);
        return this;
    }

    public SignUpPage writeRandomFirstName() {
        writeText(firstName, generateRandomText());
        return this;
    }

    public SignUpPage writeRandomLastName() {
        writeText(lastName, generateRandomText());
        return this;
    }

    public SignUpPage writeRandomCompany() {
        writeText(company, generateRandomText());
        return this;
    }

    public SignUpPage writeRandomAddress() {
        writeText(address, generateRandomText());
        return this;
    }

    public SignUpPage writeRandomAddress2() {
        writeText(address2, generateRandomText());
        return this;
    }

    public SignUpPage writeRandomCountry() {
        writeText(country, generateRandomCountry());
        return this;
    }

    public SignUpPage writeRandomState() {
        writeText(state, generateRandomText());
        return this;
    }

    public SignUpPage writeRandomCity() {
        writeText(city, generateRandomText());
        return this;
    }

    public SignUpPage writeRandomZipcode(int min, int max) {
        writeText(zipcode, String.valueOf(generateRandomNumber(min,max)));
        return this;
    }

    public SignUpPage writeRandomMobileNumber(int min , int max) {
        writeText(mobileNumber, String.valueOf(generateRandomNumber(min,max)));
        return this;
    }

    public AccountCreatedPage clickCreateAccountButton() {
        createAccountButton.click();
        return new AccountCreatedPage().init();
    }

}

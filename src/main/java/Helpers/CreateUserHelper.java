package Helpers;

import Components.HeaderComponent;
import Pages.LoginAndSignUpPage;
import Pages.SignUpPage;
import Utils.UserDataUtils;

public abstract class CreateUserHelper {
    public static void userCreateHelper() {
        HeaderComponent headerComponent = new HeaderComponent().init();
        LoginAndSignUpPage loginAndSignUpPage = headerComponent.clickOnSignUpLogin();
        String username = loginAndSignUpPage.writeRandomName();
        String email = loginAndSignUpPage.writeRandomEmail();
        SignUpPage signUpPage = loginAndSignUpPage.clickSignUpButton();
        String password = signUpPage.writeRandomPassword();

        String genderMr = signUpPage.chooseMrGender();
        String dayOfBirth = signUpPage.writeRandomDayOfBirth(1, 30);
        String monthOfBirth = signUpPage.writeRandomMonthOfBirth();
        String yearOfBirth = signUpPage.writeRandomYearOfBirth(1900, 2021);
        String newsLetterResult = signUpPage.clickNewsLetterCheckBox();
        String receiveOfferResult = signUpPage.clickReceiveOfferCheckBox();
        String firstName = signUpPage.writeRandomFirstName();
        String lastName = signUpPage.writeRandomLastName();
        String country = signUpPage.writeRandomCountry();
        String address = signUpPage.writeRandomAddress();
        String address2 = signUpPage.writeRandomAddress2();
        String company = signUpPage.writeRandomCompany();
        String state = signUpPage.writeRandomState();
        String city = signUpPage.writeRandomCity();
        String zipcode = signUpPage.writeRandomZipcode(1000, 9000);
        String mobileNumber = signUpPage.writeRandomMobileNumber(1999000, 2000000);
        signUpPage.clickCreateAccountButton();
        headerComponent.clickOnLogout();
        UserDataUtils.writeUserDataInFile(username, email, password, genderMr, firstName, lastName, company, address, address2, city, state, zipcode, country, mobileNumber);
    }


}

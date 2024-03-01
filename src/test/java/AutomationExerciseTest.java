import Base.TestBase;
import Components.HeaderComponent;
import Pages.*;
import Utils.UserDataUtils;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;

import org.testng.annotations.Test;


public class AutomationExerciseTest extends TestBase {

    @BeforeMethod(onlyForGroups = "login")
    public void createUser() {
        userCreateHelper();
    }


    @Test(description = "account creation,login, and delete functionality")
    public void RegisterUserTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new HomePage().init().isHomePageVisible(),"The home page was not displayed");

        HeaderComponent headerComponent = new HeaderComponent();
        LoginAndSignUpPage loginAndSignUpPage = headerComponent.init().clickOnSignUpLogin();
        softAssert.assertTrue(loginAndSignUpPage.getSignUpText().contains("New User Signup!"), "The 'New User Signup!' text was not displayed ");

        String username = loginAndSignUpPage.writeRandomName();
        loginAndSignUpPage.writeRandomEmail();
        SignUpPage signUpPage = loginAndSignUpPage.clickSignUpButton();

        softAssert.assertEquals(signUpPage.getAccountInformationText(), "ENTER ACCOUNT INFORMATION", "The 'ENTER ACCOUNT INFORMATION' text was not displayed");

        signUpPage.writeRandomPassword();
        AccountCreatedPage accountCreatedPage = signUpPage
                .writeRandomDayOfBirth(1, 30)
                .writeRandomMonthOfBirth()
                .writeRandomYearOfBirth(1900, 2021)
                .clickNewsLetterCheckBox()
                .clickReceiveOfferCheckBox()
                .writeRandomFirstName()
                .writeRandomLastName()
                .writeRandomCountry()
                .writeRandomAddress()
                .writeRandomAddress2()
                .writeRandomCompany()
                .writeRandomCountry()
                .writeRandomState()
                .writeRandomCity()
                .writeRandomZipcode(1000, 9000)
                .writeRandomMobileNumber(1999000, 2000000)
                .clickCreateAccountButton();

        softAssert.assertTrue(accountCreatedPage.getAccountCreatedText().contains("ACCOUNT CREATED!"), "'Account Created!' text was not displayed");
        accountCreatedPage.clickContinueButton();

        softAssert.assertTrue(headerComponent.init().getNavBarText().contains("Logged in as " + username), "The username was not displayed");
        DeleteAccountPage deleteAccountPage = headerComponent.clickDeleteAccount();

        softAssert.assertEquals(deleteAccountPage.getAccountDeletedText(), "ACCOUNT DELETED!", "'Account Deleted!' text was not displayed");
        softAssert.assertAll();
        deleteAccountPage.clickContinueButton();
    }

    @Test(description = "product searching logic verification")
    public void searchProductTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new HomePage().init().isHomePageVisible(),"The home page was not displayed");

        ProductsPage productsPage = new HeaderComponent().init().clickOnProducts();
        softAssert.assertEquals(productsPage.getAllProductsText(), "ALL PRODUCTS", "'ALL PRODUCTS' text was not displayed");

        String color = "blue";
        SearchPage searchPage = productsPage.searchProduct(color)
                .clickSearchButton();

        softAssert.assertTrue(searchPage.getSearchedProductsText().contains("SEARCHED PRODUCTS"), "The 'SEARCHED PRODUCTS' text was not displayed");
        softAssert.assertTrue(searchPage.areSearchedElementsDisplayedRight(color), "there are wrong products search is not working ok");
        softAssert.assertAll();
    }


    @Test(description = "Place Order: Login before Checkout", groups = "login")
    public void loginAndBuyProduct() {
        SoftAssert softAssert = new SoftAssert();
        String username = loginHelper();
        softAssert.assertTrue(new HomePage().init().isHomePageVisible(),"The home page was not displayed");

        HeaderComponent headerComponent = new HeaderComponent().init();
        softAssert.assertTrue(headerComponent.getNavBarText().contains("Logged in as " + username), " 'Logged in as username' was not displayed");
        softAssert.assertAll();
        //6 em hasel

    }







    //-------------Helpers-----------
    //-------------------------------
    public void userCreateHelper() {
        HeaderComponent headerComponent = new HeaderComponent().init();
        LoginAndSignUpPage loginAndSignUpPage = headerComponent.clickOnSignUpLogin();
        String username = loginAndSignUpPage.writeRandomName();
        String email = loginAndSignUpPage.writeRandomEmail();
        SignUpPage signUpPage = loginAndSignUpPage.clickSignUpButton();
        String password = signUpPage.writeRandomPassword();

        signUpPage.writeRandomDayOfBirth(1, 30)
                .writeRandomMonthOfBirth()
                .writeRandomYearOfBirth(1900, 2021)
                .clickNewsLetterCheckBox()
                .clickReceiveOfferCheckBox()
                .writeRandomFirstName()
                .writeRandomLastName()
                .writeRandomCountry()
                .writeRandomAddress()
                .writeRandomAddress2()
                .writeRandomCompany()
                .writeRandomCountry()
                .writeRandomState()
                .writeRandomCity()
                .writeRandomZipcode(1000, 9000)
                .writeRandomMobileNumber(1999000, 2000000)
                .clickCreateAccountButton();
        headerComponent.clickOnLogout();
        UserDataUtils.writeUserDataInFile(username, email, password);
    }

    public String loginHelper() {
        String userData = UserDataUtils.readUserDataFromFile();
        String[] data = userData.split(" ");
        HeaderComponent headerComponent = new HeaderComponent().init();
        String username = data[0];
        String userEmail = data[1];
        String userPassword = data[2];
        headerComponent.clickOnSignUpLogin()
                .writeEmail(userEmail)
                .writePassword(userPassword)
                .clickLoginButton();
        return username;
    }

}


import Components.FooterComponent;
import Helpers.CreateUserHelper;
import Helpers.LoginHelper;
import Helpers.UserObject;
import Base.TestBase;
import Components.HeaderComponent;
import Pages.*;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import org.testng.annotations.Test;

import static Helpers.ActionsHelper.containsAllWords;

public class AutomationExerciseTest extends TestBase {

    @BeforeMethod(onlyForGroups = "login")
    public void createUser() {
        CreateUserHelper.userCreateHelper();
    }


    @Test(description = "Test Case 1: Register User")
    public void registerUserTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new HomePage().init().isHomePageVisible(), "The home page was not displayed");

        HeaderComponent headerComponent = new HeaderComponent();
        LoginAndSignUpPage loginAndSignUpPage = headerComponent.init().clickOnSignUpLogin();
        softAssert.assertTrue(loginAndSignUpPage.getSignUpText().contains("New User Signup!"), "The 'New User Signup!' text was not displayed ");

        String username = loginAndSignUpPage.writeRandomName();
        loginAndSignUpPage.writeRandomEmail();
        SignUpPage signUpPage = loginAndSignUpPage.clickSignUpButton();

        softAssert.assertEquals(signUpPage.getAccountInformationText(), "ENTER ACCOUNT INFORMATION", "The 'ENTER ACCOUNT INFORMATION' text was not displayed");

        signUpPage.writeRandomPassword();
        signUpPage.writeRandomDayOfBirth(1, 30);
        signUpPage.writeRandomMonthOfBirth();
        signUpPage.writeRandomYearOfBirth(1900, 2021);
        signUpPage.clickNewsLetterCheckBox();
        signUpPage.clickReceiveOfferCheckBox();
        signUpPage.writeRandomFirstName();
        signUpPage.writeRandomLastName();
        signUpPage.writeRandomCountry();
        signUpPage.writeRandomAddress();
        signUpPage.writeRandomAddress2();
        signUpPage.writeRandomCompany();
        signUpPage.writeRandomCountry();
        signUpPage.writeRandomState();
        signUpPage.writeRandomCity();
        signUpPage.writeRandomZipcode(1000, 9000);
        signUpPage.writeRandomMobileNumber(1999000, 2000000);
        AccountCreatedPage accountCreatedPage = signUpPage.clickCreateAccountButton();

        softAssert.assertTrue(accountCreatedPage.getAccountCreatedText().contains("ACCOUNT CREATED!"), "'Account Created!' text was not displayed");
        accountCreatedPage.clickContinueButton();

        softAssert.assertTrue(headerComponent.init().getNavBarText().contains("Logged in as " + username), "The username was not displayed");
        DeleteAccountPage deleteAccountPage = headerComponent.clickDeleteAccount();

        softAssert.assertEquals(deleteAccountPage.getAccountDeletedText(), "ACCOUNT DELETED!", "'Account Deleted!' text was not displayed");
        softAssert.assertAll();
        deleteAccountPage.clickContinueButton();
    }

    @Test(description = "Test Case 9: Search Product")
    public void searchProductTest() {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(new HomePage().init().isHomePageVisible(), "The home page was not displayed");

        ProductsPage productsPage = new HeaderComponent().init().clickOnProducts();
        softAssert.assertEquals(productsPage.getAllProductsText(), "ALL PRODUCTS", "'ALL PRODUCTS' text was not displayed");

        String color = "blue";
        SearchPage searchPage = productsPage.searchProduct(color)
                .clickSearchButton();

        softAssert.assertTrue(searchPage.getSearchedProductsText().contains("SEARCHED PRODUCTS"), "The 'SEARCHED PRODUCTS' text was not displayed");
        softAssert.assertTrue(searchPage.areSearchedElementsDisplayedRight(color), "there are wrong products search is not working ok");
        softAssert.assertAll();
    }


    @Test(description = "Test Case 16: Place Order: Login before Checkout", groups = "login")
    public void loginAndBuyProductTest() {
        SoftAssert softAssert = new SoftAssert();
        UserObject userObject = LoginHelper.login();

        HomePage homePage = new HomePage().init();
        softAssert.assertTrue(homePage.isHomePageVisible(), "The home page was not displayed");

        HeaderComponent headerComponent = new HeaderComponent().init();
        softAssert.assertTrue(headerComponent.getNavBarText().contains("Logged in as " + userObject.getUsername()), " 'Logged in as username' was not displayed");

        String[] productInfo = homePage.clickOnAddToCardButton(3)
                .getProductInfo(1);
        homePage.clickContinueShoppingButton();
        CartPage cartPage = headerComponent.clickOnCartButton();

        softAssert.assertTrue(cartPage.init().isCartPageOpened(), "the Cart page was not opened");
        CheckoutPage checkoutPage = cartPage.clockOnProceedToCheckout();

        softAssert.assertTrue(containsAllWords(userObject.toString(), checkoutPage.getAddressDeliveryTextAsString()), "the information was wrong in address text");
        softAssert.assertTrue(containsAllWords(checkoutPage.extractProductDetails(), productInfo), "the information about added products is wrong");

        PaymentPage paymentPage = checkoutPage.writeComment()
                .clickOnPlaceOrder()
                .writeNameOnCard()
                .writeCardNumber()
                .writeCVC()
                .selectExpiryMonth()
                .selectExpiryYear()
                .clickPayButton();

        softAssert.assertEquals(paymentPage.getPaymentMessage().getText(), "Congratulations! Your order has been confirmed!", "The payment success message was not displayed");
        headerComponent.clickDeleteAccount();

        softAssert.assertEquals(new DeleteAccountPage().init().getAccountDeletedText(), "ACCOUNT DELETED!", "'Account Deleted!' text was not displayed");
        softAssert.assertAll();
    }


    @Test(description = "Test Case 25: Verify Scroll Up using 'Arrow' button and Scroll Down functionality")
    public void scrollUpAndDownTest() {
        SoftAssert softAssert = new SoftAssert();
        HomePage homePage = new HomePage().init();

        softAssert.assertTrue(homePage.isHomePageVisible(), "The home page was not displayed");

        FooterComponent footerComponent = new FooterComponent().init();
        String subscriptionText = footerComponent.scrollToFooter()
                .getSubscriptionText();

        softAssert.assertEquals(subscriptionText, "SUBSCRIPTION", "the 'SUBSCRIPTION' text was not displayed");
        homePage.init().clickArrowUp();

        softAssert.assertTrue(homePage.isCarouselTextVisible("Full-Fledged practice website for Automation Engineers"), "the 'Full-Fledged practice website for Automation Engineers' text was not displayed");
        softAssert.assertAll();
    }
}


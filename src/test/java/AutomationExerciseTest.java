import Base.TestBase;
import Components.HeaderComponent;
import Pages.HomePage;
import Pages.LoginAndSignUpPage;
import Pages.SignUpPage;
import org.testng.Assert;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class AutomationExerciseTest extends TestBase {

    @Test(description = "account creation,login, and delete functionality")
    public void createUserTest() {
        HomePage homePage = new HomePage();
        homePage.init();
        HeaderComponent headerComponent = new HeaderComponent();
        LoginAndSignUpPage loginAndSignUpPage = headerComponent.init().clickOnSignUpLogin();
        assertTrue(loginAndSignUpPage.getSignUpText().contains("New User Signup!"),"The 'New User Signup!' text were not displayed ");

        SignUpPage signUpPage = loginAndSignUpPage.writeName("Razmik")
                .writeEmail("hjgjhg@mail.ru")
                .clickSignUpButton();
        assertEquals(signUpPage.getAccountInformationText(),"ENTER ACCOUNT INFORMATION","The ENTER ACCOUNT INFORMATION' text were not displayed");
//hasa 9

    }
}

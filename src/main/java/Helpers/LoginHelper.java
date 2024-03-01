package Helpers;

import Components.HeaderComponent;
import Utils.UserDataUtils;

public abstract class LoginHelper {
    public static UserObject login() {
        UserObject userObject = UserDataUtils.readUserDataFromFile();

        HeaderComponent headerComponent = new HeaderComponent().init();
        String userEmail = userObject.getEmail();
        String userPassword = userObject.getPassword();
        headerComponent.clickOnSignUpLogin()
                .writeEmail(userEmail)
                .writePassword(userPassword)
                .clickLoginButton();
        return userObject;
    }
}

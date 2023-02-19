import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class SignupTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Visits the signup page")
    public void visitsTheSignupPage(){
        navPage.getSignup().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "URL doesn't contain /signup");
    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types")
    public void checkInputTypes(){
        navPage.getSignup().click();
        Assert.assertEquals(signupPage.getEmailField().getAttribute("type"), "email",
                "Value of the type attribute is not email");
        Assert.assertEquals(signupPage.getPasswordField().getAttribute("type"), "password",
                "Value of the type attribute is not password");
        Assert.assertEquals(signupPage.getConfirmPasswordField().getAttribute("type"), "password",
                "Value of the type attribute is not password");
    }
    @Test(priority = 30)
    @Description("Test #3: Displays errors when user already exists")
    public void displaysErrorsWhenUserAlreadyExistd(){
        navPage.getSignup().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "URL doesn't contain /signup");
        signupPage.getNameField().sendKeys("Another User");
        signupPage.getEmailField().sendKeys(" admin@admin.com");
        signupPage.getPasswordField().sendKeys("12345");
        signupPage.getConfirmPasswordField().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.getTextFromVerifyYourAccount().getText().contains("E-mail already exists"),
                "Error doesn't contain the message 'E-mail already exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/signup"),
                "URL doesn't contain /signup");

    }
    @Test(priority = 40)
    @Description("Test #4: Signup")
    public void signup(){
        navPage.getSignup().click();
        signupPage.getNameField().sendKeys("Petra Petric");
        signupPage.getEmailField().sendKeys(" petra.petric@itbootcamp.rs");
        signupPage.getPasswordField().sendKeys("12345");
        signupPage.getConfirmPasswordField().sendKeys("12345");
        signupPage.getSignMeUpButton().click();
        navPage.getHomeLink().click();
        Assert.assertTrue(messagePopUpPage.getTextFromVerifyYourAccount().getText().contains("IMPORTANT: Verify your account"),
                "Notification dialog doesn't contain the text 'IMPORTANT: Verify your account");
        messagePopUpPage.getCloseButtonFromVerifyYourAccount().click();
        navPage.getLogout().click();

    }

}

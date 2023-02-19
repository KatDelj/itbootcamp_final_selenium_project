import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTests extends BasicTest {
    @Test(priority = 10)
    @Description("Test #1: Visits the login page")
    public void visitTheLoginPage(){
        navPage.getLanguageButton().click();
        navPage.getENButton().click();
        navPage.getLoginin().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "URL doesn't contain /login");

    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types")
    public void checksInputTypes(){
        navPage.getLoginin().click();
        Assert.assertEquals(loginPage.getEmail().getAttribute("type"), "email",
                "Value of the type attribute is not email");
        Assert.assertEquals(loginPage.getPassword().getAttribute("type"), "password",
                "Value of the type attribute is not password");

    }
    @Test(priority = 30)
    @Description("Test #3: Displays errors when user does not exist")
    public void displaysErrorsWhenUserDoesNotExist(){
        navPage.getLoginin().click();
        loginPage.getEmail().sendKeys("non-existing-user@gmal.com");
        loginPage.getPassword().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.getTextFromVerifyYourAccount().getText().contains("User does not exist"),
                "Error doesn't contain the message 'User does not exists");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "URL doesn't contain /login");

    }
    @Test(priority = 40)
    @Description("Test #4: Displays errors when password is wrong")
    public void displaysErrorsWhenPasswordIsWrong(){
        navPage.getLoginin().click();
        loginPage.getEmail().sendKeys("admin@admin.com");
        loginPage.getPassword().sendKeys("password123");
        loginPage.getLoginButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.getTextFromVerifyYourAccount().getText().contains("Wrong password"),
                "Error doesn't contain the message 'Wrong password");
        Assert.assertTrue(driver.getCurrentUrl().contains("/login"),
                "URL doesn't contain /login");
    }
    @Test(priority = 50)
    @Description("Test #5: Login")
    public void login(){
        navPage.getLoginin().click();
        loginPage.getEmail().sendKeys("admin@admin.com");
        loginPage.getPassword().sendKeys("12345");
        loginPage.getLoginButton().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/home"),
                "URL doesn't contain /home");
    }
    @Test(priority = 60)
    @Description("Test #6: Logout")
    public void logout(){
        Assert.assertTrue(navPage.getLogout().isDisplayed(),
                "Logout button is not visible.");
    }


}

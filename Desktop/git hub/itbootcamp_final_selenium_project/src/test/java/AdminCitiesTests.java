import jdk.jfr.Description;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AdminCitiesTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Visits the admin cities page and list cities")
    public void visitsTheAdminCitiesPageAndListCities(){
    navPage.getLoginin().click();
    loginPage.getEmail().sendKeys("admin@admin.com");
    loginPage.getPassword().sendKeys("12345");
    loginPage.getLoginButton().click();
    navPage.getAdminButton().click();
    navPage.getCitesLink().click();
        Assert.assertTrue(driver.getCurrentUrl().contains("/admin/cities"),
                "URL doesn't contain /admin/cities");

    }
    @Test(priority = 20)
    @Description("Test #2: Checks input types for create/edit new city")
    public void checksInputTypesForCreateEditNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDeleteDialogToBeVisible();
        Assert.assertTrue(citiesPage.getNewItemInput().getAttribute("type").contains("text"),
                "Value of the type attribute is not text");
    }
    @Test(priority = 30)
    @Description("Test #3: Create new city")
    public void createNewCity(){
        navPage.getAdminButton().click();
        navPage.getCitesLink().click();
        citiesPage.getNewItemButton().click();
        citiesPage.waitForDeleteDialogToBeVisible();
        citiesPage.getNewItemInput().sendKeys("Petra Petric's city");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.getTextFromVerifyYourAccount().getText().contains("Saved successfully"),
                "Message does not contain Saved successfully");
    }
    @Test(priority = 40)
    @Description("Test #4: Edit city")
    public void editCity(){
        navPage.getAdminButton().click();
        navPage.getCitesLink().click();
        citiesPage.getSearchInput().sendKeys("Petra Petric's city Edited");
        citiesPage.getEditButton(1);
        citiesPage.getNewItemInput().sendKeys(Keys.CONTROL + "a");
        citiesPage.getNewItemInput().sendKeys(Keys.BACK_SPACE);
        citiesPage.getNewItemInput().sendKeys("Edited");
        citiesPage.getSaveButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.getTextFromVerifyYourAccount().getText().contains("Saved successfully"),
                "Message does not contain Saved successfully");
    }
    @Test(priority = 50)
    @Description("Test #5: Search city")
    public void searchCity(){
        navPage.getAdminButton().click();
        navPage.getCitesLink().click();
        citiesPage.getSearchInput().sendKeys("Petra Petric's city Edited");
        citiesPage.getEditButton(1);
        Assert.assertEquals(citiesPage.getCell(1,2).getText(),"Petra Petric's city Edited",
                "Text does not match the name from the first row");
    }
    @Test(priority = 60)
    @Description("Test #6: Delete city")
    public void deleteCity(){
        navPage.getAdminButton().click();
        navPage.getCitesLink().click();
        citiesPage.getSearchInput().sendKeys("Petra Petric's city Edited");
        citiesPage.getEditButton(1);
        Assert.assertEquals(citiesPage.getCell(1,2).getText(),"Petra Petric's city Edited",
                "Text does not match the name from the first row");
        citiesPage.getDeleteButton(1).click();
        citiesPage.waitForDeleteDialogToBeVisible();
        citiesPage.getDeleteButton().click();
        messagePopUpPage.waitForPopUp();
        Assert.assertTrue(messagePopUpPage.getTextFromVerifyYourAccount().getText().contains("Deleted successfully"),
                "Message does not contain Deleted successfully");
    }



}

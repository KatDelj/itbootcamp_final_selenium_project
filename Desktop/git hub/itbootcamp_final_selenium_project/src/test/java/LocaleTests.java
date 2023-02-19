import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LocaleTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Set locale to ES")
    public void setLocaleToES(){
        navPage.getLanguageButton().click();
        navPage.getESButton().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Página de aterrizaje"),
                "Header does not contain Página de aterrizaje");

    }
    @Test(priority = 20)
    @Description("Test #2: Set locale to EN")
    public void setLocaleToEn(){
        navPage.getLanguageButton().click();
        navPage.getENButton().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Landing"),
                "Header does not contain Landing");
    }
    @Test(priority = 30)
    @Description("Test #3: Set locale to CN")
    public void setLocaleToCn(){
        navPage.getLanguageButton().click();
        navPage.getCNButton().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("首页"),
                "Header does not contain 首页");

    }
    @Test(priority = 40)
    @Description("Test #4: Set locale to FR")
    public void setLocaleToFr(){
        navPage.getLanguageButton().click();
        navPage.getFRButton().click();
        Assert.assertTrue(navPage.getHeader().getText().contains("Page d'atterrissage"),
                "Header does not contain Page d'atterrissage");
    }
}

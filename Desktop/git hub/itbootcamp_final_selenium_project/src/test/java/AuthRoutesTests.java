import jdk.jfr.Description;
import org.testng.Assert;
import org.testng.annotations.Test;

public class AuthRoutesTests extends BasicTest{
    @Test(priority = 10)
    @Description("Test #1: Forbids visits to home url if not authenticate")
    public void forbidsVisitsToHomeUrlIfNotAuthenticate(){
        driver.get(baseUrl+"/home");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "URL doesn't contain /login");
    }
    @Test(priority = 20)
    @Description("Test #2: Forbids visits to profile url if not authenticated")
    public void forbidsVisitsToProfileUrlIfNotAuthenticated(){
        driver.get(baseUrl+"/profile");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "URL doesn't contain /login");
    }
    @Test(priority = 30)
    @Description("Test #3: Forbids visits to admin cities url if not authenticated")
    public void fobidsVisitsToAdminCitiesUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/admin/cities");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "URL doesn't contain /login");
    }
    @Test(priority = 40)
    @Description("Test #4: Forbids visits to admin users url if not authenticated")
    public void forbidsVisitsToAdminUsersUrlIfNotAuthenticated(){
        driver.get(baseUrl + "/admin/users");
        Assert.assertEquals(driver.getCurrentUrl(), baseUrl + "/login",
                "URL doesn't contain /login");
    }

}


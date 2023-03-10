import Pages.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;

public abstract class BasicTest {
    protected WebDriver driver;
    protected WebDriverWait wait;
    protected LoginPage loginPage;
    protected NavPage navPage;
    protected SignupPage signupPage;
    protected CitiesPage citiesPage;
    protected MessagePopUpPage messagePopUpPage;
    protected String baseUrl= "https://vue-demo.daniel-avellaneda.com";
    @BeforeClass
    public void BeforeClass(){
        System.setProperty("webdriver.chrome.driver",
                "drivers/chromedriver.exe");
        this.driver = new ChromeDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        loginPage=new LoginPage(driver, wait);
        navPage=new NavPage(driver,wait);
        signupPage=new SignupPage(driver,wait);
        citiesPage=new CitiesPage(driver,wait);
        messagePopUpPage=new MessagePopUpPage(driver, wait);

    }
    @BeforeMethod
    public void beforeMethod() {
        driver.get(baseUrl);
    }

    @AfterMethod
    public void afterMethod() {

    }
    @AfterClass
    public void afterClass() throws InterruptedException {
        Thread.sleep(5000);
        driver.quit();
    }


}

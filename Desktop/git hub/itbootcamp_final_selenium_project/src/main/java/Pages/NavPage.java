package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavPage extends BasePage {

    public NavPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

         public WebElement getHomeLink() {

        return driver.findElement(By.xpath("//a[contains(@class, 'btnHome')]"));
        }
        public WebElement getAboutLink() {
            return driver.findElement(By.xpath("//a[contains(@class, 'btnAbout')]"));
        }
        public WebElement getMyProfileLink() {
            return driver.findElement(By.xpath("//a[contains(@class, 'btnProfile')]"));
        }
        public WebElement getAdminButton() {
            return driver.findElement(By.className("//button[contains(@class, 'btnAdmin')]"));
        }
        public WebElement getCitesLink() {

        return driver.findElement(By.xpath("//a[@href='/admin/cities']"));
        }

        public WebElement getUsersLink() {

        return driver.findElement(By.xpath("//a[@href='/admin/users']"));
        }

    public WebElement getSignup() {

        return driver.findElement(By.xpath("//a[@href='/signup']"));
    }
        public WebElement getLoginin() {

        return driver.findElement(By.xpath("//a[@href='/login']"));
        }

        public WebElement getLogout() {

        return driver.findElement(By.className("btnLogout"));
        }
        public WebElement getLanguageButton() {

        return driver.findElement(By.className("btnLocaleActivation"));
        }
        public WebElement getENButton() {

        return driver.findElement(By.xpath("//div[@class='btnEN']"));
        }
        public WebElement getESButton() {

        return driver.findElement(By.xpath("//div[@class='btnES']"));
        }
        public WebElement getFRButton() {

        return driver.findElement(By.xpath("//div[@class='btnFR']"));
        }
        public WebElement getCNButton() {

        return driver.findElement(By.xpath("//div[@class='btnCN']"));
    }

        public WebElement getHeader(){
        return driver.findElement(By.xpath("//h1"));
    }


    }


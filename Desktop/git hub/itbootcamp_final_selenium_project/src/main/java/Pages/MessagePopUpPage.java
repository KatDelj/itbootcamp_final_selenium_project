package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MessagePopUpPage extends BasePage {

    public MessagePopUpPage(WebDriver driver, WebDriverWait wait) {
        super(driver, wait);
    }

    public void waitForPopUp(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[contains(@class, 'v-snack__wrapper')]")));
    }
    public WebElement getCloseButton() {
        return driver.findElement(By.xpath("//*[@class = 'v-snack__content']/button"));
    }

    public void waitForVerifyYourAccountDialogue(){
        wait.until(ExpectedConditions.visibilityOfElementLocated
                (By.xpath("//div[@class = 'v-card v-sheet theme--light']")));
    }
    public WebElement getTextFromVerifyYourAccount(){
        return driver.findElement(By.xpath("//div[contains(@class, 'v-card__title')]"));
    }
    public WebElement getCloseButtonFromVerifyYourAccount(){
        return driver.findElement(By.xpath("//*[@class = 'v-card v-sheet theme--light']/div[3]/button"));
    }

}

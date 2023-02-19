package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CitiesPage extends BasePage {
    public CitiesPage(WebDriver driver, WebDriverWait wait) {

        super(driver, wait);
    }

    public WebElement getNewItemButton() {

        return driver.findElement(By.className("btnNewItem"));
    }
    public WebElement getNewItemInput(){

        return driver.findElement(By.id("name"));
    }

    public WebElement getSearchInput() {

        return driver.findElement(By.id("search"));
    }

    public void waitForDialogToBeVisible() {
        wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.id("edit")));
    }

    public void waitForDeleteDialogToBeVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("delete")));
    }

    public WebElement getSaveButton() {
        return driver.findElement(By.xpath("//button[@class='BtnSave']"));
    }

    public WebElement getDeleteButton() {
        return driver.findElement(By.className("v-btn v-btn--text theme--light v-size--default red--text text--lighten3"));
    }

    public void waitForRows(int rows) {
        wait.until(ExpectedConditions.numberOfElementsToBe(By.xpath("//table/tbody//tr"), rows));
    }
    public WebElement getCell(int row, int column){
        return driver.findElement(By.xpath("table/tbody/tr[" + row + "]/td[" + column + "]"));
    }

    public WebElement getEditButton (int row){
        return driver.findElement(By.xpath("//table/tbody//tr[" + row + "]//button[@id='edit']"));
    }
    public WebElement getDeleteButton (int row){
        return driver.findElement(By.xpath("//table/tbody//tr[" + row + "]//button[@id='delete']"));
    }

}
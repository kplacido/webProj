package Pages;

import Core.DriverFactory;
import com.gargoylesoftware.htmlunit.html.Keyboard;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static Core.DriverFactory.getDriver;

public class PageBase {

    public void waitFindElement(By elemento) {
        WebDriverWait load = new WebDriverWait(getDriver(), 30);
        load.until(ExpectedConditions.visibilityOfElementLocated(elemento));
    }

    public WebElement loadWaitElement(By elemento) {
        waitFindElement(elemento);
        return getDriver().findElement(elemento);
    }

    public boolean checkIfElementVisible(By element) {
        try {
            waitFindElement(element);
            return true;
        }catch(Exception e) {
            return false;
        }
    }


    public void sendKeys(By element, String texto) {
        loadWaitElement(element).sendKeys(texto);
    }

    public void click(By element) {
        loadWaitElement(element).click();
    }

    public String getText(By element){
        return loadWaitElement(element).getText();
    }





}

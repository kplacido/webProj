package Pages;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class googlePage extends PageBase{

    By pesquisarField = By.xpath("//input[@title='Pesquisar']");

    @Test
    public void teste1() {
        sendKeys(pesquisarField,"teste123");
    }
}

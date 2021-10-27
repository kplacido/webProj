package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{
    public HomePage(WebDriver driver) {
        super(driver);
    }

    By userLoggedLabel  = By.xpath("//td[@class='login-info-left']//span[1]");
    String menus = "//td[@class='menu']/a[text()='###']";

    public String retornarUsuarioLogado(){
        return getText(userLoggedLabel);
    }

    public boolean validarOpcaoMenu(String menu){
        return checkIfElementVisible(By.xpath(menus.replace("###",menu)));
    }


}

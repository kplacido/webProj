package Pages;


import Core.DriverFactory;
import Core.ExtentReport;
import com.relevantcodes.extentreports.LogStatus;
import com.relevantcodes.extentreports.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends PageBase{


    By userNameField = By.xpath("//*[@name='username']");
    By passwordField = By.xpath("//*[@name='password']");
    By loginButton = By.xpath("//input[@value='Login']");
    By loginInvalidLabel = By.xpath("//font[text()='Your account may be disabled or blocked or the username/password you entered is incorrect.']");



    public void informarLogin (String texto) {
        sendKeys(userNameField,texto);
        ExtentReport.test.log(LogStatus.PASS, "Usuario informado");
    }
    public void informarSenha(String texto) {
        sendKeys(passwordField,texto);
    }

    public void clicarEmLogin() {
        click(loginButton);
    }

    public boolean retornarSeETelaDeLogin() {
        try {
            waitFindElement(loginInvalidLabel);
            return true;
        }catch(Exception e) {
            return false;
        }
    }
}

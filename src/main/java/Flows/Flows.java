package Flows;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Flows {
    WebDriver driver;

    public Flows (WebDriver driver) {
        this.driver = driver;
    }

    LoginPage loginPage;

    public void logar(){

        loginPage = new LoginPage(driver);

        loginPage.informarLogin("cleyton.placido");
        loginPage.informarSenha("base2");
        loginPage.clicarEmLogin();
    }

}

package Flows;

import Pages.LoginPage;
import org.openqa.selenium.WebDriver;

public class Flows {

    public Flows () {

    }

    LoginPage loginPage;

    public void logar(){

        loginPage = new LoginPage();

        loginPage.informarLogin("cleyton.placido");
        loginPage.informarSenha("base2");
        loginPage.clicarEmLogin();
    }

}

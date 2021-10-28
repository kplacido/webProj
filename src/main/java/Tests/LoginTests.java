package Tests;

import Core.DriverFactory;
import Core.Web;
import ExcelMapping.Sheet;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

import static utils.Utils.directorySheets;

public class LoginTests extends BaseTest{


    LoginPage loginPage;
    HomePage homePage;


    @Test
    public void LoginValido() {
        loginPage = new LoginPage();
        homePage = new HomePage();
        Sheet planilha = new Sheet(directorySheets("teste.xlsx"), "plan1");

        String usuario = planilha.getData("Login",1);
        String senha = planilha.getData("Senha",1);

        loginPage.informarLogin(usuario);
        loginPage.informarSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertEquals(usuario,homePage.retornarUsuarioLogado());
    }

    @Test
    public void LoginInvalido() {
        loginPage = new LoginPage();
        Sheet planilha = new Sheet(directorySheets("teste.xlsx"), "plan1");

        String usuario = planilha.getData("Login",2);
        String senha = planilha.getData("Senha",2);

        loginPage.informarLogin(usuario);
        loginPage.informarSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertTrue(loginPage.retornarSeETelaDeLogin());
    }


    @Test
    public void SenhaInvalido() {
        loginPage = new LoginPage();

        Sheet planilha = new Sheet(directorySheets("teste.xlsx"), "plan1");

        String usuario = planilha.getData("Login",3);
        String senha = planilha.getData("Senha",3);

        loginPage.informarLogin(usuario);
        loginPage.informarSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertTrue(loginPage.retornarSeETelaDeLogin());
    }
}

package Tests;

import Core.Web;
import ExcelMapping.Sheet;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;

import static utils.Utils.directorySheets;

public class LoginTests {

    WebDriver driver = Web.criaChrome();

    LoginPage loginPage;
    HomePage homePage;

    @After
    public void finalizar() {
        driver.quit();
    }


    @Test
    public void LoginValido() {
        loginPage = new LoginPage(driver);
        homePage = new HomePage(driver);
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
        loginPage = new LoginPage(driver);
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
        loginPage = new LoginPage(driver);

        Sheet planilha = new Sheet(directorySheets("teste.xlsx"), "plan1");

        String usuario = planilha.getData("Login",3);
        String senha = planilha.getData("Senha",3);

        loginPage.informarLogin(usuario);
        loginPage.informarSenha(senha);
        loginPage.clicarEmLogin();

        Assert.assertTrue(loginPage.retornarSeETelaDeLogin());
    }
}

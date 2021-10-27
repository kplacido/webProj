package Tests;

import Core.Web;
import Flows.Flows;
import Pages.HomePage;
import Pages.LoginPage;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WebDriver;

public class HomePageTests {
    WebDriver driver = Web.criaChrome();

    HomePage homePage;
    Flows flows;

    @Test
    public void validarExibicaoMenus(){

        homePage = new HomePage(driver);
        flows = new Flows(driver);

        String menuMyView = "My View";
        String menuViewIssues = "View Issues";
        String menuReportIssue = "Report Issue";
        String menuChangeLog ="Change Log";
        String menuRoadmap = "Roadmap";
        String menuMyAccount = "My Account";
        String menuLogout = "Logout";

        flows.logar();

        Assert.assertTrue(homePage.validarOpcaoMenu(menuMyView));
        Assert.assertTrue(homePage.validarOpcaoMenu(menuViewIssues));
        Assert.assertTrue(homePage.validarOpcaoMenu(menuReportIssue));
        Assert.assertTrue(homePage.validarOpcaoMenu(menuChangeLog));
        Assert.assertTrue(homePage.validarOpcaoMenu(menuRoadmap));
        Assert.assertTrue(homePage.validarOpcaoMenu(menuMyAccount));
        Assert.assertTrue(homePage.validarOpcaoMenu(menuLogout));

    }
}

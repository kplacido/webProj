package Core;
import Core.DriverFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;
import utils.*;

import static Core.DriverFactory.getDriver;


public class Web {


    public static void iniciarPagina() {



        getDriver().manage().window().maximize();

        getDriver().get("https://mantis-prova.base2.com.br/login_page.php");
        getDriver().manage().timeouts().pageLoadTimeout(15, TimeUnit.SECONDS);

    }

}

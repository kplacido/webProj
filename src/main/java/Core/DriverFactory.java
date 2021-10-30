package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class DriverFactory {

    //private static WebDriver driver;
    private static ThreadLocal<WebDriver> threadDriver = new ThreadLocal<WebDriver>(){

        @Override
        protected synchronized WebDriver initialValue(){
            return initDriver();
        }
    };

    private DriverFactory () { }

    public static WebDriver getDriver(){
        return threadDriver.get();
    }

    public static WebDriver initDriver() {
        WebDriver driver = null;

        if(Propriedades.TIPO_EXECUCAO == Propriedades.tiposExecuacao.LOCAL) {

            if (driver == null) {

                switch (Propriedades.NAVEGADOR) {
                    case CHROME:  driver = ChromeDriver();break;
                    case IE: driver = IEDriverServer();break;
                    case FIREFOX: driver = FireFox();break;
                }
            }
        }

        if(Propriedades.TIPO_EXECUCAO == Propriedades.tiposExecuacao.GRID) {

            DesiredCapabilities cap = null;
            switch (Propriedades.NAVEGADOR) {
                case CHROME: cap = DesiredCapabilities.chrome();break;
                case IE: cap = DesiredCapabilities.internetExplorer();break;
                case FIREFOX: cap = DesiredCapabilities.firefox();break;
            }

            try {
                driver = new RemoteWebDriver(new URL(" http://192.168.0.115:4444/wd/hub"),cap);
            } catch (MalformedURLException e) {
                System.err.println("falha na conexão com o GRID");
                e.printStackTrace();
            }

        }
        return driver;
    }


    public static void killDriver() {

        WebDriver driver = getDriver();
        if(driver != null) {
            driver.quit();
            driver = null;
        }
        if(threadDriver != null){
            threadDriver.remove();
        }
    }

    private static WebDriver ChromeDriver() {

        WebDriver driver;

        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver IEDriverServer() {

        WebDriver driver;

        System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/drivers/IEDriverServer.exe");

        DesiredCapabilities dc = DesiredCapabilities.internetExplorer();
        dc.setJavascriptEnabled(true);
        dc.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
        //dc.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
        dc.setCapability(InternetExplorerDriver.ENABLE_ELEMENT_CACHE_CLEANUP, true);
        dc.setCapability(InternetExplorerDriver.NATIVE_EVENTS, false);


        driver = new InternetExplorerDriver(dc);
        driver.manage().window().maximize();
        return driver;
    }

    private static WebDriver FireFox() {

        WebDriver driver;

        System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/drivers/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
        return driver;
    }
}

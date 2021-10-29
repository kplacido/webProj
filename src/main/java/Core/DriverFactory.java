package Core;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
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

        if(Propriedades.TIPO_EXECUCAO == "local") {

            if (driver == null) {
                System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/drivers/chromedriver.exe");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                return driver;
            }
        }
        if(Propriedades.TIPO_EXECUCAO == "Grid") {
            DesiredCapabilities cap;
            cap = DesiredCapabilities.chrome();
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


}

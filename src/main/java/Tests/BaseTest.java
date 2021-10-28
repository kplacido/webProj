package Tests;

import Core.DriverFactory;
import Core.Propriedades;
import Core.Web;
import org.junit.After;
import org.junit.Before;

public class BaseTest {

    @Before
    public void incial() {
        Web.iniciarPagina();
    }

    @After
    public void finalizar() {
            DriverFactory.killDriver();
    }
}

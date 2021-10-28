package Suites;

import Core.DriverFactory;
import Tests.LoginTests;
import org.junit.AfterClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTests.class})
public class LoginSuite {

    @AfterClass
    public static void fecharTudo(){
        DriverFactory.killDriver();
    }
}

package Suites;

import Core.DriverFactory;
import Core.ExtentReport;
import Tests.LoginTests;
import com.relevantcodes.extentreports.ExtentReports;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTests.class})
public class LoginSuite {

    @BeforeClass
    public static void startTest()
    {
        ExtentReport.report = new ExtentReports(System.getProperty("user.dir")+"\\report\\ExtentReportResults.html");
        ExtentReport.test = ExtentReport.report.startTest("testando report");

    }

    @AfterClass
    public static void fecharTudo(){

        DriverFactory.killDriver();
        ExtentReport.report.endTest(ExtentReport.test);
        ExtentReport.report.flush();
    }
}

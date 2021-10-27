package Suites;

import Tests.LoginTests;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({LoginTests.class})
public class LoginSuite {
}

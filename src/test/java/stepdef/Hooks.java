package stepdef;

import io.cucumber.java.After;
import io.cucumber.java.Before;


public class Hooks  extends BaseTest{
    @Before
    public void BeforeTest() {
        getDriver();
    }

    @After
    public void AfterTest() {
        driver.close();
    }
}

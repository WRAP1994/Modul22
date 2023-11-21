package stepdef;

import io.cucumber.java.en.Then;
import pages.HomePage;

import static stepdef.BaseTest.driver;

public class HomeStepDef {

    HomePage homePage;

    @Then("user is on homepage")
    public void userIsOnHomepage() {
        homePage = new HomePage(driver);
        homePage.userIsOnHomepage();
    }

    @Then("user is on homepage see error catalog")
    public void userIsOnHomepageSeeErrorCatalog() {
        homePage = new HomePage(driver);
        homePage.userIsOnHomepageSeeErrorCatalog();
    }

    @Then("user is on homepage see error one picture catalog")
    public void userIsOnHomepageSeeErrorOnePictureCatalog() {
        homePage = new HomePage(driver);
        homePage.userIsOnHomepageSeeErrorOnePictureCatalog();
    }
}

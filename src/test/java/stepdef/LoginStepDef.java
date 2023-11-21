package stepdef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

    public class LoginStepDef extends BaseTest {

        LoginPage loginPage;

        @Given("user is on login page")
        public void userIsOnLoginPage() {
            loginPage = new LoginPage(driver);
            loginPage.userIsOnLoginPage();

        }

        @And("user input username with {string}")
        public void userInputUsernameWith(String username) {
            loginPage.userInputUsernameWith(username);
        }

        @And("user input password with {string}")
        public void userInputPasswordWith(String password) {
            loginPage.userInputPasswordWith(password);
        }

        @When("user click login button")
        public void userClickLoginButton() {
            loginPage.userClickLoginButton();
        }


        @Then("user able to see error message {string}")
        public void userAbleToSeeErrorMessage(String errorMessage) {
            loginPage.userAbleToSeeErrorMessage(errorMessage);
        }
    }

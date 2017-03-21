package testing.steps;


import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import testing.pages.AuthLoggedInPage;
import testing.pages.BaseLoginPage;
import testing.pages.Basepage;





/**
 * Created by sramalin on 07/09/15.
 */
public class LoginSteps {


    protected BaseLoginPage loginPage;
    protected AuthLoggedInPage authLoggedInPage;


    @cucumber.api.java.en.Given("^I launch the app$")
    public void I_launch_the_app() throws Throwable {
        Basepage basepage = new Basepage();
        loginPage = basepage.launchApp();
        // Express the Regexp above with the code you wish you had

    }

    @When("^I login with user name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void I_login_with_user_name_and_password(String username, String password) throws Throwable {
        // Express the Regexp above with the code you wish you had
        authLoggedInPage = loginPage.doLogin(username, password);

    }

    @Then("^Home page should be loaded$")
    public void Home_page_should_be_loaded() throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("TODO : Validation for home page");
        authLoggedInPage.VerifyDisconnectButton();
        //webDriver.findElement(By.className("dropdown-toggle")).getText()
    }


}

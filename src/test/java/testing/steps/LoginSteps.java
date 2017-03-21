package testing.steps;


import cucumber.api.PendingException;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;
import testing.pages.DisconnectPage;
import testing.pages.LoginPage;
import testing.pages.BasePage;





/**
 * Created by sramalin on 07/09/15.
 */
public class LoginSteps {


    protected LoginPage loginPage;
    protected DisconnectPage disconnectPage;


    @cucumber.api.java.en.Given("^I launch the app$")
    public void I_launch_the_app() throws Throwable {
        BasePage basepage = new BasePage();
        loginPage = basepage.launchApp();
        // Express the Regexp above with the code you wish you had

    }

    @When("^I login with user name \"([^\"]*)\" and password \"([^\"]*)\"$")
    public void I_login_with_user_name_and_password(String username, String password) throws Throwable {
        // Express the Regexp above with the code you wish you had
        disconnectPage = loginPage.doLogin(username, password);

    }

    @Then("^Home page should be loaded$")
    public void Home_page_should_be_loaded() throws Throwable {
        // Express the Regexp above with the code you wish you had
        System.out.println("TODO : Validation for home page");
        Assert.assertTrue(disconnectPage.verifyDisconnectButton());
        //webDriver.findElement(By.className("dropdown-toggle")).getText()
    }


    @When("^click weibo$")
    public void clickWeibo() throws Throwable {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
    }
}

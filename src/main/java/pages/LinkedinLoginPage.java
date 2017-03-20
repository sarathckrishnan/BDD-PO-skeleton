package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for the Linkedin Login page
 * 
 * @author SESA407106
 *
 */
public class LinkedinLoginPage extends Basepage {

	public static By usernameFieldLocator = By.cssSelector("input#session_key-oauth2SAuthorizeForm"),
			signInButtonLocator = By.cssSelector("input[name='authorize']"),
			passwordFieldLocator = By.cssSelector("input#session_password-oauth2SAuthorizeForm");

	@FindBy(css = "input#session_key-oauth2SAuthorizeForm")
	private WebElement userNameField;

	@FindBy(css = "input#session_password-oauth2SAuthorizeForm")
	private WebElement passwordField;

	@FindBy(css = "input[name='authorize']")
	private WebElement signInButton;

	public LinkedinLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver,this);
	}

	/**
	 * Method to login to Linkedin using a set of test credentials and retrieve a
	 * reference to the landing page specified by the user
	 * 
	 * @param <T>
	 *            The page class for which you wish this method to return a page
	 *            object
	 * 
	 * @param pageClass
	 *            The Page class of the landing page
	 * @param creds
	 *            Credentials in the form: "username:password"
	 * @return An instance of the landing page specified by pageClass
	 */
//TODO: To review
	//	public <T> T doLogin(Class<T> pageClass, String creds) {
//		userNameField.sendKeys(creds.split(":")[0]);
//		test.takeScreenshot();
//		passwordField.sendKeys(creds.split(":")[1]);
//		test.takeScreenshot();
//		signInButton.click();
//		test.takeScreenshot();
//		BrowserUtils.waitForUrlToContain(test, "schneider-electric.com");
//		return PageFactory.getPageInstance(test, pageClass);
//	}
//
//	/**
//	 * Perform Linkedin login to Authentication and return a generic page as
//	 * required
//	 *
//	 * @param <T>
//	 *            Generic Class
//	 * @param logindata
//	 *            logindata in the form "username:password"
//	 * @param pageclass
//	 *            The class of the page you wish to land on
//	 * @param urlSubString
//	 *            A substring that must be part of the URL before page load can
//	 *            be determined
//	 * @return Instance of the default Authentication Logged In page
//	 */
//TODO: To review
//	public <T> T doLogin(String logindata, String urlSubString, Class<T> pageclass) {
//		userNameField.sendKeys(logindata.split(":")[0]);
//		test.takeScreenshot();
//		passwordField.sendKeys(logindata.split(":")[1]);
//		test.takeScreenshot();
//		// loginButton.click();
//		signInButton.click();
//		BrowserUtils.waitForUrlToContain(test, urlSubString);
//		// PageUtils.waitForPageToLoad(test);
//		return PageFactory.getPageInstance(test, pageclass);
//	}
	
}

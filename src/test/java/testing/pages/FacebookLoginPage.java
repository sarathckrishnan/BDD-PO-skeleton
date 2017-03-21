package testing.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for the Facebook Login page
 * 
 * @author SESA407106
 *
 */
public class FacebookLoginPage extends Basepage {

	public static By usernameFieldLocator = By.cssSelector("input#email"),
			signInButtonLocator = By.cssSelector("button#loginbutton"),
			passwordFieldLocator = By.cssSelector("input#pass");

	@FindBy(css = "input#email")
	private WebElement userNameField;

	@FindBy(css = "input#pass")
	private WebElement passwordField;

	@FindBy(css = "button#loginbutton")
	private WebElement signInButton;

	public FacebookLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver,this);
	}

	/**
	 * Method to login to Facebook using a set of test credentials and retrieve a
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
//TODO: TO review
	//	public AuthLoggedInPage doLogin(Class<T> pageClass, String creds) {
//		userNameField.sendKeys(creds.split(":")[0]);
//
//		passwordField.sendKeys(creds.split(":")[1]);
//
//		signInButton.click();
//
//		return new AuthLoggedInPage(webDriver);
//		////return PageFactory.getPageInstance(test, pageClass);
//	}
	
	
	/**
	 * Perform Facebook login to Authentication and return a generic page as
	 * required
	 * 
	 * @param <T>
	 *            Generic Class
	 * @param logindata
	 *            logindata in the form "username:password"
	 * @param pageclass
	 *            The class of the page you wish to land on
	 * @param urlSubString
	 *            A substring that must be part of the URL before page load can
	 *            be determined
	 * @return Instance of the default Authentication Logged In page
	 */
//	public <T> T doLogin(String logindata, String urlSubString, Class<T> pageclass) {
//		userNameField.sendKeys(logindata.split(":")[0]);
//
//		passwordField.sendKeys(logindata.split(":")[1]);
//
//		// loginButton.click();
//		signInButton.click();
//
//		// PageUtils.waitForPageToLoad(test);
//		return PageFactory.getPageInstance(test, pageclass);
//	}
	
	
}

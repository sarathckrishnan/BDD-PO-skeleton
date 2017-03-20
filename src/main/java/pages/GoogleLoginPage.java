package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for the Google Login page
 * 
 * @author SESA407106
 *
 */
public class GoogleLoginPage extends Basepage {

	public static By usernameFieldLocator = By.cssSelector("input#Email"),
			signInButtonLocator = By.cssSelector("input[name='signIn']"),
			passwordFieldLocator = By.cssSelector("input#Passwd"),
			rememberCheckBoxLocator = By.cssSelector("input#PersistentCookie");

	@FindBy(css = "input#Email")
	private WebElement userNameField;

	@FindBy(css = "input#Passwd")
	private WebElement passwordField;

	@FindBy(css = "input#signIn")
	private WebElement signInButton;

	@FindBy(css = "input#next")
	private WebElement nextButton;

	@FindBy(css = "input#PersistentCookie")
	private WebElement rememberCheckBox;

	public GoogleLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver,this);
	}

	/**
	 * Method to login to Google using a set of test credentials and retrieve a
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
//		nextButton.click();
//		passwordField.sendKeys(creds.split(":")[1]);
//		rememberCheckBox.click();
//		signInButton.click();
//		return PageFactory.getPageInstance(test, pageClass);
//	}
	
	/**
	 * Perform standard login to Authentication and return a generic page as
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
//TODO: To review
	//	public <T> T doLogin(String logindata, String urlSubString, Class<T> pageclass) {
//		userNameField.sendKeys(logindata.split(":")[0]);
//		test.takeScreenshot();
//		nextButton.click();
//		test.takeScreenshot();
//		passwordField.sendKeys(logindata.split(":")[1]);
//		test.takeScreenshot();
//		rememberCheckBox = test.getBrowser().findElement(rememberCheckBoxLocator);
//		rememberCheckBox.click();
//		test.takeScreenshot();
//		signInButton.click();
//		test.takeScreenshot();
//		BrowserUtils.waitForUrlToContain(test, urlSubString);
//		return PageFactory.getPageInstance(test, pageclass);
//	}

}

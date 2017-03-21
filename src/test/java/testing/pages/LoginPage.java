package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class LoginPage extends BasePage {


	private static By localeLinkLocator = By.cssSelector("#header-menu-country-bt"),
			languageLinkLocator = By.cssSelector("#header-menu-language-bt"),
			userNameFieldLocator = By.cssSelector("input#username"),
			passwordFieldLocator = By.cssSelector("input#password"),
			loginButtonLocator = By.cssSelector("input#loginbutton"),
			googlePlusIconLocator = By.cssSelector("a[ng-show='socialConfiguration.google']"),
			fbIconLocator = By.cssSelector("a[ng-show='socialConfiguration.facebook']"),
			twitterIconLocator = By.cssSelector("a[ng-show='socialConfiguration.twitter']"),
			linkedInIconLocator = By.cssSelector("a[ng-show='socialConfiguration.linkedin']"),
			registerIconLocator = By.xpath("//a[@class='register-now']/span/span"),
			schneiderIconLocator = By.cssSelector("span.se-log-sprite-schneider"),
			forgotPasswordLinkLocator = By.cssSelector("a.link.pull-right"),
			weiboIconLocator = By.cssSelector("a[ng-show='socialConfiguration.weibo']"),
			vkIconLocator = By.cssSelector("a[ng-show='socialConfiguration.vkontakte']"),
			okIconLocator = By.cssSelector("a[ng-show='socialConfiguration.odnoklassniki']"),
			AuthFailedError = By.xpath("//p[@class='error-login']/span/span[contains(text(), 'Authentication failed')]");

	@FindBy(css = "#header-menu-country-bt")
	private WebElement localeLink;

	@FindBy(xpath = "//span[text()='You have to enter a valid email.']")
	private WebElement emailErrormsg;

	@FindBy(xpath = "//p[@class='error-login ']")
	private WebElement errorLogin;


	private WebElement languageLink;

	@FindBy(id = "username")
	private WebElement usernameField;

	@FindBy(css = "input#password")
	private WebElement passwordField;

	@FindBy(css = "input#loginbutton")
	private WebElement loginButton;

	@FindBy(css = "a[ng-show='socialConfiguration.google']")
	private WebElement googlePlusIcon;

	@FindBy(css = "a[ng-show='socialConfiguration.facebook']")
	private WebElement fbIcon;

	@FindBy(css = "a[ng-show='socialConfiguration.twitter']")
	private WebElement twitterIcon;

	@FindBy(css = "a[ng-show='socialConfiguration.linkedin']")
	private WebElement linkedInIcon;

	@FindBy(css = "a.register-now")
	private WebElement registerIcon;

	@FindBy(css = "span.se-log-sprite-schneider")
	private WebElement schneiderIcon;

	@FindBy(css = "a.link.pull-right")
	private WebElement forgotPasswordLink;

	@FindBy(css = "a[ng-show='socialConfiguration.weibo']")
	private WebElement weiboIcon;

	@FindBy(xpath = "//p[@class='error-login ']")
	private WebElement lblAuthFailure;

	public LoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public DisconnectPage doLogin(String username, String password) {
		webDriverWait.until(ExpectedConditions.visibilityOf(usernameField));
		usernameField.sendKeys(username);
		passwordField.sendKeys(password);
		loginButton.click();
		return new DisconnectPage(webDriver);

	}


	public boolean checkFailedLogin(String logindata) {

		usernameField.sendKeys(logindata.split(":")[0]);


		passwordField.sendKeys(logindata.split(":")[1]);
		loginButton.click();

		try {
			webDriverWait.until(ExpectedConditions.visibilityOf(errorLogin));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;

		} catch (TimeoutException e1) {
			return false;
		}
	}


	public boolean checkEmailFormat(String logindata) {
		usernameField.sendKeys(logindata.split(":")[0]);
		passwordField.sendKeys(logindata.split(":")[1]);
		loginButton.click();
		try {

			webDriverWait.until(ExpectedConditions.visibilityOf(emailErrormsg));
			return true;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;

		} catch (TimeoutException e1) {
			return false;
		}

	}


	public GoogleLoginPage initiateGoogleLogin() {

		googlePlusIcon.click();
		return new GoogleLoginPage(webDriver);
	}

	public FacebookLoginPage initiateFbLogin() {
		fbIcon.click();

		return new FacebookLoginPage(webDriver);
	}

	public TwitterLoginPage initiateTwitterLogin() {
		twitterIcon.click();

		return new TwitterLoginPage(webDriver);
	}

	public LinkedinLoginPage initiateLinkedinLogin() {
		linkedInIcon.click();
		return new LinkedinLoginPage(webDriver);
	}

	public UserDetailsPage registerNewUser() {
		//PageUtils.click(test, registerIcon);
		registerIcon.click();
		//browser.findElement(registerIconLocator).click();
		return new UserDetailsPage(webDriver);

	}

	public UserDetailsPage login_ims_user(String logindata) {

		usernameField.sendKeys(logindata.split(":")[0]);
		passwordField.sendKeys(logindata.split(":")[1]);

		loginButton.click();

		//BrowserUtils.waitForUrlToContain(test, "/sign-up.jsp");
		return new UserDetailsPage(webDriver);
	}


	//Not sure about this method
	//	public BasePage initiateSELogin() {
//		schneiderIcon.click();
//	    return new DisconnectPage(webDriver);
//		//return PageFactory.getPageInstance(test, BasePage.class);
//	}

	public ForgotPasswordPage clickForgotPassword() {

		forgotPasswordLink.click();
		return new ForgotPasswordPage(webDriver);

	}

	public WeiboLoginPage initiateWeiboLogin() {
		if (weiboIcon.isDisplayed()) {
			weiboIcon.click();
		} else {
			localeLink.click();
			webDriver.findElement(By.xpath("//a[contains(text(),'China')]")).click();
			weiboIcon.click();
		}
		return new WeiboLoginPage(webDriver);
	}

	public DisconnectPage initiateVKLogin() {
		//TODO: Need to verify
		localeLink.click();
		webDriver.findElement(By.xpath("//a[contains(text(),'Россия')]")).click();
		webDriver.findElement(vkIconLocator).click();
		return new DisconnectPage(webDriver);
		//return PageFactory.getPageInstance(test, Auth.class);
	}

	public DisconnectPage initiateOKLogin() {
		//TODO: Need to verify
		localeLink.click();
		webDriver.findElement(By.xpath("//a[contains(text(),'Россия')]")).click();
		webDriver.findElement(okIconLocator).click();
		return new DisconnectPage(webDriver);

	}


	public boolean checkErrorMessage(String errormessage) {
		//Note: Not sure about this method's usage
		try {
			List<WebElement> err = webDriver.findElements(By.xpath(".//*[@id='loginbutton']/..//span[contains(text(),'" + errormessage + "')]"));
			return err.size() > 0;
		} catch (org.openqa.selenium.NoSuchElementException e) {
			return false;

		} catch (TimeoutException e1) {
			return false;
		}
	}

}
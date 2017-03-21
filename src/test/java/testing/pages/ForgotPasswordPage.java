package testing.pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Page class for Forgot Password page
 * 
 * @author SESA407106
 *
 */
public class ForgotPasswordPage extends BasePage {

	public ForgotPasswordPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
		// TODO Auto-generated constructor stub
	}

	public static By emailFieldLocator = By.cssSelector("input#email"),
			resetPasswordButtonLocator = By.cssSelector("input[id='Login.Submit']"),
			//backtologin = By.xpath("//span[text()='back to login']"),
//			backtologinLocator=By.cssSelector("a[href='https://login-sqe.pace.schneider-electric.com/startsso']"),
			backtologinLocator=By.cssSelector("a[href*='schneider-electric.com/startsso']"),
errorMsgLocator = By.cssSelector("div.error");

	@FindBy(xpath = "//span[text()='back to login']")
	private WebElement backtologin;


	@FindBy(css = "input#email")
	private WebElement emailField;

	@FindBy(css = "input[id='Login.Submit']")
	private WebElement resetPasswordButton;

	@FindBy(css = "div.error")
	private WebElement errorMsgDiv;

	public void fillEmail(String email) {
		emailField.clear();
		emailField.sendKeys(email);

	}

	public void clickResetPwd() {

		resetPasswordButton.click();
	}

	public String getErrorMessage() {
		String str = null;
		if (isErrorDisplayed()) {
			str = errorMsgDiv.getText().trim();


		}
		return str;
	}

	private boolean isErrorDisplayed() {
		return webDriver.findElement(errorMsgLocator) != null && errorMsgDiv.isDisplayed();
	}
	
	/**
	 * Click on Back to login link
	 * 
	 */
	public LoginPage backToLogin() {
			backtologin.click();
			return new LoginPage(webDriver);

	}
	
}

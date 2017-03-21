package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

public class WeiboLoginPage extends Basepage {

	public WeiboLoginPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}
	
	public static By usernamefieldLocator = By.cssSelector("input#userId");
	public static By passwordFieldLocator = By.cssSelector("input#passwd");
	public static By LoginButtonLocator = By.cssSelector("a[action-type='submit']");

	//TODO: Have changed base page to AuthLoggedInPage
	public AuthLoggedInPage doLogin(String credentials) {
		webDriver.findElement(usernamefieldLocator).sendKeys(credentials.split(":")[0]);
		webDriver.findElement(passwordFieldLocator).sendKeys(credentials.split(":")[1]);


		webDriver.findElement(LoginButtonLocator).click();

		return new AuthLoggedInPage(webDriver);
		//return PageFactory.getPageInstance(test, BasePage.class);
	}

}

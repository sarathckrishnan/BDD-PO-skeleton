package testing.pages;

import java.util.List;
import java.util.NoSuchElementException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;


public class AuthLoggedInPage extends Basepage  {

	public static By loginMessageDivLocator = By.cssSelector("div.form-group"),
			disconnectButtonLocator = By.cssSelector("a.signin-button"),
			backtologinLocator=By.cssSelector("a[href='https://login-sqe.pace.schneider-electric.com/startsso']")
			;
	
	@FindBy(css = "a.signin-button")
	private WebElement disconnectButton;

	@FindBy(css = "div.form-group")
	private WebElement loginMessageDiv;
	
	@FindBys(@FindBy(css="#header-menu-country-bt"))
	private List<WebElement> countryLink;
	
	@FindBys(@FindBy(css="#header-menu-language-bt"))
	private List<WebElement> localeLink;
	
	public AuthLoggedInPage(WebDriver webDriver) {

		this.webDriver = webDriver;
		PageFactory.initElements(webDriver,this);
		// instantiate the elements
//		disconnectButton=browser.findElement(disconnectButtonLocator);
//		loginMessageDiv=browser.findElement(loginMessageDivLocator);
	}
	

	public boolean VerifyDisconnectButton()
	{
		try{			
			disconnectButton.isDisplayed();
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}


	public BaseLoginPage dodisconnect() {
		disconnectButton.click();
		return new BaseLoginPage(webDriver);
	}
	

	public boolean VerifyCountryNotDisplayed() {
		try{			
			if(countryLink.size() ==0)
				return true;
			else
				return false;
		}catch(Exception e) {
			return false;
		}
	}
	

	public boolean VerifyLanguageNotDisplayed() {
		try{			
			if(localeLink.size() ==0)
				return true;
			else
				return false;
		}catch(Exception e) {
			return false;
		}
	}
	

	public BaseLoginPage backToLogin() {
		try{
			webDriver.findElement(backtologinLocator).click();
			return new BaseLoginPage(webDriver);
		}catch(org.openqa.selenium.WebDriverException we){
			return null;
		}
		
	}
			
}

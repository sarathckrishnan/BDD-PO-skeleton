package testing.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;


public class DisconnectPage extends BasePage  {

	public static By loginMessageDivLocator = By.cssSelector("div.form-group"),
			disconnectButtonLocator = By.cssSelector("a.signin-button"),
			backtologinLocator=By.cssSelector("a[href='startsso']")
			;
	
	@FindBy(css = "a.signin-button")
	private WebElement disconnectButton;

	@FindBy(xpath = "//span[contains(.,'Sign In')]")
	private WebElement loginMessageDiv;
	
	@FindBys(@FindBy(css="#header-menu-country-bt"))
	private List<WebElement> countryLink;


	@FindBys(@FindBy(css="#header-menu-language-bt"))
	private List<WebElement> localeLink;
	
	public DisconnectPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver,this);
	}
	

	public boolean verifyDisconnectButton() {
		webDriverWait.until(ExpectedConditions.visibilityOf(disconnectButton));
		return disconnectButton.isDisplayed();
	}


	public LoginPage dodisconnect() {
		disconnectButton.click();
		return new LoginPage(webDriver);
	}
	

	public boolean VerifyCountryNotDisplayed() {
		try{
			return countryLink.size() == 0;
		}catch(Exception e) {
			return false;
		}
	}
	

	public boolean VerifyLanguageNotDisplayed() {
		try{
			return localeLink.size() == 0;
		}catch(Exception e) {
			return false;
		}
	}
	

	public LoginPage backToLogin() {
			webDriver.findElement(backtologinLocator).click();
			return new LoginPage(webDriver);
	}
			
}

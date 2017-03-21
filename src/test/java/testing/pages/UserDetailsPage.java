package testing.pages;

import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;


public class UserDetailsPage extends BasePage {


	
	public enum FIELD_NAME {
		ADDRESS, CELL, CONF_PASSWORD, COUNTRY, EMAIL, FIRSTNAME,
		JOBFUNCTION, LANGUAGE, LASTNAME, LOCALITYNAME, PARTNERID,
		PASSWORD, PHONE, PREFCOMEMAIL, STREET, ZIPCODE, CHANNEL, SUBCHANNEL
		}



	public static By emailFieldLocator = By.cssSelector("input#email"),
			firstNameFieldLocator = By.cssSelector("input#givenName"),
			lastNameFieldLocator = By.cssSelector("input#sn"),
			submitButtonLocator = By.cssSelector("input#editprofilebutton"),
			//tncCheckboxLocator = By.cssSelector("input[@name='termsandcon']"),
			countrySelectLocator = By.cssSelector("select#country"),
			languageSelectLocator = By.cssSelector("select#language"),
			passwordFieldLocator = By.cssSelector("input#password"),
			confPasswordFieldLocator = By.cssSelector("input#password2"),
			streetFieldLocator = By.cssSelector("input#street"),
			addressfieldLocator = By.cssSelector("input#address"),
			cityFieldLocator = By.cssSelector("input#city"), 
			postalCodeFieldLocator = By.cssSelector("input#zipcode"),
			mobileFieldLocator = By.cssSelector("input#mobile"),
			workPhoneFieldLocator = By.cssSelector("input#telephone"),
			jobSelectLocator = By.cssSelector("select#jobFunction"),
			partnerIdFieldLocator = By.cssSelector("input#partnerId"),
			continueButtonSelector = By.cssSelector("input#editprofilecontinuebutton"),
			EmailPrefSelector = By.cssSelector("select#selectedEmailOptIn"),
			companyPage1 = By.cssSelector("input#company"),
			channel = By.cssSelector("select#selectedChannel"),
			subchannel = By.cssSelector("select#selectedSubchannel"),	

			//TandCHeader = By.xpath("//*[@id='categorygroup_header_title']"),
			// below locator is to be used in methods only to verify/retrieve
			// error messages
			errorDivLocator = By.xpath("//div[@class='error']"),
			fieldErrorLocator = By.xpath("following-sibling::div[@class='error']"),
			forgotPasswordLinkLocator = By.xpath("//a[@ng-href='https://login-sqe.pace.schneider-electric.com/forgot-password']")
		//	         backtologinLocator=By.cssSelector("a[href='https://login-sqe.pace.schneider-electric.com/startsso']"),
			;
	@FindBy(xpath = "//a[@ng-href='https://login-sqe.pace.schneider-electric.com/forgot-password']")
	private WebElement forgotPasswordLink;

	@FindBy(xpath = "//span[text()='Go back to login']")
	private WebElement backtologin;

	@FindBy(css = "input#email")
	private WebElement emailField;

	@FindBy(css = "input#givenName")
	private WebElement firstNameField;

	@FindBy(css = "input#sn")
	private WebElement lastNameField;
	
	@FindBy(css = "input#street")
	private WebElement street;

	@FindBy(css = "input#address")
	private WebElement address;
	
	@FindBy(css = "input#city")
	private WebElement city;

	@FindBy(css = "input#zipcode")
	private WebElement zipcode;
	
	@FindBy(css = "select#selectedEmailOptIn")
	private WebElement emailopt;

	@FindBy(css = "input#mobile")
	private WebElement mobile;
	
	@FindBy(css = "input#telephone")
	private WebElement telephone;
	
	@FindBy(css = "select#jobFunction")
	private WebElement jobFunction;
	
	@FindBy(css = "input#partnerId")
	private WebElement partnerId;
	
	@FindBy(css = "input#editprofilecontinuebutton")
	private WebElement continueButton;
	
	@FindBy(css = "input#editprofilebutton")
	private WebElement submitButton;

	@FindBy(xpath = "//input[@ng-model='termsandcon']")
	private WebElement tncCheckbox;

	@FindBy(css = "select#country")
	private WebElement countrySelect;

	@FindBy(css = "select#language")
	private WebElement languageSelect;
	
	@FindBy(css = "input#password")
	private WebElement password;
	
	@FindBy(css = "input#password2")
	private WebElement confpassword;
	
	@FindBy(css = "select#selectedChannel")
	private WebElement channel1;

	@FindBy(css = "select#selectedSubchannel")
	private WebElement subchannel1;
	
	@FindBy(css = "button#header-menu-language-bt")
	private WebElement header_lang;
	
	@FindBy(xpath = "//span[@class='checkboxStatement']/a/span/span")
	private WebElement TandClink;
	
	@FindBys(@FindBy(xpath = "//input[@ng-model='termsandcon']"))
	private List<WebElement> tandc;
	
	
	//@FindBy(xpath = "//button[@id='header-menu-language-bt']/following-sibling::ul/li/a[text()='replaceLanguage']")
	//private WebElement header_lang_value;
	
	String languageSelection = "//button[@id='header-menu-language-bt']/following-sibling::ul/li/a[text()='replaceLanguageValue']";
	
	
	public UserDetailsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver,this);
	}


	public boolean VerifyTermsAndCondNotDisplayed() {
		try{
			return tandc.size() == 0;
		}catch(Exception e) {
			return false;
		}
	}

	
	/**
	 * Method to check if any error messages are displayed on the page
	 *
	 * @return result true if Error message is displayed, false otherwise
	 */
	public boolean isErrorDisplayed() {
		boolean result;
		result = webDriver.findElements(errorDivLocator).size() > 0;
		return result;
	}

	
	/**
	 * Verify Header language button is displayed or not
	 * 
	 * @return Boolean id Header Language button is displayed
	 */
	public boolean clickLanguageButton()
	{
		try{			
			header_lang.isDisplayed();
			header_lang.click();
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	
	/**
	 * Verify Section language selected value
	 * 
	 * @return String header Language selected
	 */
	public String selectedLanguage_Header()
	{
		try{		
			////System.out.println("header_lang.getText():"+header_lang.getText());
			return header_lang.getText();
			
		}catch(NoSuchElementException e) {
			return null;
		}
	}
	
	/**
	 * Verify Header language button is displayed or not
	 * 
	 * @return Boolean id Header Language button is displayed
	 * @throws InterruptedException 
	 */
	public boolean selectLanguageHeader(String lang, String verify_value) throws InterruptedException
	{
		String newlanguageSelection = languageSelection.replace("replaceLanguageValue", lang);
		try{		
			WebElement header_lang_value = webDriver.findElement(By.xpath(newlanguageSelection));
			header_lang_value.isDisplayed();
			header_lang_value.click();
			Thread.sleep(5000);
			TandClink.click();
			Thread.sleep(20000);
			for(String winHandle : webDriver.getWindowHandles()){
				webDriver.switchTo().window(winHandle);
			}
			
			
			String pageSource = webDriver.getPageSource();
			return pageSource.contains(verify_value);
			
			
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	

	
	
	
	/**
	 *  
	 * @return Boolean id header a;anguage selection is clicked
	 * @throws UnsupportedEncodingException 
	 */
	public List<String> getHeaderLanguage() throws UnsupportedEncodingException
	{
		List<String> lst = new ArrayList<String>();
		try{	
			List<WebElement> elements = header_lang.findElements(By.xpath("following-sibling::ul/li/a"));    
		      
			for(WebElement ele : elements){
				 ////System.out.println("Language Text:"+ele.getAttribute("innerHTML"));
				 lst.add(new String(ele.getAttribute("innerHTML")));
			 }
			return lst;
		}catch(NoSuchElementException e) {
			return lst;
		}
	}


	public boolean checkErrorMessage(String errormessage) {
		try{
			List<WebElement> err = webDriver.findElements(By.xpath(".//*[@id='page']/..//span[contains(text(),'"+errormessage+"')]"));
			return err.size() > 0;
		}
		catch(org.openqa.selenium.NoSuchElementException e){
			return false;

		}
		catch(TimeoutException e1)
		{
			return false;
		}
	}

	/**
	 * Verify Submit button is displayed or not
	 *
	 * @return Boolean id Submit button is displayed
	 */
	public boolean VerifySubmitButton()
	{
		try{
			submitButton.isDisplayed();
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}

	

	public Boolean checkDisabled(FIELD_NAME feildname) {
		
		String emailatt = null;
		 
		switch (feildname) {
		case EMAIL:
			////System.out.println("emailField.getAttribute(readonly):"+emailField.getAttribute("readonly"));
			emailatt = emailField.getAttribute("readonly");
			if ((!(emailatt == null)  && !emailatt.equals("null")))
				return emailField.getAttribute("readonly").equals("true");
			else {
                return false;
               }

			case FIRSTNAME:
			//System.out.println("firstNameField.getAttribute(disabled):"+firstNameField.getAttribute("disabled"));
			return firstNameField.getAttribute("disabled").equals("true");
			
		case LASTNAME:
			//System.out.println("lastNameField.getAttribute(disabled):"+lastNameField.getAttribute("disabled"));
			return lastNameField.getAttribute("disabled").equals("true");
			

		case PASSWORD:
			return password.getAttribute("disabled").equals("true");
			
			
		case CONF_PASSWORD:
			return confpassword.getAttribute("disabled").equals("true");
					
		case STREET:
			//System.out.println("You choose STREET!"+street.getAttribute("disabled"));
			return street.getAttribute("disabled").equals("true");
			
		case ADDRESS:
			//System.out.println("You choose Address!"+address.getAttribute("disabled"));
			return address.getAttribute("disabled").equals("true");
		
		case LOCALITYNAME:
			//System.out.println("You choose city!"+city.getAttribute("disabled"));
			return city.getAttribute("disabled").equals("true");
			
		case ZIPCODE:
			//System.out.println("You choose zipcode!"+zipcode.getAttribute("disabled"));
			return zipcode.getAttribute("disabled").equals("true");
			    
		
		case PREFCOMEMAIL:
			//System.out.println("You choose emailopt!"+emailopt.getAttribute("disabled"));
			return emailopt.getAttribute("disabled").equals("true");
			

		case CELL:
			//System.out.println("You choose mobile!"+mobile.getAttribute("disabled"));
			return mobile.getAttribute("disabled").equals("true");
			
		case PHONE:
			//System.out.println("You choose telephone!"+telephone.getAttribute("disabled"));
			return telephone.getAttribute("disabled").equals("true");
			
		case JOBFUNCTION:
			//System.out.println("You choose JOBFUNCTION!"+jobFunction.getAttribute("disabled"));
			return jobFunction.getAttribute("disabled").equals("true");

		case PARTNERID:
			//System.out.println("You choose PARTNERID!"+partnerId.getAttribute("disabled"));
			return partnerId.getAttribute("disabled").equals("true");

		case LANGUAGE:
			//System.out.println("You choose languageSelect!"+languageSelect.getAttribute("disabled"));
			return languageSelect.getAttribute("disabled").equals("true");
			
		case COUNTRY:
			//System.out.println("You choose countrySelect!"+countrySelect.getAttribute("disabled"));
			return countrySelect.getAttribute("disabled").equals("true");
		case CHANNEL:
			//System.out.println("You choose CHANNEL");
			return channel1.getAttribute("disabled").equals("true");
			
		case SUBCHANNEL:
			//System.out.println("You choose SUBCHANNEL");
			return subchannel1.getAttribute("disabled").equals("true");
				
		default:
			break;
				
		 }
		return false;
	}
	

	public Boolean checkFieldDisplayed(FIELD_NAME feildname) {
		
			switch (feildname) {
		case EMAIL:
				return emailField.isDisplayed();
			
		case FIRSTNAME:
			return firstNameField.isDisplayed();
			
		case LASTNAME:
			return lastNameField.isDisplayed();
	
		case PASSWORD:
			return password.isDisplayed();
			
		case CONF_PASSWORD:
			return confpassword.isDisplayed();
					
		case STREET:
			return street.isDisplayed();
			
		case ADDRESS:
			return address.isDisplayed();
		
		case LOCALITYNAME:
			return city.isDisplayed();
			
		case ZIPCODE:
			return zipcode.isDisplayed();
			    
		case PREFCOMEMAIL:
			return emailopt.isDisplayed();

		case CELL:
			return mobile.isDisplayed();
			
		case PHONE:
			return telephone.isDisplayed();
			
		case JOBFUNCTION:
			return jobFunction.isDisplayed();

		case PARTNERID:
			return partnerId.isDisplayed();
			
		case LANGUAGE:
			return languageSelect.isDisplayed();

		case COUNTRY:
			return countrySelect.isDisplayed();
			
		case CHANNEL:
			return channel1.isDisplayed();
			
		case SUBCHANNEL:
			return subchannel1.isDisplayed();
			
		default:
			break;
				
		 }
		return false;
	}
	

	public Boolean checkFieldMandatory(FIELD_NAME feildname) {
		
	switch (feildname) {
		case EMAIL:
			//System.out.println(" checkFieldMandatory - EMAIL");
			return emailField.getAttribute("required").equals("true");
		
		case FIRSTNAME:
			//System.out.println(" checkFieldMandatory - First Name");
			return firstNameField.getAttribute("required").equals("true");
			
		case LASTNAME:
			//System.out.println(" checkFieldMandatory - Last Name");
			return lastNameField.getAttribute("required").equals("true");
	
		case PASSWORD:
			//System.out.println(" checkFieldMandatory - password");
			return password.getAttribute("required").equals("true");
			
		case CONF_PASSWORD:
			//System.out.println(" checkFieldMandatory - conf passsword");
			return confpassword.getAttribute("required").equals("true");
					
		case STREET:
			//System.out.println(" checkFieldMandatory - Street");
			return street.getAttribute("required").equals("true");
			
		case ADDRESS:
			//System.out.println(" checkFieldMandatory - Address");
			return address.getAttribute("required").equals("true");
		
		case LOCALITYNAME:
			//System.out.println(" checkFieldMandatory - city");
			return city.getAttribute("required").equals("true");
			
		case ZIPCODE:
			//System.out.println(" checkFieldMandatory - zip");
			return zipcode.getAttribute("required").equals("true");
			    
		case PREFCOMEMAIL:
			//System.out.println(" checkFieldMandatory - pref email");
			return emailopt.getAttribute("required").equals("true");
	
		case CELL:
			//System.out.println(" checkFieldMandatory - CELL - mobile");
			return mobile.getAttribute("required").equals("true");
			
		case PHONE:
			//System.out.println(" checkFieldMandatory - PHONE - telephone");
			return telephone.getAttribute("required").equals("true");
			
		case JOBFUNCTION:
			//System.out.println(" checkFieldMandatory - JOB");
			return jobFunction.getAttribute("required").equals("true");
	
		case PARTNERID:
			//System.out.println(" checkFieldMandatory - PARTNER ID");
			return partnerId.getAttribute("required").equals("true");
			
		case CHANNEL:
			//System.out.println(" checkFieldMandatory - CHANNEL");
			return channel1.getAttribute("required").equals("true");
			
		case SUBCHANNEL:
			//System.out.println(" checkFieldMandatory - SUBCHANNEL");
			return subchannel1.getAttribute("required").equals("true");
			
		case COUNTRY:
			//System.out.println(" checkFieldMandatory - COUNTRY");
			return countrySelect.getAttribute("required").equals("true");
	
		case LANGUAGE:
			//System.out.println(" checkFieldMandatory - LANGUAGE");
			return languageSelect.getAttribute("required").equals("true");
		
		default:
			break;
				
	 }
	return false;
}
	
	

	public Boolean checkErrorMessage(FIELD_NAME feildname) {
		WebElement spanele = null;
	switch (feildname) {
		case EMAIL:
			spanele = emailField.findElement(By.xpath("following-sibling::div/span"));
			//System.out.println(" checkErrorMessage - First Name "+spanele.getText());
			return spanele.getText().equals("You have to enter a valid email.");
		
		case FIRSTNAME:
			
			spanele = firstNameField.findElement(By.xpath("following-sibling::div/span"));
			//System.out.println(" ******* checkErrorMessage - First Name *********"+spanele.getText());
			return spanele.getText().equals("This field is required");
			
		case LASTNAME:
			
			spanele = lastNameField.findElement(By.xpath("following-sibling::div/span"));
			//System.out.println(" checkErrorMessage - Last Name"+spanele.getText());
			return spanele.getText().equals("This field is required");
			
	
		case PASSWORD:
			
			spanele = password.findElement(By.xpath("following-sibling::div/span"));
			//System.out.println(" checkErrorMessage - password"+spanele.getText());
			return spanele.getText().equals("The password should contain at least 8 characters.");
				
		case CONF_PASSWORD:
			
			spanele = confpassword.findElement(By.xpath("following-sibling::div/span"));
			//System.out.println(" checkErrorMessage - conf passsword "+spanele.getText());
			return spanele.getText().equals("Passwords differ.");
							
		case STREET:
			//System.out.println(" checkErrorMessage - Street");
			spanele = street.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
				
		case ADDRESS:
			//System.out.println(" checkErrorMessage - Address");
			spanele = address.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
	
		case LOCALITYNAME:
			//System.out.println(" checkErrorMessage - city");
			spanele = city.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
				
		case ZIPCODE:
			//System.out.println(" checkErrorMessage - zip");
			spanele = zipcode.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
	    
		case PREFCOMEMAIL:
			//System.out.println(" checkErrorMessage - pref email");
			spanele = emailopt.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
			
		case CELL:
			//System.out.println(" checkErrorMessage - CELL - mobile");
			spanele = mobile.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
			
		case PHONE:
			//System.out.println(" checkErrorMessage - PHONE - telephone");
			spanele = telephone.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
			
		case JOBFUNCTION:
			
			spanele = jobFunction.findElement(By.xpath("following-sibling::div/span"));
			//System.out.println(" checkErrorMessage - JOB"+spanele.getText());
			return spanele.getText().equals("This field is required");
			
		case PARTNERID:
			//System.out.println(" checkErrorMessage - PARTNER ID");
			spanele = partnerId.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
				
		case CHANNEL:
			//System.out.println(" checkErrorMessage - CHANNEL");
			spanele = channel1.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
			
		case SUBCHANNEL:
			//System.out.println(" checkErrorMessage - SUBCHANNEL");
			spanele = subchannel1.findElement(By.xpath("following-sibling::div/span"));
			return spanele.getText().equals("This field is required");
				
		case COUNTRY:
			
			spanele = countrySelect.findElement(By.xpath("following-sibling::div/span"));
			//System.out.println(" checkErrorMessage - COUNTRY "+spanele.getText());
			return spanele.getText().equals("This field is required");
			
		case LANGUAGE:
			
			spanele = languageSelect.findElement(By.xpath("following-sibling::div/span"));
			//System.out.println(" checkErrorMessage - LANGUAGE"+spanele.getText());
			return spanele.getText().equals("This field is required");
		
		default:
			break;
				
	 }
	return false;
}
	
	
	/**
	 * Verify Continue button is displayed or not
	 * 
	 * @return Boolean id Continue button is displayed
	 */
	public boolean VerifyContinueButton()
	{
		try{			
			continueButton.isDisplayed();
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	/**
	 * Click on Submit button
	 * 
	 */
	public void doSubmit() {

		submitButton.click();
	}
	
	

	/**
	 * Click on Back to login link
	 * 
	 */
	public LoginPage backToLogin() {
		try{
			backtologin.click();

			return new LoginPage(webDriver);
		}catch(org.openqa.selenium.WebDriverException we){
			return null;
		}
		
	}
	
	
	/**
	 * Click on Forgotpassword
	 * 
	 */
	public ForgotPasswordPage clickForgotPassword(){
		//System.out.println("in clickForgotPassword");
		webDriverWait.until(ExpectedConditions.visibilityOf(forgotPasswordLink));
		forgotPasswordLink.click();
		
		//List<WebElement> err = browser.findElements(By.xpath(".//*[@id='page']/..//span[contains(text(),'"+errormessage+"')]"));
		
		//System.out.println("After click forgotPasswordLinkLocator");

		//System.out.println("Waited fotr forgot password screen");
		return new ForgotPasswordPage(webDriver);

	}
	

	/**
	 * Click on tnc check box
	 * 
	 */
	public void checkTandC() {
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("return document.getElementsByClassName('fakeCheck')[0].click();");	
		
	}

	/**
	 * Click on continue button in case of 2 page registration process
	 * 
	 */
	public CompanyDetailsPage doContinue() {

		continueButton.click();
		//System.out.println("After continueButton click");
		webDriverWait.until(ExpectedConditions.visibilityOf(submitButton));
		return new CompanyDetailsPage(webDriver);

	}

	
	public void fillTestData() {
		fillEmail("z@zzz.com");
		fillFirstName("Automation");
		fillLastName("TESTER");
		fillPassword("Abcdefghi0!");
		fillConfirmPassword("Abcdefghi0!");
		fillStreet("street");
		fillCity("city");
		fillPostalCode("12345");
		fillMobileNumber("");
		fillWorkPhone("");
		selectJobFunction("Acc");
		selectLanguageByCode("en");
		selectCountryByCode("IN");
	}

	/**
	 * @param email
	 */
	public void fillEmail(String email) {

		if (emailField.isDisplayed()) {

			if (!(email == null || email.equals("null"))) {
				emailField.sendKeys(email.substring(0, email.length() - 1));
				emailField.sendKeys(email.substring(email.length() - 1));
			}
		}
	}

	/**
	 * @param firstname
	 */
	public void fillFirstName(String firstname) {
		//System.out.println("firstname:"+firstname);
		if (firstNameField.isDisplayed()) {
			firstNameField.sendKeys(firstname);

	}}

	


	public String search_Regex(String word, String search){
		String matchedText = null;
		Pattern patt = Pattern.compile(search);
		java.util.regex.Matcher mat = patt.matcher(word);
		
		while (mat.find()) {
	        int start = mat.start(0);	        
	        int end = mat.end(0);
	        matchedText = word.substring(start, end);
	      }	
		return matchedText;		
	}
	
	
	public String verifyFieldSocialLogin(String field) {
		////System.out.println("Inside fillNameSocialLogin");
			Pattern patt = Pattern.compile("var userinfo =.*;");
			String pagesource = webDriver.getPageSource();
			String matchedText = null;
			 java.util.regex.Matcher m = patt.matcher(pagesource);
		      while (m.find()) {
		        int start = m.start(0);
		        int end = m.end(0);
		        matchedText = pagesource.substring(start, end);
		     }
		      
	      	String newstr = matchedText.substring(matchedText.indexOf(field));
		    String return_string = newstr.substring(newstr.indexOf(":")+1, newstr.indexOf(","));
		    
		    return_string=return_string.replace("\"", "");
			
			 if(return_string == null || return_string.equals("null")){
				 ////System.out.println("string null - No Data");
				 return "NoData";			    	
			   }		
			 else 
			 {	
				 ////System.out.println("return data:"+return_string);
				 return return_string;
			 }
		      		      
			
	}

	/**
	 * @param lastname
	 */
	public void fillLastName(String lastname) {
		if (lastNameField.isDisplayed())
			lastNameField.sendKeys(lastname);
		}

	/**
	 * @param password
	 */
	public void fillPassword(String password) {

			WebElement loc = webDriver.findElement(passwordFieldLocator);
			if (loc.isDisplayed())
				loc.sendKeys(password);

	}

	/**
	 * @param confpassword
	 */
	public void fillConfirmPassword(String confpassword) {

			WebElement loc = webDriver.findElement(confPasswordFieldLocator);
			if (loc.isDisplayed())
				loc.sendKeys(confpassword);

	}

	/**
	 * @param street 
	 */
	public void fillStreet(String street) {
		//System.out.println("fillStreet"+street);

			WebElement loc = webDriver.findElement(streetFieldLocator);
			if (loc.isDisplayed())
				loc.sendKeys(street);				
	}
	

	public void fillAddress(String address) {
		//System.out.println("fillAddress"+address);

			WebElement loc = webDriver.findElement(addressfieldLocator);
			if (loc.isDisplayed())
				loc.sendKeys(address);

	}

	
	
	/**
	 * @param city
	 */
	public void fillCity(String city) {
		//System.out.println("fillCity"+city);

			WebElement loc = webDriver.findElement(cityFieldLocator);
			if (loc.isDisplayed())
				loc.sendKeys(city);
	}

	/**
	 * @param postalcode
	 */
	public void fillPostalCode(String postalcode) {
		//System.out.println("fillPostalCode"+postalcode);

			WebElement loc = webDriver.findElement(postalCodeFieldLocator);
			if (loc.isDisplayed())
				loc.sendKeys(postalcode);

	}

	/**
	 * @param mobilenumber
	 */
	public void fillMobileNumber(String mobilenumber) {

			WebElement loc = webDriver.findElement(mobileFieldLocator);
			if (loc.isDisplayed())
				loc.sendKeys(mobilenumber);

	}

	/**
	 * @param workphone
	 */
	public void fillWorkPhone(String workphone) {

			WebElement loc = webDriver.findElement(workPhoneFieldLocator);
			if (loc.isDisplayed())
				loc.sendKeys(workphone);

	}

	/**
	 * @param jobfunction
	 */
	public void selectJobFunction(String jobfunction) {

			WebElement loc = webDriver.findElement(jobSelectLocator);
			
			//System.out.println("Job Details:"+jobfunction+":");
			
			if (loc.isDisplayed())
				loc.sendKeys(jobfunction);
	}

	/**
	 * @param country
	 */
	public void selectCountryByName(String country) {

			WebElement loc = webDriver.findElement(countrySelectLocator);
			if (loc.isDisplayed())
				loc.sendKeys(country);
	}
	

	public void selectEmailPreference(String pref) {


			WebElement loc = webDriver.findElement(EmailPrefSelector);
			if (loc.isDisplayed())
				loc.sendKeys(pref);

	}
	
	/**
	 * @param partnerid
	 */
	public void fillPartnerId(String partnerid) {

			WebElement loc = webDriver.findElement(partnerIdFieldLocator);
			if (loc.isDisplayed())
				loc.sendKeys(partnerid);
	}
	

	public void selectchannel(String chann) {
		

			WebElement loc = webDriver.findElement(channel);
			if (loc.isDisplayed())
				loc.sendKeys(chann);
	}
	

	public void selectsubchannel(String subchan) {

			WebElement loc = webDriver.findElement(subchannel);
			if (loc.isDisplayed())
				loc.sendKeys(subchan);
			}


	public void selectCountryByCode(String countrycode) {
		Select s = new Select(webDriver.findElement(countrySelectLocator));
		s.selectByValue(countrycode);

	}
	
	/**
	 * return Selected Language in Section
	 */
	public String selectedLanguage_Section() {
		Select s = new Select(webDriver.findElement(languageSelectLocator));
		//System.out.println("Selected language in section:"+s.getFirstSelectedOption().getText());
		return s.getFirstSelectedOption().getText();
	}
	
	/**
	 * return Selected Country in Section
	 */
	public String selectedCountry_Section() {
		Select s = new Select(webDriver.findElement(countrySelectLocator));
		//System.out.println("Selected Country in section:"+s.getFirstSelectedOption().getText());
		return s.getFirstSelectedOption().getText();
	}
	

	public void selectJobfunctionByCode(String jobfunction) {
		Select s = new Select(webDriver.findElement(jobSelectLocator));
		s.selectByValue(jobfunction);

	}
	

	public void selectEmailPref(String pref) {
		Select s = new Select(webDriver.findElement(EmailPrefSelector));
		s.selectByValue(pref);

	}

	
	
	/**
	 * @param lang
	 */
	public void selectLanguageByName(String lang) {

			WebElement loc = webDriver.findElement(languageSelectLocator);
			if (loc.isDisplayed())
				loc.sendKeys(lang);

	}
	


	public void selectCompanyNamePage1(String compnamepage1) {

			WebElement loc = webDriver.findElement(companyPage1);
			if (loc.isDisplayed())
				loc.sendKeys(compnamepage1);

	}
	
	
	

	/**
	 * @param langcode
	 */
	public void selectLanguageByCode(String langcode) {
		new Select(webDriver.findElement(languageSelectLocator)).selectByValue(langcode);

	}
	
	
	/**
	 * 
	 */
	public void clickContinue() {

		continueButton.click();

	}

	/**
	 * Get the error message displayed for a particular field
	 * 
	 * @param element
	 *            The WebElement reference of the field for which the error
	 *            message needs to be retrieved
	 * @return The error message associated with the field passed as a
	 *         WebElement parameter
	 */
	/**
	 * @param element
	 * @return
	 */
	public String getErrorMessage(WebElement element) {

		WebElement errorDiv = element.findElement(fieldErrorLocator);

		return errorDiv.getText();
	}

	/**
	 * Retrieve a list of all country names as a list of Strings
	 * 
	 * @return a List of Strings containing country names - an empty ArrayList
	 *         is returned if none found
	 */
	/**
	 * @return
	 */
//TODO: To Review
	//	public List<String> getCountryList() {
//
//		List<WebElement> l = webDriver.findElement(countrySelectLocator).findElements(optionElement);
//		List<String> result = new ArrayList<String>();
//
//		for (WebElement w : l) {
//			result.add(w.getText());
//		}
//		return result;
//	}

	//Used by Social Network registration
	public void fillSocialLogin_Page2(UserProfile profile) {
	

		fillStreet(profile.getStreet());
		

		fillAddress(profile.getAddress());
		

		fillCity(profile.getCity());


		fillPostalCode(profile.getZipcode());
		

		fillMobileNumber(profile.getMobileNumber());
		

		fillWorkPhone(profile.getPhoneNumber());
		

		selectJobfunctionByCode(profile.getJobFunction());
		

		fillPartnerId(profile.getPartnerId());
		

		selectLanguageByName(profile.getLanguage());
		

		selectCountryByName(profile.getCountry());
		

		selectEmailPreference(profile.getPreferenceEmailOptIn());
		
		
	}
	
	
		//Used by Social Network registration
		public void fillSocialLogin_Page1(UserProfile profile) {


			selectCompanyNamePage1(profile.getCompanyNamePage1());
			

			selectJobfunctionByCode(profile.getJobFunction());
			

			fillPartnerId(profile.getPartnerId());
			


			selectLanguageByName(profile.getLanguage());
			

			selectCountryByName(profile.getCountry());
			

			selectEmailPreference(profile.getPreferenceEmailOptIn());
			
			
		}
		
	//Used for User Registration - Page 1
	//Email has to be filled explicitly by updating email with current date
	public void fillUserRegistration(UserProfile profile) {
			

		fillFirstName(profile.getFirstName());
		

		fillLastName(profile.getLastName());
		

		fillPassword(profile.getPassword());
		

		fillConfirmPassword(profile.getConfPassword());
		

		selectCompanyNamePage1(profile.getCompanyNamePage1());
		

		fillPartnerId(profile.getPartnerId());
					

		selectJobfunctionByCode(profile.getJobFunction());
		
//
		selectLanguageByName(profile.getLanguage());
		

		selectCountryByName(profile.getCountry());
		

		//selectEmailPreference(profile.getPreferenceEmailOptIn());
		selectEmailPref(profile.getPreferenceEmailOptIn());
		}
	
		//Used for User Registration - Page 2
	public void fillUserRegistration_Page2(UserProfile profile) {
	

		fillFirstName(profile.getFirstName());
		

		fillLastName(profile.getLastName());
		

		fillPassword(profile.getPassword());
		

		fillConfirmPassword(profile.getConfPassword());
		

		fillStreet(profile.getStreet());
		

		fillAddress(profile.getAddress());
		

		fillCity(profile.getCity());


		fillPostalCode(profile.getZipcode());
		

		fillMobileNumber(profile.getMobileNumber());
		

		fillWorkPhone(profile.getPhoneNumber());
		

		selectJobfunctionByCode(profile.getJobFunction());
		

		fillPartnerId(profile.getPartnerId());
		

		selectLanguageByName(profile.getLanguage());
		

		selectCountryByName(profile.getCountry());
		

		selectEmailPreference(profile.getPreferenceEmailOptIn());
			
	}

}

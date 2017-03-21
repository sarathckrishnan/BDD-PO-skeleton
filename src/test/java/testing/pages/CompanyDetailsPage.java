package testing.pages;

import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Registration Page 2 - Company Details
 * 
 * @author SESA407106
 *
 */
public class CompanyDetailsPage extends BasePage {


	
	public enum COMP_FIELD_NAME {
		COMPANYNAME, COMPANY_STREET, COMPANY_CITY, COMPANY_COUNTRY, COMPANY_ZIPCODE, COMPANY_STATE
	}



	public CompanyDetailsPage(WebDriver webDriver) {
		this.webDriver = webDriver;
		PageFactory.initElements(webDriver, this);
	}

	public static By companyNameFieldLocator = By.cssSelector("input#companyName"),
			companyNameECSFieldLocator = By.cssSelector("input#company_name_ecs"),
			companyStreetFieldLocator = By.cssSelector("input#company_street"),
			companyCityFieldLocator = By.cssSelector("input#company_city"),
			companyCityECSFieldLocator = By.cssSelector("input#company_city_ecs"),
			companyZipCodeLocator = By.cssSelector("input#company_zipcode"),
			companyCountrySelectLocator = By.cssSelector("select#company_country"),
			companyStateSelectLocator = By.cssSelector("select#company_state"),
			tncCheckboxLocator = By.cssSelector("input[name='termsandcon']"),
			submitButtonLocator = By.xpath("//input[@type='submit']");
	
	
	@FindBy(css = "input#companyName")
	private WebElement COMPANYNAME;
	
	@FindBy(css = "input#company_street")
	private WebElement COMPANY_STREET;

	@FindBy(css = "input#company_city")
	private WebElement COMPANY_CITY;
	
	@FindBy(css = "input#company_zipcode")
	private WebElement COMPANY_ZIPCODE;
	
	@FindBy(css = "select#company_country")
	private WebElement COMPANY_COUNTRY;
	
	@FindBy(css = "select#company_state")
	private WebElement COMPANY_STATE;


	public List<String> getCountryList() {
		//TODO: Need to remove this method
//		List<WebElement> l = webDriver.getBrowser().findElement(companyCountrySelectLocator).findElements(optionElement);
		List<String> result = new ArrayList<String>();
//
//		for (WebElement w : l) {
//			result.add(w.getText());
//		}
		return result;
	}
	

	public void checkTandC() {
		JavascriptExecutor jse = (JavascriptExecutor)webDriver;
		jse.executeScript("return document.getElementsByClassName('fakeCheck')[0].click();");	
	}
	

	public void doSubmit(){


			WebElement loc = webDriver.findElement(submitButtonLocator);
			if (loc.isDisplayed()) {
				loc.click();				
			}
	}

	
	public void fillCompanyName(String name) {

		WebElement loc = webDriver.findElement(companyNameFieldLocator);
		if (loc.isDisplayed())
			loc.sendKeys(name);
	}
	
		

	public void fillCompanyStreet(String street) {

		WebElement loc = webDriver.findElement(companyStreetFieldLocator);
		if (loc.isDisplayed())
			loc.sendKeys(street);
	}
	

	public void fillCompanyCity(String city) {

		WebElement loc = webDriver.findElement(companyCityFieldLocator);
		if (loc.isDisplayed())
			loc.sendKeys(city);
	}

	
	public void fillCompanyZip(String zip) {

		WebElement loc = webDriver.findElement(companyZipCodeLocator);
		if (loc.isDisplayed())
			loc.sendKeys(zip);
	}


	public void selectCountryByName(String country) {

			WebElement loc = webDriver.findElement(companyCountrySelectLocator);
			if (loc.isDisplayed())
				loc.sendKeys(country);

	}
	

	public Boolean checkFieldMandatory(COMP_FIELD_NAME feildname) {
		
	switch (feildname) {
		case COMPANYNAME:
			System.out.println(" checkFieldMandatory - COMPANYNAME");
			return COMPANYNAME.getAttribute("required").equals("true");
		
		case COMPANY_STREET:
			System.out.println(" checkFieldMandatory - COMPANY_STREET");
			return COMPANY_STREET.getAttribute("required").equals("true");
			
		case COMPANY_CITY:
			System.out.println(" checkFieldMandatory - COMPANY_CITY");
			return COMPANY_CITY.getAttribute("required").equals("true");
	
		case COMPANY_ZIPCODE:
			System.out.println(" checkFieldMandatory - COMPANY_ZIPCODE");
			return COMPANY_ZIPCODE.getAttribute("required").equals("true");
			
		case COMPANY_COUNTRY:
			System.out.println(" checkFieldMandatory - COMPANY_COUNTRY");
			return COMPANY_COUNTRY.getAttribute("required").equals("true");
			
		case COMPANY_STATE:
			System.out.println(" checkFieldMandatory - COMPANY_STATE");
			return COMPANY_STATE.getAttribute("required").equals("true");
		
		default:
			break;
				
	 }
	return false;
}
	

		public Boolean checkErrorMessage(COMP_FIELD_NAME feildname) {
		WebElement spanele = null;
		switch (feildname) {
			case COMPANYNAME:
				spanele = COMPANYNAME.findElement(By.xpath("following-sibling::div/span"));
				System.out.println(" checkFieldMandatory - COMPANYNAME"+spanele.getText());
				return spanele.getText().equals("This field is required");
					
			case COMPANY_STREET:				
				spanele = COMPANY_STREET.findElement(By.xpath("following-sibling::div/span"));
				System.out.println(" checkFieldMandatory - COMPANY_STREET"+spanele.getText());
				return spanele.getText().equals("This field is required");
			
			case COMPANY_CITY:
				
				spanele = COMPANY_CITY.findElement(By.xpath("following-sibling::div/span"));
				System.out.println(" checkFieldMandatory - COMPANY_CITY"+spanele.getText());
				return spanele.getText().equals("This field is required");
		
			case COMPANY_ZIPCODE:
				
				spanele = COMPANY_ZIPCODE.findElement(By.xpath("following-sibling::div/span"));
				System.out.println(" checkFieldMandatory - COMPANY_ZIPCODE"+spanele.getText());
				return spanele.getText().equals("This field is required");
				
			case COMPANY_COUNTRY:
				
				spanele = COMPANY_COUNTRY.findElement(By.xpath("following-sibling::div/span"));
				System.out.println(" checkFieldMandatory - COMPANY_COUNTRY"+spanele.getText());
				return spanele.getText().equals("This field is required");
				
			case COMPANY_STATE:
				
				spanele = COMPANY_STATE.findElement(By.xpath("following-sibling::div/span"));
				System.out.println(" checkFieldMandatory - COMPANY_STATE");
				return spanele.getText().equals("This field is required");
				
			
			default:
				break;
					
		 }
		return false;
	}
	
	
	public void fillCompanyDetails(CompanyProfile comp_profile) {
		fillCompanyName(comp_profile.getCompname());
		fillCompanyStreet(comp_profile.getStreet());
		fillCompanyCity(comp_profile.getCity());
		fillCompanyZip(comp_profile.getZipcode());
		selectCountryByName(comp_profile.getCountry());	
		
	}


	

}

package testing.pages;


public class UserProfile { 

	//These values attributes are to read data from datasource . Excel in this case (default_user_data)
	public static String EMAIL = "email", FNAME = "firstname", LNAME = "lastname", MNAME = "middlename",
			ADDRESS = "address", MNUM = "mobilenum", PHONE = "phonenum", COUNTRY = "country", STATE = "state",
			LOCALITY = "locality", PARTNER_ID = "partnerid", PREF_EMAIL_OPTIN = "preferenceEmailOptIn", ZIP = "zip",
			JOB = "jobfunc", STREET = "street", LANG = "lang", PASSWORD = "password", CONFPASSWORD = "confpassword", 
			COMPPAGE1 = "companypage1" , CHANNEL = "channel", SUBCHANNEL = "subchannel", CITY="city";

	public static String CO_NAME = "company_compname", CO_CITY = "company_city", CO_STREET = "company_street",
			CO_CURR = "company_currency", CO_STATE = "company_state", CO_COUNTRY = "company_country",
			CO_ZIP = "company_zip";
	
		

	/**
	 * The email id used to identify/create the UserProfile object (mandatory to
	 * provide)
	 */
	private String emailId;

	/**
	 * The user's first name (mandatory to provide)
	 */
	private String firstName;
	/**
	 * the user's last name (mandatory to provide)
	 */
	private String lastName;

	/**
	 * The user's middle name (optional)
	 */
	private String middleName;

	/**
	 * The user's address (optional)
	 */
	private String address;

	/**
	 * The user's mobile number (optional)
	 */
	private String mobileNumber;

	/**
	 * The user's country (optional)
	 */
	private String country;

	/**
	 * The user's jobfunction (optional)
	 */
	private String jobFunction;
	
	
	/**
	 * The user's language (optional)
	 */
	private String language;

	/**
	 * The user's locality (optional)
	 */
	private String localityName;

	/**
	 * The user's partnerid (optional)
	 */
	private String partnerId;

	/**
	 * The user's phone number (optional)
	 */
	private String phoneNumber;

	/**
	 * The user's preference for Email Opt-in features (optional)
	 */
	private String preferenceEmailOptIn;

	/**
	 * The user's state (optional)
	 */
	private String state;

	/**
	 * The user's street (optional)
	 */
	private String street;
	
	/**
	 * The user's city (optional)
	 */
	private String city;

	/**
	 * The user's zipcode (optional)
	 */
	private String zipcode;

	/**
	 * The user's company profile object
	 */
	private CompanyProfile coProfile = null;
	
	/**
	 * The user's company profile object
	 */
	private String password;
	
	/**
	 * The user's company profile object
	 */
	private String confpassword;
	
	/**
	 * The user's company name Page1
	 */
	private String comppage1;
	
	/**
	 * The user's Channel
	 */
	private String chan;
	
	/**
	 * The user's SubChannel
	 */
	private String subchan;


	/**
	 * @return the emailId
	 */
	public String getEmailId() {
		return emailId;
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @return the mobileNumber
	 */
	public String getMobileNumber() {
		return mobileNumber;
	}

	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * @return the jobFunction
	 */
	public String getJobFunction() {
		return jobFunction;
	}
	
		
	/**
	 * @return the language
	 */
	public String getLanguage() {
		return language;
	}

	/**
	 * @return the localityName
	 */
	public String getLocalityName() {
		return localityName;
	}

	/**
	 * @return the partnerId
	 */
	public String getPartnerId() {
		return partnerId;
	}

	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * @return the preferenceEmailOptIn
	 */
	public String getPreferenceEmailOptIn() {
		return preferenceEmailOptIn;
	}
	
	/**
	 * @return the company name page 1
	 */
	public String getCompanyNamePage1() {
		return comppage1;
	}
	
	/**
	 * @return the channel
	 */
	public String getChannel() {
		return chan;
	}

	/**
	 * @return the sub channel
	 */
	public String getSubChannel() {
		return subchan;
	}



	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @return the street
	 */
	public String getStreet() {
		return street;
	}
	
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @return the coProfile
	 */
	public CompanyProfile getCoProfile() {
		return coProfile;
	}

	/**
	 * @return the zipcode
	 */
	public String getZipcode() {
		return zipcode;
	}

	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * @return the confirm password
	 */
	public String getConfPassword() {
		return confpassword;
	}
	
	/**
	 * @param emailId
	 *            the emailId to set
	 */
	private void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	private void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	private void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @param middleName
	 *            the middleName to set
	 */
	private void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	private void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @param mobileNumber
	 *            the mobileNumber to set
	 */
	private void setMobileNumber(String mobileNumber) {
		this.mobileNumber = mobileNumber;
	}

	/**
	 * @param country
	 *            the country to set
	 */
	private void setCountry(String country) {
		this.country = country;
	}

	/**
	 * @param jobFunction
	 *            the jobFunction to set
	 */
	private void setJobFunction(String jobFunction) {
		this.jobFunction = jobFunction;
	}
	
	
	

	/**
	 * @param language
	 *            the language to set
	 */
	private void setLanguage(String language) {
		this.language = language;
	}

	/**
	 * @param locality
	 *            the locality Name to set
	 */
	private void setLocalityName(String locality) {
		this.localityName = locality;
	}

	/**
	 * @param partnerId
	 *            the partnerId to set
	 */
	private void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	/**
	 * @param phoneNumber
	 *            the phoneNumber to set
	 */
	private void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * @param preferenceEmailOptIn
	 *            the preferenceEmailOptIn to set
	 */
	private void setPreferenceEmailOptIn(String preferenceEmailOptIn) {
		this.preferenceEmailOptIn = preferenceEmailOptIn;
	}
	

	/**
	 * @param channel
	 *            the channel to set
	 */
	private void setChannel(String channel) {
		this.chan = channel;
	}
	

	/**
	 * @param subchannel
	 *            the subchannel to set
	 */
	private void setSubChannel(String subchannel) {
		this.subchan = subchannel;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	private void setState(String state) {
		this.state = state;
	}

	/**
	 * @param street
	 *            the street to set
	 */
	private void setStreet(String street) {
		this.street = street;
	}
	
	/**
	 * @param city
	 *            the city to set
	 */
	private void setCity(String city) {
		this.city = city;
	}


	/*private void setCoProfile(CompanyProfile coProfile) {
		this.coProfile = coProfile;
	}*/


	private void setZipcode(String zip) {
		this.zipcode = zip;
	}
	


	private void setPassword(String pwd) {
		this.password = pwd;
	}
	


	private void setConfPassword(String confpwd) {
		this.confpassword = confpwd;
	}
	

	private void setCompanyPage1(String compage1){
		this.comppage1 = compage1;
	}
	
	
	/**
	 * default constructor to be used
	 * 
	 * @param email
	 *            The email id of the profile
	 * @param firstname
	 *            The first name
	 * @param lastname
	 *            the last name
	 */
	public UserProfile(String email, String firstname, String lastname) {
		setEmailId(email);
		setFirstName(firstname);
		setLastName(lastname);
	}

	/**
	 * constructor to initialize the UserProfile object using a key for the csv
	 * lines
	 */
	public UserProfile(String dataKey) {
	//	this(dataKey, System.getProperty("user.dir") + "\\src\\test\\resources\\default_user_data.csv");
	}

	/**
	 * constructor to initialize the UserProfile object using a key for the csv
	 * file as well as it's path
	 * 
	 * @param dataKey
	 * @param filepath
	 */
//TODO: To remove
	//	public UserProfile(String dataKey, String filepath) {
//		System.out.println("filepath:"+filepath);
//		DataManager dmgr = new DataManager(filepath);
//		TestData data = dmgr.getTestData(dataKey);
//
//		setEmailId(data.getDataFor(EMAIL));
//		setFirstName(data.getDataFor(FNAME));
//		setLastName(data.getDataFor(LNAME));
//		setMiddleName(data.getDataFor(MNAME));
//		setStreet(data.getDataFor(STREET));
//		setAddress(data.getDataFor(ADDRESS));
//		setCity(data.getDataFor(CITY));
//		setZipcode(data.getDataFor(ZIP));
//
//		setCountry(data.getDataFor(COUNTRY));
//		setMobileNumber(data.getDataFor(MNUM));
//		setJobFunction(data.getDataFor(JOB));
//		setLanguage(data.getDataFor(LANG));
//		setLocalityName(data.getDataFor(LOCALITY));
//		setPartnerId(data.getDataFor(PARTNER_ID));
//		setPhoneNumber(data.getDataFor(PHONE));
//		setPreferenceEmailOptIn(data.getDataFor(PREF_EMAIL_OPTIN));
//		setPassword(data.getDataFor(PASSWORD));
//		setConfPassword(data.getDataFor(CONFPASSWORD));
//		setCompanyPage1(data.getDataFor(COMPPAGE1));
//		setChannel(data.getDataFor(CHANNEL));
//		setSubChannel(data.getDataFor(SUBCHANNEL));
//		setState(data.getDataFor(STATE));
//
//
//		coProfile=new CompanyProfile();
//		coProfile.setCompname(data.getDataFor(CO_NAME));
//		coProfile.setCity(data.getDataFor(CO_CITY));
//		coProfile.setCountry(data.getDataFor(CO_COUNTRY));
//		coProfile.setCurrency(data.getDataFor(CO_CURR));
//		coProfile.setState(data.getDataFor(CO_STATE));
//		coProfile.setStreet(data.getDataFor(CO_STREET));
//		coProfile.setZipcode(data.getDataFor(CO_ZIP));
//
//	}

}

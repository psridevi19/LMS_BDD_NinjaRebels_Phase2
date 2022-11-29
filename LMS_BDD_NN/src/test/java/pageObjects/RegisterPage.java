package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import utilities.ReadConfig;

public class RegisterPage {
	public WebDriver driver;
	
	ReadConfig config;
	@FindBy(id="registerfrom")
	WebElement registration;
	@FindBy(id="login")
	WebElement login;
	@FindBy(id="signup")
	WebElement signup;
	@FindBy(id="firstname")
	WebElement firstname;
	@FindBy(id="lastname")
	WebElement lastname;
	@FindBy(id="address")
	WebElement address;
	@FindBy(id="streetname")
	WebElement streetname;
	@FindBy(id="city")
	WebElement city;
	@FindBy(className="state")
	WebElement state;
	@FindBy(id="zip")
	WebElement zip;
	@FindBy(id="birthdate")
	WebElement birthdate;
	@FindBy(id="phonenumber")
	WebElement phonenumber;
	@FindBy(id="username")
	WebElement username;
	@FindBy(id="password")
	WebElement password;
	@FindBy(id="email")
	WebElement email;
	@FindBy(name = "warning")
	WebElement warning;
	@FindBy(name = "sucess")
	WebElement success;
	
	public RegisterPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	public String RegisterPageTitle() {
		

		String RegisterPageText = registration.getText();
		return  RegisterPageText ;
	//return driver.getTitle();
	}
	
	public void firstname(String fname) {
		firstname.sendKeys(fname);
	}
	public void lastname(String lname) {
		lastname.sendKeys(lname);
	}
	public void enteraddress(String addres) {
		address.sendKeys(addres);
	}
	public void enterstreet(String streetName) {
	  streetname.sendKeys(streetName);
	}
	public void entercity(String City) {
		city.sendKeys(City);
	}
	public void enterstate(String State) {
		state.sendKeys(State);
		}
	public void enterzip(String Zip) {
		zip.sendKeys(Zip);
	}
	public void enterbirthdate(String birthDate) {
		birthdate.sendKeys(birthDate);
	}
	public void enterphonenum(String phoneNumber) {
		phonenumber.sendKeys(phoneNumber);
	}
	
	public void enterusername(String userName) {
		username.sendKeys(userName);
	}
	
	public void enterpassword(String passWord) {
		password.sendKeys(passWord);
	}
	
	public void enteremail(String Email) {
		email.sendKeys(Email);
	}
	public void clickSignup() {
		signup.click();
	}
	public void clickLogin() {
		login.click();
	}
	public String loginFormText (String LoginFormText ) {

		String LoginText = login.getText();
		return LoginText ;
	}
	public String loginText (String loginText) {

		String Login = login.getText();
		return Login ;
	}
	
	public String signUpText (String signUpText) {

		String SignUp = signup.getText();
		return SignUp ;
	}
	
	public String warningText (String warningText) {

		String Warning = warning.getText();
		return Warning ;
	}
	public String successText (String successText) {

		String Success = success.getText();
		return Success ;
	}
	
	}

		
	
	
	
	
	




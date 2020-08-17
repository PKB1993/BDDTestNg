package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import fileReader.JsonReader;
import testRunner.CucumberRunner;

public class LoginPage extends CucumberRunner {


	public LoginPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	@FindBy(xpath = "//span[@class='login-label']")
	private WebElement loginOrRegisterOption;

	@FindBy(xpath = "//input[@id='username']")
	private WebElement userNameField;

	@FindBy(xpath = "//input[@name='password']")
	private WebElement passwordField;

	@FindBy(css = "button#login_button")
	private WebElement loginButton;
	
	@FindBy(xpath = "//span[@id='customer_name_top_menu']")
	private WebElement customerName;

	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	JsonReader jsonReader = new JsonReader();

	public void clickOnLoginOrRegisterOption() {
		new HomePage().waitForBannerLoading();
		commonMethods.click(this.loginOrRegisterOption);
	}

	public void inputUserName(String userType) {
		commonMethods.clearAndSendKeys(this.userNameField,jsonReader.getUserName(userType) );
	}

	public void inputPassword(String userType) {
		commonMethods.clearAndSendKeys(this.passwordField, jsonReader.getPassword(userType));
	}

	public void clickLoginButton() {
		commonMethods.click(loginButton);
	}

	public void verifyLogin() {
		Assert.assertTrue(genericHelper.isDisplayed(customerName));
	}

	public void enterLoginDetails(String username, String password) {
		this.inputUserName(username);
		this.inputPassword(password);
	}
	
	public void loginDetails(String username, String password) {
		this.enterLoginDetails(username,password);
		this.clickLoginButton();
	}

}

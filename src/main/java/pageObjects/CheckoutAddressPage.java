package pageObjects;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.WaitHelper;
import fileReader.JsonReader;
import testRunner.CucumberRunner;

public class CheckoutAddressPage extends CucumberRunner {

	private WebDriver driver;

	JsonReader json = new JsonReader();
	private Logger log = Logger.getLogger(CheckoutAddressPage.class.getName());

	public CheckoutAddressPage() {
		this.driver = browserFactory.getDriver();
		PageFactory.initElements(this.driver, this);
	}

	@FindBy(xpath = "//button[@class='action action-show-popup add_new_address']")
	private WebElement newAddress;

	@FindBy(xpath = "//input[@name='firstname' and @class='input-text']")
	private WebElement firstName;

	@FindBy(xpath = "//input[@name='lastname' and @class='input-text']")
	private WebElement lastName;

	@FindBy(xpath = "//input[@name='street[0]']")
	private WebElement address;

	@FindBy(xpath = "//select[@name='city']")
	private WebElement city;

	@FindBy(xpath = "//select[@name='postcode']")
	private WebElement area;

	@FindBy(xpath = "//select[@name='cn_carriercode']")
	private WebElement carrierCode;

	@FindBy(xpath = "//input[@name='contact' and @type='text']")
	private WebElement phoneNumber;

	@FindBy(xpath = "//button[@class='button action continue primary']")
	private WebElement btnDeliveryAddress;
	
	@FindBy(xpath="//div[@id='checkout-loader' or @class='loading-mask']") 
	WebElement checkoutSpinner;

	@FindBy(xpath = "//input[@id = 'shipping-save-in-address-book' and @type='checkbox']")
	private WebElement saveAddressCheckbox;
	
	@FindBy(xpath="//div[contains(@class,'shipping-address-item')]")
	private WebElement saveAddresses;
	
	@FindBy(xpath="//button[@class='action primary action-save-address']")
	private WebElement saveAddressButton;
	
	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();

	public void clickNewAddress() {
		waitHelper.waitForSpinnerInvisibility(checkoutSpinner);
		if (commonMethods.isElementPresent(saveAddresses)) {
		waitHelper.waitForElementVisible(btnDeliveryAddress);
		commonMethods.click(newAddress);
		} 
	}

	public void enterFirstName(String country) {
		commonMethods.clearAndSendKeys(firstName, json.getFirstName(country));
		log.info("First Name is entered");
	}

	public void enterLastName(String country) {
		commonMethods.clearAndSendKeys(lastName, json.getLastName(country));
		log.info("Last Name is entered");
	}

	public void enterAddress(String country) {
		commonMethods.clearAndSendKeys(address, json.getStreet(country));
		log.info("Address is entered");
	}

	public void selectCity(String country) {
		log.info("City is Value " + json.getCity(country));
		commonMethods.SelectUsingValue(city, json.getCity(country));
		log.info("City is selected");
	}

	public void selectArea(String country) {
		commonMethods.SelectUsingValue(area, json.getArea(country));
		log.info("Area is selected");
	}

	public void selectCarrierCode(String country) {
		commonMethods.SelectUsingValue(carrierCode, json.getCareerCode(country));
		log.info("Carrier Code is selected");
	}

	public void enterPhoneNumber(String country) {
		commonMethods.clearAndSendKeys(phoneNumber, json.getContactnumber(country));
		log.info("Phone Number is entered");
	}

	public void clickDeliverToAddress() {
		if (commonMethods.isElementPresent(saveAddressButton)) {
			commonMethods.click(saveAddressButton);
		}
		waitHelper.waitForSpinnerInvisibility(checkoutSpinner);
		commonMethods.click(btnDeliveryAddress);
		log.info("Delivered to this adrress button is clicked");
	}

	public void submitShippingAddress(String country) {
		this.enterFirstName(country);
		this.enterLastName(country);
		this.enterAddress(country);
		this.selectCity(country);
		this.selectArea(country);
		this.selectCarrierCode(country);
		this.enterPhoneNumber(country);
		this.clickDeliverToAddress();
	}

	public void clickSaveAddressCheckbox() {
		if (commonMethods.isElementPresent(saveAddresses)) {
		commonMethods.click(saveAddressCheckbox);
		}
	}
}

package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class PaymentPage extends CucumberRunner {

	@FindBy(xpath = "//input[@id = 'checkout-frames-card-number']")
	private WebElement txt_creditCardNumber;

	@FindBy(xpath = "//input[@id = 'checkout-frames-expiry-date']")
	private WebElement txt_creditCardExpiry;

	@FindBy(xpath = "//input[@id = 'checkout-frames-cvv']")
	private WebElement txt_creditCardCvv;

	@FindBy(xpath = "//input[@id = 'checkoutcom_card_payment']")
	private WebElement radio_creditCardPayment;

	@FindBy(xpath = "//input[@id = 'msp_cashondelivery']")
	private WebElement radio_codPayment;

	@FindBy(xpath = "//input[@id = 'tabby_checkout']")
	private WebElement radio_tabbyPayLater;

	@FindBy(xpath = "//input[@id = 'tabby_installments']")
	private WebElement radio_tabbyPayInInstallments;

	@FindBy(xpath = "//input[@id = 'checkoutcom_card_payment']/ancestor::div[contains(@class,'payment-method')][2]")
	private WebElement div_creditCardPayment;

	@FindBy(xpath = "//input[@id = 'msp_cashondelivery']/ancestor::div[contains(@class,'payment-method')][2]")
	private WebElement div_codPayment;

	@FindBy(xpath = "//input[@id = 'tabby_checkout']/ancestor::div[contains(@class,'payment-method')][2]")
	private WebElement div_tabbyPayLater;

	@FindBy(xpath = "//input[@id = 'tabby_installments']/ancestor::div[contains(@class,'payment-method')][2]")
	private WebElement div_tabbyPayInInstallments;

	@FindBy(xpath = "//button[@type = 'submit' and @class='action primary checkout button default']")
	private WebElement btn_placeOrder;

	@FindBy(xpath = "//span[@class='discount_icon']")
	private WebElement draw_couponDrawer;

	@FindBy(xpath = "//input[@id='discount-code']")
	private WebElement txt_couponCode;

	@FindBy(xpath = "//button[contains(@class,'action-apply')]")
	private WebElement btn_applyDiscount;

	@FindBy(xpath = "//input[@type='tel']")
	private WebElement txt_tabbyPhone;

	@FindBy(xpath = "//input[@placeholder='E-mail']")
	private WebElement txt_tabbyEmail;

	@FindBy(xpath = "//input[@type='tel']/following-sibling::button")
	private WebElement lnk_tabbyPhoneEdit;

	@FindBy(xpath = "//input[@placeholder='E-mail']/following-sibling::button")
	private WebElement lnk_tabbyEmailEdit;

	@FindBy(xpath = "//input[contains(@class,'Checkbox__input')]")
	private WebElement chk_tabbyTerms;

	@FindBy(xpath = "//button[contains(@class,'Button__container')]")
	private WebElement btn_tabbyCompleteOrder;

	@FindBy(xpath = "//div[contains(@class,'styles_react-code-input')]/input")
	private WebElement txt_tabbyOTP;

	WaitHelper waitHelper = new WaitHelper();
	CheckoutAddressPage checkoutAddressPage = new CheckoutAddressPage();
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();

	public PaymentPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	public String checkGetActivePayment() {
		waitHelper.waitForSpinnerInvisibility(new CheckoutAddressPage().checkoutSpinner);
		if (commonMethods.getAttribute(div_creditCardPayment, "class").contains("active")) {
			return "creditCardPayment";
		} else if (commonMethods.getAttribute(div_creditCardPayment, "class").contains("active")) {
			return "creditCardPayment";
		} else if (commonMethods.getAttribute(div_codPayment, "class").contains("active")) {
			return "codPayment";
		} else if (commonMethods.getAttribute(div_tabbyPayLater, "class").contains("active")) {
			return "tabbyPayLater";
		} else if (commonMethods.getAttribute(div_tabbyPayInInstallments, "class").contains("active")) {
			return "tabbyPayInInstallments";
		} else {
			return null;
		}
	}

	public void payUsingCreditCard(String cardnumber, String expiry, String cvv) {
		if (!checkGetActivePayment().equalsIgnoreCase("creditCardPayment")) {
			waitHelper.waitForSpinnerInvisibility(checkoutAddressPage.checkoutSpinner);
			commonMethods.click(radio_creditCardPayment);
		}
		commonMethods.clearAndSendKeys(txt_creditCardNumber, cardnumber);
		commonMethods.clearAndSendKeys(txt_creditCardExpiry, expiry);
		commonMethods.clearAndSendKeys(txt_creditCardCvv, cvv);
	}

	public void payUsingCOD() {
		if (!checkGetActivePayment().equalsIgnoreCase("codPayment")) {
			waitHelper.waitForSpinnerInvisibility(checkoutAddressPage.checkoutSpinner);
			commonMethods.click(radio_codPayment);
		}
	}

	public void payUsingTabbyPayLater(String phone, String email, String otp) {
		if (!checkGetActivePayment().equalsIgnoreCase("tabbyPayLater")) {
			waitHelper.waitForSpinnerInvisibility(checkoutAddressPage.checkoutSpinner);
			commonMethods.click(radio_tabbyPayLater);
		}
		fillTommyForm(phone, email, otp);
	}

	private void fillTommyForm(String phone, String email, String otp) {
		commonMethods.click(lnk_tabbyPhoneEdit);
		commonMethods.clearAndSendKeys(txt_tabbyPhone, phone);
		commonMethods.click(lnk_tabbyEmailEdit);
		commonMethods.clearAndSendKeys(txt_tabbyEmail, email);
		if (commonMethods.getAttribute(chk_tabbyTerms, "checked") == null) {
			commonMethods.click(chk_tabbyTerms);
		}
		commonMethods.click(btn_tabbyCompleteOrder);
		commonMethods.clearAndSendKeys(txt_tabbyOTP, otp);
	}

	public void payUsingTabbyPayInInstallments(String phone, String email, String otp) {
		if (!checkGetActivePayment().equalsIgnoreCase("tabbyPayInInstallments")) {
			waitHelper.waitForSpinnerInvisibility(checkoutAddressPage.checkoutSpinner);
			commonMethods.click(radio_tabbyPayInInstallments);
		}
		fillTommyForm(phone, email, otp);
	}

	public void payUsingTabbyPayLater() {
		if (!checkGetActivePayment().equalsIgnoreCase("tabbyPayLater")) {
			waitHelper.waitForSpinnerInvisibility(checkoutAddressPage.checkoutSpinner);
			commonMethods.click(radio_tabbyPayLater);
		}
	}

	public void payUsingTabbyPayInInstallments() {
		if (!checkGetActivePayment().equalsIgnoreCase("tabbyPayInInstallments")) {
			waitHelper.waitForSpinnerInvisibility(checkoutAddressPage.checkoutSpinner);
			commonMethods.click(radio_tabbyPayInInstallments);
		}
	}

	public void applyCoupon(String couponCode) {
		if (!genericHelper.isDisplayed(txt_couponCode)) {
			commonMethods.click(draw_couponDrawer);
		}
		commonMethods.clearAndSendKeys(txt_couponCode, couponCode);
		commonMethods.click(btn_applyDiscount);
	}

	public void clickOnPlaceOrder() {
		waitHelper.waitForSpinnerInvisibility(checkoutAddressPage.checkoutSpinner);
		commonMethods.moveToElementAndClick(btn_placeOrder);
	}

}
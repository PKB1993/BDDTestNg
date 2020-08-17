package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;
import utility.StringUtility;

public class OrderSuccess extends CucumberRunner {
	
	@FindBy(xpath = "//div[@class='checkout-success']/div[@class='title']")
	private WebElement msg_thankYou;
	
	@FindBy(xpath = "//div[@class='order-number']")
	private WebElement msg_ordernumber;
	
	@FindBy(xpath = "//a[@class='check_button']")
	private WebElement btn_continueShopping;
	
	@FindBy(xpath = "//div[@class='box-order-billing-method']//div[@class='box-content']")
	private WebElement msg_paymentMethod;
	
	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	
	public OrderSuccess(){
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	public void isOrderSuccessFull() {
		new WaitHelper().waitForElementVisible(msg_thankYou);
		Assert.assertTrue(genericHelper.isDisplayed(msg_thankYou));
	}
	
	public String getOrderNumber() {
		String ordernumber = commonMethods.getText(msg_ordernumber);
		return Integer.toString(new StringUtility().getIntValue(ordernumber)).toString();
	}
	
	public void clickOnContinueShopping() {
		commonMethods.click(btn_continueShopping);
	}
	
	public String getPaymentMethod() {
		return commonMethods.getText(msg_paymentMethod);
	}
}

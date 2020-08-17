package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class CartPage extends CucumberRunner {
	
	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();
	
	public CartPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}
	
	@FindBy(xpath = "//tr[@class='totals shipping excl']")
	private WebElement orderSummary;
	
	@FindBy(xpath = "//button[@class='action primary checkout']")
	private WebElement checkoutButton;
	
	public void clickCheckout() {
		waitHelper.waitForElementVisible(orderSummary);
		commonMethods.click(checkoutButton);
	}	
}

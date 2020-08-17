package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class PDPPage extends CucumberRunner {

	public PDPPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	@FindBy(xpath = "//select[@id='countrySize']")
	private WebElement selectCountry;

	@FindBy(xpath = "//select[@id='countrySize']/parent::div/../..//select[@class='super-attribute-select']")
	private WebElement sizeList;

	@FindBy(xpath = "//button[@id='product-addtocart-button']")
	private WebElement addToBag;

	@FindBy(xpath = "//div[@class='gallery-placeholder']")
	private WebElement productImage;

	CommonMethods commonMethods = new CommonMethods();
	WaitHelper waitHelper = new WaitHelper();

	public void selectCountry(String country) {
		waitHelper.waitForElementVisible(productImage);
		commonMethods.SelectUsingValue(selectCountry, country);
	}

	public void chooseSize(String size) {
		waitHelper.waitForElementVisible(productImage);
		commonMethods.SelectUsingVisibleText(sizeList, size);
	}

	public void clickAddToBag() {
		commonMethods.click(addToBag);
	}
}

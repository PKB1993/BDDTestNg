package pageObjects;

import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import commonHelper.GenericHelper;
import commonHelper.JavaScriptHelper;
import commonHelper.WaitHelper;
import testRunner.CucumberRunner;

public class HomePage extends CucumberRunner {

	CommonMethods commonMethods = new CommonMethods();
	GenericHelper genericHelper = new GenericHelper();
	WaitHelper waitHelper = new WaitHelper();
	JavaScriptHelper jsHelper = new JavaScriptHelper();

	public HomePage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	@FindBy(xpath = "//input[@id='search']")
	private WebElement searchProduct;

	@FindBy(xpath = "//img[@id='mainBannerImage']")
	private WebElement homePageBanner;

	@FindBy(xpath = "//div[@class='logo']//img")
	private WebElement homePageLogo;

	@FindBy(xpath = "//form[contains(@class,'active')]//span[@class='search_icon']")
	private WebElement searchIcon;

	public void searchProduct(String product) {
		commonMethods.clearAndSendKeys(searchProduct, product, Keys.ENTER);
	}

	public void verifyHomePageDisplayed() {
		Assert.assertTrue(genericHelper.isDisplayed(homePageBanner));
	}

	public void waitForBannerLoading() {
		waitHelper.staticWait(40000);
		waitHelper.waitForElementVisible(homePageLogo);
	}

}

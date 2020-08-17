package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import commonHelper.CommonMethods;
import testRunner.CucumberRunner;

public class SearhPage extends CucumberRunner {

	public SearhPage() {
		PageFactory.initElements(browserFactory.getDriver(), this);
	}

	@FindBy(xpath = "//div[@class='product_image arw-hover-actions arw-hover-image']/a")
	private WebElement productLink;

	CommonMethods commonMethods = new CommonMethods();

	public void clickProdcuctInSearchPage() {
		commonMethods.click(productLink);
	}
}

package utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Functions {
	WebDriver driver;
	ConfigReader props;
	ChromeOptions options;

	public void fclick(WebDriver dr, String ele) {

		dr.findElement(By.xpath(ele)).click();

		System.out.println("File clicked once");
	}

	public void fDoubleclick(WebDriver dr, Actions act, String ele) {

		act.doubleClick(dr.findElement(By.name(ele))).build().perform();
		dr.findElement(By.name(ele)).click();

		System.out.println("Double clicked");
	}

	public void fRightclick(WebDriver dr, Actions act, String ele) {

		act.contextClick(dr.findElement(By.name(ele))).perform();

		System.out.println("Right clicked");
	}

	public void fSendKeys(WebDriver dr, String ele, String value) {

		dr.findElement(By.name(ele)).sendKeys(value);
		System.out.println("sent value");
	}

	public boolean fDisplayed(WebDriver dr, String ele) {

		dr.findElement(By.name(ele)).isDisplayed();

		System.out.println("Displayed");
		return true;
	}

	public boolean fEnabled(WebDriver dr, String ele) {
		

		dr.findElement(By.name(ele)).isEnabled();

		System.out.println("Enabled");
		return true;
	}

	public void fwait(WebDriverWait wait, String ele) {

		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(ele)));
	}

	public void close(WebDriver dr) throws InterruptedException {
		Thread.sleep(1000);
		dr.close();
		

	}
}

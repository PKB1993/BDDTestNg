package commonHelper;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BrowserFactory {
	private static BrowserFactory instance = null;
	ThreadLocal<WebDriver> webDriver = new ThreadLocal<WebDriver>();
	ThreadLocal<String> webBrowser = new ThreadLocal<String>();
	ThreadLocal<String> country = new ThreadLocal<String>();
	ThreadLocal<String> language = new ThreadLocal<String>();

	private Logger log = Logger.getLogger(BrowserFactory.class.getName());

	/**Singleton constructor declared**/
	private BrowserFactory() {

	}

	/**Creating instance of class**/
	public static BrowserFactory getInstance() {
		new BrowserFactory().log.info("Creating Browser Factory Instance");
		if (instance == null) {
			instance = new BrowserFactory();
		}
		return instance;
	}

	/**Setting value of driver instance**/
	public final void setDriver(String browser) {
		if (browser.equalsIgnoreCase("firefox")) {
			log.info("Creating Firefox Driver Instance");
			webDriver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("chrome")) {
			log.info("Creating Chrome Driver Instance");
			ChromeOptions options = new ChromeOptions();
			options.addArguments("--disable-notifications");
			options.setExperimentalOption("useAutomationExtension", false);
			webDriver.set(new ChromeDriver(options));
		}
	}

	/**returning value of driver instance**/
	public WebDriver getDriver() {
		log.info("Returning Driver Instance");
		return webDriver.get();
	}

	/**Setting value of browser instance**/
	public final void setBrowser(String browser) {
		log.info("Creating Browser Instance " + browser);
		webBrowser.set(browser);
	}

	/**returning value of browser instance**/
	public String getBrowser() {
		log.info("Returning Browser Instance");
		return webBrowser.get();
	}

	/**Setting value of country instance**/
	public final void setCountry(String countrycode) {
		log.info("Setting Execution Country " + countrycode);
		country.set(countrycode);
	}

	/**Setting value of language instance**/
	public final void setLanguage(String languagecode) {
		log.info("Setting Execution language " + languagecode);
		language.set(languagecode);
	}

	/**returning value of country instance**/
	public String getCountry() {
		log.info("Getting Execution Country");
		return country.get();
	}

	/**returning value of language instance**/
	public String getLanguage() {
		log.info("Getting Execution language");
		return language.get();
	}
}

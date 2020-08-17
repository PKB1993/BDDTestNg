package stepdefinition;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageObjects.CartPage;
import pageObjects.CheckoutAddressPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.OrderSuccess;
import pageObjects.PDPPage;
import pageObjects.PaymentPage;
import pageObjects.SearhPage;
import testRunner.CucumberRunner;

public class Sanity extends CucumberRunner{
	
	LoginPage loginPage = new LoginPage();
	HomePage homePage = new HomePage();
	SearhPage searchPage = new SearhPage();
	PDPPage pdpPage = new  PDPPage();
	CartPage cartPage = new CartPage();
	CheckoutAddressPage checkoutAddressPage = new CheckoutAddressPage();
	PaymentPage paymentPage = new PaymentPage();
	OrderSuccess orderSuccess = new OrderSuccess();
	
	@When("^User clicks on login link$")
	public void user_clicks_on_link() {
		loginPage.clickOnLoginOrRegisterOption();
	}

	@When("^User enters valid login details \"([^\"]*)\" username and \"([^\"]*)\" password in the login popup$")
	public void user_enters_valid_login_details_and_in_the_login_popup(String username, String password) {
	    loginPage.enterLoginDetails(username,password);
	}

	@When("^User clicks on login button$")
	public void user_clicks_on_login_button() {
		loginPage.clickLoginButton();
	}

	@When("^user login is successfull$")
	public void user_login_is_successfull() {
	    loginPage.verifyLogin();
	}

	@When("^Home page is displayed$")
	public void home_page_is_displayed() {
		homePage.verifyHomePageDisplayed();
	}

	@When("^user enters product name as \"([^\"]*)\" in search text box and click search icon$")
	public void user_enters_product_name_as_in_search_text_box_and_click_search_icon(String productID) {
		homePage.searchProduct(productID);
	}

	@When("^user clicks on product tile in result$")
	public void user_clicks_on_product_tile_in_result() {
	    searchPage.clickProdcuctInSearchPage();
	}

	@When("^user selects countrySize as \"([^\"]*)\", size as \"([^\"]*)\"$")
	public void user_selects_countrySize_as_size_as(String country, String size) {
		pdpPage.selectCountry(country);
		pdpPage.chooseSize(size);
	}

	@When("^user clicks on ADDTOBAG button$")
	public void user_clicks_on_ADDTOBAG_button() {
		pdpPage.clickAddToBag();
	}

	@When("^user navigates to shopping bag page and clicks on proceedToCheckout button$")
	public void user_navigates_to_shopping_bag_page_and_clicks_on_proceedToCheckout_button() {
		 cartPage.clickCheckout();
	}

	@When("^User click on New Address$")
	public void user_click_on_New_Address() {
		checkoutAddressPage.clickNewAddress();
	}

	@When("^user enters the valid details for \"([^\"]*)\" shipping address$")
	public void user_enters_the_valid_details_for_shipping_address(String uae) {
		checkoutAddressPage.clickSaveAddressCheckbox();
		checkoutAddressPage.submitShippingAddress(uae);
	}

	@When("^user selects payment option as \"([^\"]*)\"$")
	public void user_selects_payment_option_as(String payment) {
		paymentPage.payUsingCOD();
	}

	@When("^user clicks on place order button$")
	public void user_clicks_on_place_order_button() {
		paymentPage.clickOnPlaceOrder();
	}

	@Then("^Order placing should be successful$")
	public void order_placing_should_be_successful() {
		orderSuccess.isOrderSuccessFull();
	}


}

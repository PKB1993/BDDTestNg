Feature: User loging into 6thstreet.com 

	@Smoke 
	Scenario Outline: TS01 - Registered User of 6thstreet.com UAE site should be able to place order 
	When User clicks on login link 
	When User enters valid login details "validuser" username and "validuser" password in the login popup 
	And User clicks on login button 
	And user login is successfull 
	And Home page is displayed 
	And user enters product name as "<Product>" in search text box and click search icon 
	And user clicks on product tile in result 
	And user selects countrySize as "EU", size as "10Y" 
	And user clicks on ADDTOBAG button 
	And user navigates to shopping bag page and clicks on proceedToCheckout button 
	And User click on New Address 
	And user enters the valid details for "uae" shipping address 
	And user selects payment option as "COD" 
	And user clicks on place order button 
	Then Order placing should be successful 
	
	Examples: 
		| URL                 |Product                   |CountrySize|Size|Qty|
		| SixthStreetUAEENurl |LCW-8S7179Z4-LCW-TURQUOIS |EU|10Y|1| 
		
		

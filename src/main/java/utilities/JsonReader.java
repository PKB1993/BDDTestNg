package utilities;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;



public class JsonReader {

	private Logger log = Logger.getLogger(JsonReader.class.getName());

	/**this method reads json array from file**/
	private JSONArray readJson() {
		log.info("Reading JSON Array");
		JSONParser jsonParser = new JSONParser();
		Object obj = null;
		try {
			FileReader reader = new FileReader("./src/test/resources/TestData/TestData.json");
			obj = jsonParser.parse(reader);
		} catch (Exception e) {
			e.printStackTrace();
		}

		JSONArray dataList = (JSONArray) obj;
		
		return dataList;
	}
	
	/**this method returns user login details**/
	private List<String> getUserLogin(String userType) {
			log.info("Getting user login for type "+userType);
			JSONObject users = (JSONObject)readJson().get(0);
			JSONObject userdata = ((JSONObject)users.get("users"));
			JSONObject user = null;
			if (userType.equalsIgnoreCase("validuser")) {
				user = (JSONObject) userdata.get("validuser");
			} else if (userType.equalsIgnoreCase("invaliduser")){
				user = (JSONObject) userdata.get("invaliduser");
			} else if (userType.equalsIgnoreCase("clubuser")){
				user = (JSONObject) userdata.get("clubuser");
			} else {
				try {
					throw new Exception("Invalid User Type Requested");
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			String username = (String) user.get("username");
			String password = (String) user.get("password");
			
			List <String>userdetail = new ArrayList<String>();
			userdetail.add(username);
			userdetail.add(password);
			return userdetail;
		}
	
	/**this method returns user name**/
	public String getUserName(String userType) {
		log.info("Getting user name for type "+userType);
		return getUserLogin(userType).get(0);
	}
	
	/**this method returns password**/
	public String getPassword(String userType) {
		log.info("Getting user password for type "+userType);
		return getUserLogin(userType).get(1);
	}
	
	/**this method returns credit card details**/
	private List<String> getCreditCardDetails(String cardType) {
		log.info("Getting card details for type "+cardType);
		JSONObject payments = (JSONObject)readJson().get(0);
		JSONObject paymentdata = ((JSONObject)payments.get("creditcard"));
		JSONObject card = null;
		if (cardType.equalsIgnoreCase("visa")) {
			card = (JSONObject) paymentdata.get("visa");
		} else if(cardType.equalsIgnoreCase("master")) {
			card = (JSONObject) paymentdata.get("master");
		} else if(cardType.equalsIgnoreCase("amex")){
			card = (JSONObject) paymentdata.get("amex");
		} else {
			try {
			throw new Exception("Invalid Card Type Requested");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String cardnumber = (String) card.get("cardnumber");
		String cvv = (String) card.get("cvv");
		
		List <String>userdetail = new ArrayList<String>();
		userdetail.add(cardnumber);
		userdetail.add(cvv);
		return userdetail;
	}

	/**this method returns credit card nuber**/
	public String getCardnumber(String cardType) {
		log.info("Getting card number for type "+cardType);
		return getCreditCardDetails(cardType).get(0);
	}
	
	/**this method returns credit card cvv**/
	public String getCVV(String cardType) {
		log.info("Getting card CVV for type "+cardType);
		return getCreditCardDetails(cardType).get(1);
	}
	
	/**this method returns address details**/
	private List<String> getAddressDetails(String country) {
		log.info("Getting address details for country "+country);
		JSONObject countries = (JSONObject)readJson().get(0);
		JSONObject addressdata = ((JSONObject)countries.get("addresses"));
		JSONObject value = null;
		if (country.equalsIgnoreCase("uae")) {
			value = (JSONObject) addressdata.get("uae");
		} else if(country.equalsIgnoreCase("ksa")) {
			value = (JSONObject) addressdata.get("ksa");
		} else if (country.equalsIgnoreCase("kw")) {
			value = (JSONObject) addressdata.get("kw");
		} else if(country.equalsIgnoreCase("om")) {
			value = (JSONObject) addressdata.get("om");
		} else if (country.equalsIgnoreCase("qa")) {
			value = (JSONObject) addressdata.get("qa");
		} else if(country.equalsIgnoreCase("bh")) {
			value = (JSONObject) addressdata.get("bh");
		}else {
			try {
			throw new Exception("Invalid Address Type Requested");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		String firstname = (String) value.get("firstname");
		String lastname = (String) value.get("lastname");
		String street = (String) value.get("street");
		String city = (String) value.get("city");
		String area = (String) value.get("area");
		String careercode = (String) value.get("careercode");
		String contactnumber = (String) value.get("contactnumber");
		
		List <String>userdetail = new ArrayList<String>();
		userdetail.add(firstname);
		userdetail.add(lastname);
		userdetail.add(street);
		userdetail.add(city);
		userdetail.add(area);
		userdetail.add(careercode);
		userdetail.add(contactnumber);
		return userdetail;
	}

	/**this method returns first name**/
	public String getFirstName(String country) {
		log.info("Getting address first name for country "+country);
		return getAddressDetails(country).get(0);
	}
	
	/**this method returns last name**/
	public String getLastName(String country) {
		log.info("Getting address last name for country "+country);
		return getAddressDetails(country).get(1);
	}
	
	/**this method returns street name**/
	public String getStreet(String country) {
		log.info("Getting address street for country "+country);
		return getAddressDetails(country).get(2);
	}
	
	/**this method returns city**/
	public String getCity(String country) {
		log.info("Getting address city  for country "+country);
		return getAddressDetails(country).get(3);
	}
	
	/**this method returns area**/
	public String getArea(String country) {
		log.info("Getting address area for country "+country);
		return getAddressDetails(country).get(4);
	}
	
	/**this method returns career code**/
	public String getCareerCode(String country) {
		log.info("Getting address career code for country "+country);
		return getAddressDetails(country).get(5);
	}
	
	/**this method returns phone number**/
	public String getContactnumber(String country) {
		log.info("Getting address contact number for country "+country);
		return getAddressDetails(country).get(6);
	}
	
	
}

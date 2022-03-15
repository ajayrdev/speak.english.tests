package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import automation.utilities.SeleniumUtils;

public class GuruRegisterPage {

	WebDriver driver;
	SeleniumUtils utils;

	public static By first_Name = By.xpath("//input[@name='firstName']");
	public static By last_Name = By.xpath("//input[@name='lastName']");
	public static By phone = By.xpath("//input[@name='phone']");
	public static By emailId = By.xpath("//input[@id='userName']");
	public static By address = By.xpath("//input[@name='address1']");
	public static By city = By.xpath("//input[@name='city']");
	public static By state = By.xpath("//input[@name='state']");
	public static By postal_Code = By.xpath("//input[@name='postalCode']");
	public static By country = By.xpath("//select[@name='country']");
	public static By submit = By.xpath("//input[@name='submit']");
	public static By validation_Msg = By.xpath("//font[contains(text(),'Thank you for registering')]");

	public static By selenium_menu = By.partialLinkText("Selenium");
	public static By insurance_Project = By.xpath("//a[text()='Insurance Project']");
	public static By agile_Project = By.xpath("//a[text()='Agile Project']");
	public static By bank_Project = By.xpath("//a[text()='Bank Project']");
	public static By security_Project = By.xpath("//a[text()='Security Project']");
	public static By telecom_Project = By.xpath("//a[text()='Telecom Project']");
	public static By paymentGateway_Project = By.xpath("//a[text()='Payment Gateway Project']");
	public static By new_tours = By.xpath("//a[text()='New Tours']");
	public static By SEO_menu = By.partialLinkText("SEO");

	public GuruRegisterPage(SeleniumUtils utils, WebDriver driver) {
		this.utils = utils;
		this.driver = driver;

	}

	public void launchGuruRegisterPage(String appUrl) {

		driver.get(appUrl);
	}

	public void enterRegistrationDetails(String firstName, String lastName, String phoneNumbber, String email,
			String addressDetails, String cityName, String stateName, String postalCode) {

		utils.enterText(first_Name, firstName);
		utils.enterText(last_Name, lastName);
		utils.enterText(phone, phoneNumbber);
		utils.enterText(emailId, email);
		utils.enterText(address, addressDetails);
		utils.enterText(city, cityName);
		utils.enterText(state, stateName);
		utils.enterText(postal_Code, postalCode);

	}

	public void selectCountryByValue(String value) {
		utils.selectByValue(country, value);

	}

	public void clickSubmitButton() {

		utils.clickElement(submit);
	}

	public String displayMsg() {

		return utils.getText(validation_Msg);
	}

	public boolean guruWebPageMenuOptions() {

		boolean isMenusVerifed = false;
		if (utils.isDisplayed(selenium_menu) && utils.isDisplayed(insurance_Project) && utils.isDisplayed(agile_Project) && utils.isDisplayed(bank_Project)
				&& utils.isDisplayed(paymentGateway_Project) && utils.isDisplayed(security_Project)
				&& utils.isDisplayed(telecom_Project) && utils.isDisplayed(new_tours) && utils.isDisplayed(SEO_menu)) {

			isMenusVerifed = true;
		} else {
			System.out.println(utils.isDisplayed(insurance_Project));
			System.out.println(utils.isDisplayed(agile_Project));
			System.out.println(utils.isDisplayed(bank_Project));
			System.out.println(utils.isDisplayed(paymentGateway_Project));
			System.out.println(utils.isDisplayed(security_Project));
			System.out.println(utils.isDisplayed(telecom_Project));
			System.out.println(utils.isDisplayed(new_tours));
			System.out.println("Page Menu Options are mismatched");
		}

		return isMenusVerifed;

	}
}
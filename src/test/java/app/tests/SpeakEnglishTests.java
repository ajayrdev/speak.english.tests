package app.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import app.pages.AutomationBookStorePage;
import app.pages.CosmocodeWebTable;
import app.pages.DorpDownPage;
import app.pages.FlipKartPage;
import app.pages.GuruRegisterPage;
import app.pages.SpeakEnglishHome;
import app.pages.SpeakEnglishLogin;
import app.pages.TechlistIcWebPage;
import app.pages.W3SchoolsWebTable;
import automation.utilities.SeleniumUtils;

public class SpeakEnglishTests {

	SpeakEnglishLogin loginPage;
	SpeakEnglishHome homePage;
	W3SchoolsWebTable webTablePage;
	CosmocodeWebTable webTable;
	TechlistIcWebPage TechlistPage;
	AutomationBookStorePage AutomationPage;
	GuruRegisterPage GuruWebPage;

	DorpDownPage dropdown;
	SeleniumUtils utils;
	WebDriver driver;
	Properties prop;

	FlipKartPage fkp;
	

	@BeforeClass
	public void loadData() throws Exception {
		String baseDirecoty = System.getProperty("user.dir");
		String fileRealativePath = "\\src\\test\\resources\\logindetails.properties";
		FileInputStream fis = new FileInputStream(baseDirecoty + fileRealativePath);
		prop = new Properties();
		prop.load(fis);
		
	}

	@BeforeMethod
	public void setup() {
		utils = new SeleniumUtils();
		driver = utils.getDriver();
		loginPage = new SpeakEnglishLogin(utils, driver);
		homePage = new SpeakEnglishHome(utils, driver);
		webTablePage = new W3SchoolsWebTable(utils, driver);
		webTable = new CosmocodeWebTable(utils, driver);
		TechlistPage = new TechlistIcWebPage(utils, driver);
		AutomationPage = new AutomationBookStorePage(utils, driver);
		dropdown = new DorpDownPage(utils, driver);
		GuruWebPage = new GuruRegisterPage(utils, driver);
		fkp = new FlipKartPage(utils, driver);
		
	}

	@Test(enabled = true)
	public void verifyViewAllFK() {

		try {
			String Url = prop.getProperty("FlipkartUrl");
			
			fkp.launchFlipkartWebPage(Url);
			fkp.closeLoginWindow();
			
			fkp.scrolltoViewAll();
			
			fkp.clickOnViewAll();
			
			utils.waitForPageToLoad();
			Assert.assertEquals(fkp.viewAllProducts().size() > 1, true);
			
		} catch (Exception e) {
			
		}
	}

	@Test(enabled = false)
	public void verifyInvalidUser() {

		String Url = prop.getProperty("appUrl");
		String userId = prop.getProperty("invalidUserEmail");
		String userPassword = prop.getProperty("invaliduserPwd");
		String errorMsg = prop.getProperty("errorMessage");

		loginPage.launchSpeakEnglishPage(Url); // "https://www.speaklanguages.com/"
		loginPage.clickLoginOnLandingPage();
		loginPage.enterLoginDetails(userId, userPassword);
		loginPage.clickSignInButton();
		String errorMessage = loginPage.getLoginErrorDetails();
		Assert.assertEquals(errorMessage.contains(errorMsg), false, errorMsg);
	}

	@Test(priority = 2, enabled = false)
	public void verifyValidUser() throws Exception {

		String Url = prop.getProperty("appUrl");
		String userId = prop.getProperty("userEmail");
		String userPassword = prop.getProperty("userPwd");
		String loggedInUser = prop.getProperty("loggedInuser");
		String validationMsg = prop.getProperty("validationMsg");

		loginPage.launchSpeakEnglishPage(Url);
		loginPage.clickLoginOnLandingPage();
		loginPage.enterLoginDetails(userId, userPassword);
		loginPage.clickSignInButton();
		String userName = homePage.getLogedUserName();
		Assert.assertEquals(userName.contains(loggedInUser), true, validationMsg);
	}

	@Test(priority = 1, enabled = false)
	public void verifyImagesOnLandingPage() {
		String Url = prop.getProperty("appUrl");
		loginPage.launchSpeakEnglishPage(Url);
		loginPage.verifyImages();

	}

	@Test(priority = 1, enabled = false)
	public void verifyWebTable() {
		String Url = prop.getProperty("webtable");
		webTablePage.launchW3SchoolsTable(Url);
		webTablePage.printTableData();
		Assert.assertEquals(webTablePage.printTableData(2, 1).equals("Alfreds Futterkiste"), true,
				"CellData verifcation failed");
		Assert.assertEquals(webTablePage.printTableData(7, 3).equals("Italy"), true, "CellData verifcation failed");
		Assert.assertEquals(webTablePage.verifyCellData("Canada"), true, "CellData verifcation failed");
	}

	@Test(enabled = false)
	public void verifyCosmocodeWebTable() {
		String Url = prop.getProperty("CosmocodeWebTable");
		webTable.launchCosmocodeWebTable(Url);
		webTable.printTableData();

	}

	@Test(enabled = false)
	public void verifyTechlistIcWebTable() {

		String Url = prop.getProperty("TechlistWebUrl");
		TechlistPage.launchTechlistIcTable(Url);
		TechlistPage.printTableData();
	}

	@Test(enabled = false)
	public void verifyTableData() {
		String Url = prop.getProperty("TechlistWebUrl");
		TechlistPage.launchTechlistIcTable(Url);
		TechlistPage.printTableData();
	}

	@Test(enabled = false)
	public void verifySearchBook() throws InterruptedException {
		String searchText = prop.getProperty("searchText");
		String Url = prop.getProperty("automationBookStoreUrl");
		AutomationPage.AutomationBookStoreLaunch(Url);
		AutomationPage.searchTextBook(searchText);
	}

	@Test(enabled = false)
	public void verifyAutomationPageTitle() {
		String Url = prop.getProperty("automationBookStoreUrl");
		AutomationPage.AutomationBookStoreLaunch(Url);
		AutomationPage.AutomationPageTitle("Automation Bookstore");
		AutomationPage.verifyHeading("Automation Bookstore");
		AutomationPage.AutomationPageUrl("automationbookstore.dev");
	}

	@Test(enabled = false)
	public void verifyCountryDropdown() throws InterruptedException {

		String Url = prop.getProperty("dropDownUrl");
		dropdown.launchDropDownApp(Url);
		dropdown.waitTime(2);
		dropdown.selectCountryByValue("ANGOLA");
		dropdown.waitTime(2);
		dropdown.selectCountryByVisbleText("ANDORRA");
		dropdown.waitTime(2);
		dropdown.selectCountryselectByIndex(2);
		dropdown.waitTime(2);
	}

	@Test(enabled = false)
	public void verifyGuruRegistrationPage() {
		String Url = prop.getProperty("guruWebPageUrl");
		String firstName = prop.getProperty("firstName");
		String lastName = prop.getProperty("lastName");
		String phoneNumber = prop.getProperty("phoneNumber");
		String email = prop.getProperty("email");
		String address = prop.getProperty("address");
		String city = prop.getProperty("city");
		String state = prop.getProperty("state");
		String postalCode = prop.getProperty("postalCode");
		String expectedMsg = prop.getProperty("validationMsg");

		GuruWebPage.launchGuruRegisterPage(Url);
		GuruWebPage.enterRegistrationDetails(firstName, lastName, phoneNumber, email, address, city, state, postalCode);
		GuruWebPage.selectCountryByValue("AUSTRALIA");
		GuruWebPage.clickSubmitButton();
		// if Assertion fails, testcase will be stopped and close the driver
		Assert.assertEquals(GuruWebPage.displayMsg().contains(expectedMsg), true, "Registration failed");

		// verification, it will go to next step even if a particular step is failed
	}

	@Test(enabled = false)
	public void verifyMenuOptions() {
		String Url = prop.getProperty("guruWebPageUrl");
		GuruWebPage.launchGuruRegisterPage(Url);
		Assert.assertEquals(GuruWebPage.guruWebPageMenuOptions(), true, "Guru Web Menu Options verification failed");
	}

	@AfterMethod
	public void tearDown() {
		utils.captureScreenshot();
		utils.closeBroswer();
		
	}
}

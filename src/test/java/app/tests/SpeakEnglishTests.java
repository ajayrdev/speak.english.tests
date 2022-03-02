package app.tests;

import java.io.FileInputStream;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import app.pages.SpeakEnglishHome;
import app.pages.SpeakEnglishLogin;
import automation.utilities.SeleniumUtils;

public class SpeakEnglishTests {

	SpeakEnglishLogin loginPage;
	SpeakEnglishHome homePage;
	SeleniumUtils utils;
	WebDriver driver;
	Properties prop;

	@BeforeClass
	public void loadData() throws Exception {
		String baseDirecoty = System.getProperty("user.dir");
		String fileRealativePath = "\\src\\test\\resources\\logindetails.properties";
		FileInputStream fis = new FileInputStream (baseDirecoty+fileRealativePath);
		prop = new Properties();
		prop.load(fis);
	}

	@BeforeMethod
	public void setup() {
		utils = new SeleniumUtils();
		driver = utils.getDriver();
		loginPage = new SpeakEnglishLogin(utils, driver);
		homePage = new SpeakEnglishHome(utils, driver);
	}

	@Test(priority = 3)
	public void verifyInvalidUser() {
		
		String Url = prop.getProperty("appUrl");
		String userId = prop.getProperty("invalidUserEmail");
		String userPassword = prop.getProperty("invaliduserPwd");
		String errorMsg = prop.getProperty("errorMessage");
	

		loginPage.launchSpeakEnglishPage(Url); // "https://www.speaklanguages.com/"
		loginPage.clickLoginOnLangingPage();
		loginPage.enterLoginDetails(userId, userPassword);
		loginPage.clickSignInButton();
		String errorMessage = loginPage.getLoginErrorDetails();
		Assert.assertEquals(errorMessage.contains(errorMsg), false,
				errorMsg);
	}

	@Test(priority = 2)
	public void verifyValidUser() throws Exception {
		
		String Url = prop.getProperty("appUrl");
		String userId = prop.getProperty("userEmail");
		String userPassword = prop.getProperty("userPwd");
		String loggedInUser = prop.getProperty("loggedInuser");
		String validationMsg = prop.getProperty("validationMsg");
		

		loginPage.launchSpeakEnglishPage(Url);
		loginPage.clickLoginOnLangingPage();
		loginPage.enterLoginDetails(userId, userPassword);
		loginPage.clickSignInButton();
		String userName = homePage.getLogedUserName();
		Assert.assertEquals(userName.contains(loggedInUser), true, validationMsg);
	}

	@Test(priority = 1,enabled = true)
	public void verifyImagesOnLandingPage() {
	String  Url = prop.getProperty("appUrl");
		loginPage.launchSpeakEnglishPage(Url); 
		loginPage.verifyImages();

	}

	@AfterMethod
	public void tearDown() {
		utils.closeBroswer();
	}
}

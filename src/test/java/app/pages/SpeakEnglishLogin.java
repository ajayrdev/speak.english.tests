package app.pages;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import automation.utilities.SeleniumUtils;

public class SpeakEnglishLogin {
	WebDriver driver;
	SeleniumUtils utils;

	// Page Locators
	public static By LANDING_LOGIN_BUTTON = By.id("nav_login");
	public static By EMAIL_FIELD = By.id("email_input");
	public static By PASSWORD_FIELD = By.id("password_input");
	public static By LOGIN_Button = By.id("login_button");
	public static By LOGIN_ERROR_LABEL = By.xpath("//li[@class='error_message']");
	public static By LANDING_IMAGES_LINKS = By.xpath("//img");

	public SpeakEnglishLogin(SeleniumUtils utils, WebDriver driver) {
		this.utils = utils;
		this.driver = driver;
	}

	public void launchSpeakEnglishPage(String appUrl) {
		driver.get(appUrl);
		waitTime(4);
	}

	public void verifyImages() {
		List<WebElement> imageElements = utils.getElements(LANDING_IMAGES_LINKS);
		int imageElementsCount  =   imageElements.size();
		int imageUrlsCount = 0;
		
		List<String> imageSrcLinks = new ArrayList<String>();

		for (WebElement imageElement : imageElements) {
			imageSrcLinks.add(imageElement.getAttribute("src").trim());
		}
		for (String imageSrcUrl : imageSrcLinks) {
			driver.get(imageSrcUrl);
			if(!driver.getTitle().contains("https")) {
				imageUrlsCount++;
			}
			waitTime(1);
		}
		
		if(imageElementsCount  == imageUrlsCount ) {
			System.out.println("All " + imageUrlsCount + " images are loading without issues");
		}
		else{
			System.out.println(imageElementsCount);
			System.out.println(imageUrlsCount);
			Assert.fail("Something went wrong. Images are not loading properly");
		}
	}

	public void clickLoginOnLangingPage() {
		utils.clickElement(LANDING_LOGIN_BUTTON);
		waitTime(2);
	}

	public void enterLoginDetails(String email, String password) {
		utils.enterText(EMAIL_FIELD, email);
		waitTime(1);
		utils.enterText(PASSWORD_FIELD, password);
		waitTime(1);
	}

	public void clickSignInButton() {
		utils.clickElement(LOGIN_Button);
		waitTime(3);
	}

	public String getLoginErrorDetails() {
		return utils.getText(LOGIN_ERROR_LABEL);
	}

	public void waitTime(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

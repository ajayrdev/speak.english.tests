package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.utilities.SeleniumUtils;

public class SpeakEnglishHome {

	WebDriver driver;
	SeleniumUtils utils;

//Page Locators
	public static By LOGGEDIN_USER_LABEL = By.xpath("//li[@id='nav_user']//a");

	public SpeakEnglishHome(SeleniumUtils utils, WebDriver driver) {
		this.utils = utils;
		this.driver = driver;
	}

	public String getLogedUserName() {
		return utils.getText(LOGGEDIN_USER_LABEL);
	}
}

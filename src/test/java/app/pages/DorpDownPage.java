package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import automation.utilities.SeleniumUtils;

public class DorpDownPage {

	WebDriver driver;
	SeleniumUtils utils;

	public static By country_Dropdown = By.xpath("//select[@name='country']");
	
	public DorpDownPage(SeleniumUtils utils, WebDriver driver) {
		this.utils = utils;
		this.driver = driver;

	}

	public void launchDropDownApp(String appUrl) {
		driver.get(appUrl);
	}

	public void selectCountryByValue(String value) {
		utils.selectByValue(country_Dropdown, value);
	}
	
	public void selectCountryByVisbleText(String text) {
		utils.selectByVisibleText(country_Dropdown, text);
	}
	
	public void selectCountryselectByIndex(int index) {
		utils.selectByIndex(country_Dropdown, index);
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
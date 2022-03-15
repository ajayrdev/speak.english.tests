package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import automation.utilities.SeleniumUtils;

public class AutomationBookStorePage {

	WebDriver driver;
	SeleniumUtils utils;

	public static By heading = By.xpath("//h1[@id='page-title' ]");
	public static By searchBar = By.xpath("//input[@id ='searchBar']");
	public static By clearText = By.xpath("//a[@title='Clear text']");
	public static By imageLinks = By.xpath("//img");

	public AutomationBookStorePage(SeleniumUtils utils, WebDriver driver) {
		this.utils = utils;
		this.driver = driver;

	}

	public void AutomationBookStoreLaunch(String appUrl) {
		driver.get(appUrl);
	}

	public void verifyHeading(String headingExpected) {
		String headingActual = utils.getText(heading);
		Assert.assertEquals(headingActual.equalsIgnoreCase(headingExpected), true, "Automation BookStore page heading verification Failed");
	}

	public void AutomationPageTitle(String pageTitle) {
		Assert.assertEquals(driver.getTitle().contains(pageTitle), true, "Automation BookStore Title Verification failed");
	}

	public void AutomationPageUrl(String pageUrl) {
		Assert.assertEquals(!driver.getCurrentUrl().isEmpty() && driver.getCurrentUrl().contains(pageUrl), true, "Automation Bookstore page URL Verification failed");
	}

	public void searchTextBook(String textTobeEntered) throws InterruptedException {

		utils.enterText(searchBar, textTobeEntered);
		String textCaptured  =  utils.getTextEntered(searchBar);
		Assert.assertEquals(textCaptured.equals(textTobeEntered), true, "Automation Bookstore search Verification failed");
		utils.clickElement(clearText);
	}
}
package app.pages;

import java.util.List;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


import automation.utilities.SeleniumUtils;

public class FlipKartPage {

	WebDriver driver;
	SeleniumUtils utils;

	By close_Button = By.xpath("(//span[.='Login']/../../../..//button)[1]");
	By viewAll_Products = By.xpath("(//a[.='VIEW ALL'])[1]");
	By products_List = By.xpath("//a[@title]_modified");

	public FlipKartPage(SeleniumUtils utils, WebDriver driver) {
		this.utils = utils;
		this.driver = driver;

	}

	public void launchFlipkartWebPage(String appUrl) {

		driver.get(appUrl);
	}

	public void closeLoginWindow() {

		utils.clickElement(close_Button);

	}

	public void scrolltoViewAll() {

		utils.scrollToElement(viewAll_Products);

	}
	

	public void clickOnViewAll() {

		utils.clickElementJS(viewAll_Products);

	}

	public List<WebElement> viewAllProducts() {
		return utils.getElements(products_List);
	}

}

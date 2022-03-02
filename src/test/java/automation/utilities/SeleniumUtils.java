package automation.utilities;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumUtils {
	WebDriver driver = null;

	 public SeleniumUtils() {
		String baseDirectory = System.getProperty("user.dir");
		String driverPath = "\\src\\test\\resources\\chromedriver.exe";
		System.setProperty("webdriver.chrome.driver", baseDirectory + driverPath);
		driver = new ChromeDriver();
		driver.manage().window().maximize();
	}

	public WebDriver getDriver() {
		return this.driver;
	}	

	public void closeBroswer() {
		driver.close();
		driver.quit();
	}

	public void clickElement(By by) {
		driver.findElement(by).click();
	}

	public void enterText(By by, String text) {
		driver.findElement(by).sendKeys(text);
	}

	public String getText(By by) {
		return driver.findElement(by).getText();
	}
	
	public List<WebElement> getElements(By by){
		return driver.findElements(by);
	}

}

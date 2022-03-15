package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.utilities.SeleniumUtils;

public class CosmocodeWebTable {
	WebDriver driver;
	SeleniumUtils utils;

	public static By table = By.id("countries");
	public static By rows = By.xpath("//table[@id='countries']//tr//strong"); // -->((//table[@id='countries']//tr)[1]//h3//strong)[1]
	public static By columns = By.xpath("(//table[@id='countries']//tr)[1]//td//h3//strong");

	public CosmocodeWebTable(SeleniumUtils utils, WebDriver driver) {

		this.utils = utils;
		this.driver = driver;
	}

	public void launchCosmocodeWebTable(String appUrl) {
		driver.get(appUrl);
		waitTime(2);
	}

	private void waitTime(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printTableData() {

		int rowsCount = driver.findElements(rows).size();
		int columnsCount = driver.findElements(columns).size();
		
		System.out.println("rowsCount: "+rowsCount);
		System.out.println("columnsCount: "+columnsCount);

		for (int row = 1; row < 2; row++) {
			for (int column = 2; column <= columnsCount; column++) {
				System.out.print(driver
						.findElement(
								By.xpath("(//table[@id='countries']//tr[" + row + "]//td//h3//strong)[" + column + "]"))
						.getText() + " ");
			}
		}
		System.out.println();
		for (int row = 2; row < 198; row++) {
			for (int column = 2; column <= columnsCount; column++) {
				System.out.print(
						driver.findElement(By.xpath("(//table[@id='countries']//tr[" + row + "]//td)[" + column + "]"))
								.getText() + " ");
			}
			System.out.println();
		}
	}

	public String printTableData(int rowNum, int ColumnNum) {
		String cellData = "";

		if (rowNum > 1) {

			cellData = driver
					.findElement(By.xpath("//table[@id='countries']//tr[" + rowNum + "]//td/strong[" + ColumnNum + "]"))
					.getText();
		} else {
			System.out.println("Please pass valid row number");
		}
		return cellData;
	}
}

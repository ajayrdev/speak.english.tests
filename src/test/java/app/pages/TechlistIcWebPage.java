package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.utilities.SeleniumUtils;

public class TechlistIcWebPage {

	WebDriver driver;
	SeleniumUtils utils;

	public static By table = By.id("customers");
	public static By rows = By.xpath("//table[@id='customers']//tr");
	public static By columns = By.xpath("(//table[@id='customers']//tr)[1]//th");

	public TechlistIcWebPage(SeleniumUtils utils, WebDriver driver) {
		this.utils = utils;
		this.driver = driver;
	}

	public void launchTechlistIcTable(String appUrl) {
		driver.get(appUrl);
		waitTime(2);
	}

	private void waitTime(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}

	}

	public void printTableData() {

		int rowsCount = driver.findElements(rows).size();
		int columnsCount = driver.findElements(columns).size();

		for (int row = 1; row < 2; row++) {

			for (int column = 1; column <= columnsCount; column++) {

				System.out.print(
						driver.findElement(By.xpath("//table[@id='customers']//tr[" + row + "]/th[" + column + "]"))
								.getText() + " ");
			}
		}
		String data = "";
		System.out.println(data.isBlank());
		System.out.println();
		
		for (int row = 2; row <= rowsCount; row++) {
			for (int column = 1; column <= columnsCount; column++) {
				System.out.print(
						driver.findElement(By.xpath("//table[@id='customers']//tr[" + row + "]/td[" + column + "]"))
								.getText() + " ");
			}
			System.out.println();
		}
	}
	public boolean verifyTechlistCellData(String cellDataExpected) {
		int rowsCount = driver.findElements(rows).size();
		int columnsCount = driver.findElements(columns).size();
		boolean isCellDataDisplayed = false;
		System.out.println();
		for (int row = 2; row <= rowsCount; row++) {
			for (int column = 1; column <= columnsCount; column++) {
				String CellDataActual = driver
						.findElement(By.xpath("//table[@id='customers']//tr[" + row + "]/td[" + column + "]"))
						.getText();
				if (CellDataActual.equalsIgnoreCase(cellDataExpected)) {
					isCellDataDisplayed = true;
					break;
				}
			}
			System.out.println();
		}
		return isCellDataDisplayed;
	}
	public String printTechlistTableData(int rowNum, int ColumnNum) {
		String cellData = "";
		if (rowNum > 1) {
			cellData = driver.findElement(By.xpath("//table[@id='customers']//tr[" + rowNum + "]/td[" + ColumnNum + "]"))
					.getText();
		} else {
			System.out.println("Please pass valid row number");
		}
		return cellData;
	}
}

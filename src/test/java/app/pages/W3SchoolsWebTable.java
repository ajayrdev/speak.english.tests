package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import automation.utilities.SeleniumUtils;

public class W3SchoolsWebTable {

	WebDriver driver;
	SeleniumUtils utils;

	public static By table = By.id("customers");
	public static By rows = By.xpath("//table[@id='customers']//tr");
	public static By columns = By.xpath("(//table[@id='customers']//tr)[1]//th");

	public W3SchoolsWebTable(SeleniumUtils utils, WebDriver driver) {
		this.utils = utils;
		this.driver = driver;
	}

	public void launchW3SchoolsTable(String appUrl) {
		driver.get(appUrl);
		waitTime(2);
	}

	private void waitTime(int seconds) {
		try {
			Thread.sleep(seconds * 1000);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void printTableData() {
		int rowsCount = driver.findElements(rows).size();
		int coulmnsCount = driver.findElements(columns).size();

		for (int row = 1; row < 2; row++) {
			for (int column = 1; column <= coulmnsCount; column++) {
				System.out.print(
						driver.findElement(By.xpath("//table[@id='customers']//tr[" + row + "]/th[" + column + "]"))
								.getText() + " ");
			}
		}
		
		String data = "";
		System.out.println(data.isBlank());
		System.out.println();
		for (int row = 2; row <= rowsCount; row++) {
			for (int column = 1; column <= coulmnsCount; column++) {
				System.out.print(
						driver.findElement(By.xpath("//table[@id='customers']//tr[" + row + "]/td[" + column + "]"))
								.getText() + " ");
			}
			System.out.println();
		}

	}

	public boolean verifyCellData(String cellDataExpected) {
		int rowsCount = driver.findElements(rows).size();
		int coulmnsCount = driver.findElements(columns).size();
		boolean isCellDataDisplayed  =  false;
		System.out.println();
		for (int row = 2; row <= rowsCount; row++) {
			for (int column = 1; column <= coulmnsCount; column++) {
				String CellDataActual  = driver.findElement(By.xpath("//table[@id='customers']//tr[" + row + "]/td[" + column + "]")).getText();
				if(CellDataActual.equalsIgnoreCase(cellDataExpected)) {
					isCellDataDisplayed =  true;
					break;
				}
			}
			System.out.println();
		}
		return isCellDataDisplayed;

	}

	public String printTableData(int rowNum, int CoulNum) {
		String cellData = "";

		if (rowNum > 1) {

			cellData = driver.findElement(By.xpath("//table[@id='customers']//tr[" + rowNum + "]/td[" + CoulNum + "]"))
					.getText();

		} else {
			System.out.println("Please pass valid row number");
		}
		return cellData;
	}
}

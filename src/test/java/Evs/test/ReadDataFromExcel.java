package Evs.test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ReadDataFromExcel {
	public static WebDriver driver;

	public static void main(String[] args) throws IOException {

		File filepath = new File("C:\\Users\\HP\\Desktop\\ExcelData.xlsx");
		getData(filepath);

		FileInputStream fileinput = new FileInputStream(filepath);

		// --for .xlsx files
		XSSFWorkbook xsf = new XSSFWorkbook(fileinput);

		// --for .xlx files
//		HSSFWorkbook workbook2 = new HSSFWorkbook(fileinput);

		XSSFSheet sheet = xsf.getSheetAt(0);

		// total no. of Rows
		int totalrow = sheet.getLastRowNum() + 1;

		// -- // total no. of columns/cell
		int totalcell = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i < totalrow; i++) {
			driver.findElement(By.name("user_name")).sendKeys(sheet.getRow(i).getCell(0).getStringCellValue());
			driver.findElement(By.name("user_password")).sendKeys(sheet.getRow(i).getCell(1).getStringCellValue());
			driver.findElement(By.name("user_Login")).click();

			driver.findElement(By.linkText("Sign Out")).click();
		}

		xsf.close();

	}

	public static void DataDriverTesting() {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);

		driver.get("http://localhost:8888/");

	}

	public static void getData(File filepath) throws IOException {

		FileInputStream fileinput = new FileInputStream(filepath);

		// --for .xlsx files
		XSSFWorkbook xsf = new XSSFWorkbook(fileinput);

		// --for .xlx files
//		HSSFWorkbook workbook2 = new HSSFWorkbook(fileinput);

		XSSFSheet sheet = xsf.getSheetAt(0);

		// total no. of Rows
		int totalrow = sheet.getLastRowNum() + 1;

		// -- // total no. of columns/cell
		int totalcell = sheet.getRow(0).getLastCellNum();

		for (int i = 1; i < totalrow; i++) {
			for (int j = 0; j < totalcell; j++) {
				System.out.print(sheet.getRow(i).getCell(j));
				System.out.print("\n");
			}
		}
	}

}

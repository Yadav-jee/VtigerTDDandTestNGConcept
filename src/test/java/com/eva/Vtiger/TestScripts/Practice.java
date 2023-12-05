package com.eva.Vtiger.TestScripts;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.evs.Vtiger.Pages.Common.CommonPage;
import com.evs.Vtiger.Utils.WebUtil;

public class Practice {

	public static void main(String[] args) {

//		WebUtil.LaunchBrowser();
//		WebUtil.OpenURL("http://localhost:8888/");
//
//		WebUtil.SendKeys(By.name("user_name"), "UserName", "admin");
//		WebUtil.SendKeys(By.name("user_password"), "Password", "admin");
//		boolean theme = WebUtil.IsMultiple(By.name("login_theme"), "LoginTheme");
//		System.out.println(theme);
//
//		WebUtil.Click(By.name("Login"), "LoginButton");
//		WebUtil.MyMouseHover(By.xpath("//b[contains(text(),'Top Quotes')]"), "TopQuetes");
//		WebUtil.MyDragAndDrop(By.xpath("//b[contains(text(),'Top Quotes')]"),
//				By.xpath("//b[contains(text(),'Tag Cloud')]"), "HomePageDragAndDrop");
//
//		WebUtil.MyMouseHover(By.linkText("Marketing"), "Marketing Tab");
//		WebUtil.MyMouseClick(By.linkText("Accounts"), "Account Tab");
//		String ActualAccountHeader = WebUtil.MyGetText(By.xpath("//td[@class='moduleName']"),
//				"Marketing AccountHeader");

//		String ExpectedAccountheader = "Marketing > Accounts";
//		WebUtil.VerifyText(ActualAccountHeader, ExpectedAccountheader);

//		CommonPage crc = new CommonPage();
//		crc.goToInventoryInvoicepage();
//		System.out.println("=========================");
//
//		WebUtil.CheckAllCheckBox(By.xpath("//td/input[@name='selected_id']"), "AllCheckBox");
//
//		int columnNumber = WebUtil.getcolumnNumberByColumnName("//table[@class='lvt small']", "Account Table", "Phone");
//		System.out.println(columnNumber);
//
//		List<String> ColumnData = WebUtil.getColumnDataByColumnName("//table[@class='lvt small']", "Account Table",
//				"Account Name");
//		System.out.println(ColumnData.size());
//		for (String value : ColumnData) {
//			System.out.println(value);
//		}
//
//		int RowNumber = WebUtil.getRowNumberByUniqueRowID("//table[@class='lvt small']", "Account Table", "Account No",
//				"ACC50");
//		System.out.println(RowNumber);

		
             Assert.assertEquals(false, null);
             
}
}

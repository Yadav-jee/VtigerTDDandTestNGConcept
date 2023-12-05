package com.eva.Vtiger.TestScripts;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.evs.Vtiger.Pages.Common.CommonPage;
import com.evs.Vtiger.Pages.Marketing.Accounts.MarketingAccountEditPage;
import com.evs.Vtiger.Pages.Marketing.Accounts.MarketingAccountsCreateNewAccountPage;
import com.evs.Vtiger.Pages.Marketing.Accounts.MarketingAccountsDetailPage;
import com.evs.Vtiger.Pages.Marketing.Accounts.MarketingAccountsLandingPage;
import com.evs.Vtiger.Utils.WebUtil;

public class MarketingAccountTestScript extends BaseClass {

	private WebUtil wt = WebUtil.GetWebUtilInstance();

//	@DataProvider(name = "AccountData")
	public Object[][] getTestCaseData() {
		String Arrst1[] = new String[7];
		Arrst1[0] = "Sabnam";
		Arrst1[1] = "Evs.com";
		Arrst1[2] = "85648983728";
		Arrst1[3] = "a_y1@gmail.com";
		Arrst1[4] = "Mukharjinagar";
		Arrst1[5] = "Delhi";
		Arrst1[6] = "2111006";

		String Arrst2[] = new String[7];
		Arrst2[0] = "Saamu";
		Arrst2[1] = "Evs.com";
		Arrst2[2] = "85648983728";
		Arrst2[3] = "S_y1@gmail.com";
		Arrst2[4] = "Suratpur";
		Arrst2[5] = "Delhi";
		Arrst2[6] = "2111006";

		String Arrst3[] = new String[7];
		Arrst3[0] = "Sibana";
		Arrst3[1] = "Evs.com";
		Arrst3[2] = "85648983728";
		Arrst3[3] = "a_y1@gmail.com";
		Arrst3[4] = "Mukharjinagar";
		Arrst3[5] = "Delhi";
		Arrst3[6] = "2111006";

		String Arr2D[][] = new String[3][7];
		Arr2D[0] = Arrst1;
		Arr2D[1] = Arrst2;
		Arr2D[2] = Arrst3;

		String dataArr[];

		return Arr2D;
	}

	@DataProvider(name= "ExcelData")
	public Object[][] SearchDataProviderMethod() {
		File filepath = new File("C:\\Users\\HP\\Desktop\\ExcelData.xlsx");
		Object[][] ExcelData = wt.GetTestCaseDataFromExcel(filepath, "Mysheet");

		return ExcelData;
	}

	@Test(priority = 1, dataProvider = "ExcelData")
	public void VerifyTC001AccountCreation(String AccountName, String WebSite, String Phone, String Email,
			String BillingCity, String BillingState, String PostalCode) throws InterruptedException {

		getCrc().goToMarketingAccountsPage();
		MarketingAccountsLandingPage mrkMainPage = new MarketingAccountsLandingPage(wt);
		mrkMainPage.ClickcreateNewAccountButton();

		MarketingAccountsCreateNewAccountPage MrkCreation = new MarketingAccountsCreateNewAccountPage(wt);
		MrkCreation.enterMarketingAccountInfo(AccountName, WebSite, Phone, Email, BillingCity, BillingState,
				PostalCode);
		MrkCreation.ClickOnSaveButton();

	}

//	@Test(priority = 2)
//	public void VerifyTC002AccountEdit() throws Exception {
//
//		MarketingAccountsDetailPage MrkDetail = new MarketingAccountsDetailPage(wt);
//		MrkDetail.ClickOnAccountUpdateButton();
//
//		MarketingAccountEditPage MrkEditP = new MarketingAccountEditPage(wt);
//		MrkEditP.EditMarketingAccountInfo();
//
//	}
//
//	@Test
//	public void VerifyTC003AccountDelete() {
//		System.out.println("3rd  value");
//	}
//
//	public void VerifyTC004AccountDuplicate() {
//
//	}

}

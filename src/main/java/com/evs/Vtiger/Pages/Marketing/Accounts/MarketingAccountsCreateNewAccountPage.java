package com.evs.Vtiger.Pages.Marketing.Accounts;

import com.evs.Vtiger.ObjectRepository.MarketingAccountsCreateNewAccount_OR;
import com.evs.Vtiger.Utils.WebUtil;

import net.bytebuddy.utility.RandomString;

public class MarketingAccountsCreateNewAccountPage extends MarketingAccountsCreateNewAccount_OR {
	private WebUtil wt;

	public MarketingAccountsCreateNewAccountPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

//	public void enterMarketingAccountInfo(String dataArr[]) {
//		RandomString random = new RandomString();
//
//		wt.SendKeys(getAccountNameTB(), dataArr[0], "AccountNameTB");
//		wt.SendKeys(getWebsiteTB(), dataArr[1], "WebSiteTB");
//		wt.SendKeys(getPhoneNoTB(), dataArr[2], "PhoneeTB");
//		wt.SendKeys(getEmail_IdTB(), dataArr[3], "EmailTB");
//		wt.SendKeys(getBillingCity(), dataArr[4], "Billing-CityTB");
//		wt.SendKeys(getBillingState(), dataArr[5], "Billing-StateTB");
//		wt.SendKeys(getBillingPostalCode(), dataArr[6], "Billint-PostalCodeTB");
//
//	}

	public void enterMarketingAccountInfo(String AccountName, String WebSite, String Phone, String Email,
			String BillingCity, String BillingState, String PostalCode) {

		wt.SendKeys(getAccountNameTB(), AccountName, "AccountNameTB");
		wt.SendKeys(getWebsiteTB(), WebSite, "WebSiteTB");
		wt.SendKeys(getPhoneNoTB(), Phone, "PhoneeTB");
		wt.SendKeys(getEmail_IdTB(), Email, "EmailTB");
		wt.SendKeys(getBillingCity(), BillingCity, "Billing-CityTB");
		wt.SendKeys(getBillingState(), BillingState, "Billing-StateTB");
		wt.SendKeys(getBillingPostalCode(), PostalCode, "Billint-PostalCodeTB");

	}

	public void ClickOnSaveButton() throws InterruptedException {
		wt.Click(getSaveButton());
		Thread.sleep(3000);
	}

	public void ClickOnCancleButton() {

	}

}

package com.evs.Vtiger.Pages.Common;

import java.util.Map;

import com.evs.Vtiger.ObjectRepository.CommonPageOR;
import com.evs.Vtiger.Utils.WebUtil;

public class CommonPage extends CommonPageOR {
	private WebUtil wt;

	public CommonPage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	public void LoginApplication(String username, String password) {
		wt.SendKeys(getUsernameTB(), username ,"usernameTB");
		wt.SendKeys(getPasswordTB(), password , "passwordTB");
		wt.Click(getLoginBt());
	}

	public void ValidLogin() {
		wt.SendKeys(getUsernameTB(), "admin" , "usernamTB");
		wt.SendKeys(getPasswordTB(), "admin" , "PasswordTB");
		wt.Click(getLoginBt());
	}

	public void ValidLogin(String username, String password) {
		wt.SendKeys(getUsernameTB(), username , "usernameTB");
		wt.SendKeys(getPasswordTB(), password , "PasswordTB");
		wt.Click(getLoginBt());
	}

	public void clickOnLoginButton() {
		wt.ClickByJS(getLoginBt());
	}

	public void logOut() {
		wt.Click(getLogOutButton());

	}

	public void ErrorMsgTextDispaly(String ExpInnerText) {
		wt.VerifyText(getErrorMSg(), ExpInnerText);
	}

	public void goToMarketingAccountsPage() {
		wt.MouseHover(getMarketingTaB());
		wt.Click(getMarketingAccountSubTaB());
	}

	public void goToMarketingLeadsPage() {
		wt.MouseHover(getMarketingTaB());
		wt.Click(getMarketingLeadsSubTab());
	}

	public void goToMarketingContactsPage() {
		wt.MouseHover(getMarketingTaB());
		wt.Click(getMarketingContactsTab());
	}

	public void goToMarketingCampaignPage() {
		wt.MouseHover(getMarketingTaB());
		wt.Click(getMarketingCompaign());
	}

	public void goToInventoryInvoicepage() {
		wt.MouseClick(getInventoryTab());
		wt.Click(getInventoryInvoiceTab());

	}

	public void ClickOnAllModule(String ElementName) {
		wt.Click(getAllMainModules(), ElementName);
	}

}

package com.evs.Vtiger.Pages.Marketing.Accounts;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.evs.Vtiger.ObjectRepository.VerifyMarketingAccountDuplicate_OR;
import com.evs.Vtiger.Utils.WebUtil;

public class VerifyMarketingAccountDuplicatepage extends VerifyMarketingAccountDuplicate_OR {
	private WebUtil wt;

	public VerifyMarketingAccountDuplicatepage(WebUtil wu) {
		super(wu);
		this.wt = wu;
	}

	@FindBy(name = "accountname")
	private WebElement AccountNameTB;

	public void enterDuplicateAccountInfo() throws Exception {
		wt.SendKeys(AccountNameTB, "Surya", "AccountName");
	}

}

package Evs.DeltaBatc;

import org.testng.Reporter;
import org.testng.annotations.Test;

import com.eva.Vtiger.TestScripts.BaseClass;
import com.evs.Vtiger.Pages.Common.CommonPage;
import com.evs.Vtiger.Utils.WebUtil;

public class PracticeSession extends BaseClass {

	private static WebUtil wt = WebUtil.GetWebUtilInstance();
	private static CommonPage crc;
	int a;

	@Test
	public void Main() {

		Reporter.log("this is Main method", true);

//		crc = new CommonPage(wt);

//		Assert.assertEquals(11, 15);

//		crc.goToMarketingAccountsPage();
//		wt.getExtest().log(Status.FAIL, "Method executed Successfully");
		System.out.println("hello baby");
	}

	@Test(priority = 2)
	public void M2() {
		Reporter.log("this is M2 method", true);

//		getCrc().goToMarketingContactsPage();
//		wt.getExtest().log(Status.FAIL, "Method executed Successfully");

	}

}

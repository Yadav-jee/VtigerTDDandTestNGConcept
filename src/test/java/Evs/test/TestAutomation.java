package Evs.test;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.eva.Vtiger.TestScripts.BaseClass;

public class TestAutomation  extends BaseClass {

	@Test(priority = 1, alwaysRun = true)
	public void hello1() {
		System.out.println("hello1");
	}

	@Test(priority = 3)
	public void hello2() {

		SoftAssert soft = new SoftAssert();
		soft.assertEquals("111", "111");
		soft.assertAll();
		System.out.println("hello2");
	}

}

package com.eva.Vtiger.TestScripts;

import java.lang.reflect.Method;

import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.*;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.evs.Vtiger.Pages.Common.CommonPage;
import com.evs.Vtiger.Utils.WebUtil;

import lombok.Getter;

@Getter
public class BaseClass {

	private WebUtil wt = WebUtil.GetWebUtilInstance();
	private CommonPage crc;
	private final ExtentReports extentreport = new ExtentReports();

//	@Parameters({ "username", "password" })
	@BeforeMethod
	public void BeforeMethod(Method mt) {
		ExtentTest extest = extentreport.createTest(mt.getName());
		wt.setExtentTestObject(extest);
		crc = new CommonPage(wt);
		crc.ValidLogin("admin", "admin");
		System.out.println("Application is logged-in succesfully");
		Reporter.log("Application is logged-in succesfully");
	}

	@AfterMethod
	public void AfterMethod(ITestResult result, Method mt) {

		String filePath = "test-output//SnapShot.png";
		if (result.getStatus() == result.FAILURE) {
			String FileAddress = wt.SnapShotOfFullPage(filePath, mt.getName());
			wt.getExtest().addScreenCaptureFromPath(FileAddress);
		}
		crc.logOut();
		extentreport.flush();

	}

	@Parameters({ "browser" })
	@BeforeClass
	public void BeforeClass(String BrowserName) {
		wt.LaunchBrowser(BrowserName);
		System.out.println("Browser launched Succesfully");
		wt.OpenURL("http://localhost:8888/");

	}

	@AfterClass
	public void AfterClass() {
		wt.CloseBrowser();
		System.out.println("Browser closed Successfully");
	}

	@BeforeTest
	public void BeforeTest() {
		System.out.println("create connection to database");

	}

	@BeforeSuite
	public void BeforeSuit() {
		System.out.println("generate the report");

		ExtentSparkReporter spark = new ExtentSparkReporter("test-output//ExtentReport.html");
		extentreport.attachReporter(spark);
	}

	@AfterSuite
	public void AfterSuit() {
		extentreport.flush();

	}

}

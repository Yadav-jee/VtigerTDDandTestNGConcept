package Evs.test;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

public class GenerateExtentReport {

	public static WebDriver driver;

	public static void main(String[] args) throws IOException {
		System.setProperty("webdriver.chrome.driver", "driver//chromedriver.exe");
		ChromeOptions options = new ChromeOptions();
		System.out.println("hlw");

//		WebDriverManager.chromedriver().setup();
		options.addArguments("--remote-allow-origins=*");
		driver = new ChromeDriver(options);
		driver.manage().window().maximize();

		driver.get("http:/localhost:8888/");
		System.out.println("hlw");
		WebElement password = driver.findElement(By.name("user_password"));
		WebElement username = driver.findElement(By.name("user_name"));
		WebElement Login = driver.findElement(By.name("Login"));
		username.sendKeys("admin");
		password.sendKeys("admin");

		Login.click();

		driver.findElement(By.linkText("Marketing")).click();

//		TakesScreenshot takes = (TakesScreenshot) driver;
//		File Starting = takes.getScreenshotAs(OutputType.FILE);
//		File destination = new File("test-output//SnapShot.png");
//		Files.copy(Starting, destination);

		ExtentReports extentreport = new ExtentReports();
		ExtentSparkReporter spark = new ExtentSparkReporter("test-output//ExtentReport.html");
		extentreport.attachReporter(spark);

		ExtentTest extest1 = extentreport.createTest("test1");
		extest1.log(Status.INFO, "information");
//		extest1.addScreenCaptureFromPath(destination.getAbsolutePath());
		ExtentTest extest2 = extentreport.createTest("test2");
		extest2.log(Status.FAIL, "its pass");
		extentreport.flush();
	}

}

package com.evs.Vtiger.Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.ElementNotInteractableException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.NoSuchSessionException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;

import io.github.bonigarcia.wdm.WebDriverManager;

import lombok.Getter;

@Getter
public class WebUtil {

	private WebDriver driver;
	private String MainWindowHandle;

	private static WebUtil wt;
	private ExtentTest extest;

	private WebUtil() {

	}

	public static WebUtil GetWebUtilInstance() {
		if (wt == null) {
			wt = new WebUtil();
		}

		return wt;
	}

	public void setExtentTestObject(ExtentTest extest) {
		this.extest = extest;
	}

	public ExtentTest getExtentTestObject() {
		return extest;
	}

	public void LaunchBrowser(String BrowserName) {
		try {

			if (BrowserName.equalsIgnoreCase("chrome")) {
				System.setProperty("webdriver.chrome.driver" , "driver//chromedriver.exe");
				ChromeOptions options = new ChromeOptions();
				options.addArguments("--remote-allow-origins=*");
				System.out.println(options.getBrowserVersion());
				driver = new ChromeDriver(options);
			} else if (BrowserName.equalsIgnoreCase("firefox")) {
				System.setProperty("webdriver.gecko.driver" , "driver//geckodriver.exe");
				FirefoxOptions options = new FirefoxOptions();
				System.out.println(options.getBrowserVersion());
				driver = new FirefoxDriver(options);
			} else if (BrowserName.equalsIgnoreCase("edge")) {
				System.setProperty("webdriver.edge.driver" , "driver//edgedriver.exe");
				EdgeOptions options = new EdgeOptions();
				options.addArguments("--remote-allow-origins=*");
				System.out.println(options.getBrowserVersion());
				driver = new EdgeDriver(options);
			} else {
				System.out.println("Browser not matched .");
			}

		} catch (Exception e) {
			System.out.println("Browser not launched ");
			e.printStackTrace();
		}

	}

	public void LaunchBrowserAndOpenUrl(String URL) {
		LaunchBrowser("chrome");
		OpenURL(URL);

	}

	public void MaximizeWindow() {
		driver.manage().window().maximize();
	}

	public void OpenURL(String Url) {
		try {
			driver.get(Url);
			System.out.println("Application Lauched Successfully");

		} catch (NullPointerException e) {
			System.out.println("driver is null");
			e.printStackTrace();
		} catch (NoSuchSessionException e) {
			System.out.println("Browser is  already closed |");
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ------ Close the Browser----//
	public void CloseBrowser() {
		try {
			driver.close();
			extest.log(Status.INFO, "Browser is closed Successfully Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// --- Quit Browser-----//
	public void QuitBrowser() {
		driver.quit();
		extest.log(Status.PASS, "All Browser is closed Successfully");
	}

	public String Tittle() {
		String Actualtittle = null;
		try {
			Actualtittle = driver.getTitle();
		} catch (NoSuchSessionException e) {
			System.out.println("Browser has been Closed Successfully");
			e.printStackTrace();
		}

		catch (NullPointerException e) {
			System.out.println("driver is null");
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return Actualtittle;
	}

	public String CurrentURL() {
		String ActualURL = null;
		try {
			ActualURL = driver.getCurrentUrl();
		} catch (NoSuchSessionException e) {
			System.out.println("Browser has been Closed Successfully");
			e.printStackTrace();
		}

		catch (NullPointerException e) {
			System.out.println("driver is null");
			e.printStackTrace();
		}

		catch (Exception e) {
			e.printStackTrace();
		}

		return ActualURL;
	}

	public boolean IsEnable(WebElement we) {
		boolean status = false;
		try {
			status = we.isEnabled();
		} catch (NoSuchElementException e) {
			System.out.println("Element not find");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Element not find");
			e.printStackTrace();

		}

		return status;

	}

	public boolean IsSelected(WebElement we) {
		boolean status = false;
		try {
			status = we.isSelected();
		} catch (NoSuchElementException e) {
			System.out.println("Element not find");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Element not find");
			e.printStackTrace();

		}
		System.out.println("Element is checked");

		return status;

	}

	public boolean IsDisplayed(WebElement we) {
		boolean status = false;
		try {
			status = we.isDisplayed();
		} catch (NoSuchElementException e) {
			System.out.println("Element not find");
			e.printStackTrace();

		} catch (Exception e) {
			System.out.println("Element not find");
			e.printStackTrace();

		}

		return status;

	}

	public void SendKeys(WebElement we, String InputValue, String ElementName) {
		try {
			we.clear();
			we.sendKeys(InputValue);
			extest.log(Status.INFO, "value has been sent Successfully in " + ElementName + " TextBox");
		} catch (StaleElementReferenceException e) {
			we.sendKeys(InputValue);
		}

		catch (ElementNotInteractableException e) {
			System.out.println(ElementName + " is Hidden");
			JavascriptExecutor Js = (JavascriptExecutor) driver;
			Js.executeScript("arguments[0].value=" + InputValue, we);
			System.out.println("value has been sent Successfully in " + ElementName);

		} catch (NoSuchElementException e) {
			System.out.println("Element could not find due to some problem");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// ------------- WebElement Click
	// ----------------------------------------------//
	public void Click(WebElement we) {
		String ElementName = we.getAccessibleName();

		try {
			we.click();
			System.out.println("click has been performed Successfully on " + ElementName + " Element");

		} catch (StaleElementReferenceException e) {
			we.click();
		} catch (ElementNotInteractableException e) {
			JavascriptExecutor Js = (JavascriptExecutor) driver;
			Js.executeScript("arguments[0].click();", we);
			System.out.println(ElementName + "has been clicked Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void Click(List<WebElement> we, String ElementName) {

		for (int i = 0; i < we.size(); i++) {
			WebElement Element = we.get(i);
			try {
				Element.click();
				extest.log(Status.INFO, " has been clicked Successfully ");
			} catch (NoSuchElementException e) {
				e.printStackTrace();
			} catch (Exception e) {
				e.printStackTrace();
			}

		}

	}

	// ----------- ---- Verificational
	// Code---------------------------------------------------------//
	public String GetText(WebElement we) {
		String ElementName = we.getAccessibleName();

		String ActualInnerText = null;

		try {
			ActualInnerText = we.getText();
			extest.log(Status.INFO, "getting innertextof " + ElementName);

		} catch (StaleElementReferenceException e) {
			System.out.println("Element path has been old");
			ActualInnerText = we.getText();

		} catch (Exception e) {
			e.printStackTrace();
		}

		return ActualInnerText;
	}

	public String getAttribute(WebElement we, String AttributeName) {
		String ElementName = we.getAccessibleName();
		String ElementValue = we.getAttribute(AttributeName);
		return ElementValue;
	}

	public void clear(WebElement we) {

		String ElementName = we.getAccessibleName();

		try {
			we.clear();
			System.out.println("value has been cleared/Removed Successfully of " + ElementName + "TextBox");
		} catch (StaleElementReferenceException e) {
			we.clear();

		} catch (ElementNotInteractableException e) {
			JavascriptExecutor Js = (JavascriptExecutor) driver;
			Js.executeScript("arguments[0].click();", we);
			System.out.println(ElementName + " value has been cleared Successfully");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// ----- method for JavaScript-----//
	public void ClickByJS(WebElement we) {
		String ElementName = we.getAccessibleName();

		JavascriptExecutor Js = (JavascriptExecutor) driver;
		Js.executeScript("arguments[0].click();", we);

	}

	public void SendkeysByJS(WebElement we, String InputValue) {
		String ElementName = we.getAccessibleName();
		JavascriptExecutor Js = (JavascriptExecutor) driver;
		try {
			Js.executeScript("arguments[0].value='" + InputValue + "'", we);
			System.out.println("value sent Successfully in " + ElementName);

		} catch (StaleElementReferenceException e) {
			System.out.println("Element is old");
			Js.executeScript("arguments[0].value='" + InputValue + "'", we);
		} catch (ElementNotInteractableException e) {
			Js.executeScript("arguments[0].value=" + InputValue, we);
			System.out.println("value has been sent Successfully in " + ElementName);

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	// Customized method for DropDown---//
	public void SelectByIndex(WebElement we, int index) {
		String ElementName = we.getAccessibleName();

		Select select = new Select(we);
		try {
			select.selectByIndex(index);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void SelectByValue(WebElement we, String Value) {
		String ElementName = we.getAccessibleName();
		Select select = new Select(we);
		try {
			select.selectByValue(Value);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public void SelectByText(WebElement we, String InnerText) {
		String ElementName = we.getAccessibleName();

		Select select = new Select(we);
		try {
			select.selectByVisibleText(InnerText);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String GetFirstSelectedOption(WebElement we) {
		Select select = new Select(we);
		WebElement selectedElement = select.getFirstSelectedOption();
		String SelectedOptionText = selectedElement.getText();
		return SelectedOptionText;

	}

	public List<String> GetOptions(WebElement we, String ElementName) {
		List<String> list = new ArrayList<String>();

		Select select = new Select(we);
		List<WebElement> listoptions = select.getOptions();
		for (int i = 0; i <= listoptions.size() - 1; i++) {
			WebElement Option = listoptions.get(i);
			String Optiontext = Option.getText();
			list.add(Optiontext);
		}
		return list;

	}

	public String GetWrappedAllOption(WebElement we, String ElementName) {
		Select select = new Select(we);
		WebElement element = select.getWrappedElement();
		String OptionText = element.getText();
		return OptionText;

	}

	public List<String> GetAllSelectedOption(WebElement we) {
		String ElementName = we.getAccessibleName();

		List<String> list = new ArrayList<String>();

		String ActualAllSelectedOptionText = null;
		Select select = new Select(we);
		List<WebElement> ListOption = select.getAllSelectedOptions();
		for (WebElement AllOption : ListOption) {
			ActualAllSelectedOptionText = AllOption.getText();
			list.add(ActualAllSelectedOptionText);
		}
		return list;

	}

	public boolean IsMultiple(WebElement we, String ElementName) {
		Select select = new Select(we);
		boolean ActualStatus = select.isMultiple();
		if (ActualStatus == true) {
			extest.log(Status.PASS, ElementName + " is MultiSelected DropDown");
		} else {
			extest.log(Status.FAIL, ElementName + " is Single Selected DropDown");

		}

		Assert.assertTrue(ActualStatus);

		return ActualStatus;
	}

	// pop-Up Costomized Method----------------------------------------------------

	public void accept() {
		try {
			driver.switchTo().alert().accept();
		} catch (NoAlertPresentException e) {
			extest.log(Status.INFO, "No Alert present here ");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void dismiss() {
		try {
			driver.switchTo().alert().dismiss();
		} catch (NoAlertPresentException e) {
			extest.log(Status.INFO, "No Alert present here ");
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public String PopUpText() {
		String PopUpText = null;
		try {
			PopUpText = driver.switchTo().alert().getText();
		} catch (NoAlertPresentException e) {
			extest.log(Status.INFO, "No Alert present here ");
			e.printStackTrace();
		} catch (UnhandledAlertException e) {
			extest.log(Status.INFO, "Alert is not Handled");

		} catch (Exception e) {
			e.printStackTrace();
		}
		return PopUpText;
	}

	public void SendKeysInPopUp(String InputValue) {
		driver.switchTo().alert().sendKeys(InputValue);
	}

	// ----- Iframe handling ----//
	public void switchToIframeByIndex(int indexValue) {
		try {
			driver.switchTo().frame(indexValue);
			System.out.println("You have switched on your Desire Frame");
		} catch (NoSuchFrameException e) {
			driver.switchTo().frame(indexValue);
			System.out.println("You have switched on your Desire Frame");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToIframeByString(String idOrNameValue) {
		try {
			driver.switchTo().frame(idOrNameValue);
			System.out.println("You have switched on your Desire Frame");

		} catch (NoSuchFrameException e) {
			driver.switchTo().frame(idOrNameValue);
			System.out.println("You have switched on your Desire Frame");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void switchToIframeByWebElement(WebElement we) {
		String elementName = we.getAccessibleName();
		try {
			driver.switchTo().frame(we);
			System.out.println("You have switched on your Desire Frame");

		} catch (NoSuchFrameException e) {
			driver.switchTo().frame(we);
		} catch (StaleElementReferenceException e) {
			driver.switchTo().frame(we);
			System.out.println("You have switched on your Desire Frame");

		}
	}

	public void switchToParentFrame() {
		try {
			driver.switchTo().parentFrame();
			System.out.println("You have switched on Parent Frame");

		} catch (NoSuchFrameException e) {
			driver.switchTo().parentFrame();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Customized Method for Actions Class --//

	public void MouseHover(WebElement we) {
		String ElementName = we.getAccessibleName();
		Actions Act = new Actions(driver);
		try {
			Act.moveToElement(we).build().perform();
			System.out.println("Mouse Hover performed Successfully on " + ElementName);
		} catch (NoSuchElementException e) {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
			wait.until(ExpectedConditions.visibilityOf(we));
			Act.moveToElement(we).build().perform();
			System.out.println("After waiting - Mouse Hover Performed Successfully on" + ElementName);
		} catch (ElementNotInteractableException e) {
			e.printStackTrace();
		}
	}

	public void MouseClick(WebElement we) {
		String ElementName = we.getAccessibleName();

		Actions Act = new Actions(driver);
		try {
			Act.click(we).build().perform();
			System.out.println("Mouse clicked performed Successfully on " + ElementName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void SendKeysByActions(WebElement we, String InputValue) {
		String ElementName = we.getAccessibleName();
		Actions Act = new Actions(driver);
		try {
			Act.sendKeys(we, InputValue).build().perform();
			System.out.println("value has send  Successfully on " + ElementName);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void DragAndDrop(WebElement DragElementPath, WebElement DropElementPath) {
		String DragElementname = DragElementPath.getAccessibleName();
		String DropElementname = DropElementPath.getAccessibleName();

		Actions Act = new Actions(driver);
		try {
			Act.dragAndDrop(DragElementPath, DropElementPath).build().perform();
			System.out.println("Drag and Drop perform Successfully on " + DragElementname + " and " + DropElementname);

		} catch (Exception e) {
			e.printStackTrace();

		}

	}

	// --------Size of Element ---//---------------------------
	public int GetElementHight(WebElement we, String ElementName) {
		Dimension size = null;
		int height = 0;
		try {
			size = we.getSize();
			height = size.getHeight();
		} catch (NullPointerException e) {
			extest.log(Status.INFO, ElementName + " , Element is null");
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return height;

	}

	public int GetElementWidth(WebElement we, String ElementName) {
		Dimension size = null;
		int width = 0;
		try {
			size = we.getSize();
			width = size.getWidth();
		} catch (NullPointerException e) {
			extest.log(Status.INFO, ElementName + " , Element is null");
			e.printStackTrace();

		} catch (Exception e) {
			e.printStackTrace();

		}
		return width;

	}

	// Window Handling Customized
	// method--//------------------------------------------

	public void HandleWindowByTittle(String ExpectedTittle) {

		Set<String> handlevalues = driver.getWindowHandles();
		for (String MyhandleValue : handlevalues) {
			driver.switchTo().window(MyhandleValue);
			String ActualTittle = Tittle();
			if (ActualTittle.equalsIgnoreCase(ExpectedTittle)) {
				extest.log(Status.INFO, "Yes , Current Window is Active");
				break;
			}
		}
	}

	public void HandleWindowByURL(String ExpectedURL) {

		Set<String> handlevalues = driver.getWindowHandles();
		for (String MyhandleValue : handlevalues) {
			driver.switchTo().window(MyhandleValue);
			String ActualURL = CurrentURL();
			if (ActualURL.contains(ExpectedURL)) {
				extest.log(Status.INFO, "Yes , Current Window is Active");
				break;
			}
		}
	}

	public void SwitchToMainWindowByHandleValue() {
		Set<String> handlevalues = driver.getWindowHandles();
		for (String MyhandleValue : handlevalues) {
			driver.switchTo().window(MyhandleValue);
			if (MyhandleValue.equalsIgnoreCase(MainWindowHandle)) {
				extest.log(Status.INFO, "Yes , Current Window is Active");
				break;
			}
		}

	}

	// Checked CheckBox ----//

	public void CheckAllCheckBox(List<WebElement> we, String ElementName) {

		for (WebElement checkbox : we) {
			if (checkbox.isSelected() == false) {
				checkbox.click();
				extest.log(Status.INFO, ElementName + " is Checked Successfully");
			}
		}
	}

	public void UnCheckAllCheckBox(List<WebElement> we) {
		for (WebElement checkbox : we) {
			String ElementName = checkbox.getAccessibleName();

			if (checkbox.isSelected() == true) {
				checkbox.click();
				System.out.println(ElementName + " is Unchecked Successfully");
			}
		}
	}

	// ----SnapShot / ScreenShot---//-----------------
	public void SnapShotOfFullpage(String actualFilePath) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		File tempFileLocation = tss.getScreenshotAs(OutputType.FILE);
		File actualFileLocation = new File(actualFilePath + ".png");
		try {
			Files.copy(tempFileLocation, actualFileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public String SnapShotOfFullPage(String TestCaseName, String ActualFilePath) {
		TakesScreenshot tss = (TakesScreenshot) driver;
		DateFormat dateformat = new SimpleDateFormat("dd-MM-yyyy hh_mm_ss a");
		String time = dateformat.format(new Date());
		File tempFileLocation = tss.getScreenshotAs(OutputType.FILE);
		File actualFileLocation = new File(ActualFilePath + time);
		try {
			Files.copy(tempFileLocation, actualFileLocation);
		} catch (IOException e) {
			e.printStackTrace();
		}

		return actualFileLocation.getAbsolutePath();
	}

	public void SnapShotOfSpecificElement(WebElement we, String ActualFilePath) {
		File TempFileLocation = we.getScreenshotAs(OutputType.FILE);

		File ActualFileLocation = new File(ActualFilePath + ".png");
		try {
			Files.copy(TempFileLocation, ActualFileLocation);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	// Count no . of row in a table ---------------------------
	public int CountTableRowSize(List<WebElement> welist, String ElementName) {

		int countsize = welist.size();
		System.out.println(ElementName + "size is " + countsize);
		return countsize;
	}

	// Count no. of column in a table ---------------------
	public int CountTableColumnSize(By TableColumnXpath, String ElementName) {
		List<WebElement> listOfColumn = driver.findElements(TableColumnXpath);
		int countsize = listOfColumn.size();
		return countsize;
	}

	public List<String> getRowDataListByRowNumber(String TableXpath, String ElementName, int RowNumber) {
		List<String> list = new ArrayList<String>();
		List<WebElement> listrow = driver.findElements(By.xpath(TableXpath + "//tr[" + RowNumber + "]/td"));

		for (int i = 0; i <= listrow.size() - 1; i++) {
			String ListDataOfRow = listrow.get(i).getText();
			list.add(ListDataOfRow);

		}
		return list;

	}

	public int getCountColumnOfRowByRowNumber(String TableXpath, String Element, String RowNumber) {
		List<WebElement> ListColumnName = driver.findElements(By.xpath(TableXpath + "//tr[" + RowNumber + "]/td"));
		return ListColumnName.size();
	}

	public int getcolumnNumberByColumnName(String TableXpath, String ElementName, String ColumnName) {

		List<WebElement> listColumnName = driver.findElements(By.xpath(TableXpath + "//tr[1]/td"));
		int ColumnNumber = -1;

		for (int i = 0; i <= listColumnName.size() - 1; i++) {
			String columnText = listColumnName.get(i).getText();
			if (columnText.equalsIgnoreCase(ColumnName)) {
				ColumnNumber = i + 1;
				break;
			}
		}

		return ColumnNumber;
	}

	public List<String> getColumnDataByColumnNumber(String TableXpath, String ElementName, int ColumnNumber) {
		List<String> listColumnData = new ArrayList<String>();
		List<WebElement> listColumn = driver.findElements(By.xpath(TableXpath + "//tr/td[" + ColumnNumber + "]"));
		for (int i = 1; i <= listColumn.size() - 1; i++) {
			String ColumnDataList = listColumn.get(i).getText();
			listColumnData.add(ColumnDataList);
		}

		return listColumnData;

	}

	public List<String> getColumnDataByColumnName(String TableXpath, String ElementName, String ColumnName) {
		int ColumnNumber = getcolumnNumberByColumnName(TableXpath, ElementName, ColumnName);
		System.out.println("Column Name is --: " + ColumnName);
		List<String> ColumnData = getColumnDataByColumnNumber(TableXpath, ElementName, ColumnNumber);
		return ColumnData;

	}

	public int getCountColumnDataByColumnName(String TableXpath, String Elementname, String ColumnName) {

		List<WebElement> ListColumnName = driver.findElements(By.xpath(TableXpath + "//tr[1]/td"));
		int ColumnSize = 0;
		for (int i = 0; i < ListColumnName.size() - 1; i++) {
			String ActualColumnText = ListColumnName.get(i).getText();
			if (ActualColumnText.equalsIgnoreCase(ColumnName)) {
				List<WebElement> listColumnData = driver
						.findElements(By.xpath(TableXpath + "//tr/td[" + (i + 1) + "]"));
				ColumnSize = listColumnData.size();
			}
		}
		return ColumnSize;

	}

	public int getRowNumberByUniqueRowID(String TableXpath, String ElementName, String ColumnName,
			String UniqueColumnData) {
		List<String> listofColumnData = getColumnDataByColumnName(TableXpath, ElementName, ColumnName);
		int RowNumber = 0;
		for (int i = 0; i <= listofColumnData.size() - 1; i++) {
			String ColumnData = listofColumnData.get(i);
			if (ColumnData.equalsIgnoreCase(UniqueColumnData)) {
				RowNumber = i;
				break;
			}

		}
		return RowNumber + 1;

	}

	// ------- Verification Methods-------------//

	public void VerifyText(WebElement we, String ExpectedText) {
		String ActualText = GetText(we);
		if (ExpectedText.equalsIgnoreCase(ActualText)) {

			extest.log(Status.FAIL, "Pass ,Actual Text- " + ActualText + " && Expected Text- " + ExpectedText);
		} else {
			extest.log(Status.FAIL, "Failed ,Actual Text- " + ActualText + " && Expected Text- " + ExpectedText);
		}

		Assert.assertEquals(ActualText, ExpectedText);

	}

	public void VerifyPopupText() {

	}

	public void VerifyPageTittles(String ExpTittle) {
		String ActulaTittle = Tittle();
		if (ExpTittle.equalsIgnoreCase(ActulaTittle)) {
			extest.log(Status.PASS, "Pass ,Tittle is Matched ");
		} else {
			extest.log(Status.FAIL, "Failed ,Tittle is not Matched");
		}
		Assert.assertEquals(ActulaTittle, ExpTittle);

	}

	public void VerifyPageURL(String ExpURL) {
		String ActualURL = CurrentURL();
		if (ExpURL.equalsIgnoreCase(ActualURL)) {
			extest.log(Status.PASS, "Failed ,URL is Matched");
		} else {
			extest.log(Status.FAIL, "Failed ,URL is not Matched");
		}
		Assert.assertEquals(ActualURL, ExpURL);

	}

	public void verifyNumber(int actualNumber, int expectedNumber) {

		if (actualNumber == expectedNumber) {
			System.out.println("passed. expected=" + expectedNumber + ", Actual=" + actualNumber);
		} else {
			System.out.println("failed. expected=" + expectedNumber + ", Actual=" + actualNumber);
		}

		Assert.assertEquals(actualNumber, expectedNumber);

	}

	public void VerifyAttribute(WebElement we, String ExpAttributeName) {
		String ActualAttributeValue = getAttribute(we, ExpAttributeName);
		if (ActualAttributeValue.equalsIgnoreCase(ExpAttributeName)) {
			extest.log(Status.PASS, "Actual AttributeValue--" + ActualAttributeValue + " && Expected AttributeValue--"
					+ ExpAttributeName);

		} else {
			extest.log(Status.FAIL, "Actual AttributeValue--" + ActualAttributeValue + " && Expected AttributeValue--"
					+ ExpAttributeName);

		}
		Assert.assertEquals(ActualAttributeValue, ExpAttributeName);
	}

	public void VerifyVisibility(WebElement we) {
		boolean Actualstatus = IsDisplayed(we);
		if (Actualstatus == true) {
			extest.log(Status.PASS, " Element is visible");
		} else {
			extest.log(Status.FAIL, " Element is unvisible");
		}

		Assert.assertTrue(Actualstatus);
	}

	public Object[][] GetTestCaseDataFromExcel(File filepath, String Sheet) {

		String[][] data = null;

		FileInputStream fileinput = null;
		try {
			fileinput = new FileInputStream(filepath);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		// --for .xlsx files
		XSSFWorkbook xsf = null;
		try {
			xsf = new XSSFWorkbook(fileinput);
		} catch (IOException e) {
			e.printStackTrace();
		}

		XSSFSheet sheet = xsf.getSheet(Sheet);

		// total no. of Rows
		int totalrow = sheet.getLastRowNum() + 1;

		// -- // total no. of columns/cell
		int totalcell = sheet.getRow(0).getLastCellNum();

		data = new String[totalrow - 1][totalcell];

		for (int i = 1; i < totalrow; i++) {
			for (int j = 0; j < totalcell; j++) {
				data[i - 1][j] = sheet.getRow(i).getCell(j).toString();
			}

		}

		return data;

	}

}

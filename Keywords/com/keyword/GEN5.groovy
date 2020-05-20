package com.keyword

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.util.KeywordUtil
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import com.kms.katalon.core.webui.driver.DriverFactory as DriverFactory
import org.openqa.selenium.remote.RemoteWebElement

import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.Statement
import java.util.ArrayList
import java.sql.PreparedStatement
import java.sql.Driver
import java.sql.Connection

import org.openqa.selenium.By as By
import com.kms.katalon.core.testobject.ConditionType
import org.openqa.selenium.Keys as Keys
import com.kms.katalon.core.configuration.RunConfiguration

import java.lang.Object
import java.lang.Process
import java.io.File

import internal.GlobalVariable

public class GEN5 extends UI {

	@Keyword
	public static void SideMenu (String ParentMenu, String ChildMenu) {
		String FrameXpath = '/html/frameset/frame'
		String CollapseXpath = '//button[text()=\'' + ParentMenu + '\']/parent::*/following-sibling::*//*[text()=\'' + ChildMenu +'\']//ancestor::div[2][@aria-expanded=\'true\']'
		String ParentXpath = '//button[text()=\'' + ParentMenu + '\']/parent::*/following-sibling::*//*[text()=\'' + ChildMenu +'\']//ancestor::div[2]/preceding-sibling::*/button'
		String MenuXpath = '//button[text()=\'' + ParentMenu + '\']/parent::*/following-sibling::*//*[text()=\'' + ChildMenu +'\']'

		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)
		boolean exist = WebUI.waitForElementPresent(newTestObject(CollapseXpath), 1, FailureHandling.OPTIONAL)

		while (exist == false) {
			Click(newTestObject(ParentXpath))
			exist = WebUI.waitForElementPresent(newTestObject(CollapseXpath), 1, FailureHandling.OPTIONAL)
		}

		Click(newTestObject(MenuXpath))
		WebUI.switchToDefaultContent(FailureHandling.STOP_ON_FAILURE)

		Sleep(1)
		WebUI.switchToDefaultContent()
	}

	//	@Keyword
	//	public static def SideMenu2 (String sideMenu) {
	//		String FrameXpath = '/html/frameset/frame'
	//		String CollapseXpath = '//button[text()=\''+ sideMenu +'\']//parent::div//parent::div[@aria-expanded=\'true\']'
	//		String ParentXpath = '//button[text()=\''+ sideMenu +'\']//parent::div//parent::div//parent::div//div[@class=\'panel-heading\']'
	//		String MenuXpath = '//button[text()=\''+ sideMenu +'\']'
	//
	//		WebUI.switchToDefaultContent()
	//		WebUI.switchToFrame(newTestObject(FrameXpath), 1)
	//		boolean exist = WebUI.waitForElementPresent(newTestObject(CollapseXpath), 3, FailureHandling.OPTIONAL)
	//
	//		while (exist == false) {
	//			Click(newTestObject(ParentXpath))
	//			exist = WebUI.waitForElementPresent(newTestObject(CollapseXpath), 3, FailureHandling.OPTIONAL)
	//		}
	//
	//		Click(newTestObject(MenuXpath))
	//		WebUI.switchToDefaultContent(FailureHandling.STOP_ON_FAILURE)
	//
	//		Sleep(2)
	//		WebUI.switchToDefaultContent()
	//	}

	@Keyword // By Arnold
	public static void DatePicker(String DateNow, TestObject DatePickerDiv){
		String[] SplitDate = DateNow.split('/')

		if (SplitDate[0].startsWith('0')){
			SplitDate[0] = SplitDate[0].substring(1)
		}

		String Tanggal = SplitDate[0]
		String Bulan = SplitDate[1]
		int Tahun = Integer.parseInt(SplitDate[2])

		TestObject tObj = DatePickerDiv
		String XpathTable = "${tObj.findPropertyValue('xpath')}"

		String[] separateDiv = XpathTable.split('/')
		String lostDiv = separateDiv[3].replace("div","")
		String closeBracket = lostDiv.replace("[","").replace("]","")
		//String closeBracket = openBracket.replace("]","")

		int Div = closeBracket.toInteger()

		WebDriver driver = DriverFactory.getWebDriver()
		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)

		String calendar = '/html/body/div['+Div+']/div'
		String headerXpath = calendar + '/div[1]/table/thead/tr[1]/th[2]'
		String YearXpath = calendar + '/div[2]/table/thead/tr/th[2]'

		Click(newTestObject(headerXpath))				//klik header
		Sleep(1)

		int headerTahun = WebUI.getText(newTestObject(YearXpath)).toInteger()
		String previousYear = calendar + '/div[2]/table/thead/tr/th[1]'
		String nextYear = calendar + '/div[2]/table/thead/tr/th[3]'

		if (Tahun<headerTahun) {						//cari tahun ke belakang
			while (Tahun!=headerTahun) {
				WebUI.click(newTestObject(previousYear))
				headerTahun = WebUI.getText(newTestObject(YearXpath)).toInteger()
			}

		} else if (Tahun>headerTahun) {					//cari tahun ke depan
			while(Tahun!=headerTahun){
				WebUI.click(newTestObject(nextYear))
				headerTahun = WebUI.getText(newTestObject(YearXpath)).toInteger()
			}
		}
		Sleep(1)

		String monthXpath = calendar + '/div[2]/table/tbody/tr//span[./text()=\''+Bulan+'\']'
		String dateXpath = calendar + '/div[1]/table/tbody//td[./text()=\''+Tanggal+'\' and not(@class=\'day old\') and not(@class=\'day new\')]'

		WebUI.click(newTestObject(monthXpath))				//klik bulan yang tersedia
		Sleep(1)

		WebUI.click(newTestObject(dateXpath))				//klik tanggal yang ada
		Sleep(1)

		WebUI.switchToDefaultContent()
	}

	@Keyword
	public static ArrayList getAllColumnValue (TestObject tableXpath, String gridColumn) {
		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)
		WebDriver Driver = DriverFactory.getWebDriver()

		TestObject tObj = tableXpath
		String XpathTable = "${tObj.findPropertyValue('xpath')}"

		String XpathTableRowBody = XpathTable + '/tbody'
		String XpathTableHead = XpathTable + '/thead//tr'
		String XpathTableBody = XpathTable + '/tbody//tr'

		WebElement tableHead = Driver.findElement(By.xpath(XpathTableHead))
		List<WebElement> rows =  tableHead.findElements(By.tagName("th"))

		List<String> collsName = new ArrayList()
		List<String> column = new ArrayList()

//		if (tableBody != null) {
			int i
			for (i = 0 ; i < rows.size() ; i++){
				List<WebElement> Colls = rows[i].findElements(By.tagName("span"))
				if (Colls.size() == 0){
					continue
				} else {
					collsName.add(Colls[0].getText())
				}
				WebElement tableBody = Driver.findElement(By.xpath(XpathTableBody))
				WebElement tableRowBody = Driver.findElement(By.xpath(XpathTableRowBody))
				
				List<WebElement> baris =  tableBody.findElements(By.tagName("td"))
				List<WebElement> rowBody = tableRowBody.findElements(By.tagName("tr"))
   
				int a
				if (collsName[i] == gridColumn) {
					for (a = 0 ; a < rowBody.size() ; a++) {
						List<WebElement> Kolom = rowBody[a].findElements(By.tagName("span"))
						if (Kolom.size() == 0){
							continue
						} else {
							column.add(Kolom[i].getText())
						}
					}
				}
			}
//		} 
//	else {
//			column = null
//		}
		WebUI.switchToDefaultContent()
		return column
	}

	@Keyword
	public static ArrayList getAllRowsValue (TestObject tableXpath, String columnHeader, String RowsValue) {
		WebDriver Driver = DriverFactory.getWebDriver()

		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)

		TestObject tObj = tableXpath
		String XpathTable = "${tObj.findPropertyValue('xpath')}"

		String XpathTableRowBody = XpathTable + '//tbody'
		String XpathTableHead = XpathTable + '//thead//tr'
		String XpathTableBody = XpathTable + '//tbody//tr'

		WebElement tableHead = Driver.findElement(By.xpath(XpathTableHead))
		WebElement tableBody = Driver.findElement(By.xpath(XpathTableBody))
		WebElement tableRowBody = Driver.findElement(By.xpath(XpathTableRowBody))
		WebElement BodyTable = Driver.findElement(By.xpath(XpathTable))


		List<WebElement> body = BodyTable.findElements(By.tagName("tbody"))
		List<WebElement> rows =  tableHead.findElements(By.tagName("th"))
		List<WebElement> baris =  tableBody.findElements(By.tagName("td"))
		List<WebElement> rowBody = tableRowBody.findElements(By.tagName("tr"))
		List<WebElement> spanBody = tableRowBody.findElements(By.tagName("span"))

		List<String> collsName = new ArrayList()
		List<String> column = new ArrayList()
		List<String> line = new ArrayList()
		int index = 0

		int i
		for (i = 0 ; i < rows.size() ; i++){
			List<WebElement> Colls = rows[i].findElements(By.tagName("span"))
			if (Colls.size() == 0){
				collsName.add('')
				index += 1
				//				continue
			} else {
				collsName.add(Colls[0].getText())
			}

			int a

			if (collsName[i] == columnHeader) {
				for (a = 0 ; a < rowBody.size() ; a++) {
					List<WebElement> Kolom = rowBody[a].findElements(By.tagName("span"))
					if (Kolom.size() == 0){
						continue
					} else {
						column.add(Kolom[i-index].getText())
					}

					int x
					if (column[a] == RowsValue) {
						for (x = 0 ; x < baris.size() ; x++) {
							List<WebElement> Lines = rowBody[a].findElements(By.tagName("td"))
							if (Lines.size() == 0) {
								continue
							} else {
								line.add(Lines[x].getText())
							}
						}
					}
				}
			}
		}
		WebUI.switchToDefaultContent()
		return line
	}

	@Keyword
	public static void CompareRowsValue (TestObject tableXpath, String columnHeader, String RowsValue, ArrayList RowsCompare) {
		WebDriver Driver = DriverFactory.getWebDriver()

		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)

		TestObject tObj = tableXpath
		String XpathTable = "${tObj.findPropertyValue('xpath')}"

		String XpathTableRowBody = XpathTable + '/tbody'
		String XpathTableHead = XpathTable + '/thead//tr'
		String XpathTableBody = XpathTable + '/tbody//tr'

		WebElement tableHead = Driver.findElement(By.xpath(XpathTableHead))
		WebElement tableBody = Driver.findElement(By.xpath(XpathTableBody))
		WebElement tableRowBody = Driver.findElement(By.xpath(XpathTableRowBody))
		WebElement BodyTable = Driver.findElement(By.xpath(XpathTable))

		List<WebElement> body = BodyTable.findElements(By.tagName("tbody"))
		List<WebElement> rows =  tableHead.findElements(By.tagName("th"))
		List<WebElement> baris =  tableBody.findElements(By.tagName("td"))
		List<WebElement> rowBody = tableRowBody.findElements(By.tagName("tr"))
		List<WebElement> spanBody = tableRowBody.findElements(By.tagName("span"))

		List<String> collsName = new ArrayList()
		List<String> column = new ArrayList()
		List<String> line = new ArrayList()
		int index = 0

		int i
		for (i = 0 ; i < rows.size() ; i++){
			List<WebElement> Colls = rows[i].findElements(By.tagName("span"))
			if (Colls.size() == 0){
				collsName.add('')
				index += 1
				//				continue
			} else {
				collsName.add(Colls[0].getText())
			}

			int a
			if (collsName[i] == columnHeader) {
				for (a = 0 ; a < rowBody.size() ; a++) {
					List<WebElement> Kolom = rowBody[a].findElements(By.tagName("span"))
					if (Kolom.size() == 0){
						continue
					} else {
						column.add(Kolom[i-index].getText())
					}

					int x
					if (column[a] == RowsValue) {
						for (x = 0 ; x < baris.size() ; x++) {
							List<WebElement> Lines = rowBody[a].findElements(By.tagName("td"))
							if (Lines.size() == 0) {
								continue
							} else {
								line.add(Lines[x].getText())
							}
						}
					}
				}
			}
		}
		WebUI.switchToDefaultContent()

		int r
		for (r = 0 ; r < line.size() ; r++) {
			if (line[r].trim() == RowsCompare[r]) {
				KeywordUtil.markPassed("Value of Column " + collsName[r] +" has same Value with array")
			} else {
				KeywordUtil.markWarning("Value of Column " + collsName[r] +" has different Value, Column Value = "+ line[r] + " Compare to Array = "+ RowsCompare[r])
			}
		}
	}

	@Keyword
	public static void CompareColumnsValue (TestObject tableXpath, String gridColumn, ArrayList CompareColumn) {
		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)
		WebDriver Driver = DriverFactory.getWebDriver()

		TestObject tObj = tableXpath
		String XpathTable = "${tObj.findPropertyValue('xpath')}"

		String XpathTableRowBody = XpathTable + '/tbody'
		String XpathTableHead = XpathTable + '/thead//tr'
		String XpathTableBody = XpathTable + '/tbody//tr'

		WebElement tableHead = Driver.findElement(By.xpath(XpathTableHead))
		WebElement tableBody = Driver.findElement(By.xpath(XpathTableBody))
		WebElement tableRowBody = Driver.findElement(By.xpath(XpathTableRowBody))

		List<WebElement> rows =  tableHead.findElements(By.tagName("th"))
		List<WebElement> baris =  tableBody.findElements(By.tagName("td"))
		List<WebElement> rowBody = tableRowBody.findElements(By.tagName("tr"))

		List<String> collsName = new ArrayList()
		List<String> column = new ArrayList()

		int i
		for (i = 0 ; i < rows.size() ; i++){
			List<WebElement> Colls = rows[i].findElements(By.tagName("span"))
			if (Colls.size() == 0){
				continue
			} else {
				collsName.add(Colls[0].getText())
			}

			int a
			if (collsName[i] == gridColumn) {
				for (a = 0 ; a < rowBody.size() ; a++) {
					List<WebElement> Kolom = rowBody[a].findElements(By.tagName("span"))
					if (Kolom.size() == 0){
						continue
					} else {
						column.add(Kolom[i].getText())
					}
				}
			}
		}
		WebUI.switchToDefaultContent()
		int r
		for (r = 0 ; r < column.size() ; r++) {
			int sum = r + 1

			if (column[r].trim() == CompareColumn[r]) {
				KeywordUtil.markPassed("Value of Row " + sum +" has same Value with array")
			} else {
				KeywordUtil.markWarning("Value of Row " + sum +" has different Value, Column Value = "+ column[r] + " Compare to Array = "+ CompareColumn[r])
			}
		}
	}

	@Keyword
	public static void ClickExpectedRow (TestObject tableXpath, String gridColumn, String columnValue) {
		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)
		WebDriver Driver = DriverFactory.getWebDriver()

		TestObject tObj = tableXpath
		String XpathTable = "${tObj.findPropertyValue('xpath')}"

		String XpathTableRowBody = XpathTable + '/tbody'
		String XpathTableHead = XpathTable + '/thead//tr'
		String XpathTableBody = XpathTable + '/tbody//tr'

		WebElement tableHead = Driver.findElement(By.xpath(XpathTableHead))
		WebElement tableBody = Driver.findElement(By.xpath(XpathTableBody))
		WebElement tableRowBody = Driver.findElement(By.xpath(XpathTableRowBody))

		List<WebElement> rows =  tableHead.findElements(By.tagName("th"))
		List<WebElement> baris =  tableBody.findElements(By.tagName("td"))
		List<WebElement> rowBody = tableRowBody.findElements(By.tagName("tr"))

		List<String> collsName = new ArrayList()
		List<String> column = new ArrayList()
		int index = 0

		int i
		for (i = 0 ; i < rows.size() ; i++){
			List<WebElement> Colls = rows[i].findElements(By.tagName("span"))
			if (Colls.size() == 0){
				collsName.add('')
				index += 1
				//				continue
			} else {
				collsName.add(Colls[0].getText())
			}

			int a
			if (collsName[i] == gridColumn) {
				for (a = 0 ; a < rowBody.size() ; a++) {
					List<WebElement> Kolom = rowBody[a].findElements(By.tagName("span"))
					if (Kolom.size() == 0){
						continue
					} else {
						column.add(Kolom[i-index].getText())

						if (column[a] == columnValue) {
							String xpathButton = XpathTableBody + '//span[text()=\'' + column[a] + '\']'
							Click(newTestObject(xpathButton))
						}
					}
				}
			}
		}
		WebUI.switchToDefaultContent()
	}

	@Keyword
	public static void ClickExpectedRowWithNext (TestObject tableXpath, String gridColumn, String columnValue, TestObject ButtonNext) {
		boolean found  = false

		while (!found) {
			String FrameXpath = '/html/frameset/frame'
			WebUI.switchToDefaultContent()
			WebUI.switchToFrame(newTestObject(FrameXpath), 1)
			WebDriver Driver = DriverFactory.getWebDriver()

			TestObject tObj = tableXpath
			String XpathTable = "${tObj.findPropertyValue('xpath')}"

			String XpathTableRowBody = XpathTable + '/tbody'
			String XpathTableHead = XpathTable + '/thead//tr'
			String XpathTableBody = XpathTable + '/tbody//tr'

			WebElement tableHead = Driver.findElement(By.xpath(XpathTableHead))
			WebElement tableBody = Driver.findElement(By.xpath(XpathTableBody))
			WebElement tableRowBody = Driver.findElement(By.xpath(XpathTableRowBody))

			List<WebElement> rows =  tableHead.findElements(By.tagName("th"))
			List<WebElement> baris =  tableBody.findElements(By.tagName("td"))
			List<WebElement> rowBody = tableRowBody.findElements(By.tagName("tr"))
			List<String> collsName = new ArrayList()
			List<String> column = new ArrayList()
			int index = 0

			int i = 0
			for (i = 0 ; i < rows.size() ; i++){
				ArrayList Colls = new ArrayList()
				Colls = rows[i].findElements(By.tagName("span"))
				if (Colls.size() == 0){
					collsName.add('')
					index += 1
					//					continue
				} else {
					collsName.add(Colls[0].getText())
				}

				int a = 0
				if (collsName[i] == gridColumn) {
					for (a = 0 ; a < rowBody.size() ; a++) {
						ArrayList Kolom = new ArrayList()
						Kolom = rowBody[a].findElements(By.tagName("span"))
						if (Kolom.size() == 0){
							continue
						} else {
							column.add(Kolom[i-index].getText())

							if (column[a].trim() == columnValue) { //1190022999
								String xpathButton = XpathTableBody + '//span[normalize-space()=\'' + column[a] + '\']'
								Click(newTestObject(xpathButton))
								found  = true

								break
							}
						}
					}
				}
				if (found == true) {
					break
				}
			}
			if (!found) {
				WebUI.switchToDefaultContent()
				WebUI.click(ButtonNext)
				GEN5.ProcessingCommand()
			}
		}
		WebUI.switchToDefaultContent()
	}

	@Keyword
	public static void ProcessingCommand () {
		String FrameXpath = '/html/frameset/frame'
		String xPath = '//div[contains(@id,"Blocker_Box") and not(contains(@style,"display: none"))]'

		Sleep(1)
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)

		boolean processing = WebUI.waitForElementPresent(newTestObject(xPath),
				5, FailureHandling.STOP_ON_FAILURE)

		while (processing) {
			KeywordUtil.logInfo('Processing Command pop up still displayed')
			Sleep(2)

			processing = WebUI.waitForElementPresent(newTestObject(xPath), 2, FailureHandling.STOP_ON_FAILURE)
		}
		KeywordUtil.markPassed('Processing Command Pop Up has finished')
		Sleep(1)
		WebUI.switchToDefaultContent()
	}

	@Keyword
	public static void CompareColumnToDatabase (TestObject tableXpath, String gridColumn, String url, String dbname, String queryTable, String getColumn) {
		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)
		WebDriver Driver = DriverFactory.getWebDriver()

		TestObject tObj = tableXpath
		String XpathTable = "${tObj.findPropertyValue('xpath')}"

		String XpathTableRowBody = XpathTable + '/tbody'
		String XpathTableHead = XpathTable + '/thead//tr'
		String XpathTableBody = XpathTable + '/tbody//tr'

		WebElement tableHead = Driver.findElement(By.xpath(XpathTableHead))
		WebElement tableBody = Driver.findElement(By.xpath(XpathTableBody))
		WebElement tableRowBody = Driver.findElement(By.xpath(XpathTableRowBody))

		List<WebElement> rows =  tableHead.findElements(By.tagName("th"))
		List<WebElement> baris =  tableBody.findElements(By.tagName("td"))
		List<WebElement> rowBody = tableRowBody.findElements(By.tagName("tr"))

		List<String> collsName = new ArrayList()
		List<String> column = new ArrayList()

		int i
		for (i = 0 ; i < rows.size() ; i++){
			List<WebElement> Colls = rows[i].findElements(By.tagName("span"))
			if (Colls.size() == 0){
				continue
			} else {
				collsName.add(Colls[0].getText())
			}

			int a
			if (collsName[i] == gridColumn) {
				for (a = 0 ; a < rowBody.size() ; a++) {
					List<WebElement> Kolom = rowBody[a].findElements(By.tagName("span"))
					if (Kolom.size() == 0){
						continue
					} else {
						column.add(Kolom[i].getText())
					}
				}
			}
		}
		WebUI.switchToDefaultContent()

		int r
		def database = getOneColumnDatabase(url, dbname, queryTable, getColumn)
		for (r = 0 ; r < column.size() ; r++) {
			int sum = r + 1

			if (column[r].trim() == database[r]) {
				KeywordUtil.markPassed("Value of Row " + sum +" has same Value with Database")
			} else {
				KeywordUtil.markWarning("Value of Row " + sum +" has different Value, Column Value = "+ column[r] + " Compare to Database Value = "+ database[r])
			}
		}
	}

	@Keyword
	public static void CompareRowToDatabase (TestObject tableXpath, String columnHeader, String RowsValue, String url, String dbname, String queryTable) {
		WebDriver Driver = DriverFactory.getWebDriver()

		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)

		TestObject tObj = tableXpath
		String XpathTable = "${tObj.findPropertyValue('xpath')}"

		String XpathTableRowBody = XpathTable + '/tbody'
		String XpathTableHead = XpathTable + '/thead//tr'
		String XpathTableBody = XpathTable + '/tbody//tr'

		WebElement tableHead = Driver.findElement(By.xpath(XpathTableHead))
		WebElement tableBody = Driver.findElement(By.xpath(XpathTableBody))
		WebElement tableRowBody = Driver.findElement(By.xpath(XpathTableRowBody))
		WebElement BodyTable = Driver.findElement(By.xpath(XpathTable))


		List<WebElement> body = BodyTable.findElements(By.tagName("tbody"))
		List<WebElement> rows =  tableHead.findElements(By.tagName("th"))
		List<WebElement> baris =  tableBody.findElements(By.tagName("td"))
		List<WebElement> rowBody = tableRowBody.findElements(By.tagName("tr"))
		List<WebElement> spanBody = tableRowBody.findElements(By.tagName("span"))

		List<String> collsName = new ArrayList()
		List<String> column = new ArrayList()
		List<String> line = new ArrayList()

		int i
		for (i = 0 ; i < rows.size() ; i++){
			List<WebElement> Colls = rows[i].findElements(By.tagName("span"))
			if (Colls.size() == 0){
				continue
			} else {
				collsName.add(Colls[0].getText())
			}

			int a
			if (collsName[i] == columnHeader) {
				for (a = 0 ; a < rowBody.size() ; a++) {
					List<WebElement> Kolom = rowBody[a].findElements(By.tagName("span"))
					if (Kolom.size() == 0){
						continue
					} else {
						column.add(Kolom[i].getText())
					}

					int x
					if (column[a] == RowsValue) {
						for (x = 0 ; x < baris.size() ; x++) {
							List<WebElement> Lines = rowBody[a].findElements(By.tagName("td"))
							if (Lines.size() == 0) {
								continue
							} else {
								line.add(Lines[x].getText())
							}
						}
					}
				}
			}
		}
		WebUI.switchToDefaultContent()

		int r
		def database =  getOneRowDatabase(url, dbname, queryTable)
		for (r = 0 ; r < line.size() ; r++) {
			int sum = r + 1

			if (line[r].trim() == database[r]) {
				KeywordUtil.markPassed("Value of Row " + sum +" has same Value with Database")
			} else {
				KeywordUtil.markWarning("Value of Row " + sum +" has different Value, Column Value = "+ line[r] + " Compare to Database Value = "+ database[r])
			}
		}
	}

	@Keyword
	public static void InsertIntoDataHealth (String type, String AppName, String value) {
		connectDB('172.16.94.48', 'LiTT', 'sa', 'Password95')

		def Query = execute('INSERT INTO dbo.DataHealth (Type,ApplicationName,value,RowStatus)VALUES(\''+ type +'\',\''+ AppName +'\',\''+ value +'\',0)')
		KeywordUtil.markPassed('Data has been inserted into Database dbo.DataHealth')
		closeDatabaseConnection()
	}

	@Keyword
	public static String getDataFromDataHealth (String Parameter, String ParamValue, String Value) {
		connectDB('172.16.94.48', 'LiTT', 'sa', 'Password95')

		def Query = executeQuery('SELECT TOP 1 * FROM DataHealth WHERE RowStatus = \'0\' and '+ Parameter +' = \''+ ParamValue +'\' ORDER BY id DESC')

		Query.next()
		String getData = Query.getString(Value)

		KeywordUtil.markPassed('Success get value \''+ Value + '\' from table dbo.DataHealth')
		closeDatabaseConnection()
		return getData
	}

	@Keyword
	public static def getPopUpText (TestObject TextOnPopup) {
		String getText = WebUI.getText(TextOnPopup, FailureHandling.STOP_ON_FAILURE)
		String[] separate = getText.split(" ")

		if (getText.contains("Complaint")) {
			String result = separate[-1]
			return result

		} else if (getText.contains("Tiket ID")) {
			String result = separate[-2]
			return result

		} else if (getText.contains("Document")) {
			List<String> sum = new ArrayList()
			String[] result = getText.split(" : ")
			String[] cut = result[1].split("\\.")

			sum.add(cut[0])
			sum.add(result[2])

			return sum
		}
		//		return resultSet
	}

	@Keyword
	public static void tickAllCheckboxInTable (TestObject Object) {
		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)

		WebDriver driver = DriverFactory.getWebDriver()

		TestObject tObj = Object
		String Xpath = "${tObj.findPropertyValue('xpath')}"

		String getXpath = Xpath + '/tbody'

		WebElement table = driver.findElement(By.xpath(getXpath))
		List<WebElement> row = table.findElements(By.tagName("tr"))

		int i
		int row_count = row.size()

		for (i = 1 ; i <= row_count ; i++) {
			String checkbox = Xpath + "//tr["+ i +"]//*[@type=\"checkbox\"]"
			WebUI.click(newTestObject(checkbox))
		}
		WebUI.switchToDefaultContent()
	}
}

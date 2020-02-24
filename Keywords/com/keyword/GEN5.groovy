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
	public static def SideMenu (String sideMenu) {
		String FrameXpath = '/html/frameset/frame'
		String CollapseXpath = '//button[text()=\''+ sideMenu +'\']//parent::div//parent::div[@aria-expanded=\'true\']'
		String ParentXpath = '//button[text()=\''+ sideMenu +'\']//parent::div//parent::div//parent::div//div[@class=\'panel-heading\']'
		String MenuXpath = '//button[text()=\''+ sideMenu +'\']'

		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)
		boolean exist = WebUI.waitForElementPresent(newTestObject(CollapseXpath), 3, FailureHandling.OPTIONAL)

		while (exist == false) {
			Click(newTestObject(ParentXpath))
			exist = WebUI.waitForElementPresent(newTestObject(CollapseXpath), 3, FailureHandling.OPTIONAL)
		}

		Click(newTestObject(MenuXpath))
		WebUI.switchToDefaultContent(FailureHandling.STOP_ON_FAILURE)

		Sleep(2)
		WebUI.switchToDefaultContent()
	}

	@Keyword // By Arnold
	public static def DatePicker(String DateNow, TestObject DatePickerDiv){
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
		String openBracket = lostDiv.replace("[","")
		String closeBracket = openBracket.replace("]","")

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
				Click(newTestObject(previousYear))
				headerTahun = WebUI.getText(newTestObject(YearXpath)).toInteger()
			}

		} else if (Tahun>headerTahun) {					//cari tahun ke depan
			while(Tahun!=headerTahun){
				Click(newTestObject(nextYear))
				headerTahun = WebUI.getText(newTestObject(YearXpath)).toInteger()
			}
		}
		Sleep(1)

		String monthXpath = calendar + '/div[2]/table/tbody/tr//span[./text()=\''+Bulan+'\']'
		String dateXpath = calendar + '/div[1]/table/tbody//td[./text()=\''+Tanggal+'\' and not(@class=\'day old\') and not(@class=\'day new\')]'

		Click(newTestObject(monthXpath))				//klik bulan yang tersedia
		Sleep(1)

		Click(newTestObject(dateXpath))					//klik tanggal yang ada
		Sleep(1)

		WebUI.switchToDefaultContent()
	}

	@Keyword
	public static def getAllColumnValue (TestObject tableXpath, String gridColumn) {
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
		return column
	}

	@Keyword
	public static def getAllRowsValue (TestObject tableXpath, String columnHeader, String RowsValue) {
		WebDriver Driver = DriverFactory.getWebDriver()

		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/GEN5/Frame Set'), 2)

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
		return line
	}

	@Keyword
	public static def CompareRowsValue (TestObject tableXpath, String columnHeader, String RowsValue, ArrayList RowsCompare) {
		WebDriver Driver = DriverFactory.getWebDriver()

		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/GEN5/Frame Set'), 2)

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
		for (r = 0 ; r < line.size() ; r++) {
			int sum = r + 1

			if (line[r].trim() == RowsCompare[r]) {
				KeywordUtil.markPassed("Value of Column " + collsName[r] +" has same Value with array")
			} else {
				KeywordUtil.markWarning("Value of Column " + collsName[r] +" has different Value, Column Value = "+ line[r] + " Compare to Array = "+ RowsCompare[r])
			}
		}
	}

	@Keyword
	public static def CompareColumnsValue (TestObject tableXpath, String gridColumn, ArrayList CompareColumn) {
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
	public static def ClickExpectedRow (TestObject tableXpath, String gridColumn, String columnValue) {
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
	public static def ProcessingCommand () {
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

			processing = WebUI.waitForElementPresent(newTestObject(xPath), 5, FailureHandling.STOP_ON_FAILURE)
		}
		KeywordUtil.markPassed('Processing Command Pop Up has finished')
		Sleep(1)
		WebUI.switchToDefaultContent()
	}

	@Keyword
	public static def CompareColumnToDatabase (TestObject tableXpath, String gridColumn, String url, String dbname, int totalRow, String queryTable, String getColumn) {
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
		def database = getOneColumnDatabase(url, dbname, totalRow, queryTable, getColumn)
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
	public static def CompareRowToDatabase (TestObject tableXpath, String columnHeader, String RowsValue, String url, String dbname, int totalColumn, String queryTable) {
		WebDriver Driver = DriverFactory.getWebDriver()

		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(findTestObject('Object Repository/GEN5/Frame Set'), 2)

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
		def database =  getOneRowDatabase(url, dbname, totalColumn, queryTable)
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
	public static def InsertIntoDataHealth (String type, String AppName, String value) {
		connectDB('172.16.94.48', 'LiTT', 'sa', 'Password95')

		def Query = executeQuery('INSERT INTO dbo.DataHealth (Type,ApplicationName,value,RowStatus)VALUES(\''+ type +'\',\''+ AppName +'\',\''+ value +'\',0)')
		KeywordUtil.markPassed('Data has been inserted into Database dbo.DataHealth')
		closeDatabaseConnection()
	}

	@Keyword
	public static def getDataFromDataHealth (String Parameter, String ParamValue, String Value) {
		connectDB('172.16.94.48', 'LiTT', 'sa', 'Password95')

		def Query = executeQuery('SELECT TOP 1 * FROM DataHealth WHERE RowStatus = \'0\' and '+ Parameter +' = \''+ ParamValue +'\' ORDER BY id DESC')

		Query.next()
		String getData = Query.getString(Value)

		KeywordUtil.markPassed('Success get value \''+ Value + '\' from table dbo.DataHealth')
		closeDatabaseConnection()
		return getData
	}

	@Keyword
	public static def CompareFieldtoDatabase (ArrayList ObjRep, String url, String dbname, int totalColumn, String queryTable) {
		String FrameXpath = '/html/frameset/frame'
		WebUI.switchToDefaultContent()
		WebUI.switchToFrame(newTestObject(FrameXpath), 1)

		int count = ObjRep.size()
		List<String> collectData = new ArrayList()

		int i
		for (i = 0 ; i < count ; i++) {
			collectData.add(WebUI.getAttribute(ObjRep[i], 'value', FailureHandling.STOP_ON_FAILURE))
		}

		ArrayList DBData = getOneRowDatabase(url, dbname, totalColumn, queryTable)
		List<String> Database = new ArrayList()

		int x
		for (x = 0 ; x < DBData.size() ; i++) {
			Database.add(DBData[x].toString())
		}

		int a
		for (a = 0 ; a < count ; a++) {
			if (collectData[a].trim() == Database[a].trim()) {
				KeywordUtil.markPassed('Value \'' + collectData[a] + '\' from field, has same value in database ' + DBData[a] )
			} else {
				KeywordUtil.markWarning('Field Value = \''+ collectData[a] + '\', value in database = \'' + DBData[a] + '\'')
			}
		}
		WebUI.switchToDefaultContent()
	}
}
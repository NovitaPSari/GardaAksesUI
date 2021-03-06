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
import org.apache.commons.io.FileUtils

import java.lang.Object
import java.lang.Process
import java.io.File
import java.sql.ResultSetMetaData

import org.apache.poi.xssf.usermodel.XSSFSheet
import org.apache.poi.xssf.usermodel.XSSFWorkbook

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions
import org.openqa.selenium.remote.DesiredCapabilities

import internal.GlobalVariable

public class UI {
	private static Connection connection = null;

	@Keyword
	public static def connectDB(String url, String dbname, String username, String password){
		String conn = "jdbc:sqlserver://" + url + ";databasename=" + dbname
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = DriverManager.getConnection(conn, username, password)
		return connection
	}

	@Keyword
	public static def executeQuery(String queryString) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryString)

		return rs
	}

	@Keyword
	public static def execute(String queryString) {
		Statement stm = connection.createStatement()
		boolean result = stm.execute(queryString)

		return result
	}

	@Keyword
	public static int countdbColumn (String queryTable) {
		Statement stm = connection.createStatement()
		ResultSet rs = stm.executeQuery(queryTable)

		ResultSetMetaData rsmd = rs.getMetaData()
		int countColumn = rsmd.getColumnCount()

		KeywordUtil.markPassed('Total column is ' + countColumn)
		return countColumn
	}

	@Keyword
	public static int countdbRow (String queryTable) {
		def Query = executeQuery(queryTable)
		ArrayList countRow = new ArrayList()

		while (Query.next()) {
			Object getData = Query.getObject(1)
			countRow.add(getData)
		}

		KeywordUtil.markPassed('Total row is ' + countRow.size())
		return countRow.size()
	}

	@Keyword
	public static String getValueDatabase (String url, String dbname, String queryTable, String ColumnName) {
		connectDB(url, dbname, "sa", "Password95")
		def Data = executeQuery(queryTable)
		String result

		if (!(Data.next())) {
			String hasil = null

			result = hasil
		} else {
			String getData = Data.getString(ColumnName)
			result = getData
		}
		closeDatabaseConnection()
		return result.toString().trim()
	}

	@Keyword
	public static void updateValueDatabase (String url, String dbname, String updateQuery) {
		connectDB(url, dbname, "sa", "Password95")

		def Query2 = execute(updateQuery)

		KeywordUtil.markPassed("SQL Server Query has been updated")
		closeDatabaseConnection()
	}

	@Keyword
	public static ArrayList getOneRowDatabase(String url, String dbname, String queryTable) {
		connectDB(url, dbname, "sa", "Password95")
		ArrayList columnData = new ArrayList()

		def Data = executeQuery(queryTable)
		int countColumn = countdbColumn (queryTable)

		if (!(Data.next())) {
			columnData = null
		} else {
			int i
			for (i = 1 ; i <= countColumn ; i++) {
				Object getData = Data.getString(i)
				columnData.add(getData.toString().trim())
			}
		}
		closeDatabaseConnection()
		return columnData
	}

	@Keyword
	public static ArrayList getOneColumnDatabase(String url, String dbname, String queryTable, String ColumnName) {
		connectDB(url, dbname, "sa", "Password95")
		ArrayList columnData = new ArrayList()

		def Data = executeQuery(queryTable)
		int countRow = countdbRow (queryTable)

		int i
		for (i = 1 ; i <= countRow ; i++) {
			Data.next()
			Object getData = Data.getObject(ColumnName)
			columnData.add(getData.toString().trim())
		}
		closeDatabaseConnection()
		return columnData
	}

	@Keyword
	public static void compareRowDBtoArray (String url, String dbname, String queryTable, ArrayList listData) {
		ArrayList database = getOneRowDatabase(url, dbname, queryTable)

		int i
		for (i = 0 ; i < listData.size() ; i++) {
			if (database[i] == listData[i]) {
				KeywordUtil.markPassed("Value " + listData[i] +" from Array same with Database.")
			} else {
				KeywordUtil.markFailedAndStop("Value from Array = " + listData[i] + " has different Value from database = " + database[i])
			}
		}
	}

	@Keyword
	public static void CompareFieldtoDatabase (ArrayList ObjRep, String url, String dbname, String queryTable) {
		int count = ObjRep.size()
		List<String> collectData = new ArrayList()

		int i
		for (i = 0 ; i < count ; i++) {
			collectData.add(WebUI.getAttribute(ObjRep[i], 'value', FailureHandling.STOP_ON_FAILURE))
		}

		ArrayList DBData = getOneRowDatabase(url, dbname, queryTable)
		List<String> Database = new ArrayList()

		int x
		for (x = 0 ; x < DBData.size() ; x++) {
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
	}

	@Keyword
	public static ArrayList getFieldsValue (ArrayList ObjRep) {
		int count = ObjRep.size()
		List<String> collectData = new ArrayList()

		int i
		for (i = 0 ; i < count ; i++) {
			collectData.add(WebUI.getAttribute(ObjRep[i], 'value', FailureHandling.STOP_ON_FAILURE))
		}

		return collectData
	}

	@Keyword
	public static void closeDatabaseConnection() {
		if(connection != null && !connection.isClosed()){
			connection.close()
		}
		connection = null
	}

	@Keyword
	public static TestObject newTestObject(String locator){
		TestObject updatedTestObject = new TestObject("Grid")
		updatedTestObject.addProperty("xpath", ConditionType.EQUALS, locator)

		return updatedTestObject
	}

	@Keyword
	public static void AccessURL (String url) {
		String fixUrl = url.toLowerCase()

		if (fixUrl == "retail") {
			WebUI.openBrowser('https://gen5-qc.asuransiastra.com/retail')
			KeywordUtil.markPassed("URL \'https://gen5-qc.asuransiastra.com/retail\' has opened.")
		} else if (fixUrl == "health") {
			WebUI.openBrowser('https://gen5-qc.asuransiastra.com/health')
			KeywordUtil.markPassed("URL \'https://gen5-qc.asuransiastra.com/health\' has opened.")
		} else if (fixUrl == 'gardaakses') {
			WebUI.openBrowser('https://gen5-qc.asuransiastra.com/gardaakses')
			KeywordUtil.markPassed("URL \'https://gen5-qc.asuransiastra.com/gardaakses\' has opened.")
		} else {
			WebUI.openBrowser(url)
			KeywordUtil.markPassed("URL \'"+ url +"\' has opened.")
		}
		WebUI.maximizeWindow()
	}

	@Keyword
	public static void Sleep(int timeOut) {
		if (timeOut == 0 || timeOut == null || timeOut == "") {
			KeywordUtil.markWarning("Sleep time is unidentified")
		} else {
			WebUI.delay(timeOut)
			KeywordUtil.markPassed("Sleep time is "+ timeOut + " second(s)")
		}
	}

	@Keyword
	public static void Write (TestObject xpath, String text) {
		String toString = xpath.toString()
		String[] separate = toString.split(' ')
		String[] getName = separate[separate.size()-1].split('/')
		String objGet = getName[getName.size()-1]
		String objName = objGet.replace("'", "")

		if (xpath != null || xpath != "") {
			WebUI.setText(xpath, text, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.markPassed("Write text \'" + text + "\' on Text Area \'" + objName + "\'.")
			Sleep(1)
		} else {
			KeywordUtil.markFailedAndStop("Text Area \'"+ objName +"\' is not found, Please recheck your xpath")
		}
	}

	@Keyword
	public static void WaitElement (TestObject xpath) {
		String toString = xpath.toString()
		String[] separate = toString.split(' ')
		String[] getName = separate[separate.size()-1].split('/')
		String objGet = getName[getName.size()-1]
		String objName = objGet.replace("'", "")

		boolean isExist = WebUI.waitForElementPresent(xpath, 2, FailureHandling.STOP_ON_FAILURE)
		boolean isVisible = WebUI.waitForElementVisible(xpath, 2, FailureHandling.STOP_ON_FAILURE)

		while (!isExist) {
			Sleep(2)
			isExist = WebUI.waitForElementPresent(xpath, 2, FailureHandling.STOP_ON_FAILURE)
		}

		while (!isVisible) {
			Sleep(2)
			isVisible = WebUI.waitForElementVisible(xpath, 2, FailureHandling.STOP_ON_FAILURE)
		}

		KeywordUtil.markPassed('Element '+ objName + ' is displayed')
	}

	@Keyword
	public static void Click (TestObject xpath) {
		String toString = xpath.toString()
		String[] separate = toString.split(' ')
		String[] getName = separate[separate.size()-1].split('/')
		String objGet = getName[getName.size()-1]
		String objName = objGet.replace("'", "")

		if (xpath != null || xpath != "") {
			WebUI.click(xpath, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.markPassed("Button \'"+ objName +"\' has been Clicked")
			Sleep(1)
		} else {
			KeywordUtil.markFailedAndStop("Button \'"+ objName +"\' is not found, Please recheck your xpath")
		}
	}

	@Keyword
	public static void DoubleClick (TestObject xpath) {
		String toString = xpath.toString()
		String[] separate = toString.split(' ')
		String[] getName = separate[separate.size()-1].split('/')
		String objGet = getName[getName.size()-1]
		String objName = objGet.replace("'", "")

		if (xpath != null || xpath != "") {
			WebUI.doubleClick(xpath, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.markPassed("Double click on Button "+ objName)
		} else {
			KeywordUtil.markFailedAndStop("Button "+ objName +" is not found, Please recheck your xpath")
		}
	}

	@Keyword
	public static void DragAndDrop (TestObject sourceXpath, TestObject destinationXpath) {
		if ((sourceXpath != null || sourceXpath != "") && (destinationXpath != null || destinationXpath != "")) {
			KeywordUtil.markPassed("Drag and Drop has done successfully")
			WebUI.dragAndDropToObject(sourceXpath, destinationXpath, FailureHandling.STOP_ON_FAILURE)
		} else if (sourceXpath == null || sourceXpath == "") {
			KeywordUtil.markFailedAndStop("Source path is not found, Please recheck your xpath")
		} else if (destinationXpath == null || destinationXpath == "") {
			KeywordUtil.markFailedAndStop("Destination path is not found, Please recheck your xpath")
		}
	}

	@Keyword
	public static void Back () {
		WebUI.back()
		Sleep(1)
	}

	@Keyword
	public static void HoverItem (TestObject xpath) {
		String toString = xpath.toString()
		String[] separate = toString.split(' ')
		String[] getName = separate[separate.size()-1].split('/')
		String objGet = getName[getName.size()-1]
		String objName = objGet.replace("'", "")

		if (xpath != null || xpath != "") {
			WebUI.mouseOver(xpath, FailureHandling.STOP_ON_FAILURE)
			KeywordUtil.markPassed("Item "+ objName +" has been Hover")
		} else {
			KeywordUtil.markFailedAndStop("Item "+ objName +" is not found, Please recheck your xpath")
		}
	}

	@Keyword
	public static void DeleteWrite (TestObject xpath, String text ) {
		String getValue = WebUI.getAttribute(xpath,'value', FailureHandling.OPTIONAL)
		String getText = WebUI.getText(xpath, FailureHandling.OPTIONAL)
		String getValue2
		String getText2

		if ((getValue == null || getValue == "") && (getText == null || getText == "") ) {
			TestObject childValue = xpath
			String valueXpath = "${childValue.findPropertyValue('xpath')}"
			String childrenValue = valueXpath + '//*[@value]'
			boolean checkValue = WebUI.verifyElementHasAttribute(newTestObject(childrenValue), 'value', 2)

			if (checkValue) {
				String getValueA = WebUI.getAttribute(newTestObject(childrenValue), 'value', FailureHandling.CONTINUE_ON_FAILURE)
				getValue2 = getValueA
			}
			//			else {
			//				TestObject childText = xpath
			//				String textXpath = "${childText.findPropertyValue('xpath')}"
			//				String childrenText = textXpath + '//*[text()]'
			//				String getTextA = WebUI.getText(newTestObject(childrenText), FailureHandling.CONTINUE_ON_FAILURE)
			//
			//				getText2 = getTextA
			//			}
		}

		if (getValue != "" || getValue != null || getValue2 != "" || getValue2 != null) {
			KeywordUtil.markPassed('Text field contains ' + getValue)
		}
		//		else if (getText != "" || getText != null || getText2 != "" || getText2 != null) {
		//			KeywordUtil.markPassed('Text field contains ' + getText)
		//		}

		if (getValue != "" || getText != "" || getValue != null || getText != null || getValue2 != "" || getValue2 != null || getText2 != "" || getText2 != null) {
			WebUI.clearText(xpath)
			getValue = WebUI.getAttribute(xpath,'value', FailureHandling.OPTIONAL)
			getText = WebUI.getText(xpath, FailureHandling.OPTIONAL)

			if (getValue != "" || getText != "" || getValue == null || getText == null || getValue2 != "" || getValue2 != null || getText2 != "" || getText2 != null) {
				Write(xpath, "")
				getValue = WebUI.getAttribute(xpath,'value', FailureHandling.OPTIONAL)
				getText = WebUI.getText(xpath, FailureHandling.OPTIONAL)
			}

			if (getValue != "" || getValue != null || getValue2 != "" || getValue2 != null) {
				int CharValue = getValue.length()
				int i
				for (i = 0 ; i < CharValue ; i++) {
					WebUI.sendKeys(xpath, Keys.chord(Keys.BACK_SPACE) )
				}

				//				if (getText != "" || getText != null || getText2 != "" || getText2 != null) {
				//					int CharText = getText.length()
				//					int a
				//					for (a = 0 ; a < CharText ; a++) {
				//						WebUI.sendKeys(xpath, Keys.chord(Keys.BACK_SPACE) )
				//					}
				//				}
				KeywordUtil.markPassed('Existing text has been deleted, write text ' + text)
				Write(xpath, text)
			} else {
				KeywordUtil.markPassed('Text field is empty, write text ' + text)
				Write(xpath, text)
			}
		}
	}

	@Keyword
	public static void SkipWrite (TestObject xpath, String text) {
		String getValue = WebUI.getAttribute(xpath, 'value', FailureHandling.OPTIONAL)
		String getText = WebUI.getText(xpath, FailureHandling.OPTIONAL)

		if (getValue != "" || getValue != null) {
			KeywordUtil.markPassed('Text field contains text ' + getValue + ', and will be skipped ')
		} else if (getText != "" || getText != null) {
			KeywordUtil.markPassed('Text field contains text ' + getText + ', and will be skipped ')
		}

		if ((getValue == "" || getValue == null) && (getText == "" || getText == null) ) {
			KeywordUtil.markPassed('Text field is empty, write text ' + text)
			Write(xpath, text)
		}
	}

	@Keyword
	public static void ComboBoxSearch (TestObject Combo1, TestObject Combo2, String Value) {
		TestObject tObj = Combo2
		String findXpath = "${tObj.findPropertyValue('xpath')}"
		String children = '(' + findXpath + '//ancestor::*//*[contains(text(),\''+ Value + '\')])[1]'

		if (Combo1 != null || Combo1 != "") {
			Click(Combo1)
		} else {
			KeywordUtil.markFailedAndStop('Button Open Combo Box is not found, Please check your Xpath')
		}

		if (Combo2 != null || Combo2 != "") {
			Write(Combo2, Value)
		} else {
			KeywordUtil.markFailedAndStop('Search field is not found, Please check your Xpath')
		}

		Sleep(1)

		if (newTestObject(children) != null || newTestObject(children) != "") {
			Click(newTestObject(children))
		} else {
			KeywordUtil.markFailedAndStop('Button ' + Value + ' is not found')
		}
	}

	@Keyword
	public static void ComboBoxSearchSkip (TestObject comboOpen, TestObject comboSearch, String Value) {
		String getValue = WebUI.getAttribute(comboOpen,'value', FailureHandling.OPTIONAL)
		String getText = WebUI.getText(comboOpen, FailureHandling.OPTIONAL)

		boolean cekText
		boolean checkValue

		if (getValue == null || getValue == "") {
			boolean value = false
			checkValue = value
		} else {
			if (getValue.contains('Please') || getValue.contains('Silakan') || getText.contains('Ketik')) {
				boolean value = true
				checkValue = value
			} else {
				boolean value = false
				checkValue = value
			}
		}

		if (getText == null || getText == "") {
			boolean value = false
			cekText = value
		} else {
			if (getText.contains('Please') || getText.contains('Silakan') || getText.contains('Ketik')) {
				boolean value = true
				cekText = value
			} else {
				boolean value = false
				cekText = value
			}
		}

		TestObject tObj = comboSearch
		String findXpath = "${tObj.findPropertyValue('xpath')}"
		String children = '(' + findXpath + '//ancestor::*//*[contains(text(),\''+ Value + '\')])[1]'

		if ((getValue == "" || checkValue) && (cekText || getText == "")) {

			if (comboOpen != null || comboOpen != "") {
				Click(comboOpen)
			} else {
				KeywordUtil.markFailedAndStop('Button Open Combo Box is not found, Please check your Xpath')
			}

			if (comboSearch != null || comboSearch != "") {
				Write(comboSearch, Value)
			} else {
				KeywordUtil.markFailedAndStop('Search field is not found, Please check your Xpath')
			}

			Sleep(1)

			if (newTestObject(children) != null || newTestObject(children) != "") {
				Click(newTestObject(children))
			} else {
				KeywordUtil.markFailedAndStop('Button ' + Value + ' is not found')
			}
		}
	}

	@Keyword
	public static void ComboBox (TestObject Combo, String Value) {
		TestObject tObj = Combo
		String findXpath = "${tObj.findPropertyValue('xpath')}"
		String children = '(' +findXpath + '//following-sibling::*/*[text()=\''+ Value +'\'])[1]'

		if (Combo != null || Combo != "") {
			Click(Combo)
		} else {
			KeywordUtil.markFailedAndStop('Button Open Combo Box is not found, Please check your Xpath')
		}

		if (newTestObject(children) != null || newTestObject(children) != "") {
			Click(newTestObject(children))
		} else {
			KeywordUtil.markFailedAndStop('Button ' + Value + ' is not found')
		}
	}

	@Keyword
	public static void MultiSelectComboBox (TestObject Combo, String Value1, String Value2, String Value3, String Value4) {
		if (Combo != null || Combo != "") {
			Click(Combo)
		} else {
			KeywordUtil.markFailedAndStop('Button Open Combo Box is not found, Please check your Xpath')
		}

		TestObject tObj1 = Combo
		String findXpath1 = "${tObj1.findPropertyValue('xpath')}"
		String children1 = '(' + findXpath1 + '/following-sibling::*/*[text()=\''+ Value1 +'\'])[1]'

		Click(newTestObject(children1))

		if (Value2 == null || Value2 == "") {
			KeywordUtil.markPassed("Second Value hasn't been set")
		} else {
			TestObject tObj2 = Combo
			String findXpath2 = "${tObj2.findPropertyValue('xpath')}"
			String children2 = '(' + findXpath2 + '/following-sibling::*/*[text()=\''+ Value2 +'\'])[1]'

			Click(newTestObject(children2))
		}

		if (Value3 == null || Value3 == "") {
			KeywordUtil.markPassed("Third Value hasn't been set")
		} else {
			TestObject tObj3 = Combo
			String findXpath3 = "${tObj3.findPropertyValue('xpath')}"
			String children3 = '(' + findXpath3 + '/following-sibling::*/*[text()=\''+ Value3 +'\'])[1]'

			Click(newTestObject(children3))
		}

		if (Value4 == null || Value4 == "") {
			KeywordUtil.markPassed("Fourth Value hasn't been set")
		} else {
			TestObject tObj4 = Combo
			String findXpath4 = "${tObj4.findPropertyValue('xpath')}"
			String children4 = '(' + findXpath4 + '/following-sibling::*/*[text()=\''+ Value4 +'\'])[1]'

			Click(newTestObject(children4))
		}

		Click(Combo)
	}

	@Keyword
	public static void CheckDisableandWrite (TestObject Xpath, String text) {
		boolean getValue = WebUI.verifyElementHasAttribute(Xpath, "disabled", 1, FailureHandling.OPTIONAL)

		if (!getValue) {
			boolean getAtt = WebUI.verifyElementHasAttribute(Xpath, "value", 1, FailureHandling.OPTIONAL)
			if (getAtt) {
				String getText = WebUI.getAttribute(Xpath, "value", FailureHandling.STOP_ON_FAILURE)
				if (getText != text) {
					WebUI.clearText(Xpath)
					getText = WebUI.getAttribute(Xpath, "value", FailureHandling.STOP_ON_FAILURE)

					if (getText != text || getText != "" || getText != null) {
						Write(Xpath, "")
						getText = WebUI.getAttribute(Xpath, "value", FailureHandling.STOP_ON_FAILURE)

						if (getText != text || getText != "" || getText != null) {
							int CharValue = getText.size()

							int i
							for (i = 0 ; i < CharValue ; i++) {
								WebUI.sendKeys(Xpath, Keys.chord(Keys.BACK_SPACE) )
							}
						}
					}
				}
			} else {
				Write(Xpath, text)
			}
		} else {
			KeywordUtil.markPassed("The Object is disable")
		}
	}

	@Keyword
	public static void RunningPhoneNumber (TestObject xpath) {
		connectDB('172.16.94.48', 'LiTT', 'sa', 'Password95')
		def Running = executeQuery('SELECT * FROM dbo.Otosales WHERE Parameters = \'Phone\'')

		Running.next()
		String getValue = Running.getString('Value')
		String phoneNumber = '08' + getValue

		def changeNumber = execute('UPDATE dbo.Otosales SET Value += 1 WHERE Parameters = \'Phone\'')

		closeDatabaseConnection()

		if (xpath != null || xpath != "") {
			Write(xpath, phoneNumber)
		} else {
			KeywordUtil.markFailedAndStop("Text box is not found, Please recheck your xpath")
		}
	}

	@Keyword
	public static void UploadFile (String fileLocation, String pictureName) {
		String locationFile = RunConfiguration.getProjectDir() + '/Plugins/FileLocation.txt'
		File write = new File(locationFile)
		String Location = fileLocation
		write.append(Location)

		String fileName = RunConfiguration.getProjectDir() + '/Plugins/FileName.txt'
		File write2 = new File(fileName)
		String name = pictureName
		write2.append(name)

		String upload = RunConfiguration.getProjectDir() + '/Plugins/UploadFile.exe'
		Process runUpload = Runtime.getRuntime().exec(upload)

		KeywordUtil.markPassed('Upload File : ' + pictureName + ' has Finished.' )
		Sleep(15)

		write.delete()
		write2.delete()
	}

	@Keyword
	public static void RunScheduler(String path){
		String[] getObj = path.split("\\")
		String objName = getObj[getObj.size()-1]

		Process s = Runtime.getRuntime().exec(path)
		while (s.isAlive()){
			KeywordUtil.markWarning('Scheduler '+ objName +' Still Running, Please wait until morning')
			WebUI.delay(5)
		}
		KeywordUtil.markPassed('Scheduler '+ objName +' has done')
	}

	@Keyword
	public static void WriteAllRowsXls (String path, int row ,ArrayList value) {
		int i
		int count = value.size()
		ArrayList cellData = new ArrayList()
		int baris = row - 1

		for (i = 0 ; i < count; i++) {
			FileInputStream file = new FileInputStream (new File(path))
			XSSFWorkbook workbook = new XSSFWorkbook(file)
			XSSFSheet sheet = workbook.getSheetAt(0)

			if (sheet.getRow(baris).getCell(i) == null) {
				def cell = sheet.getRow(baris).createCell(i)
			}

			int Data_fromCell=sheet.getRow(baris).getCell(i).getCellType()

			if (Data_fromCell == 1) {
				String getCellData = sheet.getRow(baris).getCell(i).getStringCellValue()
				cellData.add(getCellData)
			} else {
				int getCellData = sheet.getRow(baris).getCell(i).getNumericCellValue()
				cellData.add(getCellData)
			}

			if (value[i] == null) {
				continue
			} else if (cellData[i] != value[i]) {
				sheet.getRow(baris).createCell(i).setCellValue(value[i])
				file.close();

				FileOutputStream outFile = new FileOutputStream(new File(path));
				workbook.write(outFile);
				outFile.close();
			}
		}
		KeywordUtil.markPassed('Insert data on Excel has Done' )
	}

	@Keyword
	public static void WriteSingleCellXls (String path,int row, int column, def value) {
		FileInputStream file = new FileInputStream (new File(path))
		XSSFWorkbook workbook = new XSSFWorkbook(file)
		XSSFSheet sheet = workbook.getSheetAt(0)

		int baris = row - 1
		int kolom = column - 1

		sheet.getRow(baris).createCell(kolom).setCellValue(value)
		file.close()

		FileOutputStream outFile = new FileOutputStream(new File(path))
		workbook.write(outFile)
		outFile.close()
		KeywordUtil.markPassed('Text : \'' + value + '\' has inserted on Excel' )
	}

	@Keyword
	public static void AccessURLwithPlugin (String url, String Plugin) {
		System.setProperty("webdriver.chrome.driver", DriverFactory.getChromeDriverPath())
		ChromeOptions options = new ChromeOptions();
		String pluginPath = RunConfiguration.getProjectDir() + '/Plugins/' + Plugin
		options.addExtensions(new File(pluginPath));
		DesiredCapabilities capabilities = new DesiredCapabilities()
		capabilities.setCapability(ChromeOptions.CAPABILITY, options)

		ChromeDriver driver = new ChromeDriver(capabilities)

		String fixUrl = url.toLowerCase()

		if (fixUrl == "retail") {
			driver.get('https://gen5-qc.asuransiastra.com/retail')
			KeywordUtil.markPassed("URL \'https://gen5-qc.asuransiastra.com/retail\' has opened.")
		} else if (fixUrl == "health") {
			driver.get('https://gen5-qc.asuransiastra.com/health')
			KeywordUtil.markPassed("URL \'https://gen5-qc.asuransiastra.com/health\' has opened.")
		} else if (fixUrl == 'gardaakses') {
			driver.get('https://gen5-qc.asuransiastra.com/gardaakses')
			KeywordUtil.markPassed("URL \'https://gen5-qc.asuransiastra.com/gardaakses\' has opened.")
		} else {
			driver.get(url)
			KeywordUtil.markPassed("URL \'"+ url +"\' has opened.")
		}

		WebDriver changeDriver = DriverFactory.changeWebDriver(driver)
		WebUI.maximizeWindow()
	}

	@Keyword
	public static String readQRCode() {
		String upload = RunConfiguration.getProjectDir() + '/Plugins/OpenQRCode.exe'
		Process runUpload = Runtime.getRuntime().exec(upload)

		String locationFile = RunConfiguration.getProjectDir() + '/Plugins/QRCode.txt'
		File file = new File(locationFile)
		boolean exist = FileUtils.waitFor(file, 1)

		if (exist) {
			file.delete()
			exist = FileUtils.waitFor(file, 1)
		}

		while (!exist) {
			Sleep(2)
			exist = FileUtils.waitFor(file, 1)
		}

		Sleep(2)
		String text = FileUtils.readFileToString(file)
		KeywordUtil.markPassed("QR Code value = " + text)

		file.delete()
		return text
	}
}
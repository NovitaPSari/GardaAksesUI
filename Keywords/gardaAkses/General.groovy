package gardaAkses

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import org.openqa.selenium.WebDriver

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.driver.DriverFactory
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import org.openqa.selenium.Keys as Keys1
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import internal.GlobalVariable

public class General {

	@Keyword
	def Boolean waitProcessingCommand(){

		WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Alert - Processing Command'), 10)

		Integer stale = 0
		int countTO
		//wait until element appear
		//while(!WebUI.verifyElementClickable(objectToFind, FailureHandling.OPTIONAL)){}
		//element appear but processing command too
		WebUI.switchToFrame(findTestObject('Pages/Web/GEN5/Frame'), 5)
		WebDriver myDriver = DriverFactory.getWebDriver()
		try
		{
			while(true){
				//what if there isnt blocker? > done with try catch
				//Watchout for stale element error
				//need timeout parameter?
				//findTestObject has default 30s timeout > changed to driverfactory
				//for multiple processing command > "display: none" only appear once in last
				String result = myDriver.findElement(By.xpath("//*[contains(@id,'Blocker_Box')]")).getAttribute("style")
				//String result = WebUI.getAttribute(findTestObject('Page_a2is Retail/blocker'), 'style').toString()
				if(result.contains('display: none;'))
					break
				WebUI.delay(1)
				//WebUI.println('Found')
				countTO = countTO+1
				if(countTO == 30 ){
					throw new Exception("Freeze Processing Command")
				}
			}
		}
		catch(Exception ex)
		{
			WebUI.println('Not Found')
			WebUI.println(ex)
		}
		finally
		{
			WebUI.switchToDefaultContent()
			return true
		}
	}

	@Keyword
	def ShowSuggestion (TestObject Xpath, String Name) {

		WebUI.setText(Xpath, Name)

		WebUI.delay(GlobalVariable.Delay0)

		WebUI.setText(Xpath, Name)

		WebUI.delay(GlobalVariable.Delay0)
	}

	@Keyword
	def UpdateFieldText (TestObject Xpath, String Variable) {

		String getValue = WebUI.getAttribute(Xpath, 'value', FailureHandling.OPTIONAL)
		String getText = WebUI.getText(Xpath, FailureHandling.OPTIONAL)

		if (getValue != Variable) {
			WebUI.clearText(Xpath)

			WebUI.setText(Xpath, Variable)
		}

		if (getText != Variable) {
			WebUI.clearText(Xpath)

			WebUI.setText(Xpath, Variable)
		}

	}

	@Keyword
	def UpdateFieldCombo (TestObject XpathCombo, TestObject XpathList, String Variable) {

		String getValue = WebUI.getAttribute(XpathCombo, 'value', FailureHandling.OPTIONAL)
		String getText = WebUI.getText(XpathCombo, FailureHandling.OPTIONAL)

		if (getValue != Variable) {
			if (getValue == null || getValue == '') {
				WebUI.delay(0)
			} else {
				WebUI.click(XpathCombo)

				WebUI.click(XpathList)
			}
		}

		if (getText != Variable) {
			if (getText == null || getText == '') {
				WebUI.delay(0)
			} else {
				WebUI.click(XpathCombo)

				WebUI.click(XpathList)
			}
		}
	}
}

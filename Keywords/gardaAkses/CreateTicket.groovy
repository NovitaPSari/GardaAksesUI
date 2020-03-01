package gardaAkses

import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

import com.kms.katalon.core.annotation.Keyword
import com.kms.katalon.core.checkpoint.Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling
import com.kms.katalon.core.testcase.TestCase
import com.kms.katalon.core.testdata.TestData
import com.kms.katalon.core.testobject.TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import com.sun.org.apache.xpath.internal.compiler.Keywords

import internal.GlobalVariable

public class CreateTicket {

	@Keyword
	def ContactName (String ContactName) {
		WebUI.setText(findTestObject('Pages/Web/Garda Akses/Create Ticket/Input - Contact Name'), ContactName)

		def AutoComplete = WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Create Ticket/Auto Complete - Contact Name'),
				3)

		if (AutoComplete == true) {
			WebUI.delay(3)

			WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Auto Complete - Contact Name'))
		} else {
			WebUI.delay(0)
		}
	}

	@Keyword
	def ProviderName (String ProviderName) {

		WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Name'), ProviderName)

		WebUI.delay(3)

		WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Input - Provider Name'), ProviderName)

		WebUI.delay(3)

		WebUI.click(findTestObject('Pages/Web/Garda Akses/Create Ticket/Auto Complete - Provider Name'))
	}
}

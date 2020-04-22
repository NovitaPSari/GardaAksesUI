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

import internal.GlobalVariable

public class CreateGL {

	@Keyword
	def InputMemberName (TestObject Xpath, String MemberName) {

		def CurrentValue = WebUI.getAttribute(Xpath, 'value')

		if (CurrentValue != MemberName) {

			WebUI.setText(Xpath, MemberName)

			WebUI.delay(5)

			WebUI.setText(Xpath, MemberName)

			WebUI.delay(5)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Auto Complete - Member'))
		}

		def PopUpNonClient = WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Pop Up Non Client/Text - Non Client'), 3)

		if (PopUpNonClient) {
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Pop Up Non Client/Button - Close'))
		}
	}

	@Keyword
	def DatePicketStart (String Tanggal, String Bulan, int Tahun) {

		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Date Picker - DOB'))

		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Month Year'))

		def CurrentYear = WebUI.getText(WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Year')))

		def int DifferentYear = CurrentYear - Tahun

		for (def index : (0..DifferentYear)) {
			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Button - Prev Year'))

			WebUI.delay(2)
		}

		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - Month', [('Month') : Bulan]))

		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Patient Information/Add New Member/Choose - Date', [('Date') : Tanggal]))
	}
}

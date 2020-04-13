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

public class GetTicketID {

	@Keyword
	def GetTicketNumber (String Phase) {
		if (Phase == '1') {
			def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Text - Ticket Number'))

			GlobalVariable.TicketID1 = result.substring(9, 17)

			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Button - OK'))
		} else if (Phase == '2') {
			def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Text - Ticket Number'))

			GlobalVariable.TicketID2 = result.substring(9, 17)

			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Button - OK'))
		} else if (Phase == '3') {
			def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Text - Ticket Number'))

			GlobalVariable.TicketID3 = result.substring(9, 17)

			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Button - OK'))
		} else if (Phase == '4') {
			def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Text - Ticket Number'))

			GlobalVariable.TicketID4 = result.substring(9, 17)

			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Button - OK'))
		} else if (Phase == '5') {
			def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Text - Ticket Number'))

			GlobalVariable.TicketID5 = result.substring(9, 17)

			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Ticket Number/Button - OK'))
		}
	}

	@Keyword
	def ProviderHealthClaim (String Phase) {
		if (Phase == '1') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Text -Ticket ID'))

			GlobalVariable.TicketID1 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Button - Close'))
		} else if (Phase == '2') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Text -Ticket ID'))

			GlobalVariable.TicketID2 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Button - Close'))
		} else if (Phase == '3') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Text -Ticket ID'))

			GlobalVariable.TicketID3 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Button - Close'))
		} else if (Phase == '4') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Text -Ticket ID'))

			GlobalVariable.TicketID4 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Button - Close'))
		} else if (Phase == '5') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Text -Ticket ID'))

			GlobalVariable.TicketID5 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim/Ticket Created/Button - Close'))
		}
	}

	@Keyword
	def ProviderNonHealthCancellation (String Phase) {
		if (Phase == '1') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Text - Ticket ID'))

			GlobalVariable.TicketID1 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Button - OK'))
		} else if (Phase == '2') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Text - Ticket ID'))

			GlobalVariable.TicketID2 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Button - OK'))
		} else if (Phase == '3') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Text - Ticket ID'))

			GlobalVariable.TicketID3 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Button - OK'))
		} else if (Phase == '4') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Text - Ticket ID'))

			GlobalVariable.TicketID4 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Button - OK'))
		} else if (Phase == '5') {
			def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Text - Ticket ID'))

			GlobalVariable.TicketID5 = result.substring(10, 18)

			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Ticket Created/Button - OK'))
		}
	}
}
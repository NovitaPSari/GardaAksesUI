import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable

//Vehicle
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Cancellation/Button - Vehicle'))

WebUI.delay(GlobalVariable.Delay1)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Cancellation/Choose - Vehicle'))

//FU Status
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Cancellation/Button - FU Status'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Cancellation/Choose - FU Status Need FU - Insad'))

//FU Remarks
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Cancellation/Input - FU Remarks'), FURemarks)

//Button Direction
if (ButtonDirection == 'Save') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Cancellation/Button - Save'))
} else if (ButtonDirection == 'Back') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Cancellation/Button - Back'))
} else if (ButtonDirection == 'Exit') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Cancellation/Button - Exit'))
} else {
	WebUI.delay(0)
}

WebUI.getText(findTestObject('Pages/Web/Garda Akses/Service Type/Cancellation/Text - Get Ticket Number'))

def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Service Type/Cancellation/Text - Get Ticket Number'))

GlobalVariable.TicketIDAwal = result.substring(10, 18)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Cancellation/Button - OK'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))
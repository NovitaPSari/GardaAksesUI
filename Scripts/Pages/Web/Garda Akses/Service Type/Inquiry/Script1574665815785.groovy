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


//Member Name
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Member Name'), MemberName)

WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Member Name'), MemberName)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Choose - Member Name'))

//Provider Name
if (ContactLine == 'Customer' && Product == 'Health') {
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Provider Name'), ProviderName)
	
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Provider Name'), ProviderName)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Choose - Provider Name'))
} else {
	WebUI.delay(0)
}

//Sub Service Type
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Sub Service Type'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Choose - Sub Service Type', [('SubServiceType') : SubServiceType]))

//Remarks
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Remarks'), Remarks)

//Need Follow Up
if (NeedFollowUp == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Check Box - Need Follow Up'))
} else {
	WebUI.delay(0)
}

//Button Direction
if (ButtonDirection == 'Process') {
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

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Tidak Hal Lain Yang di Bantu'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Puas'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Show Thanks'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Close App'))
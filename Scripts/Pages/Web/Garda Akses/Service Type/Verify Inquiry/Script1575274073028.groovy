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

if (ButtonDirection == 'Back') {
	//Member Name
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Member Name'), MemberName)
	
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Member Name'), MemberName)
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Member Name'))
	
	//Provider Name
	if (ContactLine == 'Customer' && Product == 'Health') {
		WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Provider Name'), ProviderName)
		
		WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Provider Name'), ProviderName)
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Provider Name'))
	} else {
		WebUI.delay(0)
	}
	
	//Sub Service Type
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Sub Service Type'))
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Sub Service Type', [('SubServiceType') : SubServiceType]))
	
	//Remarks
	WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Remarks'), Remarks)
	
	//Need Follow Up
	if (NeedFollowUp == 'Yes') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Check Box - Need Follow Up'))
	} else {
		WebUI.delay(0)
	}
} else {
		WebUI.delay(0)
}

//Button Direction
if (ButtonDirection == 'Process') {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Process'))
} else if (ButtonDirection == 'Back') {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Back'))
} else if (ButtonDirection == 'Exit') {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit'))
} else {
	WebUI.delay(0)
}

if (ButtonDirection == 'Back') {
	WebUI.getText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Text - Get Ticket Number'))
	
	def result = WebUI.getText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Text - Get Ticket Number'))
	
	GlobalVariable.TicketIDAwal = result.substring(10, 18)
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - OK'))
	
	//Exit Confirmation 1 - Apakah ada hal lain yang dapat dibantu, Pak/Bu?
	if (ExitConfirmation1 == 'Yes') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 1 Yes'))
	} else if (ExitConfirmation1 == 'No') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 1 No'))
	}
	
	//Exit Confirmation 2 - Sebelum mengakhiri percakapan, boleh kami dibantu untuk pertanyaan penutup yaitu Apakah Bapak/Ibu PUAS dengan informasi yang telah saya berikan?
	if (ExitConfirmation2 == 'Puas') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 2 Puas'))
	} else if (ExitConfirmation2 == 'Tidak Puas') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 2 Tidak Puas'))
	}
	
	//Exit Confirmation 3
	if (ExitConfirmation3 == 'Yes') {
		WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Exit Confirmation 3 Add Comment'), Comment)
		
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 3 Ok'))
	} else {
		WebUI.delay(0)
	}
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Show Thanks'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Close App'))
} else {
	WebUI.delay(0)
}
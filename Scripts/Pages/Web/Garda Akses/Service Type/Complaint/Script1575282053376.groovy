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

//Member Info
if (NewComplaint == 'Yes') {
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Search Member'))
	
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Search Member/Input - Member No'), MemberNo)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Search Member/Button - Search'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Search Member/Choose - Member'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Search Member/Button - Select'))
} else {
	WebUI.delay(0)
}

//Complaint Category
WebUI.scrollToElement(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Save'), GlobalVariable.Delay0)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Complaint Category'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Choose - Complaint Category', [('ComplaintCategory') : ComplaintCategory]))

//Complaint Sub Category
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Complaint Sub Category'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Choose - Complaint Sub Category', [('ComplaintSubCategory') : ComplaintSubCategory]))

//Complaint Description
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Input - Complaint Description'), ComplaintDescription)

//Ticket Status
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Ticket Status'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Choose - Ticket Status', [('TicketStatus') : TicketStatus]))

//Button Direction
if (ButtonDirection == 'Save') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Save'))
	
	WebUI.delay(GlobalVariable.Delay1)
	
	if (MultipleServiceType == 'Yes') {
		def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Text - Get Ticket Number'))
		
		GlobalVariable.TicketIDRevisi = result.substring(48, 56)
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - OK'))
	} else {
		def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Text - Get Ticket Number'))
		
		GlobalVariable.TicketIDAwal = result.substring(48, 56)
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - OK'))
	}
	
	//Exit Confirmation 1 - Apakah ada hal lain yang dapat dibantu, Pak/Bu?
	if (ExitConfirmation1 == 'Yes') {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 1 Yes'))
	} else {
		WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 1 No'))
		
		//Exit Confirmation 2 - Sebelum mengakhiri percakapan, boleh kami dibantu untuk pertanyaan penutup yaitu Apakah Bapak/Ibu PUAS dengan informasi yang telah saya berikan?
		if (ExitConfirmation2 == 'Puas') {
			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 2 Puas'))
		} else {
			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 2 Tidak Puas'))
			
			WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Exit Confirmation 3 Add Comment'), Comment)
			
			WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Exit Confirmation 3 Ok'))
		}
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Show Thanks'))
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Close App'))
	}
} else if (ButtonDirection == 'Back') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Back'))
} else if (ButtonDirection == 'Exit') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Complaint/Button - Exit'))
} else {
	WebUI.delay(0)
}
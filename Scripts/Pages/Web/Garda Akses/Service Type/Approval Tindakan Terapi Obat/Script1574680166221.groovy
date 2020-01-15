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
WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Member Name'), MemberName)

WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Member Name'), MemberName)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Choose - Member Name', [('MemberName') : MemberName]))

//Sub Service Type
WebUI.delay(GlobalVariable.Delay1)

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Button - Sub Service Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Choose - Sub Service Type', [('SubServiceType') : SubServiceType]))

//Remarks
WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Remarks'), Remarks)

//Need Follow Up
if (NeedFollowUp == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Check Box - Need Follow Up'))
} else {
	WebUI.delay(0)
}

//Back


//Action
if (Action == 'Proses') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Button - Process'))
	
	WebUI.delay(GlobalVariable.Delay1)
	
	if (MultipleServiceType == 'Yes') {
		def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Text - Ticket Number'))
		
		GlobalVariable.TicketIDRevisi = result.substring(9, 17)
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Button - OK'))
	} else {
		def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Text - Ticket Number'))
		
		GlobalVariable.TicketIDAwal = result.substring(9, 17)
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Button - OK'))
	}
	
	//Exit Confirmation 1 - Apakah ada hal lain yang dapat dibantu, Pak/Bu?
	if (ExitConfirmation1 == 'Yes') {
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 1 Yes'))
	} else {
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 1 No'))
		
		//Exit Confirmation 2 - Sebelum mengakhiri percakapan, boleh kami dibantu untuk pertanyaan penutup yaitu Apakah Bapak/Ibu PUAS dengan informasi yang telah saya berikan?
		if (ExitConfirmation2 == 'Puas') {
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 2 Puas'))
		} else {
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 2 Tidak Puas'))
			
			WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Input - Exit Confirmation 3 Add Comment'), Comment)
			
			WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Exit Confirmation 3 Ok'))
		}
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Show Thanks'))
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Ok Close App'))
	}
} else if (Back == 'Yes') {
	WebUI.click(findTestObject('null'))
} else {
	WebUI.delay(0)
}
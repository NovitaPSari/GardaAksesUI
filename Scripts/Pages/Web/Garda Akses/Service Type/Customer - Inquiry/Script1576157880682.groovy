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

CustomKeywords.'gardaAkses.ProcessingCommand.waitProcessingCommand'()

//Product
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Button - Product'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Choose - Product', [('Product') : Product]))

//Category
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Button - Category'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Choose - Category', [('Category') : Categorys]))

//FU Status
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Button - FU Status'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Choose - FU Status', [('FUStatus') : FUStatus]))

//FU Remarks
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Input - FU Remarks'), FURemarks)

//Button Direction
if (Action == 'Save') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Button - Save'))
	
	WebUI.delay(GlobalVariable.Delay1)
	
	if (MultipleServiceType == 'Yes') {
		def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Text - Ticket Number'))
		
		GlobalVariable.TicketIDRevisi = result.substring(10, 18)
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Button - Ok'))
	} else {
		def result = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Text - Ticket Number'))
		
		GlobalVariable.TicketIDAwal = result.substring(10, 18)
		
		WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Inquiry/Button - Ok'))
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
} else if (Action == 'Back') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Button - Back'))
} else {
	WebUI.delay(0)
}


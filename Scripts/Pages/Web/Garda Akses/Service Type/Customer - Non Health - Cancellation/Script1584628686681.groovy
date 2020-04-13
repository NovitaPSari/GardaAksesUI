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
import internal.GlobalVariable as GlobalVariable
import com.keyword.GEN5 as GEN5
import com.keyword.UI as UI

GEN5.ProcessingCommand()

//Product
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Combo - Product'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Combo List - Product',
		[('value') : Product]))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/1. Tab - Cancellation/Tab - Cancellation'))

//Vehicle
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/1. Tab - Cancellation/Combo - Vehicle'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/1. Tab - Cancellation/Choose - Vehicle - No 1'))

//FU Status
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Combo - FU Status'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Combo List - FU Status',
		[('value') : FUStatus]))

//FU Remarks
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Input - FU Remarks'),
	FURemarks)

//Button
if (ActionC == 'Save') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Button - Save'))
	
	CustomKeywords.'gardaAkses.GetTicketID.ProviderNonHealthCancellation'(Phase)
} else if (ActionC == 'Back') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Button - Back'))
	
} else if (ActionC == 'Exit') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Button - Exit'))
	
}
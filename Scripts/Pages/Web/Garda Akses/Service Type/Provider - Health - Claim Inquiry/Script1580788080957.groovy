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

CustomKeywords.'gardaAkses.General.waitProcessingCommand'()

if (Phase == '1') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Button - New GL'))
} else if (Phase == '2') {
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Input - Ticket No'), GlobalVariable.TicketID1)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Button - Search'))
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Select - Ticket No', [('Value') : GlobalVariable.TicketID1]), GlobalVariable.Delay5)
		
	WebUI.doubleClick(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Select - Ticket No', [('Value') : GlobalVariable.TicketID1]))
} else if (Phase == '3') {
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Input - Ticket No'), GlobalVariable.TicketID2)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Button - Search'))
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Select - Ticket No', [('Value') : GlobalVariable.TicketID2]), GlobalVariable.Delay5)
	
	WebUI.doubleClick(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Select - Ticket No', [('Value') : GlobalVariable.TicketID2]))
} else if (Phase == '4') {
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Input - Ticket No'), GlobalVariable.TicketID3)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Button - Search'))
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Select - Ticket No', [('Value') : GlobalVariable.TicketID3]), GlobalVariable.Delay5)
	
	WebUI.doubleClick(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Select - Ticket No', [('Value') : GlobalVariable.TicketID3]))
} else if (Phase == '5') {
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Input - Ticket No'), GlobalVariable.TicketID4)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Button - Search'))
	
	WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Select - Ticket No', [('Value') : GlobalVariable.TicketID4]), GlobalVariable.Delay5)
	
	WebUI.doubleClick(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Select - Ticket No', [('Value') : GlobalVariable.TicketID4]))
}
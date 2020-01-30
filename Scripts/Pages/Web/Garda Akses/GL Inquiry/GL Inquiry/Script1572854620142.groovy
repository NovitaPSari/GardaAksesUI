import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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

WebUI.delay(GlobalVariable.Delay2)

if (GLType == 'Awal') {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Button - Create New GL')) //    WebUI.click(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Choose - Ticket No'))
} else if ((GLType == 'Revisi') || (GLType == 'Akhir')) {
    WebUI.setText(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Input - Ticket No'), TicketID)

    WebUI.click(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Button - Search'))

    WebUI.waitForElementPresent(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Choose - Ticket No'), GlobalVariable.Delay3)
	
	WebUI.delay(GlobalVariable.Delay5)
	
//	WebUI.click(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Choose - Ticket No'))

    WebUI.doubleClick(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Choose - Ticket No'))
} else {
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/GL Inquiry/Input - Member Name'), NewMemberName)

	WebUI.click(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Button - Search'))
	
	WebUI.delay(GlobalVariable.Delay5)

	WebUI.waitForElementPresent(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Choose - Ticket No'), GlobalVariable.Delay3)
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Choose - Ticket No'))

	WebUI.doubleClick(findTestObject('Pages/Web/Garda Akses/GL Inquiry/Choose - Ticket No'))
}


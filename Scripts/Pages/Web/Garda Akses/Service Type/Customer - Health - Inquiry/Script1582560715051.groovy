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

//Member
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Health - Inquiry/Input - Member'), MemberName)

WebUI.delay(5)

WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Health - Inquiry/Input - Member'), MemberName)

WebUI.delay(5)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Health - Inquiry/Auto Complete - Member'))

CustomKeywords.'com.keyword.GEN5.ProcessingCommand'()

//Sub Service Type
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Health - Inquiry/Combo - Sub Service Type'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Health - Inquiry/Combo List - Sub Service Type', [('value') : SubServiceType]))

//Remarks
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Health - Inquiry/Input - Remarks'), Remarks)

//Need Follow Up
if (NeedFollowUp == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Health - Inquiry/Check Box - Need Follow Up'))
}

//Action
if (ActionI == 'Exit') {
	
} else if (ActionI == 'Back') {
	
} else if (ActionI == 'Process') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Health - Inquiry/Button - Process'))
	
	CustomKeywords.'gardaAkses.GetTicketID.GetTicketNumber'(Phase)
} else {
	WebUI.delay(0)
}



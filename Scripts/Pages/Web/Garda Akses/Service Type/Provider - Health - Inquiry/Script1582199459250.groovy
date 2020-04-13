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
import com.keyword.GEN5

//Member Name
WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Member Name'), MemberName)

WebUI.delay(GlobalVariable.Delay1)

WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Member Name'), MemberName)

WebUI.delay(GlobalVariable.Delay1)

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Member Name'))

GEN5.ProcessingCommand()

//Provider Name

//Sub Service Type

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Button - Sub Service Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Choose - Sub Service Type', [('SubServiceType') : SubServiceType]))

//Remarks
WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Input - Remarks'), Remarks)

//Need Follow Up
if (NeedFollowUp == 'Yes') {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Inquiry/Check Box - Need Follow Up'))
}

//Button Direction

if (ActionI == 'Exit') {

} else if (ActionI == 'Back') {

} else if (ActionI == 'Process') {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Button - Process'))
	
	CustomKeywords.'gardaAkses.GetTicketID.GetTicketNumber'(Phase)
}
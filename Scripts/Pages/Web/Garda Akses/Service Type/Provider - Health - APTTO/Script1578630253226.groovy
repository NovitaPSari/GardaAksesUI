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

WebUI.delay(GlobalVariable.Delay3)

//========== History & Membership ==========

//========== Approval Tindakan/Terapi/Obat ==========
//Member Name
if (null) {

	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Input - Member Name'), MemberName)
	
	WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Input - Member Name'), MemberName)
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Inquiry/Choose - Member Name', [('MemberName') : MemberName]))
	
}


//Sub Service Type
WebUI.delay(GlobalVariable.Delay1)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Button - Sub Service Type'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Choose - Sub Service Type', [('SubServiceType') : SubServiceType]))

//Remarks
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Input - Remarks'), Remarks)

//Need Follow Up
if (NeedFollowUp == 'Yes') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Check Box - Need Follow Up'))
} else {
	WebUI.delay(0)
}
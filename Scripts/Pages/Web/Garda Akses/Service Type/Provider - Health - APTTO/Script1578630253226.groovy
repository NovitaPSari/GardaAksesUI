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

WebUI.delay(GlobalVariable.Delay1)

//========== History & Membership ==========
//========== Approval Tindakan/Terapi/Obat ==========
//Member Name
WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Member Name'), 
    MemberName)

WebUI.delay(GlobalVariable.Delay1)

WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Member Name'), 
    MemberName)

WebUI.delay(GlobalVariable.Delay1)

def MemberNameSuggestion = WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Choose - Member Name', 
        [('MemberName') : MemberName]), GlobalVariable.Delay1)

if (MemberNameSuggestion == true) {
WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Choose - Member Name', 
        [('MemberName') : MemberName]))

WebUI.delay(GlobalVariable.Delay1)
} else {
	WebUI.delay(0)
}

//Sub Service Type
WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Button - Sub Service Type'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Choose - Sub Service Type', 
        [('SubServiceType') : SubServiceType]))

WebUI.delay(GlobalVariable.Delay2)

//Medical Treatment
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Medical Treatment'), 
    MedicalTreatment)

//Remarks
WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Remarks'), 
    Remarks)

//Need Follow Up
if (NeedFollowUp == 'Yes') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/APPTO/Check Box - Need Follow Up'))
} else {
    WebUI.delay(0)
}

//Patient Phone Number
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Patient Phone Number'), 
    PatientPhoneNumber)

//Action
if (Action == 'Proses') {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Button - Process'))
	
	
	
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Button - OK'))
} else if (Action == 'Back') {
    WebUI.click()
} else if (Action == 'Exit') {
    WebUI.click()
} else {
	WebUI.delay(0)
}
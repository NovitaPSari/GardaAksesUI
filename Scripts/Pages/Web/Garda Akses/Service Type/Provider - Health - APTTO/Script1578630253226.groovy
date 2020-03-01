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

import com.keyword.GEN5

GEN5.ProcessingCommand()

//========== History & Membership ==========
//========== Approval Tindakan/Terapi/Obat ==========
//Member Name
WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Member Name'), 
    MemberName)

WebUI.delay(GlobalVariable.Delay1)

WebUI.setText(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Member Name'), 
    MemberName)

WebUI.delay(GlobalVariable.Delay1)

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Choose - Member Name', 
        [('MemberName') : MemberName]))

GEN5.ProcessingCommand()

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
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Check Box - Need Follow Up'))
}

//Patient Phone Number
//WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Input - Patient Phone Number'), 
//    GlobalVariable.PhoneNumber)

//Action
if (ActionAPTTO == 'Process') {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - APTTO/Approval Tindakan Terapi Obat/Button - Process'))
	
	CustomKeywords.'gardaAkses.GetTicketID.GetTicketNumber'(Phase)
} else if (ActionAPTTO == 'Back') {
    WebUI.click()
} else if (ActionAPTTO == 'Exit') {
    WebUI.click()
}
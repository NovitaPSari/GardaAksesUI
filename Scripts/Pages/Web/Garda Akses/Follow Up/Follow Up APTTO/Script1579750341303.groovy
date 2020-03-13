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

WebUI.verifyElementText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Text - TR ID'), 
    GlobalVariable.Delay5)

WebUI.verifyElementText(findTestObject('Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Text - Sub Service Type', [('ServiceType') : ServiceType]), 
    GlobalVariable.Delay5)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Button - Ticket No'))

def TicketNo = WebUI.verifyElementPresent(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Choose - Ticket No'), 
    GlobalVariable.Delay5)

if (TicketNo == true) {
    not_run: WebUI.click(findTestObject([(['TRID']) : TRID], 'Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Choose - Ticket No'))
} else {
    WebUI.delay(0)
}

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Button - New Confirmation Result'))

//Milih PIC
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Button - PIC'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Choose - PIC', [('PIC') : PIC]))

//Memilih Doctor Name
if (PIC == 'Doctor') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Button - Doctor Name'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Choose - Doctor Name', 
            [('DoctorName') : DoctorName]))
} else {
    WebUI.delay(0)
}

//Date Time Confirmation
if (PIC == 'Doctor') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Button - Date Time Confirmation'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Button - Date Time Confirmation'))
} else {
    WebUI.delay(0)
}

//Pilih Confirmation
if (PIC == 'Doctor') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Button - Confirmation'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Choose - Confirmation', 
            [('Confirmation') : Confirmation]))
} else {
    WebUI.delay(0)
}

//Pilih Mandatory
if (((PIC == 'Doctor') && (Confirmation == 'Need Confirmation Letter')) && (Mandatory == 'Yes')) {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Check Box - Mandatoy'))
} else {
    WebUI.delay(0)
}

//Confirmation Letter Type
if ((PIC == 'Doctor') && (Confirmation == 'Need Confirmation Letter')) {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Button - Confirmation Letter Type'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Choose - Confirmation Letter Type', 
            [('ConfirmationLetterType') : ConfirmationLetterType]))
} else {
    WebUI.delay(0)
}

//Remarks
if ((PIC == 'Doctor') && (Confirmation == 'Need Confirmation Letter')) {
    WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Input - Remarks'), 
        RemarksFUA)
} else {
    WebUI.delay(0)
}

//Action Add Confirmation
if (ActionAC == 'Save') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Button - Save'))
} else if (ActionAC == 'Cancel') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Add Confirmation/Button - Cancel'))
}

//========== Information ==========
def InformationAC = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Information/Text - Insert Successfully'))

WebUI.delay(GlobalVariable.Delay1)

WebUI.verifyEqual(InformationAC, 'Insert Successfully')

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Information/Button - OK'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Button - Save'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up APTTO/Button - Close'))


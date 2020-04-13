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
import com.keyword.UI

//Product
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Emergency/Combo - Product'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Emergency/Combo List - Product', [('value') : Product]))

//FU Status
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Emergency/Combo - FU Status'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Emergency/Combo List - FU Status', [('value') : FUStatus]))

//FU Remarks
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Emergency/Input - FU Remarks'), FURemarks)

//Action
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Button - Action', [('value') : Action]))

//Ticket ID
if (Action == 'Save') {
	CustomKeywords.'gardaAkses.GetTicketID.ProviderNonHealthCancellation'(Phase)
}
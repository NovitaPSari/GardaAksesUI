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
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Combo - Product'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Combo List - Product', [('value') : Product]))

//Vehicle
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Combo - Vehicle'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Combo List - Vehicle'))

GEN5.ProcessingCommand()

//Survey Location
WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Look Up - Survey Location'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Look Up - Location Detail/Combo - Search By'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Look Up - Location Detail/Combo List - Search By', [('value') : SearchBy]))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Look Up - Location Detail/Combo - Parameter'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Look Up - Location Detail/Combo List - Search By', [('value') : Parameter]))

WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Look Up - Location Detail/Input - Search Parameter'), SearchParameter)

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Look Up - Location Detail/Button - Search'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Look Up - Location Detail/Select - Location Detail'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Look Up - Location Detail/Button - Select'))

//Survey Schedule
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Date Picker - Survey Location'))

if (SurveySchedule == 'Yes') {
	WebUI.click(null)
} else if (SurveySchedule == 'No') {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Date Picker - Survey Location'))
}

//Endorsement Category
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Combo - Endorsement Category'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Endorsement/Combo List - Endorsement Category', [('value') : EndorsementCategory]))

//FU Status
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Combo - FU Status'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Combo List - FU Status',
		[('value') : FUStatus]))

//FU Remarks
WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Cancellation/Input - FU Remarks'),
	FURemarks)

//Action
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Service Type/Customer - Non Health - Endorsement/Button - Action', [('value') : Action]))

//Ticket ID
if (Action == 'Save') {
	CustomKeywords.'gardaAkses.GetTicketID.ProviderNonHealthCancellation'(Phase)
}


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

//Choose Customer 1
//WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Button - X'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 1/Radio Button - Category', [('ChooseCategoryCustomer') : ChooseCategoryCustomer]))

if (ActionCC1 == 'Next') {	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Choose Customer 1/Button - Next'))	
} else if (ActionCC1 == 'Back') {	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Choose Customer 1/Button - Back'))
} else if (ActionCC1 == 'Exit') {	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Choose Customer 1/Button - Exit'))
}

//Choose Customer 2
WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Combo - Search By'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Combo List - Search By', [('SearchBy') : SearchBy]))

WebUI.setText(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Input - Parameter Search'), Parameter)

WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Button - Search'))

def PopUpError = WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Alert - Ooops'), GlobalVariable.Delay3)

if (PopUpError == true) {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Ooops, something just went wrong/Button - Ignore'))
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Button - Search'))
} else {
	WebUI.delay(0)
}

WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Button - Choose Customer'))

if (ActionCC2 == 'Next') {	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Button - Next'))	
} else if (ActionCC2 == 'Back') {	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Button - Back'))
} else if (ActionCC2 == 'Exit') {	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Choose Customer 2/Button - Exit'))
}

//Choose Customer 3
/*
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Choose Customer/Button - Policy Summary'))

WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose - Policy Summary'))
*/

WebUI.delay(GlobalVariable.Delay1)

if (ActionCC3 == 'Finish') {
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 3/Button - Finish'))
	
	WebUI.click(findTestObject('Pages/Web/Garda Akses/Choose Customer/Choose Customer 3/Button - Yes Save Customer'))
} else if (ActionCC3 == 'Back') {

}
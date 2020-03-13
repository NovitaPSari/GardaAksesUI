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

WebUI.waitForElementPresent(findTestObject('Pages/Web/Garda Akses/Follow Up/Ticket Follow Up/Text - Response Time'), GlobalVariable.Delay5)

def StatusNow = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Ticket Follow Up/Text - Status'))

if (StatusNow == 'Available') {
    WebUI.click(findTestObject('Pages/Web/Garda Akses/Follow Up/Ticket Follow Up/Button - Status'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Follow Up/Ticket Follow Up/Choose - Status', [('Status') : Status]))
	
	WebUI.delay(GlobalVariable.Delay5)
} else {
    WebUI.delay(0)
}


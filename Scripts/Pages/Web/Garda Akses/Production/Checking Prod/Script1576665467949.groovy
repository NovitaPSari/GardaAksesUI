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
import org.openqa.selenium.Keys as Keys1
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

//int y = OnLoop
//
//int i = 1
//
//for (a = i; a <= y; a++) {}


WebUI.delay(GlobalVariable.Delay3)

//Verify Button Create e-GL
def HealthNotCollapsed = WebUI.verifyElementPresent(findTestObject('Object Repository/Pages/Web/Garda Akses/Home/Button - Health Not Collapsed'), GlobalVariable.Delay0)

if (HealthNotCollapsed == true) {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Home/Button Health'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Home/Button Create e-GL'))
} else {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Home/Button Create e-GL'))
}

//GL Inquiry
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/GL Inquiry/Button - Create New GL'))

//Claim
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Cancel'))

//GL Inquiry
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/GL Inquiry/Button - Close'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/GL Inquiry/Please Confirm/Button - Yes, Close Application'))

//Verify Create Ticket
def GeneralNotCollapsed = WebUI.verifyElementPresent(findTestObject('Pages/Web/Garda Akses/Home/Button - General Not Collapsed'), GlobalVariable.Delay0)

if (GeneralNotCollapsed == true) {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Home/Button General'))
	
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Home/Button Create Ticket'))
} else {
	WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Home/Button Create Ticket'))
}

//Create Ticket
WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Exit'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Please Confirm/Button - Yes, Close Application'))
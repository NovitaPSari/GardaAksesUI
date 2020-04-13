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
import org.openqa.selenium.Keys as Keys1
import org.openqa.selenium.WebDriver as WebDriver
import org.openqa.selenium.WebElement as WebElement
import org.openqa.selenium.By as By
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject

WebUI.delay(GlobalVariable.Delay6)

def PopUpError = WebUI.verifyElementPresent(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - 13142 Error Detected'), 
    GlobalVariable.Delay0)

if (PopUpError == true) {
    WebUI.click(findTestObject('null'))
} else {
    WebUI.delay(0)
}

//Button Health
def HealthNotCollapsed = WebUI.verifyElementPresent(findTestObject('Pages/Web/GEN5/Home/Button - Health Not Collapsed'), 
    GlobalVariable.Delay0)

if (HealthNotCollapsed == true) {
    WebUI.click(findTestObject('Pages/Web/GEN5/Home/Button Health'))

    WebUI.click(findTestObject('Pages/Web/GEN5/Home/Button Create e-GL'))
} else {
    WebUI.click(findTestObject('Pages/Web/GEN5/Home/Button Create e-GL'))
}

WebUI.delay(GlobalVariable.Delay6)

def PopUpError2 = WebUI.verifyElementPresent(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - 13142 Error Detected'), 
    GlobalVariable.Delay0)

if (PopUpError2 == true) {
    WebUI.click(findTestObject('null'))
} else {
    WebUI.delay(0)
}

WebUI.click(findTestObject('Pages/Web/Garda Akses/Service Type/Provider - Health - Claim Inquiry/Button - New GL'))

WebUI.delay(GlobalVariable.Delay6)

def PopUpError3 = WebUI.verifyElementPresent(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - 13142 Error Detected'), 
    GlobalVariable.Delay0)

if (PopUpError3 == true) {
    WebUI.click(findTestObject('null'))
} else {
    WebUI.delay(0)
}

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

WebUI.click(findTestObject('null'))

//Button General
WebUI.delay(GlobalVariable.Delay6)

def PopUpError4 = WebUI.verifyElementPresent(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - 13142 Error Detected'), 
    GlobalVariable.Delay0)

if (PopUpError4 == true) {
    WebUI.click(findTestObject('null'))
} else {
    WebUI.delay(0)
}

def GeneralNotCollapsed = WebUI.verifyElementPresent(findTestObject('Pages/Web/GEN5/Home/Button - General Not Collapsed'), 
    GlobalVariable.Delay0)

if (GeneralNotCollapsed == true) {
    WebUI.click(findTestObject('Pages/Web/GEN5/Home/Button General'))

    WebUI.click(findTestObject('Pages/Web/GEN5/Home/Button Create Ticket'))
} else {
    WebUI.click(findTestObject('Pages/Web/GEN5/Home/Button Create Ticket'))
}

WebUI.delay(GlobalVariable.Delay6)

def PopUpError5 = WebUI.verifyElementPresent(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Text - 13142 Error Detected'), 
    GlobalVariable.Delay0)

if (PopUpError5 == true) {
    WebUI.click(findTestObject('null'))
} else {
    WebUI.delay(0)
}

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Exit'))

WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Please Confirm/Button - Yes, Close Application'))


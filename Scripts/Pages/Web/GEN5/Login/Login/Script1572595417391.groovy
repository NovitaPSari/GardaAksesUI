import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
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
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.keyword.GEN5 as GEN5
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows

WebUI.openBrowser(GlobalVariable.URLGardaAksesQC)

WebUI.maximizeWindow()

def YourConnectionIsNotPrivate = WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/GEN5/Login/Text - Your connection is not private'), 
    1)

if (YourConnectionIsNotPrivate) {
    WebUI.click(findTestObject('Object Repository/Pages/Web/GEN5/Login/Button - Advance'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/GEN5/Login/Button - Proceed'))
}

WebUI.waitForPageLoad(GlobalVariable.Delay1)

WebUI.setText(findTestObject('Pages/Web/GEN5/Login/Input - Username'), UserID)

WebUI.setText(findTestObject('Pages/Web/GEN5/Login/Input - Password'), Password)

WebUI.click(findTestObject('Pages/Web/GEN5/Login/Button - Masuk'))

GEN5.ProcessingCommand()


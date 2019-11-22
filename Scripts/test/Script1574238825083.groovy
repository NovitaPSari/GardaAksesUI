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

def AppropriateRBClass = WebUI.getAttribute(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Text - Appropriate RB Class'), 
    'value')

println(AppropriateRBClass)

//Appropriate RB Class
if ((MemberStatus == 'Non Client') || (AppropriateRBClass == '')) {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Appropriate RB Class'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Appropriate RB Class/Button - Room Class'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Appropriate RB Class/Button - Choose'))
} else {
    WebUI.delay(0)
}

//Treatment RB Class
if ((MemberStatus == 'Non Client') || (AppropriateRBClass == '')) {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Button - Treatment RB Class'))

    WebUI.click(findTestObject('Pages/Web/Garda Akses/Claim/Treatment RB Class/Button - Room Class'))

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Claim/Treatment RB Class/Button - Choose'))
} else {
    WebUI.delay(0)
}

WebUI.verifyElementAttributeValue(findTestObject('Pages/Web/Garda Akses/Claim/Add New Member/Input - New Member Name'), 
    'textInput', 'value', GlobalVariable.Delay1)




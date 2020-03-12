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
import com.keyword.GEN5 as GEN5

GEN5.ProcessingCommand()

boolean ButtonStart = WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up Inquiry/Button - Start'), 
    1, FailureHandling.OPTIONAL)

if (ButtonStart) {
    //Contact Name
    String FUContactNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up Inquiry/Text - Contact Name'))

    WebUI.comment(FUContactName)

    WebUI.comment(FUContactNameExist)

    WebUI.verifyEqual(FUContactName, FUContactNameExist)

    //Client Name
    String FUClientNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up Inquiry/Text - Client Name'))

    WebUI.comment(FUClientName)

    WebUI.comment(FUClientNameExist)

    WebUI.verifyEqual(FUClientName, FUClientNameExist)
	
    //Member Name
    String FUMemberNameExist = WebUI.getText(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up Inquiry/Text - Member Name'))

    WebUI.comment(FUMemberName)

    WebUI.comment(FUMemberNameExist)

    WebUI.verifyEqual(FUMemberName, FUMemberNameExist)

    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Follow Up/Follow Up Inquiry/Button - Start'))
}


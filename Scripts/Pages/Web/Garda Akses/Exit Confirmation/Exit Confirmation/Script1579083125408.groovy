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

//Apakah ada hal lain yang dapat dibantu, Pak/Bu?
if (ECAction1 == 'Ya') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Exit Confirmation/Button - Ya'))
} else if (ECAction1 == 'Tidak') {
    WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Exit Confirmation/Button - Tidak'))

    if (ECAction2 == 'Puas') {
        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Exit Confirmation/Button - Puas'))

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Exit Confirmation/Button - OK'))

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Exit Confirmation/Button - OK'))
		
		WebUI.waitForElementVisible(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Exit'), 20)

        CustomKeywords.'gardaAkses.General.waitProcessingCommand'()

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Exit'))

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Please Confirm/Button - Yes, Close Application'))
    } else if (ECAction2 == 'Tidak Puas') {
        WebUI.setText(findTestObject('Object Repository/Pages/Web/Garda Akses/Exit Confirmation/Input - Comment'), Comment)

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Exit Confirmation/Button - OK'))

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Exit Confirmation/Button - OK'))

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Exit Confirmation/Button - OK'))

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Button - Exit'))

        WebUI.click(findTestObject('Object Repository/Pages/Web/Garda Akses/Create Ticket/Please Confirm/Button - Yes, Close Application'))
    }
}

